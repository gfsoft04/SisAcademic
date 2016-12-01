package br.com.gfsoft.sisacademic.service;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.persistence.IPersistenceProfessorDisciplina;
import br.com.gfsoft.sisacademic.persistence.PersistenceProfessorDisciplina;

public class ProfessorDisciplinaService {
	
	IPersistenceProfessorDisciplina persistencia;
	
	public ProfessorDisciplinaService(){
		this.persistencia = new PersistenceProfessorDisciplina();
	}

	public boolean cadastrar(long idProfessor, long idDisciplina){
		return this.persistencia.insert(idProfessor, idDisciplina);
	}
	
	public boolean deletar(long idProfessor, long idDisciplina){
		return this.persistencia.delete(idProfessor, idDisciplina);
	}
	
	public List<Disciplina> listar(long idProfessor){
		return this.persistencia.select(idProfessor);
	}

}
