package br.com.gfsoft.sisacademic.persistence;

import java.awt.HeadlessException;
import java.util.Set;

import br.com.gfsoft.sisacademic.model.Administracao;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;

public interface IPersistenceAdministracao {

	public boolean insert(Administracao administracao) throws HeadlessException, UsuarioJaCadastradoException, CpfInvalidoException;
	public boolean delete(Administracao administracao);
	public boolean update(Administracao administracao);
	public Administracao selectAdministracao(String matricula);
	public Set<Administracao> selectAdministradores();

}
