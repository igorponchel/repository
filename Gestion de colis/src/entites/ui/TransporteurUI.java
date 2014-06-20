package entites.ui;

import impl.TransporteurImpl;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import utils.EtatOffreTransport;
import utils.OffreTransport;
import OperateurDeTransportObjet.GestionnaireTransportObjet;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans;

import com.google.common.collect.Lists;

public class TransporteurUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private OperateurDeTransportObjet.GestionnaireTransportObjet gestionnaireTransportObjet;
	private TransporteurImpl transporteur;
	
	private ArrayList <OffreTransport> listeOffre;
	private ArrayList <OffreTransport> listeOffrePrisesEnCharge;
	private InscriptionTrans inscription;
	
	private boolean initialized = false;

	private JMenuItem itemConnexion;
	private JMenuItem itemDeconnection;

	//Vue Offre
	private JTable tableOffres;
	private JTable tableOffresPrisesEnCharge;
	private OffreTableModel offreModel;
	private OffreTableModel offrePrisesEnChargeModel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JMenuItem prendreEnCharge;

	public TransporteurUI(GestionnaireTransportObjet gestionnaireTransportObjet, int numeroTransporteur) {
		
		inscription = new InscriptionTrans();
		inscription.numeroInscritTrans = numeroTransporteur;
		this.gestionnaireTransportObjet = gestionnaireTransportObjet;

		this.listeOffre = Lists.newArrayList();
		this.listeOffrePrisesEnCharge = Lists.newArrayList();
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
		
		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		//Build the first menu.
		JMenu menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);

		//a group of JMenuItems
		itemConnexion = new JMenuItem("Connexion",
		                         KeyEvent.VK_C);
		itemConnexion.addActionListener(this);
		
		menu.add(itemConnexion);
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
		}
	}

	public void dispose() {

		gestionnaireTransportObjet.notifierDeconnexion(this.inscription.numeroInscritTrans);
		
		System.exit(0);
	}

	/**
	 * Initialise la vue offre, vue principale de la fenêtre
	 */
	private void initVueOffre() {
		
		GridLayout gridLayout = new GridLayout(2, 1);
		this.setLayout(gridLayout);

		prendreEnCharge = new JMenuItem("Prendre en charge");
		prendreEnCharge.addActionListener(this);
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.add(prendreEnCharge);
		
		offreModel = new OffreTableModel(listeOffre);
		offrePrisesEnChargeModel = new OffreTableModel(listeOffrePrisesEnCharge);
		tableOffres = new JTable(offreModel);
		tableOffres.setComponentPopupMenu(popupMenu);
		tableOffresPrisesEnCharge = new JTable(offrePrisesEnChargeModel);
		scrollPane = new JScrollPane(tableOffres);
		scrollPane2 = new JScrollPane(tableOffresPrisesEnCharge);
		this.add(scrollPane);
		this.add(scrollPane2);
		this.revalidate();
		this.repaint();
	}
	

	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();
		
		if (source == prendreEnCharge) {
			
			String numeroOffre = listeOffre.get(tableOffres.getSelectedRow()).getNumeroOffre();
			//Notifie auprès du gestionnaire de transport de la prise en charge de l'offre de transport
			String codeTransport = gestionnaireTransportObjet.notifierOffreAcceptee(inscription.numeroInscritTrans, numeroOffre);
			listeOffre.get(tableOffres.getSelectedRow()).setEtatOffreTransport(EtatOffreTransport.priseEnCharge);
			OffreTransport offre = listeOffre.get(tableOffres.getSelectedRow());
			offre.setEtatOffreTransport(EtatOffreTransport.priseEnCharge);
			//Ajoute l'offre prise en  charge dans la JList contenant exclusivement les offre prises en charge par le transporteur
			listeOffrePrisesEnCharge.add(offre);
			offrePrisesEnChargeModel.fireTableDataChanged();
			notifierSucces("Code transport : " + codeTransport);
		}
		else if (source == itemConnexion) {
			
			//Notifie la connexion du transporteur auprès du gestionnaire de transport
			gestionnaireTransportObjet.notifierConnexion(inscription.numeroInscritTrans, transporteur._this());
			initVueOffre();
			itemConnexion.setEnabled(false);
		}
		else if (source == itemDeconnection) {
			
			//Notifie la deconnexion du transporteur auprès du gestionnaire de transport
			gestionnaireTransportObjet.notifierDeconnexion(inscription.numeroInscritTrans);
			this.remove(scrollPane);
			this.repaint();
			itemConnexion.setEnabled(true);
			
			listeOffre.clear();
		}
	}
	
	/**
	 * Ajoute une offre de transport dans la JList 
	 * @param numeroOffre
	 * @param nomStationDepart
	 * @param nomStationArrivee
	 */
	public void ajouterOffreTransport(String numeroOffre, String nomStationDepart, String nomStationArrivee) {

		OffreTransport nouvelleOffre = new OffreTransport(numeroOffre, "", nomStationDepart, nomStationArrivee, EtatOffreTransport.aPrendreEnCharge);
		listeOffre.add(nouvelleOffre);
		offreModel.fireTableDataChanged();
	}
	
	/**
	 * Alerte qu'une offre de transport a été prise par un autre transporteur
	 * @param numeroOffre
	 */
	public void alerterOffreDejaPriseEnCharge(String numeroOffre) {
		
		
		for (OffreTransport offreTemp : listeOffre) {
			
			if (offreTemp.getNumeroOffre().equals(numeroOffre)) {
				
				offreTemp.setEtatOffreTransport(EtatOffreTransport.priseEnCharge);
			}
		}
		offreModel.fireTableDataChanged();
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


	public void notifierCredit(double sommeCreditee, String numeroOffre) {
		notifierSucces("Un montant de " + sommeCreditee + "€ vous a été crédité pour la livraison " + numeroOffre + ".");
		
	}
	
}