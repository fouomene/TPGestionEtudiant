package com.objis.universite.dao;

import java.util.List;

import com.objis.universite.domaine.Etudiant;

public interface IDao {
	
	public int enregistreEtudiantDao(Etudiant etudiant);
	
	public List<Etudiant> getAllEtudiants();

}
