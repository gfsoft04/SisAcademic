package br.com.gfsoft.sisacademic.controller;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.persistence.AlunoDao;


public class AlunoController {
	
	public void adicionarAluno(Aluno aluno){
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.insert(aluno);
	}
	
	public void removerAluno(Aluno aluno){
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.delete(aluno);
	}
	
	public void atualizarAluno(Aluno aluno){
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.update(aluno);
	}
	
	public Aluno listarAluno(Aluno aluno){
		AlunoDao alunoDao = new AlunoDao();
		return alunoDao.selectAluno(aluno.getMatricula());
	}
	
	public Set<Aluno> listarAlunos(long id){
		AlunoDao alunoDao = new AlunoDao();
		return alunoDao.selectAlunos();
	}

}
