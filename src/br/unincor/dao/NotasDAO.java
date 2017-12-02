package br.unincor.dao;

import java.util.ArrayList;
import java.util.List;
import br.unincor.model.Notas;

public class NotasDAO extends GenericDAO{
	
	public List<Notas> selectNotas(){
		List<Notas> listaNotas = new ArrayList<Notas>();
		String sql = "SELECT * FROM notas";
		listaNotas = super.selectAllNotas(sql);
		return listaNotas;
		}	

}
