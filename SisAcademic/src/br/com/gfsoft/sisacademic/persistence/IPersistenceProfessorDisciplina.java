package br.com.gfsoft.sisacademic.persistence;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;

public interface IPersistenceProfessorDisciplina {
	
	public boolean insert(long idProfessor, long idDisciplina);
	public boolean delete(long idProfessor, long idDisciplina);
	public List<Disciplina> select(long idProfessor);

}
