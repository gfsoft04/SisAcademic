package br.com.gfsoft.sisacademic.service;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.persistence.IPersistenceAlunoDisciplina;
import br.com.gfsoft.sisacademic.persistence.PersistenceAlunoDisciplina;

public class AlunoDisciplinaService {
	
	IPersistenceAlunoDisciplina persistencia;
	
	public AlunoDisciplinaService(){
		this.persistencia = new PersistenceAlunoDisciplina();
	}

	public boolean cadastrar(long idAluno, long idDisciplina){
		return this.persistencia.insert(idAluno, idDisciplina);
	}
	
	public boolean deletar(long idAluno, long idDisciplina){
		return this.persistencia.delete(idAluno, idDisciplina);
	}
	
	public List<Disciplina> listar(long idAluno){
		return this.persistencia.select(idAluno);
	}
}
