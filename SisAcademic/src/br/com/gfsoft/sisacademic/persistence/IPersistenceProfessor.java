package br.com.gfsoft.sisacademic.persistence;

import java.awt.HeadlessException;
import java.util.Set;

import br.com.gfsoft.sisacademic.model.Professor;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;

public interface IPersistenceProfessor {
	
	public boolean insert(Professor professor) throws HeadlessException, UsuarioJaCadastradoException, CpfInvalidoException;
	public boolean delete(Professor professor);
	public boolean update(Professor professor);
	public Professor selectProfessor(String matricula);
	public Set<Professor> selectProfessores();

}
