package entites;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import entites.ui.GestionColisUI;

public class GestionColis {
	
	public static OperateurDeTransportObjet.GestionUtilisateurs monGestionnaireUtilisateurs;
	private static OperateurDeTransportObjet.GestionnaireTransportObjet monGestionnaireTransportObjet;
	private static OperateurDeTransportObjet.GestionnairePaiement monGestionnairePaiement;
	
	public static void main(String args[]) {

		try {

			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Gestion du POA
			//****************
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			
			
			//********************* RECUPERATION DU SERVANT GESTIONNAIRE UTILISATEURS
			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");
			String idObj = "GUtilisateurs";

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot =
					org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantGestionnaireUtilisateurs = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionnaireUtilisateurs));

			monGestionnaireUtilisateurs = OperateurDeTransportObjet.GestionUtilisateursHelper.narrow(distantGestionnaireUtilisateurs);

			//********************* RECUPERATION DU SERVANT GESTIONNAIRE TRANSPORT OBJET
			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");

			String idObj2 = "GTransportObjet";

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
			nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantGestionnaireTransport = nameRoot.resolve(nameToFind2);
			System.out.println("Objet '" + idObj2 + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionnaireTransport));

			monGestionnaireTransportObjet = OperateurDeTransportObjet.GestionnaireTransportObjetHelper.narrow(distantGestionnaireTransport);
			
			//********************* RECUPERATION DU SERVANT GESTIONNAIRE PAIEMENT
			String idObj3 = "GPaiement";

			// Construction du nom a rechercher
			nameToFind2 = new org.omg.CosNaming.NameComponent[1];
			nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj3,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantGestionPaiement = nameRoot.resolve(nameToFind2);
			System.out.println("Objet '" + idObj3 + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionPaiement));

			monGestionnairePaiement = OperateurDeTransportObjet.GestionnairePaiementHelper.narrow(distantGestionPaiement);

			//FRAME
			GestionColisUI frame = new GestionColisUI(monGestionnaireTransportObjet, monGestionnaireUtilisateurs, monGestionnairePaiement, args);
			frame.setVisible(true);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
