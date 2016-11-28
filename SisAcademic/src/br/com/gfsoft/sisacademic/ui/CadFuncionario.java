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

import br.com.gfsoft.sisacademic.controller.Academico;
import br.com.gfsoft.sisacademic.model.Endereco;
import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.Professor;
import br.com.gfsoft.sisacademic.persistence.PersistenceFuncionario;
import br.com.gfsoft.sisacademic.persistence.PersistenceProfessor;
import br.com.gfsoft.sisacademic.util.BuscaCep;
import br.com.gfsoft.sisacademic.util.EnvioEmail;
import br.com.gfsoft.sisacademic.util.GeraMatricula;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;

public class CadFuncionario extends JInternalFrame {
	private JTextField txtMatricula;
	private JLabel labelMatricula;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JFormattedTextField formattedTxtDtNascimento;
	private JFormattedTextField formattedTxtCpf;
	private JFormattedTextField formattedTxtTelefone;
	private JFormattedTextField formattedTxtCep;
	private JComboBox comboBoxEstadoCivil;
	private JComboBox comboBoxSexo;
	private JComboBox comboBoxSituacao;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtComplemento;
	private JComboBox comboBoxEscolaridade;
	private JTextField txtCargo;
	private JTextField txtSalario;
	private JFormattedTextField formattedtxtDtContratacao;
	private JTextPane txtPaneObservacao;
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	
	private Academico academico;

	private Funcionario funcionario;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFuncionario frame = new CadFuncionario();
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
	public CadFuncionario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de Funcionário");
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel pane_1 = new JPanel();
		pane_1.setBounds(10, 12, 974, 236);
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
		lblEmail.setBounds(339, 69, 35, 14);
		pane_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(390, 66, 250, 20);
		pane_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 155, 60, 14);
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
		formattedTxtTelefone.setBounds(81, 152, 151, 20);
		pane_1.add(formattedTxtTelefone);

		JLabel lblNewLabel_1 = new JLabel("Situa\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(536, 112, 66, 14);
		pane_1.add(lblNewLabel_1);

		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"A - Ativo", "I - Inativo "}));
		comboBoxSituacao.setBounds(603, 109, 151, 20);
		pane_1.add(comboBoxSituacao);
		
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

		
		JPanel pane_2 = new JPanel();
		pane_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Endere\u00E7o",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pane_2.setBounds(10, 259, 974, 177);
		panel.add(pane_2);
		pane_2.setLayout(null);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(39, 38, 30, 14);
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
		formattedTxtCep.setBounds(81, 35, 120, 20);
		pane_2.add(formattedTxtCep);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(252, 38, 35, 14);
		pane_2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(299, 35, 250, 20);
		pane_2.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(599, 38, 50, 14);
		pane_2.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(666, 35, 59, 20);
		pane_2.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(37, 88, 44, 14);
		pane_2.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(93, 85, 248, 20);
		pane_2.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(392, 88, 42, 14);
		pane_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(446, 85, 250, 20);
		pane_2.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(39, 134, 42, 14);
		pane_2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(101, 131, 250, 20);
		pane_2.add(txtEstado);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(385, 134, 98, 14);
		pane_2.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(487, 131, 238, 20);
		pane_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(360, 447, 296, 186);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(10, 21, 276, 154);
		panel_3.add(txtPaneObservacao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Dados Profissionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 447, 340, 186);
		panel.add(panel_2);
		
		JLabel lblEscolaridade = new JLabel("Escolaridade:");
		lblEscolaridade.setBounds(30, 33, 75, 14);
		panel_2.add(lblEscolaridade);
		
		JLabel label_1 = new JLabel("Sal\u00E1rio: R$");
		label_1.setBounds(29, 110, 65, 14);
		panel_2.add(label_1);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(98, 107, 120, 20);
		panel_2.add(txtSalario);
		
		comboBoxEscolaridade = new JComboBox();
		comboBoxEscolaridade.setModel(new DefaultComboBoxModel(new String[] {"Fundamental", "M\u00E9dio", "Superior", "P\u00F3s Gradua\u00E7\u00E3o"}));
		comboBoxEscolaridade.setBounds(105, 29, 180, 22);
		panel_2.add(comboBoxEscolaridade);
		
		JLabel label_2 = new JLabel("Data de Contrata\u00E7\u00E3o:");
		label_2.setBounds(30, 145, 120, 14);
		panel_2.add(label_2);
		
		formattedtxtDtContratacao = new JFormattedTextField();
		formattedtxtDtContratacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedtxtDtContratacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("##/##/####")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		formattedtxtDtContratacao.setBounds(160, 142, 139, 20);
		panel_2.add(formattedtxtDtContratacao);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(84, 74, 186, 20);
		panel_2.add(txtCargo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(30, 77, 52, 14);
		panel_2.add(lblCargo);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBounds(666, 455, 290, 178);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
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
		
		/* BOTAO CADASTRAR */
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(180, 11, 100, 30);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")
						|| txtCargo.getText().equals("") || txtSalario.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatórios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				try {
					EnvioEmail email = new EnvioEmail();
					GeraMatricula geraMatricula = new GeraMatricula();
					VerificaCamposUnique verificaCamposUnique = new VerificaCamposUnique();
					academico = new Academico();
					funcionario = new Funcionario();
					
					String cpf = formattedTxtCpf.getText().replace(".", "").replace("-", "");
					String telefone = formattedTxtTelefone.getText().replace("(", "").replace(")", "").replace("-", "");
					String cep = formattedTxtCep.getText().replace("-", "");
					String estadoCivil = comboBoxEstadoCivil.getSelectedItem().toString().substring(0, 2).trim();
					String sexo = comboBoxSexo.getSelectedItem().toString().substring(0, 2).trim();
					String situacao = comboBoxSituacao.getSelectedItem().toString().substring(0, 2).trim();
					String escolaridade = comboBoxEscolaridade.getSelectedItem().toString();
					
					String dia = formattedTxtDtNascimento.getText().substring(0, 2);
					String mes = formattedTxtDtNascimento.getText().substring(3, 5);
					String ano = formattedTxtDtNascimento.getText().substring(6, 10);
					LocalDate dtNascimento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					dia = formattedtxtDtContratacao.getText().substring(0, 2);
					mes = formattedtxtDtContratacao.getText().substring(3, 5);
					ano = formattedtxtDtContratacao.getText().substring(6, 10);
					LocalDate dtContratacao = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					
					funcionario.setMatricula(geraMatricula.gerarMatricula(2, dtContratacao.getYear()));
					funcionario.setNome(txtNome.getText());
					funcionario.setCpf(cpf);
					funcionario.setRg(txtRg.getText());
					funcionario.setDtNascimento(dtNascimento);
					funcionario.setEstadoCivil(estadoCivil);
					funcionario.setSexo(sexo);
					funcionario.setSituacao(situacao);
					funcionario.setEmail(txtEmail.getText());
					funcionario.setTelefone(telefone);
					funcionario.setCep(cep);
					funcionario.setRua(txtRua.getText());
					funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
					funcionario.setBairro(txtBairro.getText());
					funcionario.setCidade(txtCidade.getText());
					funcionario.setEstado(txtEstado.getText());
					funcionario.setComplemento(txtComplemento.getText());
					funcionario.setEscolaridade(escolaridade);
					funcionario.setCargo(txtCargo.getText());
					funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
					funcionario.setDtContratacao(dtContratacao);
					funcionario.setObservacao(txtPaneObservacao.getText());
					
					//Verifica se o cpf ou rg esta cadastrado na base
					if(verificaCamposUnique.validaCpfRg(cpf, txtRg.getText())){
						if(academico.cadastrarFuncionario(funcionario)){
							String assunto = "Cadastro";
							String mensagem = "Bem vindo "+funcionario.getNome()+", seu cadastro foi efetuado com sucesso!"
											+ "\n\n\tSua Matricula é: " + funcionario.getMatricula();
							
							email.enviar(funcionario.getEmail(), assunto, mensagem);
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
		panel_4.add(btnCadastrar);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		/* BOTAO ALTERAR */
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")
						|| txtCargo.getText().equals("") || txtSalario.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatórios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				try {
					VerificaCamposUnique verificaCamposUnique = new VerificaCamposUnique();
					academico = new Academico();
					funcionario = new Funcionario();
					
					String cpf = formattedTxtCpf.getText().replace(".", "").replace("-", "");
					String telefone = formattedTxtTelefone.getText().replace("(", "").replace(")", "").replace("-", "");
					String cep = formattedTxtCep.getText().replace("-", "");
					String estadoCivil = comboBoxEstadoCivil.getSelectedItem().toString().substring(0, 2).trim();
					String sexo = comboBoxSexo.getSelectedItem().toString().substring(0, 2).trim();
					String situacao = comboBoxSituacao.getSelectedItem().toString().substring(0, 2).trim();
					String escolaridade = comboBoxEscolaridade.getSelectedItem().toString();
					
					String dia = formattedTxtDtNascimento.getText().substring(0, 2);
					String mes = formattedTxtDtNascimento.getText().substring(3, 5);
					String ano = formattedTxtDtNascimento.getText().substring(6, 10);
					LocalDate dtNascimento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					dia = formattedtxtDtContratacao.getText().substring(0, 2);
					mes = formattedtxtDtContratacao.getText().substring(3, 5);
					ano = formattedtxtDtContratacao.getText().substring(6, 10);
					LocalDate dtContratacao = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					
					funcionario.setMatricula(txtMatricula.getText());
					funcionario.setNome(txtNome.getText());
					funcionario.setCpf(cpf);
					funcionario.setRg(txtRg.getText());
					funcionario.setDtNascimento(dtNascimento);
					funcionario.setEstadoCivil(estadoCivil);
					funcionario.setSexo(sexo);
					funcionario.setSituacao(situacao);
					funcionario.setEmail(txtEmail.getText());
					funcionario.setTelefone(telefone);
					funcionario.setCep(cep);
					funcionario.setRua(txtRua.getText());
					funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
					funcionario.setBairro(txtBairro.getText());
					funcionario.setCidade(txtCidade.getText());
					funcionario.setEstado(txtEstado.getText());
					funcionario.setComplemento(txtComplemento.getText());
					funcionario.setEscolaridade(escolaridade);
					funcionario.setCargo(txtCargo.getText());
					funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
					funcionario.setDtContratacao(dtContratacao);
					funcionario.setObservacao(txtPaneObservacao.getText());
					
					//Verifica se o cpf ou rg esta cadastrado na base
					//if(verificaCamposUnique.validaCpfRg(cpf, txtRg.getText())){
						if(academico.atualizarFuncionario(funcionario)){
							JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
						}
					//}
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero só aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAlterar.setBounds(180, 99, 100, 30);
		panel_4.add(btnAlterar);
		
		/* BOTAO DELETAR */
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String matricula = txtMatricula.getText();
					academico = new Academico();
					funcionario = new Funcionario();
					
					funcionario = academico.buscarFuncionario(matricula);
					
					//Confirmacao do usuario
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.WARNING_MESSAGE) == 0){
						
						if(matricula.substring(0,1).equals("3")){
							if(academico.deletarFuncionario((Professor) funcionario)){
								JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
								limparCampos();
								Principal.CONSULTAFUNCIONARIO.preencherTabela();
							}
						} else {
							if(academico.deletarFuncionario(funcionario)){
								JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
								limparCampos();
								Principal.CONSULTAFUNCIONARIO.preencherTabela();
							}
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
		btnDeletar.setBounds(10, 99, 100, 30);
		panel_4.add(btnDeletar);
		
		/* BOTAO CANCELAR */
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 11, 100, 30);
		panel_4.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));

	}
	
	
	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Funcionario funcionario){
		txtMatricula.setText(funcionario.getMatricula());
		txtNome.setText(funcionario.getNome());
		txtRg.setText(funcionario.getRg());
		formattedTxtCpf.setText(funcionario.getCpf());
		txtEmail.setText(funcionario.getEmail());
		formattedTxtDtNascimento.setText(funcionario.getDtNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		formattedTxtTelefone.setText(funcionario.getTelefone());
		//comboBoxEstadoCivil.setSelectedIndex(0);
		//comboBoxSexo.setSelectedIndex(0);
		//comboBoxSituacao.setSelectedIndex(0);
		formattedTxtCep.setText(funcionario.getCep());
		txtRua.setText(funcionario.getRua());
		txtNumero.setText(Integer.toString(funcionario.getNumero()));
		txtBairro.setText(funcionario.getBairro());
		txtCidade.setText(funcionario.getCidade());
		txtEstado.setText(funcionario.getEstado());
		txtComplemento.setText(funcionario.getComplemento());
		//comboBoxEscolaridade.setSelectedIndex(0);
		txtCargo.setText(funcionario.getCargo());
		txtSalario.setText(funcionario.getSalario() + "");
		formattedtxtDtContratacao.setText(funcionario.getDtContratacao().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		txtPaneObservacao.setText(funcionario.getObservacao());
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
		formattedTxtDtNascimento.setValue("");
		formattedtxtDtContratacao.setValue("");
		formattedTxtCpf.setValue("");
		formattedTxtTelefone.setValue("");
		comboBoxEstadoCivil.setSelectedIndex(0);
		comboBoxSituacao.setSelectedIndex(0);
		comboBoxSexo.setSelectedIndex(0);
		formattedTxtCep.setValue("");
		txtRua.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtComplemento.setText("");
		comboBoxEscolaridade.setSelectedIndex(0);
		txtCargo.setText("");
		txtSalario.setText("");
		txtPaneObservacao.setText("");
	}
}
