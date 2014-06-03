package entites;

import entites.ui.TransporteurUI;


/*******************************
* Client CORBA de l'objet Transporteur *
*******************************/
public class Transporteur {

	public static OperateurDeTransportObjet.GestionUtilisateurs monGestionnaireUtilisateurs;

	public static void main(String args[]) {

		try {

		// Intialisation de l'orb
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);


/*

        // Saisie du nom de l'objet (si utilisation du service de nommage)
        System.out.println("Quel objet Corba voulez-vous contacter ?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String idObj = in.readLine();

        // Recuperation du naming service
        org.omg.CosNaming.NamingContext nameRoot =
        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

        // Construction du nom a rechercher
        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

        // Recherche aupres du naming service
        org.omg.CORBA.Object distantEuro = nameRoot.resolve(nameToFind);
        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
        System.out.println(orb.object_to_string(distantEuro));
*/
        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
        org.omg.CORBA.Object distantGestionUtilisateurs = orb.string_to_object("IOR:000000000000003649444C3A4F706572617465757244655472616E73706F72744F626A65742F47657374696F6E5574696C69736174657572733A312E30000000000000010000000000000060000102000000000D3139322E3136382E312E31330000C3F400000014004F4F011590986246010000504F41FE3C8EEED300000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
//         Casting de l'objet CORBA au type Ad
        monGestionnaireUtilisateurs = OperateurDeTransportObjet.GestionUtilisateursHelper.narrow(distantGestionUtilisateurs);

        // Appel de l'interface graphique
        TransporteurUI frame = new TransporteurUI(monGestionnaireUtilisateurs);
        frame.setTitle("Fenetre Transporteur");
        frame.setVisible(true);
	}
	catch (Exception e) {
		e.printStackTrace();
	}

}
}
