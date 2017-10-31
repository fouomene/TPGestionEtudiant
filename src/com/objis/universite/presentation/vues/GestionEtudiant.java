package com.objis.universite.presentation.vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.objis.universite.dao.Dao;
import com.objis.universite.dao.IDao;
import com.objis.universite.domaine.Etudiant;
import com.objis.universite.service.IService;
import com.objis.universite.service.Service;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionEtudiant {

	private JFrame frameEnregisterEtudiant;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldEmail;
	private JTextField textFieldTelephone;
	private JTextField textFieldAdresse;
	private IService service;
	private IDao dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEtudiant window = new GestionEtudiant();
					window.frameEnregisterEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionEtudiant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameEnregisterEtudiant = new JFrame();
		frameEnregisterEtudiant.setTitle("Enregister un \u00E9tuidant");
		frameEnregisterEtudiant.setBounds(100, 100, 450, 300);
		frameEnregisterEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEnregisterEtudiant.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(34, 30, 56, 16);
		frameEnregisterEtudiant.getContentPane().add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(120, 18, 251, 22);
		frameEnregisterEtudiant.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(34, 62, 56, 16);
		frameEnregisterEtudiant.getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(120, 50, 251, 22);
		frameEnregisterEtudiant.getContentPane().add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(34, 91, 56, 16);
		frameEnregisterEtudiant.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(120, 85, 251, 22);
		frameEnregisterEtudiant.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setBounds(34, 140, 76, 16);
		frameEnregisterEtudiant.getContentPane().add(lblTelephone);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(120, 137, 251, 22);
		frameEnregisterEtudiant.getContentPane().add(textFieldTelephone);
		textFieldTelephone.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(34, 184, 56, 16);
		frameEnregisterEtudiant.getContentPane().add(lblAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(120, 172, 251, 22);
		frameEnregisterEtudiant.getContentPane().add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		JButton btnEnregister = new JButton("Enregister");
		btnEnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//code source executé apres un clique sur le bouton enregistrer
				// 1- Recuperation des valeurs saisies par l'utilisateur
				
				 String nom;
				 String prenom;
				 String email;
				 String telephone;
				 String adresse;
				 
				 nom = textFieldNom.getText();
				 prenom = textFieldPrenom.getText();
				 email = textFieldEmail.getText();
				 telephone = textFieldTelephone.getText();
				 adresse = textFieldAdresse.getText();
				 
				 // 2- creation d'un objet etudiant et mise à jour attribut de l'objet etudiant
				 
				 Etudiant etudiant = new Etudiant();
				 etudiant.setNom(nom);
				 etudiant.setPrenom(prenom);
				 etudiant.setEmail(email);
				 etudiant.setTelephone(telephone);
				 etudiant.setAdresse(adresse);
				 
				 //3-appel de la methode enregistreEtudiantService de la couche service 
				 // pour enregistrer l'étudiant en base de donnée
				 
				 
				  int etat = service.enregistreEtudiantService(etudiant);
				  
				  if(etat == 1) {
					  JOptionPane.showMessageDialog(null, "L'étudiant " + etudiant.getNom() + "enregistré dans la BD!");
					  
					  textFieldNom.setText("");
					  textFieldPrenom.setText("");
					  textFieldEmail.setText("");
					  textFieldTelephone.setText("");
					  textFieldAdresse.setText("");
					  
				  }else {
					  JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de l'étudiant!!! ");
				  }
				 		
				
			}
		});
		btnEnregister.setBounds(267, 207, 97, 25);
		frameEnregisterEtudiant.getContentPane().add(btnEnregister);
		
		JButton btnListesDesEtudiants = new JButton("Listes des etudiants");
		btnListesDesEtudiants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListEtudiant frame = new ListEtudiant();
				frame.setVisible(true);
				
			}
		});
		btnListesDesEtudiants.setBounds(80, 213, 158, 25);
		frameEnregisterEtudiant.getContentPane().add(btnListesDesEtudiants);
		
		dao = new Dao();
		service = new Service(dao);
		
	}
}
