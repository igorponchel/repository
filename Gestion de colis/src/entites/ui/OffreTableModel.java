package entites.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import utils.OffreTransport;

public class OffreTableModel extends AbstractTableModel{

    private static final long serialVersionUID = 1L;
    private ArrayList <OffreTransport> offresTransport;

    
    public ArrayList <OffreTransport> getOffresTransport() {
        return offresTransport;
    }

    public void setOffresTransport(ArrayList <OffreTransport> offresTransport) {
        this.offresTransport = offresTransport;
    }

    public OffreTableModel(ArrayList <OffreTransport> offresTransport){
        this.offresTransport = offresTransport;

    }

    @Override
    public String getColumnName(int pColumnIndex) {
        switch(pColumnIndex){
            case 0 : return "Num Offre";
            case 1 : return "Station Depart";
            case 2 : return "Station Arrivee";
            case 3 : return "Etat";
        }
        throw new IllegalArgumentException("Index de colonne invalide ! " + pColumnIndex);
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return this.offresTransport.size();
    }

    @Override
    public boolean isCellEditable(int pRowIndex, int pColumnIndex) {
        // On ne peut pas editer les cellules
        return false;
    }

    public Object getValueAt(int pRowIndex, int pColumnIndex) {

        OffreTransport offre = this.offresTransport.get(pRowIndex);
        switch(pColumnIndex){
            case 0 : return offre.getNumeroOffre();
            case 1 : return offre.getNomStationDepart();
            case 2 : return offre.getNomStationArrivee();
            case 3 : return offre.getEtatOffreTransport().toString();
        }
        throw new IllegalArgumentException("Index de colonne invalide ! " + pColumnIndex);
    }
}
