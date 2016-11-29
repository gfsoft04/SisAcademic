package br.com.gfsoft.sisacademic.service;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;
import br.com.gfsoft.sisacademic.persistence.IPersistenceAluno;
import br.com.gfsoft.sisacademic.persistence.PersistenceAluno;

public class AlunoService extends Service{
	
	private IPersistenceAluno persistencia;
	
	public AlunoService(){
		
		persistencia = new PersistenceAluno();
		
	}

	public boolean cadastrar(Aluno aluno) throws UsuarioJaCadastradoException, CpfInvalidoException{
		return persistencia.insert(aluno);
	}
	
	public boolean deletar(Aluno aluno){
		return persistencia.delete(aluno);
	}
	
	public boolean atualizar(Aluno aluno){
		return persistencia.update(aluno);
	}
	
	public Aluno buscar(String matricula) throws UsuarioNaoEncontradoException{
		return persistencia.selectAluno(matricula);
	}
	
	public Set<Aluno> listar(){
		return persistencia.selectAlunos();
	}
	
	public Set<Aluno> filtrar(String nome){
		return persistencia.filtroAlunos(nome);
	} 
}
