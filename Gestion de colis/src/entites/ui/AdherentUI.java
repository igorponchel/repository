package entites.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import OperateurDeTransportObjet.Adresse;
import OperateurDeTransportObjet.CoordBancaire;
import OperateurDeTransportObjet.GestionUtilisateurs;
import OperateurDeTransportObjet.GestionnaireTransportObjet;
import OperateurDeTransportObjet.InfoObjet;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

public class AdherentUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private OperateurDeTransportObjet.GestionUtilisateurs gestionnaireUtilisateurs;
	private OperateurDeTransportObjet.GestionnaireTransportObjet gestionnaireTransportObjet;

	private boolean initialized = false;
	private Actions actions = new Actions();
	private JList<DefaultListModel<String>> listeDeEvenements;
	private DefaultListModel<String> defaultListModel;
	private JButton boutonDemandeAdhesion;
	private JButton boutonConsulterEtatObjet;
	private Container pane;


	//Formulaire adhésion
	private JLabel labelPrenomAdherent;
	private JTextField prenomAdherent;
	private JLabel labelNomAdherent;
	private JTextField nomAdherent;
	private JLabel labelNumeroRue;
	private JTextField numeroRue;
	private JLabel labelNomRue;
	private JTextField nomRue;
	private JLabel labelVille;
	private JTextField ville;
	private JLabel labelDepartement;
	private JTextField departement;
	private JLabel labelPays;
	private JTextField pays;
	private JLabel labelNumeroCarte;
	private JTextField numeroCarte;
	private JLabel labelProprietaire;
	private JTextField proprietaire;
	private JLabel labelDate;
	private JTextField date;
	private JLabel labelNumDos;
	private JTextField numDos;
	private JButton boutonAdherer;

	//vue consulter etat
	private JList listeInfoObjet;

	public AdherentUI(GestionUtilisateurs gestionnaireUtilisateurs, GestionnaireTransportObjet gestionnaireTransportObjet) {

		this.gestionnaireUtilisateurs = gestionnaireUtilisateurs;
		this.gestionnaireTransportObjet = gestionnaireTransportObjet;
		this.setVisible(true);
		initialize();
	}


	public void initialize() {
		initializeGui();
		initializeEvents();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initializeGui() {
		if (initialized)
			return;
		initialized = true;
		this.setSize(500, 400);
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
		pane = this.getContentPane();
		GridLayout gridLayout = new GridLayout(2, 1);
		pane.setLayout(gridLayout);
		boutonDemandeAdhesion = new JButton("Demande d'adhésion");
		boutonDemandeAdhesion.addActionListener(this);
		boutonConsulterEtatObjet = new JButton("Consulter état objet");
		boutonConsulterEtatObjet.addActionListener(this);
		pane.add(boutonDemandeAdhesion);
		pane.add(boutonConsulterEtatObjet);

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
		// TODO: Save settings
		//super.dispose();
		System.exit(0);
	}

	public void setVisible(boolean b) {
		initialize();
		super.setVisible(b);
	}

	public void ajouterContenu(String texte) {

		defaultListModel.addElement(texte);
	}

	private void initFormulaireAdhesion() {

		labelPrenomAdherent = new JLabel("Prénom ");
		prenomAdherent = new JTextField();
		labelNomAdherent = new JLabel("Nom ");
		nomAdherent = new JTextField();
		labelNumeroRue= new JLabel("Numero rue ");
		numeroRue = new JTextField();
		labelNomRue= new JLabel("Nom rue ");
		nomRue = new JTextField();
		labelVille= new JLabel("Ville ");
		ville = new JTextField();
		labelDepartement= new JLabel("Departement ");
		departement = new JTextField();
		labelPays= new JLabel("Pays ");
		pays = new JTextField();
		labelNumeroCarte = new JLabel("Numero CB ");
		numeroCarte = new JTextField();
		labelProprietaire = new JLabel("Propriétaire ");
		proprietaire = new JTextField();
		labelDate = new JLabel("Date ");
		date = new JTextField();
		labelNumDos = new JLabel("Num au dos");
		numDos = new JTextField();
		boutonAdherer = new JButton("Adherer");
		boutonAdherer.addActionListener(this);

		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(12, 2);
		pane.setLayout(gridLayout);
		pane.add(labelPrenomAdherent);
		pane.add(prenomAdherent);
		pane.add(labelNomAdherent);
		pane.add(nomAdherent);
		pane.add(labelNumeroRue);
		pane.add(numeroRue);
		pane.add(labelNomRue);
		pane.add(nomRue);
		pane.add(labelVille);
		pane.add(ville);
		pane.add(labelDepartement);
		pane.add(departement);
		pane.add(labelPays);
		pane.add(pays);
		pane.add(labelNumeroCarte);
		pane.add(numeroCarte);
		pane.add(labelProprietaire);
		pane.add(proprietaire);
		pane.add(labelDate);
		pane.add(date);
		pane.add(labelNumDos);
		pane.add(numDos);
		pane.add(boutonAdherer);
		pane.repaint();
	}

	private void initVueInfosObjet() {

		pane.removeAll();
		pane.revalidate();
		pane.repaint();

		try {
			InfoObjet[] infosObjet = gestionnaireTransportObjet.consulterEtatObjet(1);

			listeInfoObjet = new JList<InfoObjet>(infosObjet);

		} catch (ObjetInexistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void envoyerFormulaireAdhesion() {

		DemandeAdhesion demandeAdhesion = new DemandeAdhesion(prenomAdherent.getText(), nomAdherent.getText(), 
				new Adresse(numeroRue.getText(), nomRue.getText(), ville.getText(), Integer.parseInt(departement.getText()), pays.getText()), 
				new CoordBancaire(Integer.parseInt(numeroCarte.getText()), proprietaire.getText(), date.getText(), Integer.parseInt(numDos.getText())));
		try {
			Adhesion adhesion = gestionnaireUtilisateurs.demandeAdhesion(demandeAdhesion);
			notifierSucces("Adhesion réussie : " + adhesion.toString());

		} catch (AdherentExistantException e) {

			notifierErreur("Adhesion échouée : " + e.getLocalizedMessage());
		}
	}


	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();

		if (source == boutonDemandeAdhesion) {
			//Afficher formulaire adhésion
			initFormulaireAdhesion();

		} else if (source == boutonConsulterEtatObjet) {

			initVueInfosObjet();


		} else if (source == boutonAdherer) {

			envoyerFormulaireAdhesion();
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