package br.com.gfsoft.sisacademic.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

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
						+"'29/02/1992',"
						//+ "'"+ pessoa.getDtNascimento() +"',"
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
