package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;

public interface IPersistenceFuncionario {
	
	public boolean insert(Funcionario funcionario) throws UsuarioJaCadastradoException, CpfInvalidoException;
	public boolean delete(Funcionario funcionario);
	public boolean update(Funcionario funcionario);
	public Funcionario selectFuncionario(String matricula);
	public Set<Funcionario> selectFuncionarios();
	public Set<Funcionario> filtroFuncionarios(String nome) throws UsuarioNaoEncontradoException;

}
