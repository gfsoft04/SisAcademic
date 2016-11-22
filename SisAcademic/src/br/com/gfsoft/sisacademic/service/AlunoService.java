package br.com.gfsoft.sisacademic.service;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.persistence.IPersistenceAluno;
import br.com.gfsoft.sisacademic.persistence.PersistenceAluno;

public class AlunoService extends Service{
	
	private IPersistenceAluno persistencia;
	
	public AlunoService(){
		
		persistencia = new PersistenceAluno();
		
	}
	
	public Service getService(){
		return new AlunoService();
	}

	public boolean cadastrar(Aluno aluno){
		return persistencia.insert(aluno);
	}
	
	public boolean deletar(Aluno aluno){
		return persistencia.delete(aluno);
	}
	
	public boolean atualizar(Aluno aluno){
		return persistencia.update(aluno);
	}
	
	public Aluno buscar(String matricula){
		return persistencia.selectAluno(matricula);
	}
	
	public Set<Aluno> listar(){
		return persistencia.selectAlunos();
	}
}
