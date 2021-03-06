package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;

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
				+ "'"+ disciplina.getDtCriacao().getDayOfMonth() + "/" + disciplina.getDtCriacao().getMonthValue() + "/" + disciplina.getDtCriacao().getYear() +"',"
				+ "'"+disciplina.getSituacao()+"',"
				+ "'"+disciplina.getSemestre()+"',"
				+ "'"+disciplina.getObservacao()+"')";
		
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
	public boolean delete(Disciplina disciplina) {
		
		String sql;
		
		sql = "DELETE FROM tb_Disciplina WHERE idDisciplina = "+disciplina.getId();
		
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
	public boolean update(Disciplina disciplina) {
		
		String sql = "UPDATE tb_Disciplina SET nome = '"+disciplina.getNome()+"',"
				+ " descricao = '"+disciplina.getDescricao()+"',"
				+ " dtCriacao = '"+disciplina.getDtCriacao().getDayOfMonth() + "/" + disciplina.getDtCriacao().getMonthValue() + "/" + disciplina.getDtCriacao().getYear() +"',"
				+ " situacao = '"+disciplina.getSituacao()+"',"
				+ " semestre = '"+disciplina.getSemestre()+"',"
				+ " observacao = '"+disciplina.getObservacao()+"'"
				+ " WHERE idDisciplina = "+disciplina.getId();
		
		try {
			//Nao tenho certeza se e a mesma linha para alterar
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
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
		
		return false;
	}

	@Override
	public Disciplina selectDisciplina(long id) {
		
		Disciplina disciplina = new Disciplina();
		String sql = "SELECT * FROM tb_Disciplina WHERE idDisciplina = '"+id+"'";
		
		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				disciplina.setId(rs.getInt("idDisciplina"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setDescricao(rs.getString("descricao"));
				disciplina.setDtCriacao(LocalDate.of(Integer.parseInt(rs.getString("dtCriacao").substring(0, 4)), Integer.parseInt(rs.getString("dtCriacao").substring(5, 7)), Integer.parseInt(rs.getString("dtCriacao").substring(8, 10))));
				disciplina.setSituacao(rs.getString("situacao"));
				disciplina.setSemestre(rs.getString("semestre"));
				disciplina.setObservacao(rs.getString("observacao"));
			}
			
			return disciplina;
			
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
	
	@Override
	public List<Disciplina> filtroDisciplinas(String nome) throws UsuarioNaoEncontradoException{
		
		List<Disciplina> disciplinas =  new ArrayList<>();
		Disciplina disciplina;
		
		try {
			stmt = con.getConnection().createStatement();
			String sql = "SELECT * FROM tb_Disciplina WHERE nome LIKE '" + nome + "%'";
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
			
			if(disciplinas.isEmpty()){
				throw new UsuarioNaoEncontradoException("Disciplina nao cadastrada no sistema");
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
