package br.com.gfsoft.sisacademic.service;

import java.util.Set;

import br.com.gfsoft.sisacademic.model.Professor;
import br.com.gfsoft.sisacademic.persistence.IPersistenceProfessor;
import br.com.gfsoft.sisacademic.persistence.PersistenceProfessor;

public class ProfessorService {
	
	private IPersistenceProfessor persistencia;
	
	public ProfessorService() {
		persistencia = new PersistenceProfessor();
	}
		
	public boolean cadastrar(Professor professor){
		return persistencia.insert(professor);
	}
	
	public boolean deletar(Professor professor){
		return persistencia.delete(professor);
	}
	
	public boolean atualizar(Professor professor){
		return persistencia.update(professor);
	}
	
	public Professor buscar(String matricula){
		return persistencia.selectProfessor(matricula);
	}
	
	public Set<Professor> listar(){
		return persistencia.selectProfessores();
	}

}
