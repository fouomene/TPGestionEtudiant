package com.objis.universite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.objis.universite.domaine.Etudiant;

public class Dao implements IDao {

	
	
	public Dao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int enregistreEtudiantDao(Etudiant etudiant) {
	

		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Création d'un objet  statement
			

			String sql = "insert into `etudiant`(`nom`,`prenom`,`email`,`telephone`,`adresse`)" 
					+"values (?,?,?,?,?)";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getEmail());
			ps.setString(4, etudiant.getTelephone());
			ps.setString(5, etudiant.getAdresse());
			
		
			// Etape 3 : exécution requête
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			return 0;
		} 
		
	
		return 1;
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		
        //création d'une collection des etudiants
		List<Etudiant> maListEtudiant= new ArrayList<Etudiant>();
	
		
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : préparation requête
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM etudiant ";

			// Etape 3 : exécution requête
			ResultSet rs = st.executeQuery(sql);

			// Etape 4 :parcours Resultset (optionnel)
			while (rs.next()) {
				Etudiant etudiant =  new Etudiant();
				etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setEmail(rs.getString("email"));
				etudiant.setTelephone(rs.getString("telephone"));
				etudiant.setAdresse(rs.getString("adresse"));
				
				maListEtudiant.add(etudiant); // cette instruction permet d'inserrerl'objet document dans ma liste etudiant
				
			}
			
			// Etape 5 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
	

		
		return maListEtudiant;
		
	
	}
	
	
}
