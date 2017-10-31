package com.objis.universite.service;

import java.util.List;

import com.objis.universite.dao.IDao;
import com.objis.universite.domaine.Etudiant;

public class Service implements IService {
	
	private IDao dao;

	public Service() {
		// TODO Auto-generated constructor stub
	}
	
	public Service (IDao dao) {
		super();
		this.dao = dao; 	
	}

	@Override
	public int enregistreEtudiantService(Etudiant etudiant) {
		
		return dao.enregistreEtudiantDao(etudiant);
	}

	@Override
	public List<Etudiant> getAllEtudiantService() {
		
		return dao.getAllEtudiants();
	}

}
