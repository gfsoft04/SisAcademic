package br.com.gfsoft.sisacademic.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		String sql = "INSERT INTO tb_Pessoa(matricula, nome, cpf, rg, estadoCivil, sexo, situacao, dtNascimento, email, telefone, rua, numero, complemento, cep, bairro, cidade, estado, observacao) "
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
						+ "'"+ pessoa.getObservacao() +"'"
						+ ")";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException ex) {
			// Excecao para banco de dados
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na inserção dos dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}

	@Override
	public boolean delete(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int selectPessoa(String matricula) {
		
		int id = 0;
		String sql = "SELECT * FROM tb_Pessoa WHERE matricula='" + matricula + "'";
		
		try {
			stmt = con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("idPessoa");
			}
			
			return id;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public Set<Pessoa> selectPessoas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean selectCpf(String cpf){
		
		String sql = "SELECT * FROM tb_Pessoa WHERE cpf='" + cpf + "'";
		String campo = "";
		
		try {
			stmt = con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				campo = rs.getString("cpf");
				System.out.println("entrou na while!");
			}
			
			System.out.println(campo);
			
			if(campo.equals("")){
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean selectRg(String rg){
		
		String sql = "SELECT * FROM tb_Pessoa WHERE rg='" + rg + "'";
		String campo = "";
		
		try {
			stmt = con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				campo = rs.getString("cpf");
				System.out.println("entrou na while!");
			}
			
			System.out.println(campo);
			
			if(campo.equals("")){
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
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
			
			System.out.println(id);
			return id;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

}
