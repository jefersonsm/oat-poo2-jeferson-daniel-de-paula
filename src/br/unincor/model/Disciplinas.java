package br.unincor.model;

public class Disciplinas{
	
	private Integer id;
	private String nome;
	
	public Disciplinas(Integer id, String nome) {
		super();
		this.id = id;
		if(nome.length()<=255 && nome!=""){
			this.nome = nome;
		}else{
			this.nome=null;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.length()<=255 && nome!=""){
			this.nome = nome;
		}else{
			this.nome=null;
		}
	}

	@Override
	public String toString() {
		return "Diciplinas [id=" + id + ", nome=" + nome + "]";
	}
	
		
}