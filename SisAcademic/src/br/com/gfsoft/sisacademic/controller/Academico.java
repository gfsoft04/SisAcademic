package br.com.gfsoft.sisacademic.controller;

import java.awt.HeadlessException;
import java.util.List;
import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.Professor;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;
import br.com.gfsoft.sisacademic.service.AlunoDisciplinaService;
import br.com.gfsoft.sisacademic.service.AlunoService;
import br.com.gfsoft.sisacademic.service.DisciplinaService;
import br.com.gfsoft.sisacademic.service.FuncionarioService;
import br.com.gfsoft.sisacademic.service.ProfessorDisciplinaService;
import br.com.gfsoft.sisacademic.service.ProfessorService;

public class Academico {
	
	AlunoService alunoService;
	ProfessorService professorService;
	FuncionarioService funcionarioService;
	AlunoDisciplinaService alunoDisciplinaService;
	ProfessorDisciplinaService professorDisciplinaService;
	DisciplinaService disciplinaService;
	
	public Academico(){
		this.disciplinaService = new DisciplinaService();
		this.alunoService = new AlunoService();
		this.professorService = new ProfessorService();
		this.funcionarioService = new FuncionarioService();
		this.alunoDisciplinaService = new AlunoDisciplinaService();
		this.professorDisciplinaService = new ProfessorDisciplinaService();
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
	
	public List<Disciplina> filtrarDisciplinas(String nome) throws UsuarioNaoEncontradoException{
		return disciplinaService.filtrar(nome);
	}
	
	//-------------Metodos do Aluno-----------------------------
	
	public boolean cadastrarAluno(Aluno aluno) throws UsuarioJaCadastradoException, CpfInvalidoException{
		return alunoService.cadastrar(aluno);
	}
	
	public boolean deletarAluno(Aluno aluno){
		return alunoService.deletar(aluno);
	}
	
	public boolean atualizarAluno(Aluno aluno){
		return alunoService.atualizar(aluno);
	}
	
	public Aluno buscarAluno(String matricula) throws UsuarioNaoEncontradoException{
		return alunoService.buscar(matricula);
	}
	
	public Set<Aluno> listarAlunos(){
		return alunoService.listar();
	}
	
	public Set<Aluno> filtrarAlunos(String nome) throws UsuarioNaoEncontradoException{
		return alunoService.filtrar(nome);
	}
	
	//-------------Metodos do Funcionario-----------------------------
	
	public boolean cadastrarFuncionario(Funcionario funcionario) throws UsuarioJaCadastradoException, CpfInvalidoException{
		return funcionarioService.cadastrar(funcionario);
	}
	
	public boolean deletarFuncionario(Funcionario funcionario){
		return funcionarioService.deletar(funcionario);
	}
	
	public boolean atualizarFuncionario(Funcionario funcionario){
		return funcionarioService.atualizar(funcionario);
	}
	
	public Funcionario buscarFuncionario(String matricula){
		return funcionarioService.buscar(matricula);
	}
	
	public Set<Funcionario> listarFuncionarios(){
		return funcionarioService.listar();
	}
	
	public Set<Funcionario> filtrarFuncionarios(String nome) throws UsuarioNaoEncontradoException{
		return funcionarioService.filtrar(nome);
	}
	
	//-------------Metodos do Professor-----------------------------
	
	public boolean cadastrarProfessor(Professor professor) throws HeadlessException, UsuarioJaCadastradoException, CpfInvalidoException{
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
	
	public Set<Professor> filtrarProfessores(String nome) throws UsuarioNaoEncontradoException{
		return professorService.filtrar(nome);
	}
	
	//-------------Metodos do Aluno Disciplina-----------------------------
	
	public boolean cadastrarAlunoDisciplina(long idAluno, long idDisciplina){
		return alunoDisciplinaService.cadastrar(idAluno, idDisciplina);
	}
	
	public boolean deletarAlunoDisciplina(long idAluno, long idDisciplina){
		return alunoDisciplinaService.deletar(idAluno, idDisciplina);
	}
	
	public List<Disciplina> listarAlunoDisciplinas(long idAluno){
		return alunoDisciplinaService.listar(idAluno);
	}
	
	//-------------Metodos do Professor Disciplina-----------------------------
	
		public boolean cadastrarProfessorDisciplina(long idProfessor, long idDisciplina){
			return professorDisciplinaService.cadastrar(idProfessor, idDisciplina);
		}
		
		public boolean deletarProfessorDisciplina(long idProfessor, long idDisciplina){
			return professorDisciplinaService.deletar(idProfessor, idDisciplina);
		}
		
		public List<Disciplina> listarProfessorDisciplinas(long idProfessor){
			return professorDisciplinaService.listar(idProfessor);
		}
	
}
