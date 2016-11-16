package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public abstract class Pessoa{
	
	/**
	 * Atributos da classe Pessoa
	 */
	private long id;
	private String matricula;
	private String nome;
	private String rg;
	private String cpf;
	private String estadoCivil; 	//S(solteiro), C(casado), V (viuvo), UE(Uniao Estavel), D(divorciado)
	private String sexo; 			//M(masculino), F(feminino)
	private String situacao; 		//Matriculado (M) ou Nao matriculado (N) ou Ativo (A) ou Inativo (I)
	private LocalDate dtNascimento;
	private String email;
	private String telefone;
	private String rua;
	private int numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado; 			//sigla do estado 'PB'
	private String observacao;
	private String tipoPessoa;
	
	public abstract Pessoa getInstance();
	
	/**
	 * Metodos Getter's e Setter's
	 */
	public long getId() {
		return id;
	}

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

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	/**
	 * metodo ToString
	 */
	@Override
	public String toString() {
		return "Pessoa [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
}
