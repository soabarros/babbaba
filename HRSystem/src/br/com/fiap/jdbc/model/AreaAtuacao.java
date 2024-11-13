package br.com.fiap.jdbc.model;

public class AreaAtuacao {
// atributos
	int idarea;
	String nome;
	
	
	
	//Contrutores 
	public AreaAtuacao(int idarea, String nome) {
		super();
		this.idarea = idarea;
		this.nome = nome;
	}
	//getters/setters 
	public int getIdarea() {
		return idarea;
	}
	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
