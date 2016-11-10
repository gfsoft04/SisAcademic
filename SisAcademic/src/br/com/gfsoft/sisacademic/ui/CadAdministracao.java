package br.com.gfsoft.sisacademic.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class CadAdministracao extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPasswordField passwordFieldSenha;

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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(73, 40, 120, 20);
		panel_1.add(formattedTextField);
		
		JLabel label_1 = new JLabel("Rua:");
		label_1.setBounds(40, 90, 35, 14);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 87, 250, 20);
		panel_1.add(textField);
		
		JLabel label_2 = new JLabel("Numero:");
		label_2.setBounds(368, 93, 50, 14);
		panel_1.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(431, 90, 59, 20);
		panel_1.add(textField_1);
		
		JLabel label_3 = new JLabel("Bairro:");
		label_3.setBounds(532, 93, 44, 14);
		panel_1.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(586, 90, 237, 20);
		panel_1.add(textField_2);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setBounds(40, 136, 42, 14);
		panel_1.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(92, 133, 250, 20);
		panel_1.add(textField_3);
		
		JLabel label_5 = new JLabel("Estado:");
		label_5.setBounds(368, 136, 42, 14);
		panel_1.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(420, 133, 250, 20);
		panel_1.add(textField_4);
		
		JLabel label_6 = new JLabel("Complemento:");
		label_6.setBounds(238, 43, 71, 14);
		panel_1.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(319, 40, 171, 20);
		panel_1.add(textField_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 30, 974, 184);
		panel.add(panel_2);
		
		JLabel label_7 = new JLabel("Nome:");
		label_7.setBounds(10, 26, 40, 14);
		panel_2.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(41, 23, 329, 20);
		panel_2.add(textField_6);
		
		JLabel label_8 = new JLabel("Data de Nascimento:");
		label_8.setBounds(10, 59, 107, 14);
		panel_2.add(label_8);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(127, 56, 139, 20);
		panel_2.add(formattedTextField_1);
		
		JLabel label_9 = new JLabel("Email:");
		label_9.setBounds(10, 96, 35, 14);
		panel_2.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(55, 96, 250, 20);
		panel_2.add(textField_7);
		
		JLabel label_10 = new JLabel("Telefone:");
		label_10.setBounds(315, 96, 60, 14);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Estado Civil:");
		label_11.setBounds(276, 59, 62, 14);
		panel_2.add(label_11);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(348, 55, 151, 22);
		panel_2.add(comboBox);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(401, 23, 139, 20);
		panel_2.add(textField_8);
		
		JLabel label_12 = new JLabel("RG:");
		label_12.setBounds(380, 26, 20, 14);
		panel_2.add(label_12);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(585, 23, 139, 20);
		panel_2.add(formattedTextField_2);
		
		JLabel label_13 = new JLabel("CPF:");
		label_13.setBounds(550, 26, 25, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Sexo:");
		label_14.setBounds(505, 59, 35, 14);
		panel_2.add(label_14);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(550, 55, 151, 22);
		panel_2.add(comboBox_1);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(380, 96, 151, 20);
		panel_2.add(formattedTextField_3);
		
		JLabel label_15 = new JLabel("Situa\u00E7\u00E3o:");
		label_15.setBounds(715, 59, 46, 14);
		panel_2.add(label_15);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(771, 55, 118, 22);
		panel_2.add(comboBox_2);
		
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 21, 276, 130);
		panel_3.add(textPane);
		
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
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(99, 93, 120, 20);
		panel_4.add(textField_9);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(105, 29, 180, 22);
		panel_4.add(comboBox_3);
		
		JLabel label_18 = new JLabel("Data de Contrata\u00E7\u00E3o:");
		label_18.setBounds(30, 124, 120, 14);
		panel_4.add(label_18);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(160, 121, 139, 20);
		panel_4.add(formattedTextField_4);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(84, 62, 186, 20);
		panel_4.add(textField_10);
		
		JLabel label_19 = new JLabel("Cargo:");
		label_19.setBounds(30, 65, 52, 14);
		panel_4.add(label_19);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(null);
		panel_5.setBounds(666, 559, 290, 50);
		panel.add(panel_5);
		
		JButton button = new JButton("Cancelar");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(10, 11, 100, 30);
		panel_5.add(button);
		
		JButton button_1 = new JButton("Cadastrar");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(180, 11, 100, 30);
		panel_5.add(button_1);

	}
}
