package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.gfsoft.sisacademic.controller.Academico;
import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.model.exception.UsuarioNaoEncontradoException;

public class ConsultaAluno extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4975802096628333048L;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTable table;
	private JButton btnFiltrar;
	private JButton btnImprimir;
	private JFileChooser jfcSalvar;
	
	private Academico academico;
	private Aluno aluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAluno frame = new ConsultaAluno();
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
	public ConsultaAluno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Alunos");
		setBounds(100, 100, 1200, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 27, 350, 25);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 32, 75, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 1174, 544);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//DUPLO CLICK SOBRE LINHA DA TABELA
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2){
					String matricula = (String) table.getValueAt(table.getSelectedRow(), 0);
					academico = new Academico();
					aluno = new Aluno();
					
					try {
						aluno = academico.buscarAluno(matricula);
						
						Principal.ALUNO.preencheCampos(aluno);
						Principal.ALUNO.setEditable(false);
						Principal.ALUNO.alternaBotoes(true);
						Principal.ALUNO.setVisible(true);
						Principal.ALUNO.setTitle("Editar");
					} catch (UsuarioNaoEncontradoException ex) {
						// Excecao para usuario nao encontrado
						JOptionPane.showMessageDialog(null, "Usuario Nao Cadastrado no Sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(115, 58, 350, 25);
		panel.add(txtMatricula);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(30, 64, 75, 14);
		panel.add(lblMatricula);
		
		/* BOTAO FILTRAR */
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String matricula = txtMatricula.getText();
				String nome = txtNome.getText();
				
				preencherTabelaFiltro(nome);
			}
		});
		btnFiltrar.setBounds(510, 48, 100, 30);
		panel.add(btnFiltrar);
		
		/* BOTAO IMPRIMIR */
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// criacao do documento
		        Document document = new Document();
		        try {
		        	
		        	jfcSalvar = new JFileChooser();
		        	jfcSalvar.setDialogTitle("Salvar Como...");
		        	jfcSalvar.setAcceptAllFileFilterUsed(true);
		        	if (jfcSalvar.showSaveDialog(null) != JFileChooser.APPROVE_OPTION){
		                return;  
		            }
		        	
		        	PdfWriter.getInstance(document, new FileOutputStream(jfcSalvar.getSelectedFile().getAbsolutePath()+".pdf"));
		            document.open();
		            
		            //document.setPageSize(PageSize.A3); // modificado para o tamanho A3;
		            
		            document.add(new Paragraph("Matricula" + " - " + "Nome" + " - " + "CPF"));
		            
		            // adicionando um parágrafo no documento
		            for(int row=0; row<table.getRowCount(); row++){
		            	document.add(new Paragraph(table.getValueAt(row, 0).toString()
		            			+ " - " + table.getValueAt(row, 1).toString()
		            			+ " - " + table.getValueAt(row, 2).toString()));
		            }
		            
		            JOptionPane.showMessageDialog(null, "Relatorio gerado com sucesso!", "Relatorio", JOptionPane.INFORMATION_MESSAGE);
		            
		            
//		            document.newPage();
//		            document.add(new Paragraph("Novo parágrafo na nova página"));
		            
		            
		        }
		        catch(DocumentException de) {
		            System.err.println(de.getMessage());
		        }
		        catch(IOException ioe) {
		            System.err.println(ioe.getMessage());
		        }
		        document.close();
				
			}
		});
		btnImprimir.setBounds(650, 48, 100, 30);
		panel.add(btnImprimir);
		
		
		preencherTabela();
	}
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome","CPF","RG","Email","Data Nascimento", "Data de Matricula"};
        academico = new Academico();
        
        alunos.addAll(academico.listarAlunos());
        
        for(Aluno a : alunos){
        	dados.add(new Object[]{a.getMatricula(), a.getNome(), a.getCpf(), a.getRg(), a.getEmail(), a.getDtNascimento(), a.getDtMatricula()});
        }
        
        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setResizable(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setResizable(true);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setResizable(true);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setResizable(true);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setResizable(true);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setResizable(true);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabelaFiltro(String nome){
        List<Object> dados = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome","CPF","RG","Email","Data Nascimento", "Data de Matricula"};
        academico = new Academico();
        
        alunos.addAll(academico.filtrarAlunos(nome));
        
        for(Aluno a : alunos){
        	dados.add(new Object[]{a.getMatricula(), a.getNome(), a.getCpf(), a.getRg(), a.getEmail(), a.getDtNascimento(), a.getDtMatricula()});
        }
        
        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setResizable(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setResizable(true);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setResizable(true);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setResizable(true);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setResizable(true);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setResizable(true);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
}
