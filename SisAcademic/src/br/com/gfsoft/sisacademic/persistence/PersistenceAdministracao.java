package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Administracao;

public class PersistenceAdministracao implements IPersistenceAdministracao {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	
	@Override
	public boolean insert(Administracao administracao) {
		
		//PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		//String sql;
		//long id;
		
//		if(pFuncionario.insert(administracao)){
//			//id = pFuncionario.selectFuncionario(administracao.getMatricula());
//			
//		//	sql = "INSERT INTO tb_Aluno(tb_Funcionario_idPessoa, senha) "
//	//				+ "VALUES("+ id + ","
//		//			+ "'"+ administracao.getSenha() + "')";
//			
//			try {
//				con.getConnection().createStatement().executeUpdate(sql);
//				return true;
//			} catch (SQLException ex) {
//				// Excecao para banco de dados
//				ex.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Erro na insercao do administrador na base!", "Erro", JOptionPane.ERROR_MESSAGE);
//			}
//		}//if inseriu corretamente em pessoa
//		
//		return false;
		
		return false;
	}

	@Override
	public boolean delete(Administracao administracao) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Administracao administracao) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Administracao selectAdministracao(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Administracao> selectAdministradores() {
		// TODO Auto-generated method stub
		return null;
	}

}
