package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;

public class PersistenceAluno implements IPersistenceAluno {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	private VerificaCamposUnique verificaCpf;

	@Override
	public boolean insert(Aluno aluno) throws UsuarioJaCadastradoException, CpfInvalidoException {
		
		PersistencePessoa pPessoa = new PersistencePessoa();
		verificaCpf = new VerificaCamposUnique();
		String sql;
		long id;
		
		if (!(verificaCpf.validaCpfRg(aluno.getCpf(), aluno.getRg()))) {
			throw new UsuarioJaCadastradoException("Usuario ja cadastrado no sistema");
		}
		
		if (!(VerificaCamposUnique.validaCpf(aluno.getCpf()))) {
			throw new CpfInvalidoException("CPF Invalido");
		}
		
		if(pPessoa.insert(aluno)){
			id = pPessoa.selectPessoa(aluno.getMatricula());
			
			sql = "INSERT INTO tb_Aluno(tb_Pessoa_idPessoa, dtMatricula, profissao) "
					+ "VALUES("+ id + ","
					+ "'"+ aluno.getDtNascimento().getDayOfMonth() + "/" + aluno.getDtNascimento().getMonthValue() + "/" + aluno.getDtNascimento().getYear() +"',"
					+ "'"+ aluno.getProfissao() + "')";
			
			try {
				con.getConnection().createStatement().executeUpdate(sql);
				return true;
			} catch (SQLException ex) {
				// Excecao para banco de dados
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na insercao do aluno na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}//if inseriu corretamente em pessoa
		
		return false;
	}

	@Override
	public boolean delete(Aluno aluno) {
		
		String sqlAluno;
		String sqlPessoa;
		
		sqlAluno = "DELETE FROM tb_Aluno WHERE tb_Pessoa_idPessoa = "+aluno.getId()+"";
		
		sqlPessoa = "DELETE FROM tb_Pessoa WHERE idPessoa = "+aluno.getId()+"";
		
		try {
			con.getConnection().createStatement().executeUpdate(sqlAluno);
			con.getConnection().createStatement().executeUpdate(sqlPessoa);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Aluno aluno) {
		
		PersistencePessoa pPessoa = new PersistencePessoa();
		
		aluno.setId(pPessoa.selectPessoa(aluno.getMatricula()));
		
		if(pPessoa.update(aluno)){
			
			String sql = "UPDATE tb_Aluno SET "
					+ "profissao = '" + aluno.getProfissao() + "' "
					+ "WHERE tb_Pessoa_idPessoa = " + aluno.getId();
			
			try {
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
	public Aluno selectAluno(String matricula) throws UsuarioNaoEncontradoException{
		Aluno aluno = new Aluno();
		verificaCpf = new VerificaCamposUnique();
		String sql = "SELECT * FROM tb_Aluno JOIN tb_Pessoa	ON tb_Aluno.tb_Pessoa_idPessoa = tb_Pessoa.idPessoa WHERE matricula='" + matricula + "'";

//		if(verificaCpf.validaCpfRg(aluno.getCpf(), aluno.getRg())){
//			throw new UsuarioNaoEncontradoException("Usuario nao cadastrado no sistema");
//		}
		
		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				aluno.setId(rs.getInt("idPessoa"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRg(rs.getString("rg"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEstadoCivil(rs.getString("estadoCivil"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setSituacao(rs.getString("situacao"));
				aluno.setProfissao(rs.getString("profissao"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)), Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)), Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
				aluno.setDtMatricula(LocalDate.of(Integer.parseInt(rs.getString("dtMatricula").substring(0, 4)), Integer.parseInt(rs.getString("dtMatricula").substring(5, 7)), Integer.parseInt(rs.getString("dtMatricula").substring(8, 10))));
				aluno.setCep(rs.getString("cep"));
				aluno.setRua(rs.getString("rua"));
				aluno.setNumero(rs.getInt("numero"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setEstado(rs.getString("estado"));
				aluno.setComplemento(rs.getString("complemento"));
				aluno.setUrlFoto(rs.getString("urlFoto"));
			}
			return aluno;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca do aluno na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		return null;
	}

	@Override
	public Set<Aluno> selectAlunos() {
		Set<Aluno> alunos = new HashSet<>();
		Aluno aluno;

		try {
			stmt = con.getConnection().createStatement();
			String sql = "SELECT * FROM tb_Aluno JOIN tb_Pessoa	ON tb_Aluno.tb_Pessoa_idPessoa = tb_Pessoa.idPessoa";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				aluno = new Aluno();
				
				aluno.setId(rs.getInt("idPessoa"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRg(rs.getString("rg"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEstadoCivil(rs.getString("estadoCivil"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setSituacao(rs.getString("situacao"));
				aluno.setProfissao(rs.getString("profissao"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)), Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)), Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
				aluno.setDtMatricula(LocalDate.of(Integer.parseInt(rs.getString("dtMatricula").substring(0, 4)), Integer.parseInt(rs.getString("dtMatricula").substring(5, 7)), Integer.parseInt(rs.getString("dtMatricula").substring(8, 10))));
				aluno.setCep(rs.getString("cep"));
				aluno.setRua(rs.getString("rua"));
				aluno.setNumero(rs.getInt("numero"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setEstado(rs.getString("estado"));
				aluno.setComplemento(rs.getString("complemento"));
				
				alunos.add(aluno);
			}
			return alunos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca dos alunos na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}

}
