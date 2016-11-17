package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Disciplina;

public class PersistenceDisciplina implements IPersistenceDisciplina {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Disciplina disciplina) {
		
		String sql;
		
		sql = "INSERT INTO tb_Disciplina(nome, descricao, dtCriacao, situacao, semestre, observacao)"
				+ " VALUES('"+disciplina.getNome()+"',"
				+ "'"+disciplina.getDescricao()+"',"
				+ "'"+disciplina.getDtCriacao()+"',"
				+ "'"+disciplina.getSituacao()+"',"
				+ "'"+disciplina.getSemestre()+"',"
				+ "'"+disciplina.getObservacao()+"')";
		
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
	public boolean delete(Disciplina disciplina) {
		
		String sql;
		
		sql = "DELETE FROM tb_Disciplina WHERE ... id/nome";
		
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
	public boolean update(Disciplina disciplina) {
		
		String sql = "UPDATE tb_Disciplina SET nome = '"+disciplina.getNome()+"',"
				+ " descricao = '"+disciplina.getDescricao()+"',"
				+ " dtCriacao = '"+disciplina.getDtCriacao()+"',"
				+ " situacao = '"+disciplina.getSituacao()+"',"
				+ " semestre = '"+disciplina.getSemestre()+"',"
				+ " observacao = '"+disciplina.getObservacao()+"'"
				+ " WHERE idDisciplina = "+disciplina.getId()+"";
		
		try {
			//Nao tenho certeza se e a mesma linha para alterar
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
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
		
		return false;
	}

	@Override
	public Disciplina selectDisciplina(String nome) {
		
		Disciplina disciplina = new Disciplina();
		String sql = "SELECT * FROM tb_Disciplina WHERE nome = '"+nome+"'";
		
		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				disciplina.setNome(rs.getString("nome"));
				disciplina.setDescricao(rs.getString("descricao"));
				//disciplina.setDtCriacao();
				disciplina.setSituacao(rs.getString("situacao"));
				disciplina.setSemestre(rs.getString("semestre"));
				disciplina.setObservacao(rs.getString("observacao"));
			}
			
			return disciplina;
			
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

	@Override
	public List<Disciplina> selectDisciplinas() {
		
		List<Disciplina> disciplinas =  new ArrayList<>();
		Disciplina disciplina;
		
		try {
			stmt = con.getConnection().createStatement();
			String sql = "SELECT * FROM tb_Disciplina";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				disciplina = new Disciplina();
				
				disciplina.setNome(rs.getString("nome"));
				disciplina.setDescricao(rs.getString("descricao"));
				//disciplina.setDtCriacao();
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
