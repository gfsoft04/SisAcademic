package br.com.gfsoft.sisacademic.persistence;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Administracao;

public interface IPersistenceAdministracao {

	//Ainda falta insercao de aluno ou professor 
	public boolean insert(Administracao administracao);
	public boolean delete(Administracao administracao);
	public boolean update(Administracao administracao);
	public Administracao selectAdministracao(String matricula);
	public Set<Administracao> selectAdministradores();

}
