package entites.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class FrameStandard extends JFrame{

	private static final long serialVersionUID = 1L;

	private boolean initialized = false;
    private Actions actions = new Actions();
    private JList<DefaultListModel<String>> listeDeEvenements;
    private DefaultListModel<String> defaultListModel;
    
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
        Container pane = this.getContentPane();
        defaultListModel = new DefaultListModel<String>();
        defaultListModel.addElement("Hello");
        listeDeEvenements = new JList(defaultListModel);
        pane.add(listeDeEvenements);
        
        ajouterContenu("lol");

        
        
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

    
	public static void main(String[] args) {
        new FrameStandard().setVisible(true);
	}
	
	public void ajouterContenu(String texte) {
		
		defaultListModel.addElement(texte);
	}
}