package entites.ui;

import impl.TransporteurImpl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import utils.EtatOffreTransport;
import utils.OffreTransport;
import OperateurDeTransportObjet.Adresse;
import OperateurDeTransportObjet.CoordBancairePro;
import OperateurDeTransportObjet.GestionUtilisateurs;
import OperateurDeTransportObjet.GestionnaireTransportObjet;
import OperateurDeTransportObjet.Transporteur;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans;
import OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans;
import OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException;

import com.google.common.collect.Lists;

public class TransporteurUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private OperateurDeTransportObjet.GestionUtilisateurs gestionnaireUtilisateurs;
	private OperateurDeTransportObjet.GestionnaireTransportObjet gestionnaireTransportObjet;
	private TransporteurImpl transporteur;
	
	private ArrayList <OffreTransport> listeOffre;
	private InscriptionTrans inscription;
	
	private boolean initialized = false;
	private Actions actions = new Actions();
	private JList<DefaultListModel<String>> listeDeEvenements;
	private DefaultListModel<String> defaultListModel;
	private JButton boutonDemandeInscription;
	private JButton boutonConsulterOffreTransport;
	private JButton boutonAccepterOffreTransport;
	private Container pane;
	
	private JMenuItem itemConnection;
	private JMenuItem itemDeconnection;
	
	//Formulaire adhésion
	private JLabel labelNomTransporteur;
	private JTextField nomTransporteur;
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
	private JLabel labelCodeBanque;
	private JTextField codeBanque;
	private JLabel labelCodeGuichet;
	private JTextField codeGuichet;
	private JLabel labelNumCompte;
	private JTextField numCompte;
	private JLabel labelCleRIB;
	private JTextField cleRIB;
	private JButton boutonInscrire;
	
	//Vue Offre
	private JTable tableOffres;
	private OffreTableModel offreModel;
	private JScrollPane scrollPane;
	private JMenuItem prendreEnCharge;
	
	
	private String args[];
	
	private TransporteurImpl monTransporteur;
	
	public TransporteurUI(GestionUtilisateurs gestionnaireUtilisateurs, GestionnaireTransportObjet gestionnaireTransportObjet, String args[], int numeroTransporteur) {
		
		inscription = new InscriptionTrans();
		inscription.numeroInscritTrans = numeroTransporteur;
		this.gestionnaireUtilisateurs = gestionnaireUtilisateurs;
		this.gestionnaireTransportObjet = gestionnaireTransportObjet;
		
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
		boutonDemandeInscription = new JButton("Demande d'inscription");
		boutonDemandeInscription.addActionListener(this);
		boutonConsulterOffreTransport = new JButton("Consulter offre transport");
		boutonConsulterOffreTransport.addActionListener(this);
		pane.add(boutonDemandeInscription);
		pane.add(boutonConsulterOffreTransport);
		
		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		//Build the first menu.
		JMenu menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);

		//a group of JMenuItems
		itemConnection = new JMenuItem("Connexion",
		                         KeyEvent.VK_C);
		itemConnection.addActionListener(this);
		itemDeconnection = new JMenuItem("Deconnexion",
                KeyEvent.VK_D);
		itemDeconnection.addActionListener(this);
		
		menu.add(itemConnection);
		menu.add(itemDeconnection);		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
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
		
		labelNomTransporteur = new JLabel("Nom entreprise");
		nomTransporteur = new JTextField();
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
		labelCodeBanque = new JLabel("Code banque ");
		codeBanque = new JTextField();
		labelCodeGuichet = new JLabel("Code guichet ");
		codeGuichet = new JTextField();
		labelNumCompte = new JLabel("Numero compte");
		numCompte = new JTextField();
		labelCleRIB = new JLabel("Clé RIB");
		cleRIB = new JTextField();
		boutonInscrire = new JButton("S'inscrire");
		boutonInscrire.addActionListener(this);
		
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		GridLayout gridLayout = new GridLayout(11, 2);
		pane.setLayout(gridLayout);
		pane.add(labelNomTransporteur);
		pane.add(nomTransporteur);
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
		pane.add(labelCodeBanque);
		pane.add(codeBanque);
		pane.add(labelCodeGuichet);
		pane.add(codeGuichet);
		pane.add(labelNumCompte);
		pane.add(numCompte);
		pane.add(labelCleRIB);
		pane.add(cleRIB);
		pane.add(boutonInscrire);
		pane.repaint();
	}
	
	private void envoyerFormulaireInscription() {
		
		DemandeInscriptionTrans demandeInscription = new DemandeInscriptionTrans(nomTransporteur.getText(), 
				new Adresse(numeroRue.getText(), nomRue.getText(), ville.getText(), Integer.parseInt(departement.getText()), pays.getText()), 
				new CoordBancairePro(Integer.parseInt(codeBanque.getText()), Integer.parseInt(codeGuichet.getText()), Integer.parseInt(numCompte.getText()), Integer.parseInt(cleRIB.getText())));
		try {
			inscription = gestionnaireUtilisateurs.demandeInscriptionTrans(demandeInscription);
			notifierSucces("Inscription réussie : " + inscription.toString());
			initVueOffre();
			gestionnaireTransportObjet.notifierConnexion(inscription.numeroInscritTrans, transporteur._this());
			
		} catch (TransExistantException e) {

			notifierErreur("Inscription échouée : " + e.getLocalizedMessage());
		}
	}
	
	private void initVueOffre() {
		
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		BorderLayout borderLayout = new BorderLayout();
		pane.setLayout(borderLayout);

		prendreEnCharge = new JMenuItem("Prendre en charge");
		prendreEnCharge.addActionListener(this);
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.add(prendreEnCharge);
		
		offreModel = new OffreTableModel(listeOffre);
		tableOffres = new JTable(offreModel);
		tableOffres.setComponentPopupMenu(popupMenu);
		scrollPane = new JScrollPane(tableOffres);
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.repaint();
	}
	

	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();

		if (source == boutonDemandeInscription) {
			//Afficher formulaire adhésion
			initFormulaireAdhesion();
			
		} else if (source == boutonConsulterOffreTransport) {
			
			initVueOffre();

		} else if (source == boutonInscrire) {
			
			envoyerFormulaireInscription();
			
		} else if (source == boutonAccepterOffreTransport) {
			
		}
		else if (source == prendreEnCharge) {
			
//			String numeroOffre = String.valueOf(tableOffres.getModel().getValueAt(tableOffres.getSelectedRow(), 0));
			String numeroOffre = listeOffre.get(tableOffres.getSelectedRow()).getNumeroOffre();
			String codeTransport = gestionnaireTransportObjet.notifierOffreAcceptee(inscription.numeroInscritTrans, numeroOffre);
			listeOffre.get(tableOffres.getSelectedRow()).setEtatOffreTransport(EtatOffreTransport.priseEnCharge);
			offreModel.fireTableDataChanged();
			notifierSucces("Code transport : " + codeTransport);
		}
		else if (source == itemConnection) {
			
			gestionnaireTransportObjet.notifierConnexion(inscription.numeroInscritTrans, transporteur._this());
		}
		else if (source == itemDeconnection) {
			
			gestionnaireTransportObjet.notifierDeconnexion(inscription.numeroInscritTrans);
		}
	}
	
	public void ajouterOffreTransport(String numeroOffre, String nomStationDepart, String nomStationArrivee) {
		
		System.out.println("TOTO");
		OffreTransport nouvelleOffre = new OffreTransport(numeroOffre, nomStationDepart, nomStationArrivee, EtatOffreTransport.aPrendreEnCharge);
		listeOffre.add(nouvelleOffre);
		offreModel.fireTableDataChanged();
	}
	
	public void alerterOffreDejaPriseEnCharge(String numeroOffre) {
		
		listeOffre.remove(numeroOffre);
		notifierSucces("Vous venez de prendre en charge l'offre " + numeroOffre);
		offreModel.fireTableDataChanged();
		//transfert de l'offre prise en charge dans une autre jtable
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
	
	public void setTransporteur(TransporteurImpl transporteur) {
		
		this.transporteur = transporteur;
	}
	
}