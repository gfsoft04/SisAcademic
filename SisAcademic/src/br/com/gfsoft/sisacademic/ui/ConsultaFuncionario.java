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

import br.com.gfsoft.sisacademic.model.Funcionario;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.persistence.PersistenceFuncionario;

public class ConsultaFuncionario extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTable table;
	private JButton btnFiltrar;
	private JButton btnImprimir;
	
	private Funcionario funcionario;
	private PersistenceFuncionario pFuncionario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionario frame = new ConsultaFuncionario();
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
	public ConsultaFuncionario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Funcionários");
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
					
					funcionario = new Funcionario();
					pFuncionario = new PersistenceFuncionario();
					funcionario = pFuncionario.selectFuncionario(matricula);
					
					Principal.FUNCIONARIO.preencheCampos(funcionario);
					Principal.FUNCIONARIO.setEditable(false);
					Principal.FUNCIONARIO.alternaBotoes(true);
					Principal.FUNCIONARIO.setVisible(true);
					Principal.FUNCIONARIO.setTitle("Editar");
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
		
		/* BOTAO FILTRAR */
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(510, 48, 100, 30);
		panel.add(btnFiltrar);
		
		/* BOTAO IMPRIMIR */
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(650, 48, 100, 30);
		panel.add(btnImprimir);
		
		
		preencherTabela();
	}
	
	
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Funcionario> funcionario = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome","cpf","rg","email","Data Nascimento", "Data de Contratação"};
        pFuncionario = new PersistenceFuncionario();
        
        funcionario.addAll(pFuncionario.selectFuncionarios());
        
        for(Funcionario f : funcionario){
        	dados.add(new Object[]{f.getMatricula(), f.getNome(), f.getCpf(), f.getRg(), f.getEmail(), f.getDtNascimento(), f.getDtContratacao()});
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
