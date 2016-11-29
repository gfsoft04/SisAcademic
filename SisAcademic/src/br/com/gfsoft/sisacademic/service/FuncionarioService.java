package br.com.gfsoft.sisacademic.service;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.persistence.IPersistenceFuncionario;
import br.com.gfsoft.sisacademic.persistence.PersistenceFuncionario;

public class FuncionarioService {
	
	private IPersistenceFuncionario persistencia;
	
	public FuncionarioService(){
		persistencia = new PersistenceFuncionario();
	}
	
	public boolean cadastrar(Funcionario funcionario) throws UsuarioJaCadastradoException, CpfInvalidoException{
		return persistencia.insert(funcionario);
	}
	
	public boolean deletar(Funcionario funcionario){
		return persistencia.delete(funcionario);
	}
	
	public boolean atualizar(Funcionario funcionario){
		return persistencia.update(funcionario);
	}
	
	public Funcionario buscar(String matricula){
		return persistencia.selectFuncionario(matricula);
	}
	
	public Set<Funcionario> listar(){
		return persistencia.selectFuncionarios();
	}
	
	public Set<Funcionario> filtrar(String nome){
		return persistencia.filtroFuncionarios(nome);
	}

}
