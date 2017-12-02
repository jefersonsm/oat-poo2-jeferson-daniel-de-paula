package br.unincor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unincor.connection.DBConnection;
import br.unincor.model.Aluno;
import br.unincor.model.Disciplinas;
import br.unincor.model.Notas;

public class GenericDAO {
	
	private DBConnection dbConnection = new DBConnection();
	private PreparedStatement pStatement;
	
	public List<Aluno> selectAllAlunos(String sql){
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		try {
			dbConnection.openDBConnection();
			pStatement = dbConnection.CON.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno(
						rs.getInt("matricula"),
						rs.getString("nome"),
						rs.getDate("dt_nasc"),
						rs.getString("cpf"),
						rs.getDouble("mensalidade"));
				listaAlunos.add(aluno);
			}
			
			dbConnection.closeDBConnection();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaAlunos;
		}
	
	public List<Disciplinas> selectAllDisciplinas(String sql){
		List<Disciplinas> listaDisc = new ArrayList<Disciplinas>();
		
		try {
			dbConnection.openDBConnection();
			pStatement = dbConnection.CON.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				Disciplinas disc = new Disciplinas(rs.getInt("id"),
						rs.getString("nome"));
				listaDisc.add(disc);
			}
			dbConnection.closeDBConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listaDisc;		
	}
	
	public List<Notas> selectAllNotas(String sql){
		List<Notas> listaNotas = new ArrayList<Notas>();
		
		try {
			dbConnection.openDBConnection();
			pStatement = dbConnection.CON.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				Notas disc = new Notas(rs.getInt("mat_aluno"),
						rs.getInt("id_disc"), 
						rs.getDouble("nota"));
				listaNotas.add(disc);
			}
			dbConnection.closeDBConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listaNotas;
		
		
	}
	
	}
