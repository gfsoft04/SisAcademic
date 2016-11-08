package br.com.gfsoft.sisacademic.persistence;

import java.util.List;

import br.com.gfsoft.sisacademic.model.Disciplina;

public interface IPersistenceDisciplina {
	
	public boolean insert(Disciplina disciplina);
	public boolean delete(Disciplina disciplina);
	public boolean update(Disciplina disciplina);
	public Disciplina selectDisciplina(String nome); //ATENCAO! -- em relacao ao curso
	public List<Disciplina> selectDisciplina(); //ATENCAO! -- list ou set dependendo se ira ter cursos ou nao

}
