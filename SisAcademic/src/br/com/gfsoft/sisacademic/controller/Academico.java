package br.com.gfsoft.sisacademic.controller;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.service.DisciplinaService;

public class Academico {
	
	//
	DisciplinaService disciplinaService;
	
	public Academico(){
		this.disciplinaService = new DisciplinaService();
	}
	
	public boolean cadastrarDisciplina(Disciplina disciplina){
		return disciplinaService.cadastrar(disciplina);
	}
	
	public boolean deletarDisciplina(Disciplina disciplina){
		return disciplinaService.deletar(disciplina);
	}
	
	public boolean atualizarDisciplina(Disciplina disciplina){
		return disciplinaService.atualizar(disciplina);
	}
	
	public Disciplina buscarDisciplina(long id){
		return disciplinaService.buscar(id);
	}
	
	public List<Disciplina> listarDisciplina(){
		return disciplinaService.listar();
	}
	
}
