package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		String sql;
		
		sql = "DELETE FROM tb_AlunoDisciplina WHERE tb_Aluno_idPessoa = "+idAluno+" AND tb_Disciplina_idDisciplina = "+idDisciplina;
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Disciplina> select(long idAluno) {
		List<Disciplina> disciplinas =  new ArrayList<>();
		Disciplina disciplina;
		String sql = "SELECT * FROM tb_AlunoDisciplina AS AD "
				+ "INNER JOIN tb_Disciplina AS D ON AD.tb_Disciplina_idDisciplina = D.idDisciplina "
				+ "WHERE tb_Aluno_idPessoa = " + idAluno;
		
		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				disciplina = new Disciplina();

				disciplina.setId(rs.getInt("idDisciplina"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setDescricao(rs.getString("descricao"));
				disciplina.setDtCriacao(LocalDate.of(Integer.parseInt(rs.getString("dtCriacao").substring(0, 4)), Integer.parseInt(rs.getString("dtCriacao").substring(5, 7)), Integer.parseInt(rs.getString("dtCriacao").substring(8, 10))));
				disciplina.setSituacao(rs.getString("situacao"));
				disciplina.setSemestre(rs.getString("semestre"));
				disciplina.setObservacao(rs.getString("observacao"));
				
				disciplinas.add(disciplina);
			}
			
			return disciplinas;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} /*finally {
			if (con != null)
				con.close();
	
			if (stmt != null)
				stmt.close();

			if (rs != null)
				rs.close();
			System.out.println("--- Após encerrar as conexões. ---");
		}*/
		
		return null;
	}

}
