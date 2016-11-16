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
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.Endereco;
import br.com.gfsoft.sisacademic.util.BuscaCep;

public class CadAluno extends JInternalFrame {

	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtProfissao;
	private JFormattedTextField formattedTxtDtNascimento;
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
	private JButton btnCancelar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	
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
		pane_2.setBounds(10, 223, 974, 196);
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
		lblBairro.setBounds(38, 93, 44, 14);
		pane_2.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(94, 90, 248, 20);
		pane_2.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(393, 93, 42, 14);
		pane_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(447, 90, 250, 20);
		pane_2.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(40, 139, 42, 14);
		pane_2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(102, 136, 250, 20);
		pane_2.add(txtEstado);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(386, 139, 98, 14);
		pane_2.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(488, 136, 238, 20);
		pane_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 432, 296, 127);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JTextPane txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(12, 20, 276, 95);
		panel_3.add(txtPaneObservacao);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBounds(339, 484, 621, 50);
		panel.add(panel_4);
		panel_4.setLayout(null);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 11, 100, 30);
		panel_4.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(163, 11, 100, 30);
		panel_4.add(btnCadastrar);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(314, 10, 98, 30);
		panel_4.add(btnDeletar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(163, 10, 98, 30);
		panel_4.add(btnAlterar);

		JPanel pane_1 = new JPanel();
		pane_1.setBounds(10, 12, 962, 196);
		panel.add(pane_1);
		pane_1.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pane_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 26, 43, 14);
		pane_1.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(49, 23, 329, 20);
		pane_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 71, 108, 14);
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
		formattedTxtDtNascimento.setBounds(122, 68, 139, 20);
		pane_1.add(formattedTxtDtNascimento);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 112, 35, 14);
		pane_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(49, 109, 250, 20);
		pane_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(309, 112, 60, 14);
		pane_1.add(lblTelefone);

		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(291, 71, 86, 14);
		pane_1.add(lblEstadoCivil);

		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(368, 67, 151, 22);
		pane_1.add(comboBoxEstadoCivil);
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "Solteiro", "Casado", "Vi\u00FAvo", "Divorciado", "Uni\u00E3o Est\u00E1vel" }));

		txtRg = new JTextField();
		txtRg.setBounds(420, 23, 139, 20);
		pane_1.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(388, 26, 24, 14);
		pane_1.add(lblRg);

		formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(599, 23, 139, 20);
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
		lblCpf.setBounds(569, 26, 35, 14);
		pane_1.add(lblCpf);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(538, 71, 44, 14);
		pane_1.add(lblSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(569, 67, 151, 22);
		pane_1.add(comboBoxSexo);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

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
		formattedTxtTelefone.setBounds(368, 109, 151, 20);
		pane_1.add(formattedTxtTelefone);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(538, 112, 58, 14);
		pane_1.add(lblProfisso);

		txtProfissao = new JTextField();
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(596, 109, 180, 20);
		pane_1.add(txtProfissao);

		JLabel lblNewLabel_1 = new JLabel("Situa\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(730, 71, 46, 14);
		pane_1.add(lblNewLabel_1);

		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(
				new String[] { "Matriculado(M)", "N\u00E3o Matriculado(N)", "Ativo(A)", "Inativo(I) " }));
		comboBoxSituacao.setBounds(786, 68, 139, 20);
		pane_1.add(comboBoxSituacao);

		JLabel lblDataDeMatricula = new JLabel("Data de matr\u00EDcula:");
		lblDataDeMatricula.setBounds(10, 153, 92, 14);
		pane_1.add(lblDataDeMatricula);

		JFormattedTextField formattedTxtDtMatricula = new JFormattedTextField();
		formattedTxtDtMatricula.setBounds(112, 150, 108, 20);
		pane_1.add(formattedTxtDtMatricula);
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
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
	}
	
	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Aluno aluno){
		txtNome.setText(aluno.getNome());
		txtRg.setText(aluno.getRg());
		formattedTxtCpf.setText(aluno.getCpf());
		txtEmail.setText(aluno.getEmail());
		txtProfissao.setText(aluno.getProfissao());
		//formattedTxtDtNascimento.setText(aluno.getDtNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		formattedTxtTelefone.setText(aluno.getTelefone());
		comboBoxEstadoCivil.setSelectedIndex(0);
		comboBoxSexo.setSelectedIndex(0);
		comboBoxSituacao.setSelectedIndex(0);
		formattedTxtCep.setText(aluno.getCep());
		txtRua.setText(aluno.getRua());
		//txtNumero.setText(aluno.getNumero());
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
	}
	
	/**
	 * Metodo para desabilitar alguns campos para edicao
	 */
	public void setEditable(boolean flag){
		txtNome.setEditable(flag);
		formattedTxtCpf.setEditable(flag);
		formattedTxtCpf.setFocusable(flag);
		
		btnCadastrar.setVisible(flag);
	}
	
}
