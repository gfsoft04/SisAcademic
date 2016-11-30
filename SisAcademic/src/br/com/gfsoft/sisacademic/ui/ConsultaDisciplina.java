package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import br.com.gfsoft.sisacademic.controller.Academico;
import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;

public class ConsultaDisciplina extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 239174010113643168L;
	private JTextField txtNome;
	private JTable table;
	private JButton btnFiltrar;
	private JButton btnImprimir;
	
	private Academico academico;
	private Disciplina disciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDisciplina frame = new ConsultaDisciplina();
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
	public ConsultaDisciplina() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Disciplinas");
		setBounds(100, 100, 1200, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(95, 25, 350, 25);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 30, 75, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 1174, 575);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//DUPLO CLICK SOBRE LINHA DA TABELA
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2){
					long id = Long.parseLong(table.getValueAt(table.getSelectedRow(),0).toString());
					
					academico = new Academico();
					disciplina = new Disciplina();
					disciplina = academico.buscarDisciplina(id);
					
					Principal.DISCIPLINA.preencheCampos(disciplina);
					Principal.DISCIPLINA.setEditable(false);
					Principal.DISCIPLINA.alternaBotoes(true);
					Principal.DISCIPLINA.setVisible(true);
					Principal.DISCIPLINA.setTitle("Editar");
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		/* BOTAO FILTRAR */
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				preencherTabelaFiltro(nome);
			}
		});
		btnFiltrar.setBounds(490, 20, 100, 30);
		panel.add(btnFiltrar);
		
		/* BOTAO IMPRIMIR */
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(630, 20, 100, 30);
		panel.add(btnImprimir);
		
		
		preencherTabela();
	}
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome", "Descri��o", "Data de Cria��o", "Situa��o", "Semestre", "Observa��o"};
        academico = new Academico();
        
        disciplinas.addAll(academico.listarDisciplinas());
        
        for(Disciplina disc : disciplinas){
        	dados.add(new Object[]{disc.getId(), disc.getNome(), disc.getDescricao(), disc.getDtCriacao(), disc.getSituacao(), disc.getSemestre(), disc.getObservacao()});
        }

        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
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
        List<Disciplina> disciplinas = new ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome", "Descri��o", "Data de Cria��o", "Situa��o", "Semestre", "Observa��o"};
        academico = new Academico();
        
        disciplinas.addAll(academico.filtrarDisciplinas(nome));
        
        for(Disciplina disc : disciplinas){
        	dados.add(new Object[]{disc.getId(), disc.getNome(), disc.getDescricao(), disc.getDtCriacao(), disc.getSituacao(), disc.getSemestre(), disc.getObservacao()});
        }

        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
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
