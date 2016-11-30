package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Login extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 315377563778912521L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 500, 400);
		
		JPanel panel = new JPanel();
		panel.setLocation(-68, -65);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(77, 137, 340, 199);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(49, 87, 61, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(49, 37, 61, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(107, 31, 170, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 80, 170, 28);
		panel_1.add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(187, 142, 90, 30);
		panel_1.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(49, 142, 90, 30);
		panel_1.add(btnCancelar);
		
	}
}
