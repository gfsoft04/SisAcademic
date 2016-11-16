package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import br.com.gfsoft.sisacademic.model.Aluno;

public class PersistenceAluno implements IPersistenceAluno {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Aluno aluno) {

		try {
			stmt = con.getConnection().createStatement();
			String sql = "INSERT INTO ...";
			rs = stmt.executeQuery(sql);

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Aluno aluno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Aluno aluno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Aluno selectAluno(String matricula) {
		Aluno aluno = new Aluno();

		try {
			stmt = con.getConnection().createStatement();
			String sql = "SELECT * FROM tabela WHERE matricula='" + matricula + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRg(rs.getString("rg"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEmail(rs.getString("email"));
				aluno.setProfissao(rs.getString("profissao"));
				aluno.setTelefone(rs.getString("telefone"));
				//aluno.setDtNascimento(rs.getDate("dtNascimento"));
				aluno.setCep(rs.getString("cep"));
				aluno.setRua(rs.getString("rua"));
				aluno.setNumero(rs.getInt("numero"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setEstado(rs.getString("estado"));
				aluno.setComplemento(rs.getString("complemento"));
			}
			return aluno;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Set<Aluno> selectAlunos() {
		return null;
	}

}
