package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Disciplina {
	
	/**
	 * Atributos da classe Disciplina
	 */
	private String nome;
	private String descricao; 		//descricao do conteudo ministrado na disciplina 
	private LocalDate dtCriacao; 	//data da criacao da disciplina
	private String situacao; 		//disponivel ou nao disponivel no semestre
	private String semestre; 		//a qual semestre pertence essa disciplina
	private String observacao;
	
	/**
	 * Metodos Getter's e Setter's
	 */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(LocalDate dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


}
