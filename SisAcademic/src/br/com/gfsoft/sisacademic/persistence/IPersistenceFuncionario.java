package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Funcionario;

public interface IPersistenceFuncionario {
	
	public boolean insert(Funcionario funcionario);
	public boolean delete(Funcionario funcionario);
	public boolean update(Funcionario funcionario);
	public Funcionario selectFuncionario(String matricula);
	public Set<Funcionario> selectFuncionarios();

}
