package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Disciplina;

public class PersistenceProfessorDisciplina implements IPersistenceProfessorDisciplina {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(long idProfessor, long idDisciplina) {
		String sql;
		
		sql = "INSERT INTO tb_ProfessorDisciplina(tb_Professor_idPessoa, tb_Disciplina_idDisciplina)"
				+ " VALUES("+ idProfessor +","+ idDisciplina +")";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na insercao dos dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(long idProfessor, long idDisciplina) {
		String sql;
		
		sql = "DELETE FROM tb_ProfessorDisciplina WHERE tb_Professor_idPessoa = "+idProfessor+" AND tb_Disciplina_idDisciplina = "+idDisciplina;
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public List<Disciplina> select(long idProfessor) {
		List<Disciplina> disciplinas =  new ArrayList<>();
		Disciplina disciplina;
		String sql = "SELECT * FROM tb_ProfessorDisciplina AS PD "
				+ "INNER JOIN tb_Disciplina AS D ON PD.tb_Disciplina_idDisciplina = D.idDisciplina "
				+ "WHERE tb_Professor_idPessoa = " + idProfessor;
		
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
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
