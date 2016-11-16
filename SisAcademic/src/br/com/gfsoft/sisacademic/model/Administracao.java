package br.com.gfsoft.sisacademic.model;

public class Administracao extends Funcionario{
	
	/**
	 * Atributos da classe Administracao
	 */
	private String senha;
	
	public Administracao getInstance(){
		return new Administracao();
	}

	/**
	 * Metodos Getter's e Setter's
	 */
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
