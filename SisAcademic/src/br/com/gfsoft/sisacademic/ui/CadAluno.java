package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Endereco;
import br.com.gfsoft.sisacademic.persistence.PersistenceAluno;
import br.com.gfsoft.sisacademic.util.BuscaCep;
import br.com.gfsoft.sisacademic.util.EnvioEmail;
import br.com.gfsoft.sisacademic.util.GeraMatricula;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;

public class CadAluno extends JInternalFrame {

	private JTextField txtMatricula;
	private JLabel labelMatricula;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtProfissao;
	private JFormattedTextField formattedTxtDtNascimento;
	private JFormattedTextField formattedTxtDtMatricula;
	private JFormattedTextField formattedTxtCpf;
	private JFormattedTextField formattedTxtTelefone;
	private JComboBox comboBoxEstadoCivil;
	private JComboBox comboBoxSituacao;
	private JComboBox comboBoxSexo;
	private JFormattedTextField formattedTxtCep;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtComplemento;
	private JButton btnCadastrar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	
	private PersistenceAluno pAluno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAluno frame = new CadAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadAluno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de Aluno");
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel pane_2 = new JPanel();
		pane_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Endere\u00E7o",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pane_2.setBounds(10, 259, 974, 196);
		panel.add(pane_2);
		pane_2.setLayout(null);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(40, 43, 30, 14);
		pane_2.add(lblCep);

		formattedTxtCep = new JFormattedTextField();
		formattedTxtCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("#####-###")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				BuscaCep buscaCep = new BuscaCep();
				Endereco endereco = new Endereco();
				String cep = formattedTxtCep.getText();
				
				endereco = buscaCep.getEndereco(cep);
				
				if(endereco != null){
					txtRua.setText(endereco.getLogradouro());
					txtBairro.setText(endereco.getBairro());
					txtCidade.setText(endereco.getCidade());
					txtEstado.setText(endereco.getEstado());
				}
			}
		});
		formattedTxtCep.setBounds(82, 40, 120, 20);
		pane_2.add(formattedTxtCep);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(253, 43, 35, 14);
		pane_2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(300, 40, 250, 20);
		pane_2.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(600, 43, 50, 14);
		pane_2.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(667, 40, 59, 20);
		pane_2.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(417, 92, 44, 14);
		pane_2.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(479, 89, 248, 20);
		pane_2.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(40, 143, 42, 14);
		pane_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(94, 140, 250, 20);
		pane_2.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(395, 143, 42, 14);
		pane_2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(455, 140, 250, 20);
		pane_2.add(txtEstado);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(40, 92, 98, 14);
		pane_2.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(141, 89, 238, 20);
		pane_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 468, 296, 127);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JTextPane txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(12, 20, 276, 95);
		panel_3.add(txtPaneObservacao);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBounds(339, 520, 621, 50);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel pane_1 = new JPanel();
		pane_1.setBounds(10, 12, 962, 236);
		panel.add(pane_1);
		pane_1.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pane_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(12, 30, 43, 14);
		pane_1.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(51, 27, 329, 20);
		pane_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 69, 132, 14);
		pane_1.add(lblDataDeNascimento);

		formattedTxtDtNascimento = new JFormattedTextField();
		formattedTxtDtNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtDtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("##/##/####")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		formattedTxtDtNascimento.setBounds(152, 66, 140, 20);
		pane_1.add(formattedTxtDtNascimento);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 155, 35, 14);
		pane_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(61, 152, 250, 20);
		pane_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(343, 155, 60, 14);
		pane_1.add(lblTelefone);

		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(10, 112, 86, 14);
		pane_1.add(lblEstadoCivil);

		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(98, 108, 151, 22);
		pane_1.add(comboBoxEstadoCivil);
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"S - Solteiro", "C - Casado", "V - Vi\u00FAvo", "D - Divorciado", "UE - Uni\u00E3o Est\u00E1vel"}));

		txtRg = new JTextField();
		txtRg.setBounds(445, 27, 139, 20);
		pane_1.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(414, 30, 24, 14);
		pane_1.add(lblRg);

		formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(647, 27, 139, 20);
		pane_1.add(formattedTxtCpf);
		formattedTxtCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("###.###.###-##")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(605, 30, 35, 14);
		pane_1.add(lblCpf);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(292, 112, 44, 14);
		pane_1.add(lblSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(343, 108, 151, 22);
		pane_1.add(comboBoxSexo);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"M - Masculino", "F - Feminino"}));

		formattedTxtTelefone = new JFormattedTextField();
		formattedTxtTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("(##) 9 ####-####")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		formattedTxtTelefone.setBounds(412, 152, 151, 20);
		pane_1.add(formattedTxtTelefone);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(580, 155, 58, 14);
		pane_1.add(lblProfisso);

		txtProfissao = new JTextField();
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(656, 152, 180, 20);
		pane_1.add(txtProfissao);

		JLabel lblNewLabel_1 = new JLabel("Situa\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(536, 112, 66, 14);
		pane_1.add(lblNewLabel_1);

		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"M - Matriculado", "N - N\u00E3o Matriculado", "A - Ativo", "I - Inativo "}));
		comboBoxSituacao.setBounds(603, 109, 151, 20);
		pane_1.add(comboBoxSituacao);

		JLabel lblDataDeMatricula = new JLabel("Data de matr\u00EDcula:");
		lblDataDeMatricula.setBounds(362, 69, 116, 14);
		pane_1.add(lblDataDeMatricula);

		formattedTxtDtMatricula = new JFormattedTextField();
		formattedTxtDtMatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtDtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("##/##/####")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		formattedTxtDtMatricula.setBounds(496, 66, 140, 20);
		pane_1.add(formattedTxtDtMatricula);
		
		labelMatricula = new JLabel("Matricula:");
		labelMatricula.setBounds(10, 196, 66, 14);
		pane_1.add(labelMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(86, 193, 250, 20);
		pane_1.add(txtMatricula);
		formattedTxtDtNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtDtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("##/##/####")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		
		/** BOTAO CADASTRAR **/
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(163, 11, 100, 30);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatórios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				try {
					Aluno aluno = new Aluno();
					EnvioEmail email = new EnvioEmail();
					GeraMatricula geraMatricula = new GeraMatricula();
					VerificaCamposUnique verificaCamposUnique = new VerificaCamposUnique();
					pAluno = new PersistenceAluno();
					
					String cpf = formattedTxtCpf.getText().replace(".", "").replace("-", "");
					String telefone = formattedTxtTelefone.getText().replace("(", "").replace(")", "").replace("-", "");
					String cep = formattedTxtCep.getText().replace("-", "");
					String estadoCivil = comboBoxEstadoCivil.getSelectedItem().toString().substring(0, 2).trim();
					String sexo = comboBoxSexo.getSelectedItem().toString().substring(0, 2).trim();
					String situacao = comboBoxSituacao.getSelectedItem().toString().substring(0, 2).trim();
					
					String dia = formattedTxtDtNascimento.getText().substring(0, 2);
					String mes = formattedTxtDtNascimento.getText().substring(3, 5);
					String ano = formattedTxtDtNascimento.getText().substring(6, 10);
					LocalDate dtNascimento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					dia = formattedTxtDtMatricula.getText().substring(0, 2);
					mes = formattedTxtDtMatricula.getText().substring(3, 5);
					ano = formattedTxtDtMatricula.getText().substring(6, 10);
					LocalDate dtMatricula = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					
					aluno.setMatricula(geraMatricula.gerarMatricula(1, dtMatricula.getYear()));
					aluno.setNome(txtNome.getText());
					aluno.setCpf(cpf);
					aluno.setRg(txtRg.getText());
					aluno.setDtNascimento(dtNascimento);
					aluno.setEstadoCivil(estadoCivil);
					aluno.setSexo(sexo);
					aluno.setSituacao(situacao);
					aluno.setEmail(txtEmail.getText());
					aluno.setTelefone(telefone);
					aluno.setProfissao(txtProfissao.getText());
					aluno.setDtMatricula(dtMatricula);
					aluno.setCep(cep);
					aluno.setRua(txtRua.getText());
					aluno.setNumero(Integer.parseInt(txtNumero.getText()));
					aluno.setBairro(txtBairro.getText());
					aluno.setCidade(txtCidade.getText());
					aluno.setEstado(txtEstado.getText());
					aluno.setComplemento(txtComplemento.getText());
					aluno.setObservacao(txtPaneObservacao.getText());
					
					//Verifica se o cpf ou rg esta cadastrado na base
					if(verificaCamposUnique.validaCpfRg(cpf, txtRg.getText())){
						if(pAluno.insert(aluno)){
							String assunto = "Cadastro";
							String mensagem = "Bem vindo "+aluno.getNome()+", seu cadastro foi efetuado com sucesso!"
											+ "\n\n\tSua Matricula é: " + aluno.getMatricula();
							
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
							email.enviar(aluno.getEmail(), assunto, mensagem);
							limparCampos();
						}
					}
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero só aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		/** BOTAO DELETAR **/
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(314, 10, 98, 30);
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(btnDeletar);
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Aluno aluno = new Aluno();
					pAluno = new PersistenceAluno();
					String matricula = txtMatricula.getText();
					
					aluno = pAluno.selectAluno(matricula);
					
					//Confirmacao do usuario
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.WARNING_MESSAGE) == 0){
						if(pAluno.delete(aluno)){
							JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
						}
					} 
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero só aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				}
				
			}
		});
		
		/** BOTAO ALTERAR **/
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(163, 10, 98, 30);
		panel_4.add(btnAlterar);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatórios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				try {
					Aluno aluno = new Aluno();
					VerificaCamposUnique verificaCamposUnique = new VerificaCamposUnique();
					pAluno = new PersistenceAluno();
					
					String cpf = formattedTxtCpf.getText().replace(".", "").replace("-", "");
					String telefone = formattedTxtTelefone.getText().replace("(", "").replace(")", "").replace("-", "");
					String cep = formattedTxtCep.getText().replace("-", "");
					String estadoCivil = comboBoxEstadoCivil.getSelectedItem().toString().substring(0, 2).trim();
					String sexo = comboBoxSexo.getSelectedItem().toString().substring(0, 2).trim();
					String situacao = comboBoxSituacao.getSelectedItem().toString().substring(0, 2).trim();
					
					String dia = formattedTxtDtNascimento.getText().substring(0, 2);
					String mes = formattedTxtDtNascimento.getText().substring(3, 5);
					String ano = formattedTxtDtNascimento.getText().substring(6, 10);
					LocalDate dtNascimento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					dia = formattedTxtDtMatricula.getText().substring(0, 2);
					mes = formattedTxtDtMatricula.getText().substring(3, 5);
					ano = formattedTxtDtMatricula.getText().substring(6, 10);
					LocalDate dtMatricula = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					
					aluno.setMatricula(txtMatricula.getText());
					aluno.setNome(txtNome.getText());
					aluno.setCpf(cpf);
					aluno.setRg(txtRg.getText());
					aluno.setDtNascimento(dtNascimento);
					aluno.setEstadoCivil(estadoCivil);
					aluno.setSexo(sexo);
					aluno.setSituacao(situacao);
					aluno.setEmail(txtEmail.getText());
					aluno.setTelefone(telefone);
					aluno.setProfissao(txtProfissao.getText());
					aluno.setDtMatricula(dtMatricula);
					aluno.setCep(cep);
					aluno.setRua(txtRua.getText());
					aluno.setNumero(Integer.parseInt(txtNumero.getText()));
					aluno.setBairro(txtBairro.getText());
					aluno.setCidade(txtCidade.getText());
					aluno.setEstado(txtEstado.getText());
					aluno.setComplemento(txtComplemento.getText());
					aluno.setObservacao(txtPaneObservacao.getText());
					
					//Verifica se o cpf ou rg esta cadastrado na base
					if(verificaCamposUnique.validaCpfRg(cpf, txtRg.getText())){
						if(pAluno.update(aluno)){
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
						}
					}
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero só aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		/** BOTAO CANCELAR **/
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 11, 100, 30);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				setVisible(false);
			}
		});
		
	}
	
	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Aluno aluno){
		txtMatricula.setText(aluno.getMatricula());
		txtNome.setText(aluno.getNome());
		txtRg.setText(aluno.getRg());
		formattedTxtCpf.setText(aluno.getCpf());
		txtEmail.setText(aluno.getEmail());
		txtProfissao.setText(aluno.getProfissao());
		formattedTxtDtNascimento.setText(aluno.getDtNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		formattedTxtTelefone.setText(aluno.getTelefone());
		//comboBoxEstadoCivil.setSelectedIndex(0);
		//comboBoxSexo.setSelectedIndex(0);
		//comboBoxSituacao.setSelectedIndex(0);
		formattedTxtCep.setText(aluno.getCep());
		txtRua.setText(aluno.getRua());
		txtNumero.setText(Integer.toString(aluno.getNumero()));
		txtBairro.setText(aluno.getBairro());
		txtCidade.setText(aluno.getCidade());
		txtEstado.setText(aluno.getEstado());
		txtComplemento.setText(aluno.getComplemento());
		
	}
	
	/**
	 * Metodo para alternar botoes habilitados e desabilitados
	 * true = habilita botao alterar e deletar
	 * flase = habilita botao cadastrar
	 */
	public void alternaBotoes(boolean flag){
		btnCadastrar.setVisible(!flag);
		btnAlterar.setVisible(flag);
		btnDeletar.setVisible(flag);
		txtMatricula.setVisible(flag);
		labelMatricula.setVisible(flag);	
	}
	
	/**
	 * Metodo para desabilitar alguns campos para edicao
	 */
	public void setEditable(boolean flag){
		txtMatricula.setEditable(flag);
		txtNome.setEditable(flag);
		formattedTxtCpf.setEditable(flag);
		formattedTxtCpf.setFocusable(flag);
		
		btnCadastrar.setVisible(flag);
	}
	
	/**
	 * Metodo para limpar campos
	 */
	public void limparCampos(){
		txtNome.setText("");
		txtRg.setText("");
		txtEmail.setText("");
		txtProfissao.setText("");
		formattedTxtDtNascimento.setValue(null);
		formattedTxtDtMatricula.setValue(null);
		formattedTxtCpf.setValue(null);
		formattedTxtTelefone.setValue(null);
		comboBoxEstadoCivil.setSelectedIndex(0);
		comboBoxSituacao.setSelectedIndex(0);
		comboBoxSexo.setSelectedIndex(0);
		formattedTxtCep.setValue(null);
		txtRua.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtComplemento.setText("");
	}
}
