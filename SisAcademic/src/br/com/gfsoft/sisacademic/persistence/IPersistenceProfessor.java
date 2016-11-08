package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Professor;

public interface IPersistenceProfessor {
	
	public boolean insert(Professor professor);
	public boolean delete(Professor professor);
	public boolean update(Professor professor);
	public Professor selectProfessor(String matricula);
	public Set<Professor> selectProfessores();

}
