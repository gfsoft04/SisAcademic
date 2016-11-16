package br.com.gfsoft.sisacademic.model;

import java.util.Date;

public class Aluno extends Pessoa{
	
	/**
	 * Atributos da classe Aluno
	 */
	private Date dtMatricula;
	private String profissao;
	
	public Aluno getInstance(){
		return new Aluno();
	}
	
	/**
	 * Metodos Getter's e Setter's
	 */
	public Date getDtMatricula() {
		return dtMatricula;
	}
	public void setDtMatricula(Date dtMatricula) {
		this.dtMatricula = dtMatricula;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
