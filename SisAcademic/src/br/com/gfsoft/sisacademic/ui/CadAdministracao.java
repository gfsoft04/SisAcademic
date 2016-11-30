package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CadAdministracao extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5003983736953466121L;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtComplemento;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtRg;
	private JTextField txtSalario;
	private JTextField txtCargo;
	private JFormattedTextField formattedTxtCep;
	private JFormattedTextField formattedTxtDtNascimento;
	private JFormattedTextField formattedTxtCpf;
	private JFormattedTextField formattedTxtTelefone;
	private JFormattedTextField formattedTxtDtContratacao;
	private JTextPane textPaneObservacao;
	private JPasswordField passwordFieldSenha;
	private JComboBox comboBoxEstadoCivil;
	private JComboBox comboBoxSexo;
	private JComboBox comboBoxSituacao;
	private JComboBox comboBoxEscolaridade;
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAdministracao frame = new CadAdministracao();
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
	public CadAdministracao() {
		setBounds(100, 100, 1000, 670);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Endere\u00E7o",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 240, 974, 196);
		panel.add(panel_1);
		
		JLabel label = new JLabel("CEP:");
		label.setBounds(40, 43, 30, 14);
		panel_1.add(label);
		
		formattedTxtCep = new JFormattedTextField();
		formattedTxtCep.setBounds(73, 40, 120, 20);
		panel_1.add(formattedTxtCep);
		
		JLabel label_1 = new JLabel("Rua:");
		label_1.setBounds(238, 43, 35, 14);
		panel_1.add(label_1);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(279, 40, 250, 20);
		panel_1.add(txtRua);
		
		JLabel label_2 = new JLabel("Numero:");
		label_2.setBounds(586, 40, 50, 14);
		panel_1.add(label_2);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(649, 37, 59, 20);
		panel_1.add(txtNumero);
		
		JLabel label_3 = new JLabel("Bairro:");
		label_3.setBounds(40, 90, 44, 14);
		panel_1.add(label_3);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(94, 87, 237, 20);
		panel_1.add(txtBairro);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setBounds(368, 87, 42, 14);
		panel_1.add(label_4);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(420, 84, 250, 20);
		panel_1.add(txtCidade);
		
		JLabel label_5 = new JLabel("Estado:");
		label_5.setBounds(40, 143, 42, 14);
		panel_1.add(label_5);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(92, 140, 250, 20);
		panel_1.add(txtEstado);
		
		JLabel label_6 = new JLabel("Complemento:");
		label_6.setBounds(384, 140, 71, 14);
		panel_1.add(label_6);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(465, 137, 171, 20);
		panel_1.add(txtComplemento);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 30, 974, 184);
		panel.add(panel_2);
		
		JLabel label_7 = new JLabel("Nome:");
		label_7.setBounds(10, 26, 40, 14);
		panel_2.add(label_7);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(41, 23, 329, 20);
		panel_2.add(txtNome);
		
		JLabel label_8 = new JLabel("Data de Nascimento:");
		label_8.setBounds(10, 59, 107, 14);
		panel_2.add(label_8);
		
		formattedTxtDtNascimento = new JFormattedTextField();
		formattedTxtDtNascimento.setBounds(127, 56, 139, 20);
		panel_2.add(formattedTxtDtNascimento);
		
		JLabel label_9 = new JLabel("Email:");
		label_9.setBounds(10, 96, 35, 14);
		panel_2.add(label_9);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(55, 96, 250, 20);
		panel_2.add(txtEmail);
		
		JLabel label_10 = new JLabel("Telefone:");
		label_10.setBounds(315, 96, 60, 14);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Estado Civil:");
		label_11.setBounds(276, 59, 62, 14);
		panel_2.add(label_11);
		
		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(348, 55, 151, 22);
		panel_2.add(comboBoxEstadoCivil);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(401, 23, 139, 20);
		panel_2.add(txtRg);
		
		JLabel label_12 = new JLabel("RG:");
		label_12.setBounds(380, 26, 20, 14);
		panel_2.add(label_12);
		
		formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(585, 23, 139, 20);
		panel_2.add(formattedTxtCpf);
		
		JLabel label_13 = new JLabel("CPF:");
		label_13.setBounds(550, 26, 25, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Sexo:");
		label_14.setBounds(505, 59, 35, 14);
		panel_2.add(label_14);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(550, 55, 151, 22);
		panel_2.add(comboBoxSexo);
		
		formattedTxtTelefone = new JFormattedTextField();
		formattedTxtTelefone.setBounds(380, 96, 151, 20);
		panel_2.add(formattedTxtTelefone);
		
		JLabel label_15 = new JLabel("Situa\u00E7\u00E3o:");
		label_15.setBounds(715, 59, 46, 14);
		panel_2.add(label_15);
		
		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setBounds(771, 55, 118, 22);
		panel_2.add(comboBoxSituacao);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 141, 34, 14);
		panel_2.add(lblSenha);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(55, 138, 139, 20);
		panel_2.add(passwordFieldSenha);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(360, 447, 296, 162);
		panel.add(panel_3);
		
		textPaneObservacao = new JTextPane();
		textPaneObservacao.setBounds(10, 21, 276, 130);
		panel_3.add(textPaneObservacao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Dados Profissionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 447, 340, 162);
		panel.add(panel_4);
		
		JLabel label_16 = new JLabel("Escolaridade:");
		label_16.setBounds(30, 33, 75, 14);
		panel_4.add(label_16);
		
		JLabel label_17 = new JLabel("Sal\u00E1rio: R$");
		label_17.setBounds(30, 96, 65, 14);
		panel_4.add(label_17);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(99, 93, 120, 20);
		panel_4.add(txtSalario);
		
		comboBoxEscolaridade = new JComboBox();
		comboBoxEscolaridade.setBounds(105, 29, 180, 22);
		panel_4.add(comboBoxEscolaridade);
		
		JLabel label_18 = new JLabel("Data de Contrata\u00E7\u00E3o:");
		label_18.setBounds(30, 124, 120, 14);
		panel_4.add(label_18);
		
		formattedTxtDtContratacao = new JFormattedTextField();
		formattedTxtDtContratacao.setBounds(160, 121, 139, 20);
		panel_4.add(formattedTxtDtContratacao);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(84, 62, 186, 20);
		panel_4.add(txtCargo);
		
		JLabel label_19 = new JLabel("Cargo:");
		label_19.setBounds(30, 65, 52, 14);
		panel_4.add(label_19);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(null);
		panel_5.setBounds(666, 454, 290, 155);
		panel.add(panel_5);
		
		/* BOTAO CADASTRAR */
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(180, 11, 100, 30);
		panel_5.add(btnCadastrar);
		
		/* BOTAO ALTERAR */
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(180, 106, 100, 30);
		panel_5.add(btnAlterar);
		
		/* BOTAO DELETAR */
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(10, 106, 100, 30);
		panel_5.add(btnDeletar);
		
		/* BOTAO CANCELAR */
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(10, 11, 100, 30);
		panel_5.add(btnCancelar);

	}
}
