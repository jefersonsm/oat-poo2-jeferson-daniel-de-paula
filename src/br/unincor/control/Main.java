package br.unincor.control;
import java.text.DecimalFormat;
import br.unincor.dao.AlunoDAO;
import br.unincor.dao.DisciplinaDAO;
import br.unincor.dao.NotasDAO;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Usuario gui = new Usuario();
		Operacoes operacao = new Operacoes();
		AlunoDAO alunoDao = new AlunoDAO();
		NotasDAO notasDao = new NotasDAO();
		DisciplinaDAO disciplinasDao = new DisciplinaDAO();
		DecimalFormat df = new DecimalFormat("R$0.00");
		DecimalFormat dfNota = new DecimalFormat("00.00");
		
		int op = 0;
		
		while(op!=-1){
			op=gui.exibeMenu();
			if(op==0){
				//Boletim
				String aluno = gui.recebeTexto("Digite o nome do aluno");
				String boletim=operacao.exibeBoletim(alunoDao.selectAluno(), 
						notasDao.selectNotas(),
						disciplinasDao.selectDisciplinas(), 
						aluno);
				gui.exibeMsg(boletim);
				int importaBO = gui.importBoletim();
				if(importaBO==0){
					operacao.gerarBoletim(boletim, aluno);
				}
				/*operacao.gerarBoletim(alunoDao.selectAluno(), 
						notasDao.selectNotas(),
						disciplinasDao.selectDisciplinas(), 
						aluno);*/
				System.out.println("Boletim");
			}else if(op==1){
				//Aproveitamento por Disciplina
				String materia = gui.recebeTexto("Digite a materia desejada");
				int idDisc = operacao.escolherDisciplina(materia);
				operacao.arquivoNotasDisc(alunoDao.selectAluno(),
						notasDao.selectNotas(), 
						idDisc, 
						materia);
				System.out.println("Aproveitamento por Disciplina");
			}else if(op==2){
				//Media por Disciplina
				String materia = gui.recebeTexto("Digite a materia desejada");
				int idDisc = operacao.escolherDisciplina(materia);
				Double media = operacao.calculaMediaDiciplina(notasDao.selectNotas(), idDisc);
                if(media!=0){
                	gui.exibeMsg("Média da disciplina " + materia + " é: " + dfNota.format(media));
                }else{
        			gui.exibeMsgErro("Não existe a disciplina "+ materia +" no sistema \n ou pode haver algum erro na escrita");

                }
				
			}else if(op==3){
				//Calculo mensalidade
				Double soma = operacao.totalMensalidade(alunoDao.selectAluno());
				gui.exibeMsg("Total das mensalidades: " + df.format(soma));
				
				
			}
		}	
		

	}

}
