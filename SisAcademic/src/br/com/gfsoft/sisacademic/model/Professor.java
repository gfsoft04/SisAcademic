package br.com.gfsoft.sisacademic.model;


public class Professor extends Funcionario{
	
	/**
	 * Atributos da classe Professor
	 */
	private String titularidade;		//(M) Mestrado, (D) Doutorado, (E) Especialista	

	/**
	 * Metodos Getter's e Setter's
	 */
	public String getTitularidade() {
		return titularidade;
	}

	public void setTitularidade(String titularidade) {
		this.titularidade = titularidade;
	}
	
	
	
	
}
