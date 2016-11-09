package br.com.gfsoft.sisacademic.controller;

import br.com.gfsoft.sisacademic.service.AlunoService;

public class Academico {
	
	AlunoService aluno;
	
	public Academico(){
		aluno = new AlunoService();
		
	}	
	
}
