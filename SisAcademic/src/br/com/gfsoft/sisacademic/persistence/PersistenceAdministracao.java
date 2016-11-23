package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Administracao;
import br.com.gfsoft.sisacademic.model.Funcionario;

public class PersistenceAdministracao implements IPersistenceAdministracao {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	
	@Override
	public boolean insert(Administracao administracao) {
		
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		Funcionario funcionario = new Funcionario ();
		
		String sql;
		long id;
		
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
			}
		}//if inseriu corretamente em pessoa
		
		return false;
		
	}

	@Override
	public boolean delete(Administracao administracao) {
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		Funcionario funcionario = new Funcionario ();
		
		String sqlPessoa;
		String sqlFuncionario;
		String sqlAdministracao;

		long id;
		
		if(pFuncionario.delete(administracao)){
			funcionario = pFuncionario.selectFuncionario(administracao.getMatricula());
			id = funcionario.getId();
			
			sqlAdministracao = "DELETE FROM tb_Administracao WHERE tb_Funcionario_tb_Pessoa_idPessoa "+ administracao.getId() +"";
			sqlFuncionario = "DELETE FROM  tb_Funcionario WHERE tb_Pessoa_idPessoa" + administracao.getId()+"";
			sqlPessoa = "DELETE FROM tb_Pessoa WHERE idPessoa" + administracao.getId() + "";
			
			try{
				con.getConnection().createStatement().executeUpdate(sqlAdministracao);
				con.getConnection().createStatement().executeUpdate(sqlFuncionario);
				con.getConnection().createStatement().executeUpdate(sqlPessoa);
				return true;
			}catch (SQLException ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao deletar administrador da base de dados","Erro", JOptionPane.ERROR_MESSAGE);
			}
			
				
			
		}
		
		
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
