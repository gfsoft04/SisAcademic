package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Disciplina;

public interface IPersistenceAlunoDisciplina {
	
	public boolean insert(long idAluno, long idDisciplina);
	public boolean delete(long idAluno, long idDisciplina);
	public boolean update(long idAluno, long idDisciplina);
	public Set<Disciplina> select(long idAluno, long idDisciplina);

}
