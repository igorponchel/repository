package entites.ui;

import java.util.List;

import javax.swing.AbstractListModel;

import OperateurDeTransportObjet.InfoObjet;

/**
 * Modèle utilisé pour afficher les informations des objets concernant un adhérent
 * @author Igor
 *
 */
public class InfoObjetListModel extends AbstractListModel<String>{

    private static final long serialVersionUID = 1L;
    private List<InfoObjet> infoObjetList;

    public InfoObjetListModel(List<InfoObjet> infoObjetList) {
    	
    	this.infoObjetList = infoObjetList;	
    }
    
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return infoObjetList.size();
	}

	@Override
	public String getElementAt(int index) {
		
		InfoObjet infoObjet = infoObjetList.get(index);
		
		StringBuilder sb = new StringBuilder();
		sb.append("    Objet :                ");
		sb.append(infoObjet.idObjet);
		sb.append("             |             Etat : ");
		sb.append(infoObjet.etatObjet);
		
		return sb.toString();
	}
	
	public void setInfoObjetList(List<InfoObjet> listInfoObjet) {
		
		infoObjetList = listInfoObjet;
	}

}
