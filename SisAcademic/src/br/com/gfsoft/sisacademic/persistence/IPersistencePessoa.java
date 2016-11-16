package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Pessoa;

public interface IPersistencePessoa {
	
	public boolean insert(Pessoa pessoa);
	public boolean delete(Pessoa pessoa);
	public boolean update(Pessoa pessoa);
	public int selectPessoa(String matricula);
	public Set<Pessoa> selectPessoas();

}
