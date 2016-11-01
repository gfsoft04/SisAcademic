package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Disciplina {
	
	private String nome;
	private String descricao; 		//descricao do conteúdo ministrado na disciplina 
	private LocalDate dtCriacao; 	//data da criação da disciplina
	private String situacao; 		//disponível ou não disponível no semestre
	private String semestre; 		//a qual semestre pertence essa disciplina
	private String observacao;


}
