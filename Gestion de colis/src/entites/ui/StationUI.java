package entites.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import utils.OffreTransportStation;
import utils.RandomStr;
import OperateurDeTransportObjet.CoordBancaire;
import OperateurDeTransportObjet.EtatObjet;
import OperateurDeTransportObjet.GestionUtilisateurs;
import OperateurDeTransportObjet.GestionnairePaiement;
import OperateurDeTransportObjet.GestionnaireTransportObjet;
import OperateurDeTransportObjet.Objet;
import OperateurDeTransportObjet.Station;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;
import OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException;
import OperateurDeTransportObjet.StationPackage.Casier;
import OperateurDeTransportObjet.StationPackage.EtatCasier;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import exception.AucunCasierLibreException;
import exception.StationPasEnServiceException;

public class StationUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private String nomStation;
	private OperateurDeTransportObjet.GestionUtilisateurs gestionnaireUtilisateurs;
	private GestionnaireTransportObjet gestionnaireTransportObjetDistant;
	private GestionnairePaiement gestionnairePaiement;
	private String args[];

	private boolean initialized = false;
	private JButton boutonEffectuerDepot;
	private JButton boutonRetirerDepot;
	private JButton boutonRetirerPourTransport;
	private JButton boutonDeposerApresTransport;

	private Container pane;
	private JButton boutonMenuPrincipal;

	//Formulaire connexion
	private JLabel labelNumAdherent;
	private JTextField numAdherent;
	private JLabel labelMotDePasse;
	private JTextField motDePasse;
	private JButton boutonLogin;

	//Formulaire saisie destinataire
	private JLabel labelPrenomDestinataire;
	private JTextField prenomDestinataire;
	private JLabel labelNomDestinataire;
	private JTextField nomDestinataire;
	private JButton boutonValiderDestinataire;

	//Formulaire retrait pour transport
	private JLabel labelNumTransporteur;
	private JTextField numTransporteur;
	private JLabel labelCodeTransport;
	private JTextField codeTransport;	
	private JButton boutonValiderRetraitPourTransport;
	//formulaire depot apres transport
	private JButton boutonValiderDeposerApresTransport;
	//formulaire retrait final
	private JButton boutonValiderRetraitFinal;

	//Liste des casiers
	private List <Casier> listeCasiers;

	//Sert au retrait du colis par le transporteur
	private Map <String, OffreTransportStation> mapCodeOffreTransport;
	//Sert au déport du(des) colis par le transporteur
	private Multimap <Integer, Integer> multimapNumTransporteurCasier;

	private Map <Integer, String> mapNumCasierIdObjet;

	private Multimap <Integer, Objet> multiMapNumAdherentObjet;

	public StationUI(String nomStation, GestionUtilisateurs gestionnaireUtilisateurs, GestionnaireTransportObjet gestionnaireTransportObjetDistant, GestionnairePaiement gestionnairePaiement, String args[]) {


		listeCasiers = new ArrayList<>();
		initCasiers();
		mapCodeOffreTransport = new HashMap<>();
		multimapNumTransporteurCasier = ArrayListMultimap.create();
		mapNumCasierIdObjet = new HashMap<>();
		multiMapNumAdherentObjet = ArrayListMultimap.create();

		this.nomStation = nomStation;
		this.gestionnaireUtilisateurs = gestionnaireUtilisateurs;
		this.gestionnaireTransportObjetDistant = gestionnaireTransportObjetDistant;
		this.gestionnairePaiement = gestionnairePaiement;
		this.args = args;
		this.setTitle("Station " + this.nomStation);
		this.setVisible(true);
		initialize();
	}


	public void initialize() {
		initializeGui();
		initializeEvents();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initializeGui() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

		if (initialized)
			return;
		initialized = true;
		this.setSize(500, 400);
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
		pane = this.getContentPane();

		boutonMenuPrincipal = new JButton("Menu Principal");
		boutonMenuPrincipal.addActionListener(this);

		accederMenuPrincipal();
	}

	private void accederMenuPrincipal() {

		pane.removeAll();
		pane.revalidate();
		pane.repaint();

		GridLayout gridLayout = new GridLayout(2, 2);
		pane.setLayout(gridLayout);
		//Boutons principaux
		boutonEffectuerDepot = new JButton("Effectuer dépôt");
		boutonRetirerPourTransport = new JButton("Retirer pour transport");
		boutonDeposerApresTransport = new JButton("Déposer après transport");
		boutonRetirerDepot = new JButton("Retirer dépôt");
		boutonRetirerPourTransport.addActionListener(this);
		boutonEffectuerDepot.addActionListener(this);
		boutonDeposerApresTransport.addActionListener(this);
		boutonRetirerDepot.addActionListener(this);
		pane.add(boutonEffectuerDepot);
		pane.add(boutonRetirerPourTransport);
		pane.add(boutonDeposerApresTransport);
		pane.add(boutonRetirerDepot);
	}


	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();

		if (source == boutonEffectuerDepot) {
			//Afficher formulaire adhésion
			saisieLogin();

		} else if (source == boutonValiderDestinataire) {

			try {

				String zoneDestinataire = gestionnaireUtilisateurs.getZoneAdherent(nomDestinataire.getText(), prenomDestinataire.getText());
				int numAdherentDestinataire = gestionnaireUtilisateurs.getNumAdherent(nomDestinataire.getText(), prenomDestinataire.getText());
				int numAdherentExpediteur = Integer.parseInt(numAdherent.getText());
				//récupération du servant Station destinataire pour reserver un casier
				Station stationDistante = getStationDestinataireViaNamingService(zoneDestinataire);

				String idObjet = genererIdObjet();
				int numeroCasierDepart = getNumeroCasierLibre();
				int numeroCasierArrivee = stationDistante.reserverCasier(numAdherentExpediteur);

				if(numeroCasierDepart >= 0) {

					Casier casierDepot = listeCasiers.get(numeroCasierDepart);

					String nomStationArrivee = zoneDestinataire;
					String codeTransport = gestionnaireTransportObjetDistant.notifierOffreTransport(idObjet, nomStation, nomStationArrivee) ;
					mapCodeOffreTransport.put(codeTransport, new OffreTransportStation(codeTransport, nomStation, nomStationArrivee, casierDepot));

					CoordBancaire coordonneesBancaires = gestionnaireUtilisateurs.getCoordBancairesAdherent(numAdherentDestinataire);

					double sommeDebitee = gestionnairePaiement.debiter(coordonneesBancaires, nomStation, nomStationArrivee);
					notifierSucces("Vous pouvez effectuer votre dépot dans le casier : " + numeroCasierDepart + "\nLa somme de " + sommeDebitee + "€ a été débité de votre compte.");

					mapNumCasierIdObjet.put(numeroCasierDepart, idObjet);
					Objet objet = new Objet(idObjet, EtatObjet.depose, numAdherentExpediteur, numAdherentDestinataire, numeroCasierDepart, numeroCasierArrivee);
					//signale à la station distante le couple codeTransport/CasierDistant pour assurer la recherche lors de la livraison
					stationDistante.notifierInfoTransportObjet(codeTransport, objet);
					gestionnaireTransportObjetDistant.enregistrerObjet(objet);

				}
				else {
					notifierErreur("Il n'y a plus de casier libre dans notre station. Veuillez re-essayer plus tard.");
				}

			} catch (AdherentInexistantException e) {

				notifierErreur("L'adhérent destinataire n'existe pas.");
			} catch (AucunCasierDisponibleException e) {

				notifierErreur("Aucun casier n'est disponible pour le moment dans la station destinataire. Veuillez re-essayer plus tard.");
			} catch (StationPasEnServiceException e) {

				notifierErreur("La station du destinataire est hors service. \nDépôt impossible.");
			} catch (AucunCasierLibreException e) {

				notifierErreur("Aucun casier libre dans notre station. \nDépôt impossible.");
			} 


		} else if (source == boutonLogin) {

			String zone;
			try {
				zone = gestionnaireUtilisateurs.verifierAdherent(Integer.parseInt(numAdherent.getText()), motDePasse.getText());

				if (zone.equals(this.nomStation)) {

					initFormulaireDestination();
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AdherentInexistantException e) {
				notifierErreur("Les informations saisies n'ont pas permis de vous authentifier.");
				saisieLogin();
			}
		}
		else if (source == boutonRetirerPourTransport) {

			initFormulaireRetraitPourTransport();
		}
		else if (source == boutonValiderRetraitPourTransport) {

			String leCodeTransport = codeTransport.getText();
			boolean transporteurOK = gestionnaireTransportObjetDistant.verifierTransporteur(Integer.parseInt(numTransporteur.getText()), leCodeTransport);

			if (transporteurOK) {

				OffreTransportStation offre = mapCodeOffreTransport.get(leCodeTransport);
				if (offre != null) {
					int numeroCasier = offre.getCasierLocal().numeroCasier;
					notifierSucces("Rappel des information de retrait \nStation destinataire : " + offre.getNomStationArrivee() + "\nNuméro casier local : " + numeroCasier);
					mapCodeOffreTransport.remove(leCodeTransport);
					listeCasiers.get(numeroCasier).etatCasier = EtatCasier.vide;
					try {
						gestionnaireTransportObjetDistant.notifierEtatObjet(mapNumCasierIdObjet.get(numeroCasier), EtatObjet.enTransit);
					} catch (ObjetInexistantException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					notifierErreur("Votre code transport est incorrect.");
				}
			}
			else { 
				notifierErreur("Code de transport erroné.");
			}
		}
		else if (source == boutonDeposerApresTransport) {

			initFormulaireDepotApresTransport();
		}
		else if (source == boutonValiderDeposerApresTransport) {

			int numeroTransporteur = Integer.parseInt(numTransporteur.getText());

			Collection <Integer> listeCasierPourTransporteur;
			listeCasierPourTransporteur = multimapNumTransporteurCasier.get(numeroTransporteur);

			if (!listeCasierPourTransporteur.isEmpty()) {

				StringBuilder sb = new StringBuilder();

				for (int numCasier : listeCasierPourTransporteur) {

					String idObjet = mapNumCasierIdObjet.get(numCasier);

					sb.append("  Objet " + idObjet + " à déposer dans le casier " + numCasier + "\n");

					listeCasiers.get(numCasier).etatCasier = EtatCasier.occupe;
					try {

						gestionnaireTransportObjetDistant.notifierEtatObjet(idObjet, EtatObjet.livre);

					} catch (ObjetInexistantException e) {
						e.printStackTrace();
					}
				}	

				notifierSucces("Détails des objets à déposer : \n" + sb.toString());	
				multimapNumTransporteurCasier.removeAll(numeroTransporteur);
			}
			else {

				notifierErreur("Vous n'êtes pas autorisé à déposer d'objet dans notre station.");
			}
		}
		else if (source == boutonRetirerDepot) {

			initFormulaireRetraitFinal();
		}
		else if (source == boutonValiderRetraitFinal) {

			int numeroAdherentSaisi = Integer.parseInt(numAdherent.getText());
			String motDePasseSaisi = motDePasse.getText();

			try {
				String zone = gestionnaireUtilisateurs.verifierAdherent(numeroAdherentSaisi, motDePasseSaisi);

				Collection<Objet> listObjet = multiMapNumAdherentObjet.get(numeroAdherentSaisi);
				String casiers = "";

				if (listObjet.size() > 0) {

					for (Objet objetTemp : listObjet) {

						casiers = casiers + "\nNuméro " + objetTemp.numeroCasierArrivee;

						try {
							gestionnaireTransportObjetDistant.notifierEtatObjet(objetTemp.idObjet, EtatObjet.delivre);
							listeCasiers.get(objetTemp.numeroCasierArrivee).etatCasier = EtatCasier.vide;
						} catch (ObjetInexistantException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					notifierSucces("Vous pouvez récupérer votre colis dans le(s) casier(s) :" + casiers);
					multiMapNumAdherentObjet.removeAll(numeroAdherentSaisi);
				}
				else {
					notifierErreur("Aucun colis pour vous.");
				}

			} catch (AdherentInexistantException e1) {
				notifierErreur("Les informations saisies n'ont pas permis de vous authentifier.");
				saisieLogin();
			}
		}
		else if (source == boutonMenuPrincipal) {

			accederMenuPrincipal();
		}
	}

	public void initFormulaireDestination() {

		labelPrenomDestinataire = new JLabel("Prénom destinataire ");
		prenomDestinataire = new JTextField();
		labelNomDestinataire = new JLabel("Nom destinataire ");
		nomDestinataire = new JTextField();
		boutonValiderDestinataire = new JButton("Valider");
		boutonValiderDestinataire.addActionListener(this);

		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(4, 2);
		pane.setLayout(gridLayout);
		pane.add(boutonMenuPrincipal);
		pane.add(new JButton());
		pane.add(labelPrenomDestinataire);
		pane.add(prenomDestinataire);
		pane.add(labelNomDestinataire);
		pane.add(nomDestinataire);
		pane.add(boutonValiderDestinataire);

	}

	public void initFormulaireRetraitPourTransport() {

		labelNumTransporteur = new JLabel("Numéro de transporteur");
		numTransporteur = new JTextField();
		labelCodeTransport = new JLabel("Code de transport");
		codeTransport = new JTextField();
		boutonValiderRetraitPourTransport = new JButton("Valider");
		boutonValiderRetraitPourTransport.addActionListener(this);

		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(4, 2);
		pane.setLayout(gridLayout);
		pane.add(boutonMenuPrincipal);
		pane.add(new JButton());
		pane.add(labelNumTransporteur);
		pane.add(numTransporteur);
		pane.add(labelCodeTransport);
		pane.add(codeTransport);
		pane.add(boutonValiderRetraitPourTransport);

	}

	public void initFormulaireDepotApresTransport() {

		labelNumTransporteur = new JLabel("Numéro de transporteur");
		numTransporteur = new JTextField();
		labelCodeTransport = new JLabel("Code de transport");
		codeTransport = new JTextField();
		boutonValiderDeposerApresTransport = new JButton("Valider");
		boutonValiderDeposerApresTransport.addActionListener(this);

		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(4, 2);
		pane.setLayout(gridLayout);
		pane.add(boutonMenuPrincipal);
		pane.add(new JButton());
		pane.add(labelNumTransporteur);
		pane.add(numTransporteur);
		pane.add(labelCodeTransport);
		pane.add(codeTransport);
		pane.add(boutonValiderDeposerApresTransport);

	}

	public void initFormulaireRetraitFinal() {

		labelNumAdherent = new JLabel("Numéro adhérent ");
		numAdherent = new JTextField();
		labelMotDePasse= new JLabel("Mot de passe ");
		motDePasse = new JTextField();
		boutonValiderRetraitFinal = new JButton("Valider");
		boutonValiderRetraitFinal.addActionListener(this);

		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(4, 2);
		pane.setLayout(gridLayout);
		pane.add(boutonMenuPrincipal);
		pane.add(new JButton());
		pane.add(labelNumAdherent);
		pane.add(numAdherent);
		pane.add(labelMotDePasse);
		pane.add(motDePasse);
		pane.add(boutonValiderRetraitFinal);

	}

	private void saisieLogin () {

		labelNumAdherent = new JLabel("Numéro adhérent ");
		numAdherent = new JTextField();
		labelMotDePasse= new JLabel("Mot de passe ");
		motDePasse = new JTextField();
		boutonLogin = new JButton("S'identifier");
		boutonLogin.addActionListener(this);

		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(4, 2);
		pane.setLayout(gridLayout);
		pane.add(boutonMenuPrincipal);
		pane.add(new JButton());
		pane.add(labelNumAdherent);
		pane.add(numAdherent);
		pane.add(labelMotDePasse);
		pane.add(motDePasse);
		pane.add(boutonLogin);
	}

	private Station getStationDestinataireViaNamingService (String zoneDestinataire) throws StationPasEnServiceException{

		OperateurDeTransportObjet.Station maStationDistante = null;

		// Intialisation de l'orb
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

		// Saisie du nom de l'objet (si utilisation du service de nommage)
		System.out.println("Quel objet Corba voulez-vous contacter ?");
		String idObj = zoneDestinataire;

		// Recuperation du naming service
		org.omg.CosNaming.NamingContext nameRoot;
		try {
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object stationDestinataire = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(stationDestinataire));			

			maStationDistante = OperateurDeTransportObjet.StationHelper.narrow(stationDestinataire);

		} catch (Exception e) {
			throw new StationPasEnServiceException();
		} 

		return maStationDistante;
	}

	private String genererIdObjet() {

		RandomStr rand = new RandomStr();

		return nomStation + rand.get(8);
	}

	private void initCasiers() {

		for (int i = 0; i < 20; i++) {

			listeCasiers.add(new Casier(i, EtatCasier.vide));
		}
	}

	public int getNumeroCasierLibre() throws AucunCasierLibreException {

		for (int i = 0; i < 20; i++) {

			if (listeCasiers.get(i).etatCasier == EtatCasier.vide) {

				listeCasiers.get(i).etatCasier = EtatCasier.occupe;
				return i; 
			}
		}

		throw new AucunCasierLibreException();
	}

	public void ajouterCoupleNumTransporteurCasier(int numTransporteur, String idObjet) {

		int numCasier;
		try {

			numCasier = getNumCasierViaIdObjet(idObjet);
			multimapNumTransporteurCasier.put(numTransporteur, numCasier);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ajouterCoupleCodeTransportCasier(String codeTransport, int numeroCasier) {

		Casier casier = listeCasiers.get(numeroCasier);
		casier.etatCasier = EtatCasier.occupe;

		mapCodeOffreTransport.put(codeTransport, new OffreTransportStation(codeTransport, "", nomStation, casier));
	}

	public void ajouterCoupleNumCasierIdObjet(int numeroCasier, String idObjet) {

		mapNumCasierIdObjet.put(numeroCasier, idObjet);
	}

	public void ajouterCoupleNumAdherentObjet(int numeroAdherent, Objet objet) {

		multiMapNumAdherentObjet.put(numeroAdherent, objet);
	}

	private int getNumCasierViaIdObjet(String idObjet) throws Exception {

		for (int i = 0; i < mapNumCasierIdObjet.size(); i++) {

			if (mapNumCasierIdObjet.get(i).equals(idObjet)) {

				return i;
			}
		}

		throw new Exception("L'objet n'existe pas");

	}

	// others
	private void initializeEvents() {
		// TODO: Add action listeners, etc
	}

	public class Actions implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			command = command == null ? "" : command;
			// TODO: add if...if else... for action commands

		}
	}

	public void dispose() {
		// TODO: Save settings
		//super.dispose();
		System.exit(0);
	}

	public void setVisible(boolean b) {
		initialize();
		super.setVisible(b);
	}

	private void notifierSucces (String message) {

		JOptionPane.showMessageDialog(this, message);
	}

	private void notifierErreur (String message) {

		JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	private void notifierWarning (String message) {

		JOptionPane.showMessageDialog(this, message, "Attention", JOptionPane.WARNING_MESSAGE);
	}
}