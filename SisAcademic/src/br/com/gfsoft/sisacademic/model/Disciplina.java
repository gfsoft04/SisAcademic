package br.com.gfsoft.sisacademic.model;

import java.time.LocalDate;

public class Disciplina {
	
	private String nome;
	private String descricao; 		//descricao do conte�do ministrado na disciplina 
	private LocalDate dtCriacao; 	//data da cria��o da disciplina
	private String situacao; 		//dispon�vel ou n�o dispon�vel no semestre
	private String semestre; 		//a qual semestre pertence essa disciplina
	private String observacao;


}
