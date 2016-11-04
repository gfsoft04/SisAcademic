package br.com.gfsoft.sisacademic.controller;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.persistence.AlunoDaoImp;


public class AlunoController {
	
	public void adicionarAluno(Aluno aluno){
		AlunoDaoImp alunoDao = new AlunoDaoImp();
		alunoDao.insert(aluno);
	}
	
	public void removerAluno(Aluno aluno){
		AlunoDaoImp alunoDao = new AlunoDaoImp();
		alunoDao.delete(aluno);
	}
	
	public void atualizarAluno(Aluno aluno){
		AlunoDaoImp alunoDao = new AlunoDaoImp();
		alunoDao.update(aluno);
	}
	
	public Aluno listarAluno(Aluno aluno){
		AlunoDaoImp alunoDao = new AlunoDaoImp();
		return alunoDao.selectAluno(aluno.getMatricula());
	}
	
	public Set<Aluno> listarAlunos(long id){
		AlunoDaoImp alunoDao = new AlunoDaoImp();
		return alunoDao.selectAlunos();
	}

}
