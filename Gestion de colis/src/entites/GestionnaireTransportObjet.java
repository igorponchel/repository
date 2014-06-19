package entites;

import impl.GestionnaireTransportObjetImpl;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


/*******************************
 * Gestionnaire de transport objet - partie serveur
 *******************************/
public class GestionnaireTransportObjet {

	public static OperateurDeTransportObjet.GestionUtilisateurs monGestionnaireUtilisateurs;

	public static void main(String args[]) {
		try {
			// Intialisation de l'ORB
			//************************
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Gestion du POA
			//****************
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			
//			//********************* RECUPERATION DU SERVANT GESTIONNAIRE D'UTILISATEURS
//			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");

			String idObj = "GUtilisateurs";

//			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot =
					org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

//			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

//			// Recherche aupres du naming service
			org.omg.CORBA.Object distantGestionUtilisateurs = nameRoot.resolve(nameToFind);  //BOUCLE DAPPEL
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionUtilisateurs));

			monGestionnaireUtilisateurs = OperateurDeTransportObjet.GestionUtilisateursHelper.narrow(distantGestionUtilisateurs);
//			monGestionnaireUtilisateurs = null;
			
			
			// Creation du servant
			//*********************
			GestionnaireTransportObjetImpl monGestionnaireTransportObjet = new GestionnaireTransportObjetImpl(args, monGestionnaireUtilisateurs);

			// Activer le servant au sein du POA et recuperer son ID
			byte[] monGestionnaireTransportObjetId = rootPOA.activate_object(monGestionnaireTransportObjet);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();

			
	        // Enregistrement dans le service de nommage
	        //*******************************************

	        // Construction du nom a enregistrer
	        org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
	        System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
	        String nomObj = "GTransportObjet";
	        nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

	        // Enregistrement de l'objet CORBA dans le service de noms
	        nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(monGestionnaireTransportObjet));
	        System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");
			 
			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monGestionnaireTransportObjet));
			System.out.println("L'objet possede la reference suivante :");
			System.out.println(IORServant);

			// Lancement de l'ORB et mise en attente de requete
			//**************************************************
			orb.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
