package br.com.gfsoft.sisacademic.persistence;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;

public interface IPersistenceDisciplina {
	
	public boolean insert(Disciplina disciplina);
	public boolean delete(Disciplina disciplina);
	public boolean update(Disciplina disciplina);
	public Disciplina selectDisciplina(long id); 
	public List<Disciplina> selectDisciplinas();
	public List<Disciplina> filtroDisciplinas(String nome) throws UsuarioNaoEncontradoException;

}
