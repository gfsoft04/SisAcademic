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
import javax.swing.border.LineBorder;

public class CadAluno extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtProfissao;

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
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel pane_2 = new JPanel();
		pane_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Endere\u00E7o",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pane_2.setBounds(10, 225, 974, 196);
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
		});
		formattedTxtCep.setBounds(73, 40, 120, 20);
		pane_2.add(formattedTxtCep);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(40, 90, 35, 14);
		pane_2.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(81, 87, 250, 20);
		pane_2.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(368, 93, 50, 14);
		pane_2.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(431, 90, 59, 20);
		pane_2.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(532, 93, 44, 14);
		pane_2.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(586, 90, 237, 20);
		pane_2.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(40, 136, 42, 14);
		pane_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(92, 133, 250, 20);
		pane_2.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(368, 136, 42, 14);
		pane_2.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(420, 133, 250, 20);
		pane_2.add(txtEstado);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 432, 296, 127);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JTextPane txtPaneObservacao = new JTextPane();
		txtPaneObservacao.setBounds(12, 20, 276, 95);
		panel_3.add(txtPaneObservacao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBounds(475, 487, 290, 50);
		panel.add(panel_4);
						panel_4.setLayout(null);
				
						JButton btnCancelar = new JButton("Cancelar");
						btnCancelar.setBounds(10, 11, 100, 30);
						panel_4.add(btnCancelar);
						btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				JButton btnCadastrar = new JButton("Cadastrar");
				btnCadastrar.setBounds(180, 11, 100, 30);
				panel_4.add(btnCadastrar);
				btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
						JPanel pane_1 = new JPanel();
						pane_1.setBounds(10, 12, 962, 196);
						panel.add(pane_1);
						pane_1.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						pane_1.setLayout(null);
						
								JLabel lblNewLabel = new JLabel("Nome:");
								lblNewLabel.setBounds(12, 42, 60, 14);
								pane_1.add(lblNewLabel);
								
										txtNome = new JTextField();
										txtNome.setBounds(65, 40, 329, 20);
										pane_1.add(txtNome);
										txtNome.setColumns(10);
										
												JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
												lblDataDeNascimento.setBounds(12, 87, 151, 14);
												pane_1.add(lblDataDeNascimento);
												
														JFormattedTextField formattedTxtDtNascimento = new JFormattedTextField();
														formattedTxtDtNascimento.setBounds(254, 85, 139, 20);
														pane_1.add(formattedTxtDtNascimento);
														
																JLabel lblEmail = new JLabel("Email:");
																lblEmail.setBounds(40, 133, 35, 14);
																pane_1.add(lblEmail);
																
																		txtEmail = new JTextField();
																		txtEmail.setBounds(120, 131, 250, 20);
																		pane_1.add(txtEmail);
																		txtEmail.setColumns(10);
																		
																				JLabel lblTelefone = new JLabel("Telefone:");
																				lblTelefone.setBounds(368, 133, 60, 14);
																				pane_1.add(lblTelefone);
																				
																						JLabel lblEstadoCivil = new JLabel("Estado Civil:");
																						lblEstadoCivil.setBounds(497, 87, 86, 14);
																						pane_1.add(lblEstadoCivil);
																						
																								JComboBox comboBoxEstadoCivil = new JComboBox();
																								comboBoxEstadoCivil.setBounds(601, 83, 151, 22);
																								pane_1.add(comboBoxEstadoCivil);
																								comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(
																										new String[] { "Solteiro", "Casado", "Vi\u00FAvo", "Divorciado", "Uni\u00E3o Est\u00E1vel" }));
																								
																										txtRg = new JTextField();
																										txtRg.setBounds(613, 41, 139, 20);
																										pane_1.add(txtRg);
																										txtRg.setColumns(10);
																										
																												JLabel lblRg = new JLabel("RG:");
																												lblRg.setBounds(404, 67, 24, 14);
																												pane_1.add(lblRg);
																												
																														JFormattedTextField formattedTxtCpf = new JFormattedTextField();
																														formattedTxtCpf.setBounds(823, 41, 139, 20);
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
																																lblCpf.setBounds(770, 43, 35, 14);
																																pane_1.add(lblCpf);
																																
																																		JLabel lblSexo = new JLabel("Sexo:");
																																		lblSexo.setBounds(761, 87, 44, 14);
																																		pane_1.add(lblSexo);
																																		
																																				JComboBox comboBoxSexo = new JComboBox();
																																				comboBoxSexo.setBounds(811, 84, 151, 22);
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
																																						
																																						JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
																																						lblProfisso.setBounds(620, 133, 60, 14);
																																						pane_1.add(lblProfisso);
																																						
																																						txtProfissao = new JTextField();
																																						txtProfissao.setColumns(10);
																																						txtProfissao.setBounds(688, 130, 180, 20);
																																						pane_1.add(txtProfissao);
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
				btnCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						setVisible(false);

					}
				});

	}
}
