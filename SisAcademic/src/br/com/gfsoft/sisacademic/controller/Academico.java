package br.com.gfsoft.sisacademic.controller;

import java.util.List;
import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.Professor;
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
	
	//-------------Metodos da Disciplina------------------------
	
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
	
	public List<Disciplina> listarDisciplinas(){
		return disciplinaService.listar();
	}
	
	//-------------Metodos do Aluno-----------------------------
	
	public boolean cadastrarAluno(Aluno aluno){
		return alunoService.cadastrar(aluno);
	}
	
	public boolean deletarAluno(Aluno aluno){
		return alunoService.deletar(aluno);
	}
	
	public boolean atualizarAluno(Aluno aluno){
		return alunoService.atualizar(aluno);
	}
	
	public Aluno buscarAluno(String matricula){
		return alunoService.buscar(matricula);
	}
	
	public Set<Aluno> listarAlunos(){
		return alunoService.listar();
	}
	
	//-------------Metodos do Funcionario-----------------------------
	
	public boolean cadastrarFuncionario(Funcionario funcionario){
		return funcionarioService.cadastrar(funcionario);
	}
	
	public boolean deletarAluno(Funcionario funcionario){
		return funcionarioService.deletar(funcionario);
	}
	
	public boolean atualizarAluno(Funcionario funcionario){
		return funcionarioService.atualizar(funcionario);
	}
	
	public Funcionario buscarFuncionario(String matricula){
		return funcionarioService.buscar(matricula);
	}
	
	public Set<Funcionario> listarFuncionarios(){
		return funcionarioService.listar();
	}
	
	//-------------Metodos do Funcionario-----------------------------
	
	public boolean cadastrarProfessor(Professor professor){
		return professorService.cadastrar(professor);
	}
	
	public boolean deletarProfessor(Professor professor){
		return professorService.deletar(professor);
	}
	
	public boolean atualizarProfessor(Professor professor){
		return professorService.atualizar(professor);
	}
	
	public Professor buscarProfessor(String matricula){
		return professorService.buscar(matricula);
	}
	
	public Set<Professor> listarProfessores(){
		return professorService.listar();
	}
	
}
