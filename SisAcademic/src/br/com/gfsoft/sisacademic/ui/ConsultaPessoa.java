package br.com.gfsoft.sisacademic.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConsultaPessoa extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPessoa frame = new ConsultaPessoa();
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
	public ConsultaPessoa() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Pessoas");
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(115, 27, 350, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setBounds(30, 30, 75, 14);
		panel.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Ok");
		btnBuscar.setBounds(500, 26, 91, 23);
		panel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 974, 554);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
