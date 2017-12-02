package br.unincor.model;

import java.util.Date;

public class Aluno{
	
	private Integer matricula;
	private String nome;
	private Date dt_nasc;
	private String cpf;
	private Double mensalidade;
	
	public Aluno(Integer matricula, String nome, Date dt_nasc, String cpf, Double mensalidade) {
		super();
		if(matricula>=0){
			this.matricula = matricula;			
		}else{
			this.matricula=null;
		}
		this.nome = nome;
		this.dt_nasc = dt_nasc;
		if(cpf.length()==14){
			this.cpf = cpf;
		}else{
			this.cpf=null;
		}
		if(mensalidade>=0){
			this.mensalidade = mensalidade;
		}else{
			this.mensalidade=null;
		}
	}
	

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		if(matricula>=0){
			this.matricula = matricula;			
		}else{
			this.matricula=null;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.length()==14){
			this.cpf = cpf;
		}else{
			this.cpf=null;
			}
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		if(mensalidade>=0){
			this.mensalidade = mensalidade;
		}else{
			this.mensalidade=null;
		}
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", dt_nasc=" + dt_nasc + ", cpf=" + cpf
				+ ", mensalidade=" + mensalidade + "]";
	}
	
	
	
	

}
