package entites;

import impl.StationImpl;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import entites.ui.StationUI;


/*******************************
 * Client CORBA de l'objet Station *
 *******************************/
public class Station2 {

	public static OperateurDeTransportObjet.GestionUtilisateurs monGestionnaireUtilisateurs;
	public static OperateurDeTransportObjet.GestionnaireTransportObjet monGestionnaireTransportObjet;
	
	public static void main(String args[]) {

		try {
			
			// Intialisation de l'ORB
			//************************
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Gestion du POA
			//****************
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));


			//********************* RECUPERATION DU SERVANT GESTIONNAIRE D'UTILISATEURS
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
			org.omg.CORBA.Object distantGestionUtilisateurs = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionUtilisateurs));

			monGestionnaireUtilisateurs = OperateurDeTransportObjet.GestionUtilisateursHelper.narrow(distantGestionUtilisateurs);

			
			//********************* RECUPERATION DU SERVANT GESTIONNAIRE TRANSPORT OBJET
			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");

			String idObj2 = "GTransportObjet";

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
			nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantGestionTransportObjet = nameRoot.resolve(nameToFind2);
			System.out.println("Objet '" + idObj2 + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionTransportObjet));

			monGestionnaireTransportObjet = OperateurDeTransportObjet.GestionnaireTransportObjetHelper.narrow(distantGestionTransportObjet);
			
			//********************* ENREGISTREMENT DU SERVANT STATION 
			// Appel de l'interface graphique
			StationUI frame = new StationUI("Station32", monGestionnaireUtilisateurs, monGestionnaireTransportObjet, args);
			frame.setTitle("Fenetre Station");
			frame.setVisible(true);

			// Creation du servant			
			StationImpl maStation = new StationImpl(frame);

			// Activer le servant au sein du POA et recuperer son ID
			byte[] maStationId = rootPOA.activate_object(maStation);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();

			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
	        System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
	        String nomObj = "Station32";
	        nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

	        // Enregistrement de l'objet CORBA dans le service de noms
	        nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(maStation));
	        System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");
			 
			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(maStation));
			
			orb.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
