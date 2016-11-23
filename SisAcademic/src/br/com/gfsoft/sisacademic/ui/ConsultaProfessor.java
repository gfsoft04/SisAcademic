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

import br.com.gfsoft.sisacademic.model.Professor;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.persistence.PersistenceProfessor;

public class ConsultaProfessor extends JInternalFrame {
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
					ConsultaProfessor frame = new ConsultaProfessor();
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
	public ConsultaProfessor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Professores");
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
		btnFiltrar.setBounds(510, 48, 100, 30);
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
					String matricula;
					PersistenceProfessor pPersistenceProfessor = new PersistenceProfessor();
					Professor professor = new Professor();
					//professor = pPersistenceProfessor.selectProfessor(matricula);					
					
//					Principal.ALUNO.preencheCampos(professor);
//					Principal.PROFESSOR.setEditable(false);
//					Principal.PROFESSOR.alternaBotoes(true);
//					Principal.PROFESSOR.setVisible(true);
//					Principal.PROFESSOR.setTitle("Editar");
					
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
		
		//preencherTabela();

	}
	
	
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Professor> professor = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome","cpf","rg","email","Data Nascimento"};
        PersistenceProfessor pPersistenceProfessor = new PersistenceProfessor();
        
        professor.addAll(pPersistenceProfessor.selectProfessores());
        
        for(Professor a : professor){
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
