package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CadAlunoDisciplina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3134335899633879852L;
	private final JPanel contentPanel = new JPanel();
	private JTable jTableInicial;
	private JTable jTableFinal;
	private JButton btnAdd;
	private JButton btnRemover;
	private JButton btnOk;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadAlunoDisciplina dialog = new CadAlunoDisciplina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadAlunoDisciplina() {
		setBounds(100, 100, 900, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 872, 372);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 330, 273);
		panel.add(scrollPane);
		
		jTableInicial = new JTable();
		scrollPane.setViewportView(jTableInicial);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(532, 88, 330, 273);
		panel.add(scrollPane_1);
		
		jTableFinal = new JTable();
		scrollPane_1.setViewportView(jTableFinal);
		
		btnAdd = new JButton(">>");
		btnAdd.setBounds(388, 168, 100, 30);
		panel.add(btnAdd);
		
		btnRemover = new JButton("<<");
		btnRemover.setBounds(388, 227, 100, 30);
		panel.add(btnRemover);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(50, 28, 100, 30);
		panel.add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(190, 28, 100, 30);
		panel.add(btnCancelar);
	}
}
