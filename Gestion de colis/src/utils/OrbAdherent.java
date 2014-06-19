package utils;

import impl.AdherentImpl;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import OperateurDeTransportObjet.Adherent;
import entites.ui.GestionColisUI;

public class OrbAdherent extends Thread {

	private int numAdherent;
	private Adherent adherent;
	private GestionColisUI gestionColisUI;
	
	private org.omg.CORBA.ORB orb;
	
	public OrbAdherent(String args[], int numeroAdherent, GestionColisUI gestionColisUI) {
		
		this.numAdherent = numeroAdherent;
		this.gestionColisUI = gestionColisUI;
		
		try {

			// Intialisation de l'orb
			orb = org.omg.CORBA.ORB.init(args,null);

			// Gestion du POA
			//****************
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot =
					org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Creation du servant			
			AdherentImpl monAdherent = new AdherentImpl(gestionColisUI);

			// Activer le servant au sein du POA et recuperer son ID
			byte[] monAdherentId = rootPOA.activate_object(monAdherent);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();

			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
			String nomObj = "Adherent" + this.numAdherent;
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(monAdherent));
			System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");

			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monAdherent));

			adherent = monAdherent._this();

			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		orb.run();
	}

	public void shutdown() {
		
		orb.shutdown(isInterrupted());
	}
	
	public Adherent getAdherent() {
		
		return adherent;
	}
}
