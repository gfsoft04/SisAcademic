package br.com.gfsoft.sisacademic.persistence;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.Professor;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;

public class PersistenceProfessor implements IPersistenceProfessor {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	
	private VerificaCamposUnique verificaCpf;

	@Override
	public boolean insert(Professor professor) throws HeadlessException, UsuarioJaCadastradoException, CpfInvalidoException {
		
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		Funcionario funcionario = new Funcionario();
		verificaCpf = new VerificaCamposUnique();
		
		String sql;
		long id;
		
		if (!(verificaCpf.validaCpfRg(professor.getCpf(), professor.getRg()))) {
			throw new UsuarioJaCadastradoException("Usuario ja cadastrado no sistema");
		}
		
		if (!(VerificaCamposUnique.validaCpf(professor.getCpf()))) {
			throw new CpfInvalidoException("CPF Invalido");
		}
		
		if(pFuncionario.insert(professor)){
			
			funcionario = pFuncionario.selectFuncionario(professor.getMatricula());		
			
			id = funcionario.getId();
			
			sql = "INSERT INTO tb_Professor(tb_Funcionario_idPessoa, titularidade) VALUES "
					+ "("+id+", '"+professor.getTitularidade()+"')";
			
			try {
				con.getConnection().createStatement().executeUpdate(sql);
				return true;
			} catch (SQLException ex) {
				// Excecao para banco de dados
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na insercao do professor na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}//if inseriu corretamente em funcionario
		
		return false;
	}

	@Override
	public boolean delete(Professor professor) {
		
		String sqlProfessor;
		String sqlFuncionario;
		String sqlPessoa;
		
		sqlProfessor = "DELETE FROM tb_Professor WHERE tb_Funcionario_idPessoa = "+professor.getId();
		sqlFuncionario = "DELETE FROM tb_Funcionario WHERE tb_Pessoa_idPessoa = "+professor.getId();
		sqlPessoa = "DELETE FROM tb_Pessoa WHERE idPessoa = "+professor.getId();
		
		try {
			con.getConnection().createStatement().executeUpdate(sqlProfessor);
			con.getConnection().createStatement().executeUpdate(sqlFuncionario);
			con.getConnection().createStatement().executeUpdate(sqlPessoa);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Professor professor) {
		
		PersistencePessoa pPessoa = new PersistencePessoa();
		PersistenceFuncionario pFuncionario = new PersistenceFuncionario();
		
		professor.setId(pPessoa.selectPessoa(professor.getMatricula()));
		
		System.out.println(professor.getMatricula());
		System.out.println(professor.getId());
		
		if(pFuncionario.update(professor)){
			
			String sql = "UPDATE tb_Professor SET "
					+ "titularidade = '"+professor.getTitularidade()+"' "
					+ "WHERE tb_Funcionario_idPessoa = "+professor.getId();
			
			try {
				//Nao tenho certeza se e a mesma linha para alterar(executeUpdate)
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
		}
		
		
		return false;
	}

	@Override
	public Professor selectProfessor(String matricula) {

		Professor professor = new Professor();
		//A renomeacao vai dar problema com o JTable no pacote ui?
		String sql = "SELECT * FROM tb_Pessoa P INNER JOIN tb_Funcionario F"
				+ "	ON F.tb_Pessoa_idPessoa = P.idPessoa"
				+ "	INNER JOIN tb_Professor Pr"
				+ "	ON Pr.tb_Funcionario_idPessoa = F.tb_Pessoa_idPessoa"
				+ " WHERE matricula = '" + matricula + "'";

		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				professor.setId(rs.getInt("idPessoa"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setNome(rs.getString("nome"));
				professor.setRg(rs.getString("rg"));
				professor.setCpf(rs.getString("cpf"));
				professor.setEmail(rs.getString("email"));
				professor.setEstadoCivil(rs.getString("estadoCivil"));
				professor.setSexo(rs.getString("sexo"));
				professor.setSituacao(rs.getString("situacao"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)), Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)), Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
				professor.setCep(rs.getString("cep"));
				professor.setRua(rs.getString("rua"));
				professor.setNumero(rs.getInt("numero"));
				professor.setBairro(rs.getString("bairro"));
				professor.setCidade(rs.getString("cidade"));
				professor.setEstado(rs.getString("estado"));
				professor.setComplemento(rs.getString("complemento"));
				professor.setObservacao(rs.getString("observacao"));
				professor.setDtContratacao(LocalDate.of(Integer.parseInt(rs.getString("dtContratacao").substring(0, 4)),
						Integer.parseInt(rs.getString("dtContratacao").substring(5, 7)),
						Integer.parseInt(rs.getString("dtContratacao").substring(8, 10))));
				professor.setCargo(rs.getString("cargo"));
				professor.setSalario(rs.getDouble("salario"));
				professor.setEscolaridade(rs.getString("escolaridade"));
				professor.setTitularidade(rs.getString("titularidade"));
			}
			return professor;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca do professor na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	
		return null;
	}

	@Override
	public Set<Professor> selectProfessores() {
		
		Set<Professor> professores = new HashSet<>();
		Professor professor;

		try {
			stmt = con.getConnection().createStatement();
			String sql = "SELECT * FROM tb_Pessoa P INNER JOIN tb_Funcionario F"
					+ " ON P.idPessoa = F.tb_Pessoa_idPessoa"
					+ " INNER JOIN tb_Professor Pr"
					+ " ON F.tb_Pessoa_idPessoa = Pr.tb_Funcionario_idPessoa";
			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				professor = new Professor();
				
				professor.setId(rs.getInt("idPessoa"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setNome(rs.getString("nome"));
				professor.setRg(rs.getString("rg"));
				professor.setCpf(rs.getString("cpf"));
				professor.setEmail(rs.getString("email"));
				professor.setEstadoCivil(rs.getString("estadoCivil"));
				professor.setSexo(rs.getString("sexo"));
				professor.setSituacao(rs.getString("situacao"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)), Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)), Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
				professor.setCep(rs.getString("cep"));
				professor.setRua(rs.getString("rua"));
				professor.setNumero(rs.getInt("numero"));
				professor.setBairro(rs.getString("bairro"));
				professor.setCidade(rs.getString("cidade"));
				professor.setEstado(rs.getString("estado"));
				professor.setComplemento(rs.getString("complemento"));
				professor.setDtContratacao(LocalDate.of(Integer.parseInt(rs.getString("dtContratacao").substring(0, 4)),
						Integer.parseInt(rs.getString("dtContratacao").substring(5, 7)),
						Integer.parseInt(rs.getString("dtContratacao").substring(8, 10))));
				professor.setCargo(rs.getString("cargo"));
				professor.setSalario(rs.getDouble("salario"));
				professor.setEscolaridade(rs.getString("escolaridade"));
				professor.setTitularidade(rs.getString("titularidade"));
				
				professores.add(professor);
			}
			
			return professores;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca dos professores na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}

}
