package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Pessoa {
	
	private String matricula;
	private String nome;
	private String rg;
	private String cpf;
	private String situacao; 		//matriculado (M) ou não matriculado (N) ou ativo (A) ou Inativo (I)
	private LocalDate dtNascimento;
	private String estadoCivil; 	// S (solteiro), C (casado), V (viúvo), UE (União Estável), D (divorciado) 
	private String sexo; 			//M (masculino),  F (feminino)
	private String email;
	private String telefone;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado; 			//sigla do estado 'PB'
	private String cep;
	private String observacao;
	
	
	/**
	 * Metodos Getter's e Setter's
	 */
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numeoro) {
		this.numero = numeoro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Pessoa [matricula=" + matricula + ", nome=" + nome + "]";
	}
}
