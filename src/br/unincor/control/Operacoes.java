package br.unincor.control;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.List;
import br.unincor.model.Aluno;
import br.unincor.model.Disciplinas;
import br.unincor.model.Notas;
import br.unincor.view.Usuario;

public class Operacoes {
	
	private static final String ARQUIVO_DISCIPLINA = "../Disciplina.txt";
	DecimalFormat dfNota = new DecimalFormat("00.00");
	Usuario gui = new Usuario();
	
	public String exibeBoletim(List<Aluno> a, List<Notas> n, List<Disciplinas> d, String nomeAluno){
		
		Boolean existeAluno=false;
		Integer idAluno=0;
		String result="";
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).getNome().equalsIgnoreCase(nomeAluno)){
				existeAluno=true;
				idAluno=a.get(i).getMatricula();
			}			
		}
		
		if(existeAluno==true && idAluno!=0){
			
				result = ("Nome: " + a.get(idAluno-1).getNome() +
						"\nData Nascimento: "+ a.get(idAluno-1).getDt_nasc() +
						"\nCPF:" + a.get(idAluno-1).getCpf() + "\n--- BOLETIM ---");
			
				for (int i = 0; i < n.size(); i++) {
					if(n.get(i).getMat_aluno()==idAluno){
						if(n.get(i).getId_disc()==1){	
							if(n.get(i).getNota()<60){
								result= result + ("\nPortuguês:" + n.get(i).getNota()+"*");
				
							}else{
								result= result + ("\nPortuguês:" + n.get(i).getNota());
							}
						}
		
						if(n.get(i).getId_disc()==2){
							if(n.get(i).getNota()<60){
								result= result + ("\nMatemática:" + n.get(i).getNota()+"*");
							}else{
								result= result + ("\nMatemática:" + n.get(i).getNota());
							}
						}
						if(n.get(i).getId_disc()==3){
							if(n.get(i).getNota()<60){
								result= result + ("\nHistória:" + n.get(i).getNota()+"*");
							}else{
								result= result + ("\nHistória:" + n.get(i).getNota());
							}
						}
						if(n.get(i).getId_disc()==4){
							if(n.get(i).getNota()<60){
								result= result + ("\nGeografia:" + n.get(i).getNota()+"*");								
							}else{
								result= result + ("\nGeografia:" + n.get(i).getNota());								
							}
						}
						if(n.get(i).getId_disc()==5){
							if(n.get(i).getNota()<60){
								result= result + ("\nCiências:" + n.get(i).getNota()+"*");
							}else{
								result= result + ("\nCiências:" + n.get(i).getNota());
							}
						}						
					}
				}
			
		}else{
			gui.exibeMsgErro("Não existe o aluno " +nomeAluno+" no sistema \n ou pode haver algum erro na escrita");
		}
		return result;
	}
	
	public void gerarBoletim(String boletim, String nomeAluno){
		try {
			File ba = new File("../"+nomeAluno+".txt");
			
			if(ba.exists()){
				ba.delete();
			}
			
			FileWriter fw = new FileWriter(ba, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(boletim);
			bw.newLine();
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	
	public void arquivoNotasDisc(List<Aluno> a, List<Notas> n, int idDis, String nomeD){
		if(idDis != 0){
			try {
				File nd = new File(ARQUIVO_DISCIPLINA);
				
				if(nd.exists()){
					nd.delete();
				}
				
				FileWriter fw = new FileWriter(nd, false);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Disciplina: "+ nomeD +"\n--- NOTAS ---");
				bw.newLine();			
				for (int j = 1; j < n.size(); j++) {
					if(n.get(j).getId_disc()==idDis){
						if(n.get(j).getNota()<60){
							bw.write(a.get(n.get(j).getMat_aluno()-1).getNome() + ": " + 
									n.get(j).getNota()+"*");
							bw.newLine();
						}else{
							bw.write(a.get(n.get(j).getMat_aluno()-1).getNome() + ": " + 
						n.get(j).getNota());
							bw.newLine();
						}
						
					}
					
				}			
				bw.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else{
			gui.exibeMsgErro("Não existe a disciplina " +nomeD+" no sistema \n ou pode haver algum erro na escrita");
		}
		
	}
	
	public Double calculaMediaDiciplina(List<Notas> n, int idDis){
		if(idDis != 0){
			Double media = 0D;
			int quantiaAluno=0;
			for (int i = 0; i < n.size(); i++) {
				if(n.get(i).getId_disc()==idDis){
					quantiaAluno+=1;
					media+=n.get(i).getNota();
				}
				
			}
			return media/quantiaAluno;
		}else{
			return 0D;	
			
		}
	}
	
	public Double totalMensalidade(List<Aluno> a){
		Double soma=0D;
		for (int i = 0; i < a.size(); i++) {
			soma+=a.get(i).getMensalidade();			
		}
		return(soma);		
	}
	
	public int escolherDisciplina(String nomeDisciplina) {
		int idDisciplina = 0;
		
		if(nomeDisciplina.equals("português") || nomeDisciplina.equals("portugues"))
			idDisciplina = 1;
		else if(nomeDisciplina.equals("matemática") || nomeDisciplina.equals("matematica"))
			idDisciplina = 2;
		else if(nomeDisciplina.equals("história") || nomeDisciplina.equals("historia"))
			idDisciplina = 3;
		else if(nomeDisciplina.equals("geografia"))
			idDisciplina = 4;
		else if(nomeDisciplina.equals("ciências") || nomeDisciplina.equals("ciencias"))
			idDisciplina = 5;
		else
			idDisciplina = 0;
		
		
		return idDisciplina;
		
		
	}

}
