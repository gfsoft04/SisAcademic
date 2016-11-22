package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.persistence.PersistenceDisciplina;

public class CadDisciplina extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JComboBox comboBoxSituacao;
	private JTextPane textPaneObservacao;
	private JFormattedTextField formattedTxtDtCriacao;
	private JFormattedTextField formattedTextSemestre;
	private JLabel labelId;
	private JTextField txtId;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	
	private PersistenceDisciplina pDisciplina;

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
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(346, 83, 86, 14);
		panel_1.add(lblSemestre);
		
		textPaneObservacao = new JTextPane();
		textPaneObservacao.setBounds(109, 191, 299, 141);
		panel_1.add(textPaneObservacao);
		
		comboBoxSituacao = new JComboBox();
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
		
		formattedTxtDtCriacao = new JFormattedTextField();
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
		
		formattedTextSemestre = new JFormattedTextField();
		formattedTextSemestre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					formattedTextSemestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("####.#")));
                } catch (ParseException pe) {
                    pe.printStackTrace();
                }
			}
		});
		formattedTextSemestre.setBounds(421, 80, 103, 20);
		panel_1.add(formattedTextSemestre);
		
		labelId = new JLabel("ID:");
		labelId.setBounds(253, 132, 42, 14);
		panel_1.add(labelId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(291, 129, 101, 20);
		panel_1.add(txtId);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 365, 612, 54);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		/* BOTAO CADASTRAR */
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtDescricao.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				
				try {
					Disciplina disciplina = new Disciplina();
					pDisciplina = new PersistenceDisciplina();
					
					String situacao = comboBoxSituacao.getSelectedItem().toString().substring(0, 1);
					
					String dia = formattedTxtDtCriacao.getText().substring(0, 2);
					String mes = formattedTxtDtCriacao.getText().substring(3, 5);
					String ano = formattedTxtDtCriacao.getText().substring(6, 10);
					LocalDate dtCriacao = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					
					disciplina.setNome(txtNome.getText());
					disciplina.setSituacao(situacao);
					disciplina.setDescricao(txtDescricao.getText());
					disciplina.setSemestre(formattedTextSemestre.getText());
					disciplina.setDtCriacao(dtCriacao);
					disciplina.setObservacao(textPaneObservacao.getText());
					
					if(pDisciplina.insert(disciplina)){
						JOptionPane.showMessageDialog(null, "Cadastro eferuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
					} /*else {
						JOptionPane.showMessageDialog(null, "Error!", "Erro", JOptionPane.ERROR_MESSAGE);
					}*/
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} 
				
			}
		});
		btnCadastrar.setBounds(159, 11, 100, 30);
		panel_2.add(btnCadastrar);
		
		/* BOTAO DELETAR */
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Disciplina disciplina = new Disciplina();
					pDisciplina = new PersistenceDisciplina();
					long id = Long.parseLong(txtId.getText());
					
					disciplina = pDisciplina.selectDisciplina(id);
					
					//Confirmacao do usuario
					if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirma��o", JOptionPane.WARNING_MESSAGE) == 0){
						if(pDisciplina.delete(disciplina)){
							JOptionPane.showMessageDialog(null, "Exclus�o efetuada com sucesso!", "Exclus�o", JOptionPane.INFORMATION_MESSAGE);
							limparCampos();
							Principal.CONSULTADISCIPLINA.preencherTabela();
						}
					} 
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				} catch (NumberFormatException ex) {
					// Excecao para conversao de texto em numero
					JOptionPane.showMessageDialog(null, "Campo numero s� aceita digitos", "Erro", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				}
			}
		});
		btnDeletar.setBounds(317, 11, 100, 30);
		panel_2.add(btnDeletar);
		
		/* BOTAO ALTERAR */
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtNome.getText().equals("") || txtDescricao.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				
				try {
					Disciplina disciplina = new Disciplina();
					pDisciplina = new PersistenceDisciplina();
					
					String situacao = comboBoxSituacao.getSelectedItem().toString().substring(0, 1);
					
					String dia = formattedTxtDtCriacao.getText().substring(0, 2);
					String mes = formattedTxtDtCriacao.getText().substring(3, 5);
					String ano = formattedTxtDtCriacao.getText().substring(6, 10);
					LocalDate dtCriacao = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
					
					disciplina.setNome(txtNome.getText());
					disciplina.setSituacao(situacao);
					disciplina.setDescricao(txtDescricao.getText());
					disciplina.setSemestre(formattedTextSemestre.getText());
					disciplina.setDtCriacao(dtCriacao);
					disciplina.setObservacao(textPaneObservacao.getText());
					
					if(pDisciplina.insert(disciplina)){
						JOptionPane.showMessageDialog(null, "Cadastro eferuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
						Principal.CONSULTADISCIPLINA.preencherTabela();
					} /*else {
						JOptionPane.showMessageDialog(null, "Error!", "Erro", JOptionPane.ERROR_MESSAGE);
					}*/
					
				} catch (DateTimeException ex) {
					// Excesao para data invalida
					JOptionPane.showMessageDialog(null, "Data Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		btnAlterar.setBounds(159, 11, 100, 30);
		panel_2.add(btnAlterar);
		
		/* BOTAO CANCELAR */
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				setVisible(false);
				
			}
		});
		btnCancelar.setBounds(10, 11, 100, 30);
		panel_2.add(btnCancelar);

	}
	
	
	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Disciplina disciplina){
		txtNome.setText(disciplina.getNome());
		txtDescricao.setText(disciplina.getDescricao());
		//comboBoxSituacao.setSelectedIndex(0);
		textPaneObservacao.setText(disciplina.getObservacao());
		formattedTxtDtCriacao.setText(disciplina.getDtCriacao().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		formattedTextSemestre.setText(disciplina.getSemestre());
	}	
	
	/**
	 * Metodo para alternar botoes habilitados e desabilitados
	 * true = habilita botao alterar e deletar
	 * flase = habilita botao cadastrar
	 */
	public void alternaBotoes(boolean flag){
		btnCadastrar.setVisible(!flag);
		btnAlterar.setVisible(flag);
		btnDeletar.setVisible(flag);
		txtId.setVisible(flag);
		labelId.setVisible(flag);
	}
	
	/**
	 * Metodo para desabilitar alguns campos para edicao
	 */
	public void setEditable(boolean flag){
		txtId.setEditable(flag);
		txtNome.setEditable(flag);	
//		formattedTxtDtCriacao.setEditable(flag);
	}
	
	/**
	 * Metodo para limpar campos
	 */
	public void limparCampos(){
		txtNome.setText("");
		txtDescricao.setText("");
		textPaneObservacao.setText("");
		formattedTextSemestre.setValue("");
		formattedTxtDtCriacao.setValue("");
		comboBoxSituacao.setSelectedIndex(0);
	}
	
}
