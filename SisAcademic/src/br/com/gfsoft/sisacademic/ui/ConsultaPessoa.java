package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import br.com.gfsoft.sisacademic.model.Aluno;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;
import br.com.gfsoft.sisacademic.persistence.Conexao;

public class ConsultaPessoa extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPessoa frame = new ConsultaPessoa();
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
	public ConsultaPessoa() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Pessoas");
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
		
		JButton btnBuscar = new JButton("Ok");
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
					Aluno aluno = new Aluno();
					aluno.setNome("Bruno Cesar Alves Ramos");
					aluno.setRg("1234567");
					aluno.setCpf("012.345.678-91");
					
					Principal.ALUNO.preencheCampos(aluno);
					Principal.ALUNO.setEditable(false);
					Principal.ALUNO.alternaBotoes(true);
					Principal.ALUNO.setVisible(true);
					Principal.ALUNO.setTitle("Editar");
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		preencherTabela("SELECT * FROM tb_Pessoa");

	}
	
	
	public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Matricula","Nome","cpf","rg","email","Data Nascimento"};
        
        Conexao con = new Conexao();
        try{
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            //rs.first();
            while(rs.next()){
                dados.add(new Object[]{rs.getString("matricula"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("email"), rs.getDate("dtNascimento")});
            }
            stmt.close();
            con.getConnection().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO PREENCHER O ARRAYLIST!: " + e);
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
//        table.getColumnModel().getColumn(6).setPreferredWidth(80);
//        table.getColumnModel().getColumn(6).setResizable(true);
//        table.getColumnModel().getColumn(7).setPreferredWidth(80);
//        table.getColumnModel().getColumn(7).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
}
