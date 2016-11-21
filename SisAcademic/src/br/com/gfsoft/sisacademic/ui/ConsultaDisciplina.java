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

import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.persistence.PersistenceDisciplina;

public class ConsultaDisciplina extends JInternalFrame {
	private JTextField textField;
	private JButton btnBuscar;
	private JTable table;

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
		setTitle("Consulta Disciplinas");
		setBounds(100, 100, 1000, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(115, 27, 350, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setBounds(30, 30, 75, 14);
		panel.add(lblNewLabel);
		
		btnBuscar = new JButton("Ok");
		btnBuscar.setBounds(500, 26, 91, 23);
		panel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 974, 554);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//DUPLO CLICK SOBRE LINHA DA TABELA
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2){
					long id;
					PersistenceDisciplina pPersistenceDisciplina = new PersistenceDisciplina();
					Disciplina disciplina = new Disciplina();
					//disciplina = pPersistenceDisciplina.selectDisciplina(id);
					
					//Principal.ALUNO.preencheCampos(disciplina);
					Principal.DISCIPLINA.setEditable(false);
					Principal.DISCIPLINA.alternaBotoes(true);
					Principal.DISCIPLINA.setVisible(true);
					Principal.DISCIPLINA.setTitle("Editar");
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		preencherTabela();

	}
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome", "Descrição", "Data de Criação", "Situação", "Semestre", "Observação"};
        PersistenceDisciplina pPersistenceDisc = new PersistenceDisciplina();
        
        disciplinas.addAll(pPersistenceDisc.selectDisciplinas());
        
        for(Disciplina disc : disciplinas){
        	dados.add(new Object[]{disc.getId(), disc.getNome(), disc.getDescricao(), disc.getDtCriacao(), disc.getSituacao(), disc.getSemestre(), disc.getObservacao()});
        }

        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
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
