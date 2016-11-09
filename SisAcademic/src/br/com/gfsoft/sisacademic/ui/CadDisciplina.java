package br.com.gfsoft.sisacademic.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class CadDisciplina extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtSemestre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadDisciplina frame = new CadDisciplina();
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
	public CadDisciplina() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de Disciplina");
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados da Disciplina", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 622, 343);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(76, 24, 219, 20);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel label_3 = new JLabel("Nome:");
		label_3.setBounds(24, 27, 53, 14);
		panel_1.add(label_3);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(95, 80, 200, 20);
		panel_1.add(txtDescricao);
		
		JLabel label_2 = new JLabel("Descri\u00E7\u00E3o:");
		label_2.setBounds(24, 83, 82, 14);
		panel_1.add(label_2);
		
		txtSemestre = new JTextField();
		txtSemestre.setColumns(10);
		txtSemestre.setBounds(417, 80, 86, 20);
		panel_1.add(txtSemestre);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(346, 83, 86, 14);
		panel_1.add(lblSemestre);
		
		JTextPane textPaneObservacao = new JTextPane();
		textPaneObservacao.setBounds(109, 191, 299, 141);
		panel_1.add(textPaneObservacao);
		
		JComboBox comboBoxSituacao = new JComboBox();
		comboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"Dispon\u00EDvel", "Indispon\u00EDvel"}));
		comboBoxSituacao.setBounds(421, 23, 155, 22);
		panel_1.add(comboBoxSituacao);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(346, 27, 46, 14);
		panel_1.add(lblSituao);
		
		JLabel lblNewLabel = new JLabel("Observa\u00E7\u00E3o:");
		lblNewLabel.setBounds(26, 186, 62, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblDataDeCriao = new JLabel("Data de cria\u00E7\u00E3o:");
		lblDataDeCriao.setBounds(24, 132, 82, 14);
		panel_1.add(lblDataDeCriao);
		
		JFormattedTextField formattedTxtDtCriacao = new JFormattedTextField();
		formattedTxtDtCriacao.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                	formattedTxtDtCriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("##/##/####")));
                } catch (ParseException pe) {
                    pe.printStackTrace();
                }
            }
        });
		formattedTxtDtCriacao.setBounds(109, 129, 98, 20);
		panel_1.add(formattedTxtDtCriacao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(350, 365, 282, 54);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 11, 100, 30);
		panel_2.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(172, 11, 100, 30);
		panel_2.add(btnCadastrar);

	}
}
