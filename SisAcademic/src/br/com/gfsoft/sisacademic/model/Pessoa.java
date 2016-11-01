package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Pessoa {
	
	private String matricula;
	private String nome;
	private String rg;
	private String cpf;
	private String situacao; 		//matriculado (M) ou n�o matriculado (N)
	private LocalDate dtNascimento;
	private String estadoCivil; 	// S (solteiro), C (casado), V (vi�vo), UE (Uni�o Est�vel), D (divorciado) 
	private String sexo; 			//M (masculino),  F (feminino)
	private String email;
	private String telefone;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado; 			//sigla do estado 'PB'
	private String cep;
	private String observacao;
	

}
