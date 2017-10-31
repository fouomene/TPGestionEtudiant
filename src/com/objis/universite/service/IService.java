package com.objis.universite.service;

import java.util.List;

import com.objis.universite.domaine.Etudiant;

public interface IService {
	
	public int enregistreEtudiantService(Etudiant etudiant);
	
	public List<Etudiant> getAllEtudiantService();
	
}
