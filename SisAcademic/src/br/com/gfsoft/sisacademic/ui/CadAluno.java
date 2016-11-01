package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class CadAluno extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 1000, 700);
		setLocation(400, 100);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 56, 139, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 118, 139, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(66, 25, 285, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(323, 225, 91, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(25, 28, 31, 14);
		panel.add(lblNewLabel);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(25, 59, 18, 14);
		panel.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(25, 90, 23, 14);
		panel.add(lblCpf);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try{
					formattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		        }
		        catch(ParseException pe){
		            pe.printStackTrace();
		        }
			}
		});
		formattedTextField.setText("000.000.000-00");
		formattedTextField.setBounds(66, 87, 139, 20);
		panel.add(formattedTextField);

	}
}
