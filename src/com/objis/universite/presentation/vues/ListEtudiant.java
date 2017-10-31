package com.objis.universite.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.objis.universite.dao.Dao;
import com.objis.universite.dao.IDao;
import com.objis.universite.domaine.EtudiantModel;
import com.objis.universite.service.IService;
import com.objis.universite.service.Service;

import javax.swing.JTable;

public class ListEtudiant extends JFrame {

	private JPanel contentPane;
	private JTable tableEtudiants;
	
	private IDao dao;
	private IService service;
	private EtudiantModel etumodel;


	/**
	 * Create the frame.
	 */
	public ListEtudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dao = new Dao();
		service = new Service(dao);
		
	    etumodel = new EtudiantModel(service.getAllEtudiantService());
		
		
		tableEtudiants = new JTable(etumodel);
		
		
		contentPane.add(new JScrollPane(tableEtudiants), BorderLayout.CENTER);
	}

}
