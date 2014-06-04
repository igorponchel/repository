package entites;

import impl.StationImpl;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import entites.ui.StationUI;


/*******************************
 * Client CORBA de l'objet Station *
 *******************************/
public class Station {

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


			//********************* ENREGISTREMENT DU SERVANT STATION 
			// Appel de l'interface graphique
			StationUI frame = new StationUI("S1", monGestionnaireUtilisateurs, args);
			frame.setTitle("Fenetre Station");
			frame.setVisible(true);

			// Creation du servant			
			StationImpl maStation = new StationImpl(frame);

			// Activer le servant au sein du POA et recuperer son ID
			byte[] maStationId = rootPOA.activate_object(maStation);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();


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

//			// Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//			org.omg.CORBA.Object distantGestionUtilisateurs = orb.string_to_object("IOR:000000000000003649444C3A4F706572617465757244655472616E73706F72744F626A65742F47657374696F6E5574696C69736174657572733A312E30000000000000010000000000000060000102000000000D3139322E3136382E312E31330000EAE000000014004F4F01B86A016646010000504F41FE620FFC4200000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
			//         Casting de l'objet CORBA au type Ad
			monGestionnaireUtilisateurs = OperateurDeTransportObjet.GestionUtilisateursHelper.narrow(distantGestionUtilisateurs);

			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
