package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import br.com.gfsoft.sisacademic.model.Administracao;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.persistence.PersistenceAdministracao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaAdm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1393135058574089530L;
	private JTextField txtNome;
	private JButton btnFiltrar;
	private JTable table;
	private JTextField txtMatricula;
	private JFileChooser jfcSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAdm frame = new ConsultaAdm();
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
	public ConsultaAdm() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Administradores");
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
		lblNewLabel.setBounds(30, 33, 75, 14);
		panel.add(lblNewLabel);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(510, 47, 100, 30);
		panel.add(btnFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 1174, 544);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//DUPLO CLICK SOBRE LINHA DA TABELA
			public void mouseClicked(MouseEvent e) {
				
//				if(e.getClickCount() == 2){
//					Aluno aluno = new Aluno();
//					aluno.setNome("Bruno Cesar Alves Ramos");
//					aluno.setRg("1234567");
//					aluno.setCpf("012.345.678-91");
//					aluno.setDtNascimento(LocalDate.now());
//					
//					Principal.ALUNO.preencheCampos(aluno);
//					Principal.ALUNO.setEditable(false);
//					Principal.ALUNO.alternaBotoes(true);
//					Principal.ALUNO.setVisible(true);
//					Principal.ALUNO.setTitle("Editar");
//					
//				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(30, 64, 75, 14);
		panel.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(115, 58, 350, 25);
		panel.add(txtMatricula);
		
		JButton btnImprimir = new JButton("Imprimir");
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
		btnImprimir.setBounds(650, 47, 100, 30);
		panel.add(btnImprimir);
		
		//preencherTabela();

	}
	
	
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Administracao> administracao = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome","cpf","rg","email","Data Nascimento"};
        PersistenceAdministracao pPersistenceAdm = new PersistenceAdministracao();
        
        administracao.addAll(pPersistenceAdm.selectAdministradores());
        
        for(Administracao a : administracao){
        	dados.add(new Object[]{a.getMatricula(), a.getNome(), a.getCpf(), a.getRg(), a.getEmail(), a.getDtNascimento()});
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
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
}
