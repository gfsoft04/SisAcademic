package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

import br.com.gfsoft.sisacademic.model.Professor;

public class PersistenceProfessor implements IPersistenceProfessor {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Professor professor) {
		
		/*
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		
		String sql;
		long id;
		
		if(pFuncionario.insert(professor)){
			
			id = pFuncionario.selectFuncionario(professor.getMatricula());
			
			sql = "INSERT INTO tb_Professor(tb_Funcionario_idPessoa, titularidade) VALUES "
					+ "("+id+", '"+professor.getTitularidade()+"')";
			
			con.getConnection().createStatement().executeUpdate(sql);
			
			
		} */
	
		
		return false;
	}

	@Override
	public boolean delete(Professor professor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Professor professor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Professor selectProfessor(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Professor> selectProfessores() {
		// TODO Auto-generated method stub
		return null;
	}

}
