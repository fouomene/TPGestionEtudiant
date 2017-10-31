package com.objis.universite.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EtudiantModel extends AbstractTableModel {

    private final String[] entetes = {"Numero","Nom", "Prénom","Email","Téléphone","Adresse"};

    private List<Etudiant> etudiants;

    public EtudiantModel(List<Etudiant> etudiants) {  
        this.etudiants = etudiants; 
    }


    public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}



	@Override
    public int getRowCount() {
        return etudiants.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                // ID
                return etudiants.get(rowIndex).getIdEtudiant();

            case 1:
                // Nom
                return etudiants.get(rowIndex).getNom();
            case 2:
                // Prenom
                return etudiants.get(rowIndex).getPrenom();
            case 3:
                // Email
                return etudiants.get(rowIndex).getEmail();
            case 4:
                // Telephone
                return etudiants.get(rowIndex).getTelephone();
            case 5:
                // Adresse
                return etudiants.get(rowIndex).getAdresse();
            default:
                throw new IllegalArgumentException();

        }
       
        
    }



}
