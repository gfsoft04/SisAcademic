package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.Professor;

public class PersistenceProfessor implements IPersistenceProfessor {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Professor professor) {
		
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		Funcionario funcionario = new Funcionario();
		
		String sql;
		long id;
		
		if(pFuncionario.insert(professor)){
			
			funcionario = pFuncionario.selectFuncionario(professor.getMatricula());		
			
			id = funcionario.getId();
			
			sql = "INSERT INTO tb_Professor(tb_Funcionario_idPessoa, titularidade) VALUES "
					+ "("+id+", '"+professor.getTitularidade()+"')";
			
			try {
				con.getConnection().createStatement().executeUpdate(sql);
				return true;
			} catch (SQLException ex) {
				// Excecao para banco de dados
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na insercao do aluno na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}//if inseriu corretamente em pessoa
		
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
