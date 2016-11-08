package br.com.gfsoft.sisacademic.controller;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.persistence.PersistenceAluno;


public class AlunoController {
	
	private PersistenceAluno alunoDao;
	
	public void adicionarAluno(Aluno aluno){
		alunoDao.insert(aluno);
	}
	
	public void removerAluno(Aluno aluno){
		alunoDao.delete(aluno);
	}
	
	public void atualizarAluno(Aluno aluno){
		alunoDao.update(aluno);
	}
	
	public Aluno listarAluno(Aluno aluno){
		return alunoDao.selectAluno(aluno.getMatricula());
	}
	
	public Set<Aluno> listarAlunos(long id){
		return alunoDao.selectAlunos();
	}

}
