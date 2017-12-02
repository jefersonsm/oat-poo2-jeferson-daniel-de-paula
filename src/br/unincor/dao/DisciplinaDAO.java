package br.unincor.dao;

import java.util.ArrayList;
import java.util.List;
import br.unincor.model.Disciplinas;

public class DisciplinaDAO extends GenericDAO{ 	
	
	public List<Disciplinas> selectDisciplinas(){
		List<Disciplinas> disc = new ArrayList<Disciplinas>();
		String sql = "SELECT * FROM disciplinas";
		disc = super.selectAllDisciplinas(sql);
		return disc;
		}

}
