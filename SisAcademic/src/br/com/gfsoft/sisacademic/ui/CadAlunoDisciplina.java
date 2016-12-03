package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.com.gfsoft.sisacademic.controller.Academico;
import br.com.gfsoft.sisacademic.model.Disciplina;
import br.com.gfsoft.sisacademic.model.TabelaConsulta;

public class CadAlunoDisciplina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3134335899633879852L;
	private static long idAluno;
	private final JPanel contentPanel = new JPanel();
	private JTable jTableInicial;
	private JTable jTableFinal;
	private JButton btnAdd;
	private JButton btnRemover;
	private Academico academico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadAlunoDisciplina dialog = new CadAlunoDisciplina(idAluno);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadAlunoDisciplina(long idAluno) {
		setTitle("Disciplinas");
		setResizable(false);
		CadAlunoDisciplina.idAluno = idAluno;
		setBounds(100, 100, 900, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 872, 372);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 330, 350);
		panel.add(scrollPane);
		
		jTableInicial = new JTable();
		scrollPane.setViewportView(jTableInicial);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(532, 11, 330, 350);
		panel.add(scrollPane_1);
		
		jTableFinal = new JTable();
		scrollPane_1.setViewportView(jTableFinal);
		
		btnAdd = new JButton(">>");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			//EVENTO PARA ADD DISCIPLINA DA jTableInicial para jTableFinal
			public void actionPerformed(ActionEvent e) {
				academico = new Academico();
				List<Disciplina> disciplinas = new ArrayList<>();
				
				try{
					int linhaSelecionada = jTableInicial.getSelectedRow();// Linha Selecionada
					long id = Long.parseLong(jTableInicial.getValueAt(linhaSelecionada ,0).toString());
					
					disciplinas.addAll(academico.listarAlunoDisciplinas(idAluno));
					
					for(Disciplina d : disciplinas){
						if(d.getId() == id){
							JOptionPane.showMessageDialog(null, "O aluno ja esta matriculado nesta disciplina!", "Erro", JOptionPane.ERROR_MESSAGE);
							return ;
						}
					}
					
					if(academico.cadastrarAlunoDisciplina(idAluno, id)){
						//System.out.println("disciplina cadastrado!");
						//atualizar tabela
						preencherTabelaFinal(idAluno);
					}
				} catch(IndexOutOfBoundsException ex){
		            JOptionPane.showMessageDialog(null, "Nenhuma disciplina selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
			}
		});
		btnAdd.setBounds(388, 111, 100, 40);
		panel.add(btnAdd);
		
		btnRemover = new JButton("<<");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					int linhaSelecionada = jTableFinal.getSelectedRow();// Linha Selecionada
					long id = Long.parseLong(jTableFinal.getValueAt(linhaSelecionada ,0).toString());
					
		            if(academico.deletarAlunoDisciplina(idAluno, id)){
		            	//System.out.println("disciplina deletado!");
						//atualizar tabela
						preencherTabelaFinal(idAluno);
		            }
		        } catch(IndexOutOfBoundsException ex){
		            JOptionPane.showMessageDialog(null, "Nenhuma disciplina selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemover.setBounds(388, 174, 100, 40);
		panel.add(btnRemover);
		
		preencherTabelaInicial();
		preencherTabelaFinal(CadAlunoDisciplina.idAluno);
	}
	
	/**
	 * Metodo para preencher a tabelas
	 * 
	 */
	public void preencherTabelaInicial(){
        List<Object> dados = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome"};
        academico = new Academico();
        
        disciplinas.addAll(academico.listarDisciplinas());
        
        for(Disciplina disc : disciplinas){
        	dados.add(new Object[]{disc.getId(), disc.getNome()});
        }

        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        jTableInicial.setModel(modelo);
        
        jTableInicial.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableInicial.getColumnModel().getColumn(0).setResizable(true);
        jTableInicial.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableInicial.getColumnModel().getColumn(1).setResizable(true);
                
        jTableInicial.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        jTableInicial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableInicial.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
	public void preencherTabelaFinal(long idAluno){
        List<Object> dados = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome"};
        academico = new Academico();
        
        disciplinas.addAll(academico.listarAlunoDisciplinas(idAluno));
        
        for(Disciplina disc : disciplinas){
        	dados.add(new Object[]{disc.getId(), disc.getNome()});
        }

        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        jTableFinal.setModel(modelo);
        
        jTableFinal.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableFinal.getColumnModel().getColumn(0).setResizable(true);
        jTableFinal.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableFinal.getColumnModel().getColumn(1).setResizable(true);
                
        jTableFinal.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        jTableFinal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableFinal.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
}
