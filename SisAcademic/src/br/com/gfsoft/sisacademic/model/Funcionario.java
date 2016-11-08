package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	/**
	 * Atributos da classe Funcionario
	 */
	private LocalDate dtContratacao;
	private String cargo;
	private Double salario;
	private String escolaridade; // 1º Grau Incompleto, Superior Completo 
	
	/**
	 * Metodos Getter's e Setter's
	 */
	public LocalDate getDtContratacao() {
		return dtContratacao;
	}
	public void setDtContratacao(LocalDate dtContratacao) {
		this.dtContratacao = dtContratacao;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}


}
