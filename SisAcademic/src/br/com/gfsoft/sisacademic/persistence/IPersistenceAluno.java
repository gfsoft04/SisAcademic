package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;

public interface IPersistenceAluno {
	
	public boolean insert(Aluno aluno);
	public boolean delete(Aluno aluno);
	public boolean update(Aluno aluno);
	public Aluno selectAluno(String matricula);
	public Set<Aluno> selectAlunos();
	
}
