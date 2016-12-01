package br.com.gfsoft.sisacademic.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Pessoa;

public class PersistencePessoa implements IPersistencePessoa {
	
	//private static Statement stmt;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Pessoa pessoa) {
		
		String sql = "INSERT INTO tb_Pessoa(matricula, nome, cpf, rg, estadoCivil, sexo, situacao, dtNascimento, email, telefone, rua, numero, complemento, cep, bairro, cidade, estado, observacao, urlFoto) "
				+ "VALUES('"+ pessoa.getMatricula() +"',"
						+ "'"+ pessoa.getNome() +"',"
						+ "'"+ pessoa.getCpf() +"',"
						+ "'"+ pessoa.getRg() +"',"
						+ "'"+ pessoa.getEstadoCivil() +"',"
						+ "'"+ pessoa.getSexo() +"',"
						+ "'"+ pessoa.getSituacao() +"',"
						+ "'"+ pessoa.getDtNascimento().getDayOfMonth() + "/" + pessoa.getDtNascimento().getMonthValue() + "/" + pessoa.getDtNascimento().getYear() +"',"
						+ "'"+ pessoa.getEmail() +"',"
						+ "'"+ pessoa.getTelefone() +"',"
						+ "'"+ pessoa.getRua() +"',"
						+ pessoa.getNumero() +","
						+ "'"+ pessoa.getComplemento() +"',"
						+ "'"+ pessoa.getCep() +"',"
						+ "'"+ pessoa.getBairro() +"',"
						+ "'"+ pessoa.getCidade() +"',"
						+ "'"+ pessoa.getEstado() +"',"
						+ "'"+ pessoa.getObservacao() +"',"
						+ "'"+ pessoa.getUrlFoto() + "'"
						+ ")";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException ex) {
			// Excecao para banco de dados
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na inserção dos dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
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
	public boolean delete(Pessoa pessoa) {
		
		String sql;
		
		sql = "DELETE FROM tb_Pessoa WHERE idPessoa = "+pessoa.getId()+"";
		
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
	public boolean update(Pessoa pessoa) {
		
		String sql = "UPDATE tb_Pessoa SET nome = '"+pessoa.getNome()+"',"
				+ " estadoCivil = '"+pessoa.getEstadoCivil()+"',"
				+ " sexo = '"+pessoa.getSexo()+"',"
				+ " situacao = '"+pessoa.getSituacao()+"',"
				+ " email = '"+pessoa.getEmail()+"',"
				+ " telefone = '"+pessoa.getTelefone()+"',"
				+ " rua = '"+pessoa.getRua()+"',"
				+ " numero = "+pessoa.getNumero()+","
				+ " complemento = '"+pessoa.getComplemento()+"',"
				+ " cep = '"+pessoa.getCep()+"',"
				+ " bairro = '"+pessoa.getBairro()+"',"
				+ " cidade = '"+pessoa.getCidade()+"',"
				+ " estado = '"+pessoa.getEstado()+"',"
				+ " observacao = '"+pessoa.getObservacao()+"',"
				+ "urlFoto = '"+ pessoa.getUrlFoto() + "'"
																				
				+ " WHERE idPessoa = "+pessoa.getId();
		
		try {
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
	public long selectPessoa(String matricula) {
		
		long id = 0;
		String sql = "SELECT * FROM tb_Pessoa WHERE matricula='" + matricula + "'";
		
		try {
			stmt = con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getLong("idPessoa");
			}
			
			return id;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return id;
	}

	@Override
	public Set<Pessoa> selectPessoas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Metodo para buscar quantidade de registros (CPF OU RG)
	 * 
	 * @param campo -> Coluna ou Campo da tabela
	 * @param valor -> Valor a ser buscado
	 * @return quantidade de registros encontrado na base
	 */
	public int qtdRegistros(String campo, String valor){
		
		String sql = "SELECT COUNT(*) AS QTD FROM tb_Pessoa WHERE " + campo + "='" + valor + "'";
		int qtd = 0;
		
		try {
			stmt = con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				qtd = rs.getInt("QTD");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		return qtd;
	}
	

	public int selectUltimoID(){
		String sql = "SELECT * FROM tb_Pessoa ORDER BY idPessoa";
		int id = 0;
		
		try {
			stmt = con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("idPessoa");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		return id;
	}

}
