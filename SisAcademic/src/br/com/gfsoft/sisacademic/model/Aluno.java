package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Aluno extends Pessoa{
	
	/**
	 * Atributos da classe Aluno
	 */
	private LocalDate dtMatricula;
	private String profissao;
	
	public Aluno getInstance(){
		return new Aluno();
	}
	
	/**
	 * Metodos Getter's e Setter's
	 */
	public LocalDate getDtMatricula() {
		return dtMatricula;
	}
	public void setDtMatricula(LocalDate dtMatricula) {
		this.dtMatricula = dtMatricula;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
