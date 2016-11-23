package br.com.gfsoft.sisacademic.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Funcionario;

public class PersistenceFuncionario implements IPersistenceFuncionario {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	
	@Override
	public boolean insert(Funcionario funcionario) {
		PersistencePessoa pPessoa = new PersistencePessoa();
		String sql;
		long id;
		
		if(pPessoa.insert(funcionario)){
			id = pPessoa.selectPessoa(funcionario.getMatricula());
			
			sql = "INSERT INTO tb_Funcionario (tb_Pessoa_idPessoa, dtContratacao, cargo, salario, escolaridade)"
					+"VALUES("+id+","+
					"'"+funcionario.getDtContratacao().getDayOfMonth()+ "/"
					+ funcionario.getDtContratacao().getMonth()+ "/" 
					+ funcionario.getDtContratacao().getYear()+"'"+
					"," +"'" +funcionario.getCargo()+"'" + "," + funcionario.getSalario()+","+
					"'"+ funcionario.getEscolaridade()+"'";
			try{
				con.getConnection().createStatement().executeUpdate(sql);
				return true;
			}
			catch (SQLException exept){
				exept.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção de funcionario na base de dados","Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
		
	}

	@Override
	public boolean delete(Funcionario funcionario) {
		String sqlPessoa;
		String sqlFuncionario;
		
		sqlFuncionario= "DELETE FROM tb_Funcionario WHERE tb_Pessoa_idPessoa = "+funcionario.getId()+"";
		sqlPessoa = "DELETE FROM  tb_Pessoa WHERE idPessoa = "+funcionario.getId()+"";
		
		try{
			con.getConnection().createStatement().executeUpdate(sqlFuncionario);
			con.getConnection().createStatement().executeUpdate(sqlPessoa);
			return true;
		}
		catch (SQLException exept){
			exept.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao deletar funcionario da base de dados","Erro", JOptionPane.ERROR_MESSAGE);
		}
	
		return false;
	}

	@Override
	public boolean update(Funcionario funcionario) {
		PersistencePessoa pPessoa = new PersistencePessoa();
		
		if(pPessoa.update(funcionario)){
			
			String sql = "UPDATE tb_Funcionario SET "
					+ "dtContratacao= '"+ funcionario.getDtContratacao().getDayOfMonth() + "/" + funcionario.getDtNascimento().getMonthValue() + "/" + funcionario.getDtNascimento().getYear() +"',"
					+ "cargo = '" + funcionario.getCargo() + "'"
					+ "salario = '"+ funcionario.getSalario() + "'"
					+ "escolaridade = '" + funcionario.getEscolaridade() + "'"
					+ "WHERE tb_Pessoa_idPessoa = " + funcionario.getId();
			
			try {
				//Nao tenho certeza se e a mesma linha para alterar(executeUpdate)
				con.getConnection().createStatement().executeUpdate(sql);
				return true;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}
		

	@Override
	public Funcionario selectFuncionario(String matricula) {
		Funcionario funcionario = new Funcionario();
		String sql = "SELECT * FROM tb_Funcionario JOIN tb_Pessoa"
		+ "	ON tb_Funcinario.tb_Pessoa_idPessoa = tb_Pessoa.idPessoa WHERE matricula='" + matricula + "'";
		
		try{
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(sql)	;
			
			while(rs.next()){
				funcionario.setId(rs.getInt("idPessoa"));
				funcionario.setMatricula(rs.getString("matricula"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setRg(rs.getString("rg"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setEstadoCivil(rs.getString("estadoCivil"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setSituacao(rs.getString("situacao"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)),
					Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)),
					Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
				funcionario.setCep(rs.getString("cep"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setCidade(rs.getString("cidade"));
				funcionario.setEstado(rs.getString("estado"));
				funcionario.setComplemento(rs.getString("complemento"));
			}
			return funcionario;
		}catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca do funcionario na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
			
		return null;
		
	}

	@Override
	public Set<Funcionario> selectFuncionarios() {
		Set<Funcionario> funcionarios = new HashSet<>();
		Funcionario funcionario;

		try {
			stmt = con.getConnection().createStatement();
			String sql = "SELECT * FROM tb_Aluno JOIN tb_Pessoa	ON tb_Aluno.tb_Pessoa_idPessoa = tb_Pessoa.idPessoa";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				funcionario = new Funcionario();
				
				funcionario.setId(rs.getInt("idPessoa"));
				funcionario.setMatricula(rs.getString("matricula"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setRg(rs.getString("rg"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setEstadoCivil(rs.getString("estadoCivil"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setSituacao(rs.getString("situacao"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDtNascimento(LocalDate.of(Integer.parseInt(rs.getString("dtNascimento").substring(0, 4)), Integer.parseInt(rs.getString("dtNascimento").substring(5, 7)), Integer.parseInt(rs.getString("dtNascimento").substring(8, 10))));
				funcionario.setCep(rs.getString("cep"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setCidade(rs.getString("cidade"));
				funcionario.setEstado(rs.getString("estado"));
				funcionario.setComplemento(rs.getString("complemento"));
				
				funcionarios.add(funcionario);
			}
			return funcionarios;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca dos alunos na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}

}
