package entites.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import utils.OffreTransport;
import utils.OrbAdherent;
import OperateurDeTransportObjet.Adherent;
import OperateurDeTransportObjet.Adresse;
import OperateurDeTransportObjet.CoordBancaire;
import OperateurDeTransportObjet.CoordBancairePro;
import OperateurDeTransportObjet.GestionUtilisateurs;
import OperateurDeTransportObjet.GestionnairePaiement;
import OperateurDeTransportObjet.GestionnaireTransportObjet;
import OperateurDeTransportObjet.InfoObjet;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException;

import com.google.common.collect.Lists;
import com.jgoodies.forms.builder.ButtonBarBuilder;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class GestionColisUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private OperateurDeTransportObjet.GestionnaireTransportObjet gestionnaireTransportObjet;
	private OperateurDeTransportObjet.GestionUtilisateurs gestionnaireUtilisateurs;
	private OperateurDeTransportObjet.GestionnairePaiement gestionnairePaiement;
	private OrbAdherent orbAdherent = null;
	private int numAdherent = 0;

	private ArrayList <OffreTransport> listeOffre;
	private InscriptionTrans inscription;

	private boolean initialized = false;

	private JButton boutonDemandeInscription;
	private JButton boutonDemandeAdhesion;
	private JButton boutonConsulterEtatObjet;
	private JButton boutonAccueil;

	private JPanel panelMenu;
	private JPanel panelContenu;
	private JPanel panelAccueil;
	private JPanel panelConsultationEtat;
	private JPanel panelConnexion;
	private CardLayout cardLayout;

	private JMenuItem itemConnection;
	private JMenuItem itemDeconnection;

	//Formulaire inscription
	private JTextField nomTransporteur;
	private JTextField numeroRue;
	private JTextField nomRue;
	private JTextField ville;
	private JComboBox codePostalT;
	private JTextField pays;
	private JTextField codeBanque;
	private JTextField codeGuichet;
	private JTextField numCompte;
	private JTextField cleRIB;
	private JButton boutonInscription;

	//Formulaire adhésion
	private JTextField prenomAdherent;
	private JTextField nomAdherent;
	private JTextField numeroRueAdh;
	private JTextField nomRueAdh;
	private JTextField villeAdh;
	private JComboBox codePostalAdh;
	private JTextField numeroCarte;
	private JTextField proprietaire;
	private JTextField date;
	private JTextField numDos;
	private JButton boutonAdherer;
	private JComboBox comboZones;

	//Formulaire connexion
	private JTextField numeroAdherent;
	private JPasswordField motDePasse;
	private JButton boutonConnexion;

	//vue consulter etat
	private JScrollPane scrollPane;
	private JList listeInfoObjet;
	InfoObjetListModel listModel;



	private String args[];

	public GestionColisUI() {

		initialize();
	}

	public GestionColisUI(GestionnaireTransportObjet gestionnaireTransportObjet, GestionUtilisateurs gestionnaireUtilisateurs, GestionnairePaiement gestionnairePaiement, String args[]) {

		this.setTitle("Bienvenue chez UPS");
		this.gestionnaireTransportObjet = gestionnaireTransportObjet;
		this.gestionnaireUtilisateurs = gestionnaireUtilisateurs;
		this.gestionnairePaiement = gestionnairePaiement;
		this.args = args;

		this.listeOffre = Lists.newArrayList();
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
		this.setSize(600, 550);
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);

		boutonDemandeAdhesion = new JButton("Demande d'adhésion");
		boutonDemandeAdhesion.setFocusPainted(false);
		boutonDemandeAdhesion.addActionListener(this);
//		boutonDemandeAdhesion.setBackground(new Color(250, 220, 70, 10));
		boutonConsulterEtatObjet = new JButton("Consulter état objet");
		boutonConsulterEtatObjet.setFocusPainted(false);
		boutonConsulterEtatObjet.addActionListener(this);
//		boutonConsulterEtatObjet.setBackground(new Color(250, 220, 70, 10));
		boutonDemandeInscription = new JButton("Demande inscription");
//		boutonDemandeInscription.setBackground(new Color(220, 250, 70, 10));
		boutonDemandeInscription.setFocusPainted(false);
		boutonDemandeInscription.addActionListener(this);
		boutonAccueil = new JButton("Accueil");
		boutonAccueil.setFocusPainted(false);
		boutonAccueil.addActionListener(this);
//		boutonAccueil.setBackground(new Color(250, 180, 80, 10));

		//init des panel
		cardLayout = new CardLayout();
		panelMenu = new JPanel();
		panelContenu = new JPanel(cardLayout);
		panelAccueil = new JPanel();
		JLabel background =new JLabel(new ImageIcon("src/entites/ui/Ups_logo.gif"));
		panelAccueil.add(background);

		ButtonBarBuilder builder = new ButtonBarBuilder();
		builder.addRelatedGap();
		builder.addGlue();
		builder.addButton(boutonAccueil);
		builder.addButton(boutonDemandeAdhesion);
		builder.addButton(boutonConsulterEtatObjet);
		builder.addButton(boutonDemandeInscription);
		builder.addRelatedGap();
		builder.addGlue();
		panelMenu = builder.getPanel();

		panelContenu.add(panelAccueil, "Accueil");
		panelContenu.add(getFormulaireAdhesion(), "Adhesion");
		panelContenu.add(getFormulaireConnexion(), "Connexion");
		panelContenu.add(getVueConsultation(), "Consultation");
		panelContenu.add(getFormulaireInscription(), "Inscription");

		//main layout
		BorderLayout mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
		this.add(panelMenu, BorderLayout.NORTH);
		this.add(panelContenu, BorderLayout.CENTER);
		this.pack();
	}

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

		if (orbAdherent != null) {
			orbAdherent.shutdown();
		}
		if (numAdherent != 0) {
			gestionnaireUtilisateurs.notifierDeconnexionAdh(numAdherent);
		}

		System.exit(0);
	}

	public void setVisible(boolean b) {
		initialize();
		super.setVisible(b);
	}

	private JPanel getFormulaireAdhesion() {

		prenomAdherent = new JTextField();
		nomAdherent = new JTextField();
		numeroRueAdh = new JTextField();
		nomRueAdh = new JTextField();
		villeAdh = new JTextField();
		String[] listCodePostaux = { "31000", "31100", "31200", "31300", "31400", "31500" };
		codePostalAdh = new JComboBox(listCodePostaux);
		codePostalAdh.addActionListener(this);
		comboZones = new JComboBox<String>();
		numeroCarte = new JTextField();
		proprietaire = new JTextField();
		date = new JTextField();
		numDos = new JTextField();
		boutonAdherer = new JButton("Adherer");
		boutonAdherer.addActionListener(this);

		FormLayout layout = new FormLayout(
				"right:pref, 3dlu, pref, 7dlu, right:pref, 45dlu, pref:grow", // columns
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p");      // rows

		PanelBuilder builder = new PanelBuilder(layout);
		builder.setDefaultDialogBorder();

		// Obtain a reusable constraints object to place components in the grid.
		CellConstraints cc = new CellConstraints();

		// Fill the grid with components; the builder can create
		// frequently used components, e.g. separators and labels.

		// Add a titled separator to cell (1, 1) that spans 7 columns.
		builder.addSeparator("Informations personnelles",   cc.xyw(1,  1, 7));
		builder.addLabel("Prénom",     		      cc.xy (1,  3));
		builder.add(prenomAdherent,         	   cc.xyw(3,  3, 5));
		builder.addLabel("Nom",     		      cc.xy (1,  5));
		builder.add(nomAdherent,         	   cc.xyw(3,  5, 5));
		builder.addLabel("     Numero de la rue",       cc.xy (1,  7));
		builder.add(numeroRueAdh,         cc.xyw(3,  7, 3));
		builder.addLabel("Nom de la rue",       cc.xy (1,  9));
		builder.add(nomRueAdh,         cc.xyw(3,  9, 5));
		builder.addLabel("Ville",       cc.xy (1,  11));
		builder.add(villeAdh,         cc.xyw(3,  11, 3));
		builder.addLabel("Code postal",       cc.xy (1,  13));
		builder.add(codePostalAdh,         cc.xyw(3,  13, 3));
		builder.addLabel("Quartier",    cc.xy(1, 15));
		builder.add(comboZones,         cc.xyw(3,  15, 5));

		builder.addSeparator("Coordonnées bancaires", cc.xyw(1,  17, 7));
		builder.addLabel("Numéro carte",      cc.xy (1,  19));
		builder.add(numeroCarte,             cc.xyw (3,  19, 5));
		builder.addLabel("Propriétaire",    cc.xy (1,  21));
		builder.add(proprietaire,           cc.xyw (3,  21, 5));
		builder.addLabel("Date",        cc.xy (1, 23));
		builder.add(date,          cc.xyw (3, 23, 3));
		builder.addLabel("Numéro au dos",        cc.xy (1, 25));
		builder.add(numDos,        cc.xyw (3, 25, 3));
		builder.add(boutonAdherer,        cc.xy (5, 27));

		// The builder holds the layout container that we now return.
		return builder.getPanel();
	}

	private boolean checkFormulaireAdhesion() {

		StringBuilder sb = new StringBuilder();

		if (prenomAdherent.getText().equals("")) {
			sb.append("Prénom \n");
		}
		if (nomAdherent.getText().equals("")) {
			sb.append("Nom\n");
		}
		if (numeroRueAdh.getText().equals("")) {
			sb.append("Numero de la rue\n");
		}
		if (nomRueAdh.getText().equals("")) {
			sb.append("Nom de la rue\n");
		}
		if (villeAdh.getText().equals("")) {
			sb.append("Ville\n");
		}
		if (comboZones.getSelectedItem().equals("")) {
			sb.append("Quartier\n");
		}
		if (numeroCarte.getText().equals("")) {
			sb.append("Numéro carte\n");
		}
		if (proprietaire.getText().equals("")) {
			sb.append("Propriétaire\n");
		}
		if (date.getText().equals("")) {
			sb.append("Date\n");
		}
		if (numDos.getText().equals("")) {
			sb.append("Numéro au dos\n");
		}

		//Si champs pas renseigné, alors message
		if (!sb.toString().equals("")) {
			notifierErreur("Veuillez remplir les champs suivants : \n" + sb.toString());
			return false;
		}

		return true;
	}

	private JPanel getFormulaireInscription() {

		nomTransporteur = new JTextField();
		numeroRue = new JTextField();
		nomRue = new JTextField();
		ville = new JTextField();
		String[] listCodePostaux = { "31000", "31100", "31200", "31300", "31400", "31500" };
		codePostalT = new JComboBox(listCodePostaux);
		codeBanque = new JTextField();
		codeGuichet = new JTextField();
		numCompte = new JTextField();
		cleRIB = new JTextField();
		boutonInscription = new JButton("S'inscrire");
		boutonInscription.addActionListener(this);

		FormLayout layout = new FormLayout(
				"right:pref, 3dlu, pref, 7dlu, right:pref, 45dlu, pref:grow", // columns
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p");      // rows

		PanelBuilder builder = new PanelBuilder(layout);
		builder.setDefaultDialogBorder();

		// Obtain a reusable constraints object to place components in the grid.
		CellConstraints cc = new CellConstraints();

		// Fill the grid with components; the builder can create
		// frequently used components, e.g. separators and labels.

		// Add a titled separator to cell (1, 1) that spans 7 columns.
		builder.addSeparator("Informations entreprise",   cc.xyw(1,  1, 7));
		builder.addLabel("Nom entreprise",     		      cc.xy (1,  3));
		builder.add(nomTransporteur,         	   cc.xyw(3,  3, 5));
		builder.addLabel("Numero de la rue",       cc.xy (1,  5));
		builder.add(numeroRue,         cc.xyw(3,  5, 3));
		builder.addLabel("Nom de la rue",       cc.xy (1,  7));
		builder.add(nomRue,         cc.xyw(3,  7, 5));
		builder.addLabel("Ville",       cc.xy (1,  9));
		builder.add(ville,         cc.xyw(3,  9, 3));
		builder.addLabel("Code postale",       cc.xy (1,  11));
		builder.add(codePostalT,         cc.xyw(3,  11, 3));


		builder.addSeparator("Coordonnées bancaires", cc.xyw(1,  13, 7));
		builder.addLabel("Code banque",      cc.xy (1,  15));
		builder.add(codeBanque,             cc.xyw (3,  15, 3));
		builder.addLabel("Code guichet",    cc.xy (1,  17));
		builder.add(codeGuichet,           cc.xyw (3,  17, 3));
		builder.addLabel("Numero de compte",        cc.xy (1, 19));
		builder.add(numCompte,          cc.xyw (3, 19, 5));
		builder.addLabel("Clé RIB",        cc.xy (1, 21));
		builder.add(cleRIB,        cc.xyw (3, 21, 3));
		builder.add(boutonInscription,        cc.xy (5, 23));

		// The builder holds the layout container that we now return.
		return builder.getPanel();
	}

	private boolean checkFormulaireInscription() {

		StringBuilder sb = new StringBuilder();

		if (nomTransporteur.getText().equals("")) {
			sb.append("Nom entreprise \n");
		}
		if (numeroRue.getText().equals("")) {
			sb.append("Numero de la rue\n");
		}
		if (nomRue.getText().equals("")) {
			sb.append("Nom de la rue\n");
		}
		if (ville.getText().equals("")) {
			sb.append("Ville\n");
		}
		if (codeBanque.getText().equals("")) {
			sb.append("Code banque\n");
		}
		if (codeGuichet.getText().equals("")) {
			sb.append("Code guichet\n");
		}
		if (numCompte.getText().equals("")) {
			sb.append("Numéro de compte\n");
		}
		if (cleRIB.getText().equals("")) {
			sb.append("Clé RIB\n");
		}

		//Si champs pas renseigné, alors message
		if (!sb.toString().equals("")) {
			notifierErreur("Veuillez remplir les champs suivants : \n" + sb.toString());
			return false;
		}

		return true;
	}
	
	private void cleanFormulaireAdhesion() {
				
		prenomAdherent.setText("");
		nomAdherent.setText("");
		numeroRueAdh.setText("");
		nomRueAdh.setText("");
		villeAdh.setText("");
		numeroCarte.setText("");
		proprietaire.setText("");
		date.setText("");
		numDos.setText("");
	}
	
	private void cleanFormulaireInscription() {
		
		nomTransporteur.setText("");
		numeroRue.setText("");
		nomRue.setText("");
		ville.setText("");
		codeBanque.setText("");
		codeGuichet.setText("");
		numCompte.setText("");
		cleRIB.setText("");
	}

	private JPanel getFormulaireConnexion() {

		numeroAdherent = new JTextField();
		motDePasse = new JPasswordField();
		boutonConnexion = new JButton("Connexion");
		boutonConnexion.addActionListener(this);


		FormLayout layout = new FormLayout(
				"right:pref, 3dlu, pref, 7dlu, right:pref, 45dlu, pref:grow", // columns
				"p, 3dlu, p, 3dlu, p, 3dlu, p");      // rows

		PanelBuilder builder = new PanelBuilder(layout);
		builder.setDefaultDialogBorder();

		// Obtain a reusable constraints object to place components in the grid.
		CellConstraints cc = new CellConstraints();

		// Fill the grid with components; the builder can create
		// frequently used components, e.g. separators and labels.

		// Add a titled separator to cell (1, 1) that spans 7 columns.
		builder.addSeparator("Informations de connexion",   cc.xyw(1,  1, 7));
		builder.addLabel("Numéro adhérent",     		      cc.xy (1,  3));
		builder.add(numeroAdherent,         	   cc.xyw(3,  3, 4));
		builder.addLabel("Mot de passe",       cc.xy (1,  5));
		builder.add(motDePasse,         cc.xyw(3,  5, 4));
		builder.add(boutonConnexion,        cc.xy (5, 7));

		// The builder holds the layout container that we now return.
		return builder.getPanel();
	}

	private JPanel getVueConsultation() {

		panelConsultationEtat = new JPanel();
		panelConsultationEtat.setLayout(new BorderLayout());
		listModel = new InfoObjetListModel(new ArrayList<InfoObjet>());
		listeInfoObjet = new JList(listModel);
		scrollPane = new JScrollPane(listeInfoObjet);
		panelConsultationEtat.add(scrollPane, BorderLayout.CENTER);		

		return panelConsultationEtat;
	}

	private void loadListeEtatObjets() {

		InfoObjet[] infosObjet;
		try {
			infosObjet = gestionnaireTransportObjet.consulterEtatObjet(Integer.parseInt(numeroAdherent.getText()));


			listModel = new InfoObjetListModel(Arrays.asList(infosObjet));
			listeInfoObjet.setModel(listModel);

		} catch (NumberFormatException | ObjetInexistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void envoyerFormulaireInscription() {

		DemandeInscriptionTrans demandeInscription = new DemandeInscriptionTrans(nomTransporteur.getText(), 
				new Adresse(numeroRue.getText(), nomRue.getText(), ville.getText(), Integer.parseInt((String)codePostalT.getSelectedItem()), ""), 
				new CoordBancairePro(Integer.parseInt(codeBanque.getText()), Integer.parseInt(codeGuichet.getText()), Integer.parseInt(numCompte.getText()), Integer.parseInt(cleRIB.getText())));
		try {
			inscription = gestionnaireTransportObjet.demandeInscriptionTrans(demandeInscription);
			notifierSucces("Inscription réussie.");


		} catch (TransExistantException e) {

			notifierErreur("Inscription échouée : " + e.getLocalizedMessage());
		}
	}

	private void envoyerFormulaireAdhesion() {

		DemandeAdhesion demandeAdhesion = new DemandeAdhesion(prenomAdherent.getText(), nomAdherent.getText(), 
				new Adresse(numeroRue.getText(), nomRue.getText(), ville.getText(), Integer.parseInt((String)codePostalAdh.getSelectedItem()), (String)comboZones.getSelectedItem()), 
				new CoordBancaire(Long.parseLong(numeroCarte.getText()), proprietaire.getText(), date.getText(), Integer.parseInt(numDos.getText())));
		try {
			gestionnaireUtilisateurs.demandeAdhesion(demandeAdhesion);
			double coutInscription = gestionnairePaiement.getCoutAdhesion();

			notifierSucces("Adhesion réussie.\nUn montant de " + coutInscription + "€ a été débité de votre compte.");

		} catch (AdherentExistantException e) {

			notifierErreur("Adhesion échouée : \nUn adhérent avec le même prénom et nom existe déjà.");
		}
	}


	private void displayCard(String nomCard) {

		CardLayout cl = (CardLayout)(panelContenu.getLayout());
		cl.show(panelContenu, nomCard);	
	}


	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();

		if (source == boutonDemandeInscription) {

			displayCard("Inscription");
		}
		else if (source == boutonDemandeAdhesion) {

			displayCard("Adhesion");
		} 
		else if (source == boutonConsulterEtatObjet) {

			displayCard("Connexion");
		}
		else if (source == boutonAccueil) {

			displayCard("Accueil");
		}
		else if (source == boutonConnexion) {

			if (orbAdherent != null) {
				orbAdherent.shutdown();
			}
			if (numAdherent != 0) {
				gestionnaireUtilisateurs.notifierDeconnexionAdh(numAdherent);
			}
			numAdherent = Integer.parseInt(numeroAdherent.getText());

			String authentifie = gestionnaireUtilisateurs.verifierAdherent(Integer.parseInt(numeroAdherent.getText()), motDePasse.getText());

			if(!authentifie.equals("")) {

				//Enregistre l'adherent connecté dans le naming service et attend dans un thread
				orbAdherent = new OrbAdherent(args, numAdherent, this);
				orbAdherent.start();
				//notifie le gestionnaire utilisateur de la connexion de l'adherent et envoie son IOR
				gestionnaireUtilisateurs.notifierConnexionAdh(numAdherent, orbAdherent.getAdherent());
				//charge la liste des états des objets
				loadListeEtatObjets();
				//affiche la vue Consultation contenant la liste des états des objets
				displayCard("Consultation");
			}
			else {
				notifierErreur("Les informations saisies n'ont pas permis de vous authentifier.");
			}
		}
		else if (source == boutonInscription) {

			boolean ok = checkFormulaireInscription();
			if (ok) {
				envoyerFormulaireInscription();
				cleanFormulaireInscription();
				displayCard("Accueil");
			}

		}
		else if (source == boutonAdherer) {

			boolean ok = checkFormulaireAdhesion();
			if (ok) {
				envoyerFormulaireAdhesion();
				cleanFormulaireAdhesion();
				displayCard("Accueil");
			}
		}
		else if (source == codePostalAdh) {

			String[] listeZones = gestionnairePaiement.getListZones((String)codePostalAdh.getSelectedItem());
			comboZones.removeAllItems();

			for(String zone : listeZones) {

				comboZones.addItem(zone);
			}
		}
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

	public void notifierColisArrive(String idObjet) {

		JOptionPane.showMessageDialog(this, "L'objet " + idObjet + " vient d'arriver dans votre station.");
	}

}