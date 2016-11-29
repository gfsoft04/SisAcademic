package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;

public interface IPersistenceAluno {
	
	public boolean insert(Aluno aluno) throws UsuarioJaCadastradoException, CpfInvalidoException;
	public boolean delete(Aluno aluno);
	public boolean update(Aluno aluno);
	public Aluno selectAluno(String matricula) throws UsuarioNaoEncontradoException;
	public Set<Aluno> selectAlunos();
	
}
