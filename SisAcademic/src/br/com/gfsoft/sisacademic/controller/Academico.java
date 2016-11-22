package br.com.gfsoft.sisacademic.controller;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.service.AlunoService;
import br.com.gfsoft.sisacademic.service.DisciplinaService;
import br.com.gfsoft.sisacademic.service.FuncionarioService;
import br.com.gfsoft.sisacademic.service.ProfessorService;

public class Academico {
	
	AlunoService alunoService;
	ProfessorService professorService;
	FuncionarioService funcionarioService;
	
	DisciplinaService disciplinaService;
	
	public Academico(){
		this.disciplinaService = new DisciplinaService();
		
		this.alunoService = new AlunoService();
		this.professorService = new ProfessorService();
		this.funcionarioService = new FuncionarioService();
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
	
	//-------------------------------------------------
	
	public boolean cadastrarAluno(Aluno aluno){
		return alunoService.cadastrar(aluno);
	}
	
}
