package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Endereco;
import br.com.gfsoft.sisacademic.model.exception.CpfInvalidoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioJaCadastradoException;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;
import br.com.gfsoft.sisacademic.util.BuscaCep;
import br.com.gfsoft.sisacademic.util.EnvioEmail;
import br.com.gfsoft.sisacademic.util.GeraMatricula;
import br.com.gfsoft.sisacademic.util.VerificaCamposUnique;
import br.com.gfsoft.sisacademic.util.WebCamView;

public class CadAluno extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4371247386629035416L;
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
	private JTextPane txtPaneObservacao;
	private JPanel panelFoto;
	private JLabel labelImagem;
	private ImageIcon imagem;
	private JButton btnCadastrar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnVisualizar;
	private JButton btnCapturaFoto;
	private JButton btnDisciplinas;
	
	private Academico academico;
	private Aluno aluno;
	private WebCamView webView;
	private String path = ""; //path da imagem
	
	
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
		setBounds(100, 100, 1205, 670);
		setLocation(0, 0);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel pane_2 = new JPanel();
		pane_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Endere\u00E7o",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pane_2.setBounds(10, 259, 804, 183);
		panel.add(pane_2);
		pane_2.setLayout(null);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 40, 30, 14);
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
		formattedTxtCep.setBounds(50, 34, 120, 25);
		pane_2.add(formattedTxtCep);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(223, 40, 35, 14);
		pane_2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(268, 34, 250, 25);
		pane_2.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(570, 40, 50, 14);
		pane_2.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(630, 34, 59, 25);
		pane_2.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(387, 91, 44, 14);
		pane_2.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(441, 85, 248, 25);
		pane_2.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 142, 50, 14);
		pane_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(70, 136, 250, 25);
		pane_2.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(373, 142, 42, 14);
		pane_2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(425, 136, 250, 25);
		pane_2.add(txtEstado);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(10, 91, 98, 14);
		pane_2.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(109, 85, 238, 25);
		pane_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 453, 296, 142);
		panel.add(panel_3);
		panel_3.setLayout(null);

		txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(12, 20, 276, 111);
		panel_3.add(txtPaneObservacao);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBounds(338, 545, 621, 50);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel pane_1 = new JPanel();
		pane_1.setBounds(10, 11, 804, 236);
		panel.add(pane_1);
		pane_1.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pane_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 32, 43, 14);
		pane_1.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(51, 27, 329, 25);
		pane_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 72, 132, 14);
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
		formattedTxtDtNascimento.setBounds(152, 66, 140, 25);
		pane_1.add(formattedTxtDtNascimento);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 155, 35, 14);
		pane_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(51, 149, 250, 25);
		pane_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(343, 155, 60, 14);
		pane_1.add(lblTelefone);

		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(10, 112, 86, 14);
		pane_1.add(lblEstadoCivil);

		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(88, 107, 151, 25);
		pane_1.add(comboBoxEstadoCivil);
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"S - Solteiro", "C - Casado", "V - Vi\u00FAvo", "D - Divorciado", "UE - Uni\u00E3o Est\u00E1vel"}));

		txtRg = new JTextField();
		txtRg.setBounds(445, 27, 139, 25);
		pane_1.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(412, 32, 24, 14);
		pane_1.add(lblRg);

		formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(647, 27, 139, 25);
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
		lblCpf.setBounds(602, 32, 35, 14);
		pane_1.add(lblCpf);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(292, 112, 44, 14);
		pane_1.add(lblSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(337, 107, 151, 25);
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
		formattedTxtTelefone.setBounds(413, 149, 151, 25);
		pane_1.add(formattedTxtTelefone);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(12, 194, 58, 14);
		pane_1.add(lblProfisso);

		txtProfissao = new JTextField();
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(80, 188, 180, 25);
		pane_1.add(txtProfissao);

		JLabel lblNewLabel_1 = new JLabel("Situa\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(536, 112, 66, 14);
		pane_1.add(lblNewLabel_1);

		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"M - Matriculado", "N - N\u00E3o Matriculado"}));
		comboBoxSituacao.setBounds(597, 107, 151, 25);
		pane_1.add(comboBoxSituacao);

		JLabel lblDataDeMatricula = new JLabel("Data de matr\u00EDcula:");
		lblDataDeMatricula.setBounds(343, 72, 116, 14);
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
		formattedTxtDtMatricula.setBounds(455, 66, 140, 25);
		pane_1.add(formattedTxtDtMatricula);
		
		labelMatricula = new JLabel("Matricula:");
		labelMatricula.setBounds(314, 194, 66, 14);
		pane_1.add(labelMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(387, 188, 250, 25);
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
		
		panelFoto = new JPanel();
		panelFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFoto.setBounds(824, 11, 360, 270);
		panel.add(panelFoto);
		
		labelImagem = new JLabel("");
		labelImagem.setBounds(2, 2, 360, 270);
		labelImagem.setVisible(false);
		panelFoto.setLayout(null);
		panelFoto.add(labelImagem);
		
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
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				try {
					EnvioEmail email = new EnvioEmail();
					GeraMatricula geraMatricula = new GeraMatricula();
					academico = new Academico();
					aluno = new Aluno();
					
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
					aluno.setUrlFoto(path);
					
					if(academico.cadastrarAluno(aluno)){
						String assunto = "Cadastro";
						String mensagem = "Bem vindo "+aluno.getNome()+", seu cadastro foi efetuado com sucesso!"
										+ "\n\n\tSua Matricula é: " + aluno.getMatricula();
						
						email.enviar(aluno.getEmail(), assunto, mensagem);
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
					}
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero so aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (UsuarioJaCadastradoException ex) {
					// Excecao para usuario ja cadastrado
					JOptionPane.showMessageDialog(null, "Usuario Ja Cadastrado no Sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (CpfInvalidoException ex) {
					// Excecao para usuario ja cadastrado
					JOptionPane.showMessageDialog(null, "CPF Invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
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
					String matricula = txtMatricula.getText();
					academico = new Academico();
					aluno = new Aluno();
					
					aluno = academico.buscarAluno(matricula);
					
					//Confirmacao do usuario
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.WARNING_MESSAGE) == 0){
						if(academico.deletarAluno(aluno)){
							JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
							Principal.CONSULTAALUNO.preencherTabela();
						}
					} 
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero so aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				} catch (UsuarioNaoEncontradoException ex) {
					// Excecao para usuario ja cadastrado
					JOptionPane.showMessageDialog(null, "Usuario Nao Cadastrado no Sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		/** BOTAO ALTERAR **/
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(163, 10, 98, 30);
		panel_4.add(btnAlterar);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				try {
					VerificaCamposUnique verificaCamposUnique = new VerificaCamposUnique();
					academico = new Academico();
					aluno = new Aluno();
					
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
					//if(verificaCamposUnique.validaCpfRg(cpf, txtRg.getText())){
						if(academico.atualizarAluno(aluno)){
							JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Atencao", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
							Principal.CONSULTAALUNO.preencherTabela();
						}
					//}
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero so aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		/** BOTAO CANCELAR **/
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				
				if(webView != null)
					webView.pararWebCam();
				
				setVisible(false);
			}
		});
		btnCancelar.setBounds(12, 11, 100, 30);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(btnCancelar);
		
		/** BOTAO CAPTURA FOTO **/
		btnCapturaFoto = new JButton("Capturar");
		btnCapturaFoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCapturaFoto.setEnabled(false);
		btnCapturaFoto.addActionListener(new ActionListener() {
			//CAPTURA IMAGEM VIA WEB CAM E SALVA
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtEmail.getText().equals("")
						|| txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("")
						|| txtCidade.getText().equals("") || txtEstado.getText().equals("") || formattedTxtCpf.getText().equals("")
						|| formattedTxtCep.getText().equals("") || formattedTxtTelefone.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Preencha os campos antes de salvar a imagem!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				
				GeraMatricula geraMatricula = new GeraMatricula();
				String matricula = geraMatricula.gerarMatricula(1, Integer.parseInt(formattedTxtDtMatricula.getText().substring(6, 10)));
				File file = new File("img\\"+matricula+".png");
				
				webView.salvarFoto(webView.getPlayer().getImage(), file);
				webView.pararWebCam();
				
				ImageIcon icon = new ImageIcon(file.getPath());
				path = file.getPath();
				labelImagem.setVisible(true);
				labelImagem.setIcon(icon);
			}
		});
		btnCapturaFoto.setBounds(1017, 292, 100, 30);
		panel.add(btnCapturaFoto);
		
		/** BOTAO VISUALIZAR **/
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VISUALIZAR IMAGEM VIA WEB CAM
				webView = new WebCamView();
				webView.iniciarWebCam();
				panelFoto.add(webView.getPlayer().asComponent());
				
				btnCapturaFoto.setEnabled(true);
			}
		});
		btnVisualizar.setBounds(896, 292, 100, 30);
		panel.add(btnVisualizar);
		
		btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadAlunoDisciplina cadAlunoDisciplina;
				academico = new Academico();
				try {
					cadAlunoDisciplina = new CadAlunoDisciplina(academico.buscarAluno(txtMatricula.getText()).getId());
					cadAlunoDisciplina.setVisible(true);
				} catch (UsuarioNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisciplinas.setBounds(859, 412, 100, 30);
		panel.add(btnDisciplinas);
		
	}
	
	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Aluno aluno){
		File path = new File("img\\"+aluno.getMatricula()+".png");
		imagem = new ImageIcon(path.getPath());
		imagem.setImage(imagem.getImage().getScaledInstance(360, 270, 100));
		
		txtMatricula.setText(aluno.getMatricula());
		txtNome.setText(aluno.getNome());
		txtRg.setText(aluno.getRg());
		formattedTxtCpf.setText(aluno.getCpf());
		txtEmail.setText(aluno.getEmail());
		txtProfissao.setText(aluno.getProfissao());
		formattedTxtDtNascimento.setText(aluno.getDtNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		formattedTxtDtMatricula.setText(aluno.getDtMatricula().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		formattedTxtTelefone.setText(aluno.getTelefone());
		
		if(aluno.getEstadoCivil().equals("S"))
			comboBoxEstadoCivil.setSelectedIndex(0);
		else if(aluno.getEstadoCivil().equals("C"))
			comboBoxEstadoCivil.setSelectedIndex(1);
		else if(aluno.getEstadoCivil().equals("V"))
			comboBoxEstadoCivil.setSelectedIndex(2);
		else if(aluno.getEstadoCivil().equals("D"))
			comboBoxEstadoCivil.setSelectedIndex(3);
		else
			comboBoxEstadoCivil.setSelectedIndex(4);
		
		if(aluno.getSexo().equals("M"))
			comboBoxSexo.setSelectedIndex(0);
		else
			comboBoxSexo.setSelectedIndex(1);
		
		if(aluno.getSituacao().equals("M"))
			comboBoxSituacao.setSelectedIndex(0);
		else
			comboBoxSituacao.setSelectedIndex(1);
		
		formattedTxtCep.setText(aluno.getCep());
		txtRua.setText(aluno.getRua());
		txtNumero.setText(Integer.toString(aluno.getNumero()));
		txtBairro.setText(aluno.getBairro());
		txtCidade.setText(aluno.getCidade());
		txtEstado.setText(aluno.getEstado());
		txtComplemento.setText(aluno.getComplemento());
		txtPaneObservacao.setText(aluno.getObservacao());
		labelImagem.setIcon(imagem);
		
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
		btnDisciplinas.setVisible(flag);
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
		txtProfissao.setText("");
		formattedTxtDtNascimento.setValue("");
		formattedTxtDtMatricula.setValue("");
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
		txtPaneObservacao.setText("");
		labelImagem.setIcon(null);
	}
}
