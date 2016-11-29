package br.com.gfsoft.sisacademic.persistence;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;

public interface IPersistenceAlunoDisciplina {
	
	public boolean insert(long idAluno, long idDisciplina);
	public boolean delete(long idAluno, long idDisciplina);
	public List<Disciplina> select(long idAluno);

}
