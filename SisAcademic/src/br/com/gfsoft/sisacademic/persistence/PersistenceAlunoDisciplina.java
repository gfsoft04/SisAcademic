package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Disciplina;

public class PersistenceAlunoDisciplina implements IPersistenceAlunoDisciplina {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(long idAluno, long idDisciplina) {
		String sql;
		
		sql = "INSERT INTO tb_AlunoDisciplina(tb_Aluno_idPessoa, tb_Disciplina_idDisciplina)"
				+ " VALUES("+ idAluno +","+ idDisciplina +")";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na insercao dos dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}

	@Override
	public boolean delete(long idAluno, long idDisciplina) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(long idAluno, long idDisciplina) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Disciplina> select(long idAluno, long idDisciplina) {
		// TODO Auto-generated method stub
		return null;
	}

}
