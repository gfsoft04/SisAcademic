package br.com.gfsoft.sisacademic.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CadFuncionario extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}
