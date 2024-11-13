package br.com.fiap.jdbc.model;

import java.sql.Date;

public class Candidato {
	//atributos
	int  tempoexperiencia;//PK
	String nome, telefone, emial, enderco, formacao;
	Date datanasc;
	long idcandidato;
	long idarea;//FK
	Genero genero;
	
	public Candidato() {
		
	}

	//Constutores
	public Candidato(int tempoexperiencia, String nome, String telefone, String emial, String enderco, String formacao,
			Date datanasc, long idcandidato, long idarea, Genero genero) {
		super();
		this.tempoexperiencia = tempoexperiencia;
		this.nome = nome;
		this.telefone = telefone;
		this.emial = emial;
		this.enderco = enderco;
		this.formacao = formacao;
		this.datanasc = datanasc;
		this.idcandidato = idcandidato;
		this.idarea = idarea;
		this.genero = genero;
	}


	// getters/setters
	public int getTempoexperiencia() {
		return tempoexperiencia;
	}
	public void setTempoexperiencia(int tempoexperiencia) {
		this.tempoexperiencia = tempoexperiencia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getEnderco() {
		return enderco;
	}
	public void setEnderco(String enderco) {
		this.enderco = enderco;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public Date getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}
	public long getIdcandidato() {
		return idcandidato;
	}
	public void setIdcandidato(long idcandidato) {
		this.idcandidato = idcandidato;
	}
	public long getIdarea() {
		return idarea;
	}
	public void setIdarea(long idarea) {
		this.idarea = idarea;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}

	
	
	
