package br.com.gfsoft.sisacademic.persistence;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Administracao;
import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;

public class PersistenceAdministracao implements IPersistenceAdministracao {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	private VerificaCamposUnique verificaCpf;
	
	@Override
	public boolean insert(Administracao administracao) throws HeadlessException, UsuarioJaCadastradoException, CpfInvalidoException {
		
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		Funcionario funcionario = new Funcionario ();
		verificaCpf = new VerificaCamposUnique();
		
		String sql;
		long id;
		
		if (!(verificaCpf.validaCpfRg(administracao.getCpf(), administracao.getRg()))) {
			throw new UsuarioJaCadastradoException("Usuario ja cadastrado no sistema");
		}
		
		if (!(VerificaCamposUnique.validaCpf(administracao.getCpf()))) {
			throw new CpfInvalidoException("CPF Invalido");
		}
		
		if(pFuncionario.insert(administracao)){
			funcionario = pFuncionario.selectFuncionario(administracao.getMatricula());
			
			id = funcionario.getId();
			sql = "INSERT INTO tb_Administracao(tb_Funcionario_idPessoa, senha) "
					+ "VALUES("+ id + ","
					+ "'"+ administracao.getSenha() + "')";
			
			try {
				con.getConnection().createStatement().executeUpdate(sql);
				return true;
			} catch (SQLException ex) {
				// Excecao para banco de dados
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na insercao do administrador na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
//					if(con != null)
//						con.getConnection().close();
					
					if(stmt != null)
						stmt.close();
					
					if(rs != null)
						rs.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//if inseriu corretamente em pessoa
		
		return false;
		
	}

	@Override
	public boolean delete(Administracao administracao) {
//		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
//		Funcionario funcionario = new Funcionario ();
//		
//		String sqlPessoa;
//		String sqlFuncionario;
//		String sqlAdministracao;
//
//		long id;
//		
//		if(pFuncionario.delete(administracao)){
//			funcionario = pFuncionario.selectFuncionario(administracao.getMatricula());
//			id = funcionario.getId();
//			
//			sqlAdministracao = "DELETE FROM tb_Administracao WHERE tb_Funcionario_tb_Pessoa_idPessoa "+ administracao.getId() +"";
//			sqlFuncionario = "DELETE FROM  tb_Funcionario WHERE tb_Pessoa_idPessoa" + administracao.getId()+"";
//			sqlPessoa = "DELETE FROM tb_Pessoa WHERE idPessoa" + administracao.getId() + "";
//			
//			try{
//				con.getConnection().createStatement().executeUpdate(sqlAdministracao);
//				con.getConnection().createStatement().executeUpdate(sqlFuncionario);
//				con.getConnection().createStatement().executeUpdate(sqlPessoa);
//				return true;
//			}catch (SQLException ex){
//				ex.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Erro ao deletar administrador da base de dados","Erro", JOptionPane.ERROR_MESSAGE);
//			} finally {
//				try {
//		//			if(con != null)
//		//				con.getConnection().close();
//					
//					if(stmt != null)
//						stmt.close();
//					
//					if(rs != null)
//						rs.close();
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//				
//			
//		}
		
		
		return false;
	}

	@Override
	public boolean update(Administracao administracao) {
		PersistencePessoa pPessoa = new PersistencePessoa();
		
		if(pPessoa.update(administracao)){
			String sql = "UPDATE tb_Administracao SET"
			+"senha = ' " + administracao.getSenha()
			+"WHERE tb_Funcionario_tb_Pessoa_idPessoa = " + administracao.getId();
		
			try{
				con.getConnection().createStatement().executeQuery(sql);
			}catch(SQLException ex){
				ex.printStackTrace();
			} finally {
				try {
//					if(con != null)
//						con.getConnection().close();
					
					if(stmt != null)
						stmt.close();
					
					if(rs != null)
						rs.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Administracao selectAdministracao(String matricula) {
		Administracao administracao = new Administracao();
		String sql =  "SELECT * FROM tb_Administracao JOIN tb_Pessoa " 
		+ " on tb_Administracao.tb_Funcionario_tb_Pessoa_id_Pessoa = tb_Funcionario.tb_pessoa_idPessoa"
		+ "WHERE matricula ' "+ matricula + "'";//>>>>>>>>>>>>>>>>>>N�O SEI SE ESTA CORRETO!!<<<<<<<<<<<<<<<<<<<<
		
		try{
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			administracao.setId(rs.getInt("idPessoa"));
			administracao.setMatricula(rs.getString("matricula"));
			administracao.setNome(rs.getString("nome"));
			administracao.setRg(rs.getString("rg"));
			administracao.setCpf(rs.getString("cpf"));
			administracao.setEmail(rs.getString("email"));
			administracao.setEstadoCivil(rs.getString("estadoCivil"));
			administracao.setSexo(rs.getString("sexo"));
			administracao.setSituacao(rs.getString("situacao"));
			administracao.setTelefone(rs.getString("telefone"));
			administracao.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)),
				Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)),
				Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
			administracao.setCep(rs.getString("cep"));
			administracao.setRua(rs.getString("rua"));
			administracao.setNumero(rs.getInt("numero"));
			administracao.setBairro(rs.getString("bairro"));
			administracao.setCidade(rs.getString("cidade"));
			administracao.setEstado(rs.getString("estado"));
			administracao.setComplemento(rs.getString("complemento"));
			}
		return administracao;	
		}catch (SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca do administrador na base!", "Erro", JOptionPane.ERROR_MESSAGE);
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
	public Set<Administracao> selectAdministradores() {
		// TODO Auto-generated method stub
		return null;
	}

}
