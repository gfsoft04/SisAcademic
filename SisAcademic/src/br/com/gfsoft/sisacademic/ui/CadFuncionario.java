package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.util.BuscaCep;
import br.com.gfsoft.sisacademic.util.EnvioEmail;
import br.com.gfsoft.sisacademic.util.GeraMatricula;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;
import br.com.gfsoft.sisacademic.util.WebCamView;

public class CadFuncionario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3139901361093054677L;
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
	private JPanel panelFoto;
	private JLabel labelImagem;
	private ImageIcon imagem;
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnVisualizar;
	private JButton btnCapturaFoto;
	
	private Academico academico;
	private WebCamView webView;
	private String path = ""; //path da imagem
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
		setTitle("Cadastro de Funcionario");
		setBounds(100, 100, 1205, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel pane_1 = new JPanel();
		pane_1.setBounds(10, 12, 800, 236);
		panel.add(pane_1);
		pane_1.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pane_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 25, 43, 14);
		pane_1.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(51, 20, 329, 25);
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
		formattedTxtDtNascimento.setBounds(136, 64, 140, 25);
		pane_1.add(formattedTxtDtNascimento);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(318, 69, 35, 14);
		pane_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(363, 64, 250, 25);
		pane_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 158, 60, 14);
		pane_1.add(lblTelefone);

		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(10, 112, 86, 14);
		pane_1.add(lblEstadoCivil);

		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(92, 107, 151, 25);
		pane_1.add(comboBoxEstadoCivil);
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"S - Solteiro", "C - Casado", "V - Vi\u00FAvo", "D - Divorciado", "UE - Uni\u00E3o Est\u00E1vel"}));

		txtRg = new JTextField();
		txtRg.setBounds(436, 20, 139, 25);
		pane_1.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(402, 25, 24, 14);
		pane_1.add(lblRg);

		formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(638, 20, 139, 25);
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
		lblCpf.setBounds(596, 25, 35, 14);
		pane_1.add(lblCpf);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(292, 112, 44, 14);
		pane_1.add(lblSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(328, 107, 151, 25);
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
		formattedTxtTelefone.setBounds(81, 152, 151, 25);
		pane_1.add(formattedTxtTelefone);

		JLabel lblNewLabel_1 = new JLabel("Situa\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(536, 112, 66, 14);
		pane_1.add(lblNewLabel_1);

		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"A - Ativo", "I - Inativo "}));
		comboBoxSituacao.setBounds(597, 107, 151, 25);
		pane_1.add(comboBoxSituacao);
		
		labelMatricula = new JLabel("Matricula:");
		labelMatricula.setBounds(10, 196, 66, 14);
		pane_1.add(labelMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(81, 190, 250, 25);
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
		pane_2.setBounds(10, 259, 800, 165);
		panel.add(pane_2);
		pane_2.setLayout(null);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(12, 34, 30, 14);
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
		formattedTxtCep.setBounds(54, 28, 120, 25);
		pane_2.add(formattedTxtCep);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(225, 34, 35, 14);
		pane_2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(266, 28, 250, 25);
		pane_2.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(572, 34, 50, 14);
		pane_2.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(639, 28, 59, 25);
		pane_2.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(12, 77, 44, 14);
		pane_2.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(68, 71, 248, 25);
		pane_2.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(360, 77, 49, 14);
		pane_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(423, 71, 250, 25);
		pane_2.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 125, 42, 14);
		pane_2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(71, 119, 250, 25);
		pane_2.add(txtEstado);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(351, 125, 98, 14);
		pane_2.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(457, 119, 238, 25);
		pane_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(360, 437, 296, 196);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(10, 21, 276, 162);
		panel_3.add(txtPaneObservacao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Dados Profissionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 437, 340, 196);
		panel.add(panel_2);
		
		JLabel lblEscolaridade = new JLabel("Escolaridade:");
		lblEscolaridade.setBounds(33, 35, 93, 14);
		panel_2.add(lblEscolaridade);
		
		JLabel label_1 = new JLabel("Sal\u00E1rio: R$");
		label_1.setBounds(33, 115, 65, 14);
		panel_2.add(label_1);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(110, 109, 120, 25);
		panel_2.add(txtSalario);
		
		comboBoxEscolaridade = new JComboBox();
		comboBoxEscolaridade.setModel(new DefaultComboBoxModel(new String[] {"Fundamental", "M\u00E9dio", "Superior", "P\u00F3s Gradua\u00E7\u00E3o"}));
		comboBoxEscolaridade.setBounds(126, 31, 180, 25);
		panel_2.add(comboBoxEscolaridade);
		
		JLabel label_2 = new JLabel("Data de Contrata\u00E7\u00E3o:");
		label_2.setBounds(33, 150, 120, 14);
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
		formattedtxtDtContratacao.setBounds(165, 144, 139, 25);
		panel_2.add(formattedtxtDtContratacao);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(84, 69, 186, 25);
		panel_2.add(txtCargo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(33, 74, 52, 14);
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
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
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
					
					if(academico.cadastrarFuncionario(funcionario)){
						String assunto = "Cadastro";
						String mensagem = "Bem vindo "+funcionario.getNome()+", seu cadastro foi efetuado com sucesso!"
										+ "\n\n\tSua Matricula e: " + funcionario.getMatricula();
						
						email.enviar(funcionario.getEmail(), assunto, mensagem);
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
					}
					
					//Verifica se o cpf ou rg esta cadastrado na base
					/*if(verificaCamposUnique.validaCpfRg(cpf, txtRg.getText())){
						if(academico.cadastrarFuncionario(funcionario)){
							String assunto = "Cadastro";
							String mensagem = "Bem vindo "+funcionario.getNome()+", seu cadastro foi efetuado com sucesso!"
											+ "\n\n\tSua Matricula �: " + funcionario.getMatricula();
							
							email.enviar(funcionario.getEmail(), assunto, mensagem);
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
						}
					}*/
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero nao aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (HeadlessException ex) {
					JOptionPane.showMessageDialog(null, "Nao sei que exception eh esse!", "Erro", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (UsuarioJaCadastradoException ex) {
					JOptionPane.showMessageDialog(null, "Funcionario ja cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} catch (CpfInvalidoException ex) {
					JOptionPane.showMessageDialog(null, "CPF Invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		panel_4.add(btnCadastrar);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		/* BOTAO ALTERAR */
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")
						|| txtCargo.getText().equals("") || txtSalario.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
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
							JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Atencao", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
						}
					//}
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero nao aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAlterar.setBounds(180, 99, 100, 30);
		panel_4.add(btnAlterar);
		
		/* BOTAO DELETAR */
		btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String matricula = txtMatricula.getText();
					academico = new Academico();
					funcionario = new Funcionario();
					
					funcionario = academico.buscarFuncionario(matricula);
					
					//Confirmacao do usuario
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmacao", JOptionPane.WARNING_MESSAGE) == 0){
						
						if(matricula.substring(0,1).equals("3")){
							Professor prof = new Professor();
							prof.setId(funcionario.getId());
							
							if(academico.deletarProfessor(prof)){
								JOptionPane.showMessageDialog(null, "Exclusao efetuada com sucesso!", "Exclusao", JOptionPane.INFORMATION_MESSAGE);
								limparCampos();
								Principal.CONSULTAFUNCIONARIO.preencherTabela();
							}
						} else {
							if(academico.deletarFuncionario(funcionario)){
								JOptionPane.showMessageDialog(null, "Exclusao efetuada com sucesso!", "Exclusao", JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Campo numero nao aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
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
				
				if(webView != null)
					webView.pararWebCam();
				
				setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 11, 100, 30);
		panel_4.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		panelFoto = new JPanel();
		panelFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFoto.setBounds(820, 12, 360, 270);
		panel.add(panelFoto);
		panelFoto.setLayout(null);
		
		labelImagem = new JLabel("");
		labelImagem.setBounds(0, 0, 360, 270);
		panelFoto.add(labelImagem);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VISUALIZAR IMAGEM VIA WEB CAM
				webView = new WebCamView();
				webView.iniciarWebCam();
				panelFoto.add(webView.getPlayer().asComponent());
				
				btnCapturaFoto.setEnabled(true);
			}
		});
		btnVisualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisualizar.setBounds(895, 293, 100, 30);
		panel.add(btnVisualizar);
		
		btnCapturaFoto = new JButton("Capturar");
		btnCapturaFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")
						|| txtCargo.getText().equals("") || txtSalario.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Preencha os campos antes de salvar a imagem!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				GeraMatricula geraMatricula = new GeraMatricula();
				String matricula = geraMatricula.gerarMatricula(1, Integer.parseInt(formattedtxtDtContratacao.getText().substring(6, 10)));
				File file = new File("img\\"+matricula+".png");
				ImageIcon icon = new ImageIcon(file.getPath());
				
				webView.salvarFoto(webView.getPlayer().getImage(), file);
				webView.pararWebCam();
				path = file.getPath();
				labelImagem.setVisible(true);
				labelImagem.setIcon(icon);
			}
		});
		btnCapturaFoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCapturaFoto.setBounds(1005, 293, 100, 30);
		panel.add(btnCapturaFoto);

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
		btnVisualizar.setVisible(!flag);
		btnCapturaFoto.setVisible(!flag);
		labelImagem.setVisible(flag);
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
		txtMatricula.setText("");
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
