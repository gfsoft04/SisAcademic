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

import br.com.gfsoft.sisacademic.model.Endereco;
import br.com.gfsoft.sisacademic.util.BuscaCep;

public class CadProfessor extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtSalario;
	private JTextField txtEscolaridade;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtComplemento;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProfessor frame = new CadProfessor();
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
	public CadProfessor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de Professor");
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel pane_1 = new JPanel();
		pane_1.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pane_1.setBounds(10, 30, 974, 184);
		panel.add(pane_1);
		pane_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(40, 43, 40, 14);
		pane_1.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(90, 40, 329, 20);
		pane_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(41, 88, 120, 14);
		pane_1.add(lblDataDeNascimento);

		JFormattedTextField formattedTxtDtNascimento = new JFormattedTextField();
		formattedTxtDtNascimento.setBounds(171, 85, 139, 20);
		pane_1.add(formattedTxtDtNascimento);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 133, 35, 14);
		pane_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(81, 130, 250, 20);
		pane_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(368, 133, 60, 14);
		pane_1.add(lblTelefone);

		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(333, 89, 70, 14);
		pane_1.add(lblEstadoCivil);

		JComboBox comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(413, 84, 151, 22);
		pane_1.add(comboBoxEstadoCivil);
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(
				new String[] { "Solteiro", "Casado", "Vi\u00FAvo", "Divorciado", "Uni\u00E3o Est\u00E1vel" }));

		txtRg = new JTextField();
		txtRg.setBounds(482, 40, 139, 20);
		pane_1.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(454, 43, 20, 14);
		pane_1.add(lblRg);

		JFormattedTextField formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(688, 40, 139, 20);
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
		lblCpf.setBounds(655, 43, 25, 14);
		pane_1.add(lblCpf);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(595, 88, 35, 14);
		pane_1.add(lblSexo);

		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(636, 83, 151, 22);
		pane_1.add(comboBoxSexo);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

		JFormattedTextField formattedTxtTelefone = new JFormattedTextField();
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
		formattedTxtTelefone.setBounds(431, 130, 151, 20);
		pane_1.add(formattedTxtTelefone);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(595, 133, 46, 14);
		pane_1.add(lblSituao);
		
		JComboBox comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"Matriculado (M)", "N\u00E3o Matriculado (N)", "Ativo (A)", "Inativo (I)"}));
		comboBoxSituacao.setBounds(651, 129, 136, 22);
		pane_1.add(comboBoxSituacao);
		
		JPanel pane_2 = new JPanel();
		pane_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Endere\u00E7o",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pane_2.setBounds(10, 223, 974, 196);
		panel.add(pane_2);
		pane_2.setLayout(null);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(40, 43, 30, 14);
		pane_2.add(lblCep);

		JFormattedTextField formattedTxtCep = new JFormattedTextField();
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
		panel_3.setBounds(368, 432, 296, 201);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JTextPane txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(10, 21, 276, 130);
		panel_3.add(txtPaneObservacao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Dados Profissionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 432, 340, 201);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTitularidade = new JLabel("Titularidade:");
		lblTitularidade.setBounds(30, 33, 75, 14);
		panel_4.add(lblTitularidade);
		
		JLabel lblSalarioR = new JLabel("Sal\u00E1rio: R$");
		lblSalarioR.setBounds(30, 76, 65, 14);
		panel_4.add(lblSalarioR);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(99, 73, 100, 20);
		panel_4.add(txtSalario);
		
		JComboBox comboBoxTitularidade = new JComboBox();
		comboBoxTitularidade.setModel(new DefaultComboBoxModel(new String[] {"Especialista", "Mestrado", "Doutorado", "P\u00F3s-doutorado"}));
		comboBoxTitularidade.setBounds(105, 29, 180, 22);
		panel_4.add(comboBoxTitularidade);
		
		JLabel lblDataDeContratao = new JLabel("Data de Contrata\u00E7\u00E3o:");
		lblDataDeContratao.setBounds(30, 117, 120, 14);
		panel_4.add(lblDataDeContratao);
		
		JFormattedTextField formattedTxtDtContratacao = new JFormattedTextField();
		formattedTxtDtContratacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTxtDtContratacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
							new javax.swing.text.MaskFormatter("##/##/####")));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		formattedTxtDtContratacao.setBounds(160, 114, 139, 20);
		panel_4.add(formattedTxtDtContratacao);
		
		JLabel lblEscolaridade = new JLabel("Escolaridade:");
		lblEscolaridade.setBounds(30, 154, 64, 14);
		panel_4.add(lblEscolaridade);
		
		txtEscolaridade = new JTextField();
		txtEscolaridade.setBounds(99, 151, 120, 20);
		panel_4.add(txtEscolaridade);
		txtEscolaridade.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBounds(674, 544, 290, 50);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(10, 11, 100, 30);
				panel_5.add(btnCancelar);
				btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
						JButton btnCadastrar = new JButton("Cadastrar");
						btnCadastrar.setBounds(180, 11, 100, 30);
						panel_5.add(btnCadastrar);
						btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
						btnCadastrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								setVisible(false);

							}
						});
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

	}

}
