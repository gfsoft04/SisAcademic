package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.persistence.PersistenceAluno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaAluno extends JInternalFrame {
	private JTextField txtNome;
	private JButton btnFiltrar;
	private JTable table;
	private JTextField txtMatricula;

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
		txtNome.setBounds(115, 27, 350, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 30, 75, 14);
		panel.add(lblNewLabel);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = txtMatricula.getText();
				String nome = txtNome.getText();
				
				
				
			}
		});
		btnFiltrar.setBounds(500, 48, 100, 30);
		panel.add(btnFiltrar);
		
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
					PersistenceAluno pPersistenceAluno = new PersistenceAluno();
					Aluno aluno = new Aluno();
					aluno = pPersistenceAluno.selectAluno(matricula);
					
					Principal.ALUNO.preencheCampos(aluno);
					Principal.ALUNO.setEditable(false);
					Principal.ALUNO.alternaBotoes(true);
					Principal.ALUNO.setVisible(true);
					Principal.ALUNO.setTitle("Editar");
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(115, 58, 350, 20);
		panel.add(txtMatricula);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(30, 61, 75, 14);
		panel.add(lblMatricula);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(650, 48, 100, 30);
		panel.add(btnImprimir);
		
		preencherTabela();

	}
	
	
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome","cpf","rg","email","Data Nascimento", "Data de Matricula"};
        PersistenceAluno pPersistenceAluno = new PersistenceAluno();
        
        alunos.addAll(pPersistenceAluno.selectAlunos());
        
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
