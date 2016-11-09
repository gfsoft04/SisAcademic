package br.com.gfsoft.sisacademic.service;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.persistence.IPersistenceDisciplina;
import br.com.gfsoft.sisacademic.persistence.PersistenceDisciplina;

public class DisciplinaService {
	
	IPersistenceDisciplina persistencia;
	
	public DisciplinaService(){
		this.persistencia = new PersistenceDisciplina();
	}

	public boolean cadastrar(Disciplina disciplina){
		return this.persistencia.insert(disciplina);
	}
	
	public boolean deletar(Disciplina disciplina){
		return this.persistencia.delete(disciplina);
	}
	
	public boolean atualizar(Disciplina disciplina){
		return this.persistencia.update(disciplina);
	}
	
	public Disciplina buscar(String nome){
		return this.persistencia.selectDisciplina(nome);
	}
	
	public List<Disciplina> listar(){
		return this.persistencia.selectDisciplinas();
	}
}
