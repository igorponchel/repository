package entites;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import entites.ui.AdherentUI;


/*******************************
 * Client CORBA de l'objet Adherent *
 *******************************/
public class Adherent {

	public static OperateurDeTransportObjet.GestionUtilisateurs monGestionnaireUtilisateurs;

	public static void main(String args[]) {

		try {

			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

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

			// Appel de l'interface graphique
			AdherentUI frame = new AdherentUI(monGestionnaireUtilisateurs);
			frame.setTitle("Fenetre Adherent");
			frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
