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
		panel_1.setBounds(10, 226, 974, 192);
		panel.add(panel_1);
		
		JLabel label = new JLabel("CEP:");
		label.setBounds(10, 37, 30, 14);
		panel_1.add(label);
		
		formattedTxtCep = new JFormattedTextField();
		formattedTxtCep.setBounds(43, 32, 120, 25);
		panel_1.add(formattedTxtCep);
		
		JLabel label_1 = new JLabel("Rua:");
		label_1.setBounds(198, 37, 35, 14);
		panel_1.add(label_1);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(243, 32, 250, 25);
		panel_1.add(txtRua);
		
		JLabel label_2 = new JLabel("Numero:");
		label_2.setBounds(549, 37, 50, 14);
		panel_1.add(label_2);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(609, 32, 59, 25);
		panel_1.add(txtNumero);
		
		JLabel label_3 = new JLabel("Bairro:");
		label_3.setBounds(10, 92, 44, 14);
		panel_1.add(label_3);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(61, 87, 237, 25);
		panel_1.add(txtBairro);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setBounds(334, 92, 42, 14);
		panel_1.add(label_4);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(386, 87, 250, 25);
		panel_1.add(txtCidade);
		
		JLabel label_5 = new JLabel("Estado:");
		label_5.setBounds(10, 150, 42, 14);
		panel_1.add(label_5);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(57, 145, 250, 25);
		panel_1.add(txtEstado);
		
		JLabel label_6 = new JLabel("Complemento:");
		label_6.setBounds(349, 150, 71, 14);
		panel_1.add(label_6);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(430, 145, 171, 25);
		panel_1.add(txtComplemento);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 974, 204);
		panel.add(panel_2);
		
		JLabel label_7 = new JLabel("Nome:");
		label_7.setBounds(10, 29, 40, 14);
		panel_2.add(label_7);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(60, 24, 329, 25);
		panel_2.add(txtNome);
		
		JLabel label_8 = new JLabel("Data de Nascimento:");
		label_8.setBounds(10, 74, 107, 14);
		panel_2.add(label_8);
		
		formattedTxtDtNascimento = new JFormattedTextField();
		formattedTxtDtNascimento.setBounds(127, 69, 139, 25);
		panel_2.add(formattedTxtDtNascimento);
		
		JLabel label_9 = new JLabel("Email:");
		label_9.setBounds(10, 126, 35, 14);
		panel_2.add(label_9);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(55, 121, 250, 25);
		panel_2.add(txtEmail);
		
		JLabel label_10 = new JLabel("Telefone:");
		label_10.setBounds(327, 126, 60, 14);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Estado Civil:");
		label_11.setBounds(288, 74, 62, 14);
		panel_2.add(label_11);
		
		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setBounds(360, 68, 151, 25);
		panel_2.add(comboBoxEstadoCivil);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(474, 24, 139, 25);
		panel_2.add(txtRg);
		
		JLabel label_12 = new JLabel("RG:");
		label_12.setBounds(444, 29, 20, 14);
		panel_2.add(label_12);
		
		formattedTxtCpf = new JFormattedTextField();
		formattedTxtCpf.setBounds(695, 24, 139, 25);
		panel_2.add(formattedTxtCpf);
		
		JLabel label_13 = new JLabel("CPF:");
		label_13.setBounds(647, 29, 25, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Sexo:");
		label_14.setBounds(546, 74, 35, 14);
		panel_2.add(label_14);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(591, 68, 151, 25);
		panel_2.add(comboBoxSexo);
		
		formattedTxtTelefone = new JFormattedTextField();
		formattedTxtTelefone.setBounds(392, 121, 151, 25);
		panel_2.add(formattedTxtTelefone);
		
		JLabel label_15 = new JLabel("Situa\u00E7\u00E3o:");
		label_15.setBounds(777, 75, 46, 14);
		panel_2.add(label_15);
		
		comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setBounds(833, 69, 118, 25);
		panel_2.add(comboBoxSituacao);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 173, 34, 14);
		panel_2.add(lblSenha);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(55, 168, 139, 25);
		panel_2.add(passwordFieldSenha);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(360, 429, 296, 204);
		panel.add(panel_3);
		
		textPaneObservacao = new JTextPane();
		textPaneObservacao.setBounds(10, 21, 276, 172);
		panel_3.add(textPaneObservacao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Dados Profissionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 429, 340, 204);
		panel.add(panel_4);
		
		JLabel label_16 = new JLabel("Escolaridade:");
		label_16.setBounds(10, 31, 75, 14);
		panel_4.add(label_16);
		
		JLabel label_17 = new JLabel("Sal\u00E1rio: R$");
		label_17.setBounds(10, 112, 65, 14);
		panel_4.add(label_17);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(79, 109, 120, 25);
		panel_4.add(txtSalario);
		
		comboBoxEscolaridade = new JComboBox();
		comboBoxEscolaridade.setBounds(85, 27, 180, 25);
		panel_4.add(comboBoxEscolaridade);
		
		JLabel label_18 = new JLabel("Data de Contrata\u00E7\u00E3o:");
		label_18.setBounds(10, 155, 120, 14);
		panel_4.add(label_18);
		
		formattedTxtDtContratacao = new JFormattedTextField();
		formattedTxtDtContratacao.setBounds(140, 152, 139, 25);
		panel_4.add(formattedTxtDtContratacao);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(64, 68, 186, 25);
		panel_4.add(txtCargo);
		
		JLabel label_19 = new JLabel("Cargo:");
		label_19.setBounds(10, 71, 52, 14);
		panel_4.add(label_19);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(null);
		panel_5.setBounds(667, 478, 290, 155);
		panel.add(panel_5);
		
		/* BOTAO CADASTRAR */
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(180, 11, 100, 30);
		panel_5.add(btnCadastrar);
		
		/* BOTAO ALTERAR */
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(180, 106, 100, 30);
		panel_5.add(btnAlterar);
		
		/* BOTAO DELETAR */
		btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeletar.setBounds(10, 106, 100, 30);
		panel_5.add(btnDeletar);
		
		/* BOTAO CANCELAR */
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(10, 11, 100, 30);
		panel_5.add(btnCancelar);

	}
}
