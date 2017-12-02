package br.unincor.dao;

import java.util.ArrayList;
import java.util.List;
import br.unincor.model.Aluno;

public class AlunoDAO extends GenericDAO{
	
	public List<Aluno> selectAluno(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "SELECT * FROM aluno";
		alunos = super.selectAllAlunos(sql);
		return alunos;
		}	
}
