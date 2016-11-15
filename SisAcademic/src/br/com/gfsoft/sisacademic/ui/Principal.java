package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Principal extends JFrame {

	private static CadAluno aluno;
	private static CadFuncionario funcionario;
	private static CadProfessor professor;
	private static CadDisciplina disciplina;
	private static ConsultaPessoa consultaPessoa;
	private static Principal principal;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
    
	public static Principal getInstancia(){
        if(principal == null){
        	principal = new Principal();
        }
        return principal;
    }
    
    public static JDesktopPane getDesktop(){
        return getInstancia().desktopPane;
    }
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		desktopPane.setBackground(SystemColor.desktop);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmCadAluno = new JMenuItem("Cadastro de Aluno");
		mntmCadAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aluno == null) {
					aluno = new CadAluno();
					desktopPane.add(aluno);
					try {
						aluno.setMaximum(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					aluno.setVisible(true);
				} else {
					aluno.setVisible(true);
					desktopPane.moveToFront(aluno);
				}

			}
		});
		mnArquivo.add(mntmCadAluno);

		JMenuItem mntmCadProfessor = new JMenuItem("Cadastro de Professor");
		mntmCadProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (professor == null) {
					professor = new CadProfessor();
					desktopPane.add(professor);
					try {
						professor.setMaximum(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					professor.setVisible(true);
				} else {
					professor.setVisible(true);
					desktopPane.moveToFront(professor);
				}
				
			}
		});
		mnArquivo.add(mntmCadProfessor);

		JMenuItem mntmCadFuncinario = new JMenuItem("Cadastro de Funcion\u00E1rio");
		mntmCadFuncinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (funcionario == null) {
					funcionario = new CadFuncionario();
					desktopPane.add(funcionario);
					try {
						funcionario.setMaximum(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					funcionario.setVisible(true);
				} else {
					funcionario.setVisible(true);
					desktopPane.moveToFront(funcionario);
				}
			
			}
		});
		mnArquivo.add(mntmCadFuncinario);

		JMenuItem mntmCadDisciplina = new JMenuItem("Cadastro de Disciplina");
		mntmCadDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (disciplina == null) {
					disciplina = new CadDisciplina();
					desktopPane.add(disciplina);
					try {
						disciplina.setMaximum(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					disciplina.setVisible(true);
				} else {
					disciplina.setVisible(true);
					desktopPane.moveToFront(disciplina);
				}
				
			}
		});
		mnArquivo.add(mntmCadDisciplina);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);

		JMenuItem mntmConsultaPessoa = new JMenuItem("Pessoa");
		mntmConsultaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (consultaPessoa == null) {
					consultaPessoa = new ConsultaPessoa();
					desktopPane.add(consultaPessoa);
					try {
						consultaPessoa.setMaximum(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					consultaPessoa.setVisible(true);
				} else {
					consultaPessoa.setVisible(true);
					desktopPane.moveToFront(consultaPessoa);
				}
				
			}
		});
		mnConsulta.add(mntmConsultaPessoa);

		JMenuItem mntmConsultaDisciplina = new JMenuItem("Disciplina");
		mnConsulta.add(mntmConsultaDisciplina);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnAjuda.add(mntmAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
	}
	
}
