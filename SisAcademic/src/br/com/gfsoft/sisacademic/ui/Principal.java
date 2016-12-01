package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2668553652567269485L;
	public static CadAluno ALUNO;
	public static CadFuncionario FUNCIONARIO;
	public static CadProfessor PROFESSOR;
	public static CadDisciplina DISCIPLINA;
	public static ConsultaAluno CONSULTAALUNO;
	public static ConsultaFuncionario CONSULTAFUNCIONARIO;
	public static ConsultaProfessor CONSULTAPROFESSOR;
	public static ConsultaDisciplina CONSULTADISCIPLINA;
	
	private JDesktopPane desktopPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
			System.out.println(e);
		} catch (ClassNotFoundException e) {
		    // handle exception
			System.out.println(e);
		} catch (InstantiationException e) {
		    // handle exception
			System.out.println(e);
		} catch (IllegalAccessException e) {
		    // handle exception
			System.out.println(e);
		}
		
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
		setTitle("SisAcademic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 720);
		setExtendedState(MAXIMIZED_BOTH);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelInicial.setBounds(10, 11, 1342, 644);
		desktopPane.add(panelInicial);
		panelInicial.setLayout(null);
		
		JButton btnNewButton = new JButton("Aluno");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\add.png"));
		btnNewButton.setBounds(146, 48, 170, 65);
		panelInicial.add(btnNewButton);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\add.png"));
		btnProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfessor.setBounds(146, 168, 170, 65);
		panelInicial.add(btnProfessor);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\add.png"));
		btnFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		btnFuncionario.setBounds(146, 288, 170, 65);
		panelInicial.add(btnFuncionario);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\add.png"));
		btnDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		btnDisciplina.setBounds(146, 408, 170, 65);
		panelInicial.add(btnDisciplina);
		
		JButton button = new JButton("Aluno");
		button.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\consultar.png"));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBounds(952, 48, 170, 65);
		panelInicial.add(button);
		
		JButton button_1 = new JButton("Professor");
		button_1.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\consultar.png"));
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setBounds(952, 168, 170, 65);
		panelInicial.add(button_1);
		
		JButton button_2 = new JButton("Funcionario");
		button_2.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\consultar.png"));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setBounds(952, 288, 170, 65);
		panelInicial.add(button_2);
		
		JButton button_3 = new JButton("Disciplina");
		button_3.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\consultar.png"));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setBounds(952, 408, 170, 65);
		panelInicial.add(button_3);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("C:\\Users\\Bruno\\git\\SisAcademic\\SisAcademic\\icon\\sisAcademic.png"));
		labelLogo.setBounds(501, 108, 301, 245);
		panelInicial.add(labelLogo);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmCadAluno = new JMenuItem("Cadastro de Aluno");
		mntmCadAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ALUNO.setVisible(true);
				ALUNO.alternaBotoes(false);
				ALUNO.setEditable(true);
				ALUNO.setTitle("Cadastro de Aluno");
				desktopPane.moveToFront(ALUNO);
			}
		});
		mnArquivo.add(mntmCadAluno);

		JMenuItem mntmCadProfessor = new JMenuItem("Cadastro de Professor");
		mntmCadProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PROFESSOR.setVisible(true);
				PROFESSOR.alternaBotoes(false);
				PROFESSOR.setEditable(true);
				PROFESSOR.setTitle("Cadastro de Professor");
				desktopPane.moveToFront(PROFESSOR);
			}
		});
		
				JMenuItem mntmCadFuncinario = new JMenuItem("Cadastro de Funcion\u00E1rio");
				mntmCadFuncinario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FUNCIONARIO.setVisible(true);
						FUNCIONARIO.alternaBotoes(false);
						FUNCIONARIO.setEditable(true);
						FUNCIONARIO.setTitle("Cadastro de Funcionário");
						desktopPane.moveToFront(FUNCIONARIO);
					}
				});
				mnArquivo.add(mntmCadFuncinario);
		mnArquivo.add(mntmCadProfessor);

		JMenuItem mntmCadDisciplina = new JMenuItem("Cadastro de Disciplina");
		mntmCadDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DISCIPLINA.setVisible(true);
				DISCIPLINA.alternaBotoes(false);
				DISCIPLINA.setEditable(true);
				DISCIPLINA.setTitle("Cadastro de Disciplina");
				desktopPane.moveToFront(DISCIPLINA);
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

		JMenuItem mntmConsultaAluno = new JMenuItem("Aluno");
		mntmConsultaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAALUNO.setVisible(true);
				CONSULTAALUNO.setTitle("Consulta de Alunos");
				CONSULTAALUNO.preencherTabela();
				desktopPane.moveToFront(CONSULTAALUNO);
			}
		});
		mnConsulta.add(mntmConsultaAluno);

		JMenuItem mntmConsultaDisciplina = new JMenuItem("Disciplina");
		mntmConsultaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTADISCIPLINA.setVisible(true);
				CONSULTADISCIPLINA.setTitle("Consulta de Disciplinas");
				CONSULTADISCIPLINA.preencherTabela();
				desktopPane.moveToFront(CONSULTADISCIPLINA);
			}
		});
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAFUNCIONARIO.setVisible(true);
				CONSULTAFUNCIONARIO.setTitle("Consulta de Funcionários");
				CONSULTAFUNCIONARIO.preencherTabela();
				desktopPane.moveToFront(CONSULTAFUNCIONARIO);
			}
		});
		mnConsulta.add(mntmFuncionario);
		
		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAPROFESSOR.setVisible(true);
				CONSULTAPROFESSOR.setTitle("Consulta de Professores");
				CONSULTAPROFESSOR.preencherTabela();
				desktopPane.moveToFront(CONSULTAPROFESSOR);
			}
		});
		mnConsulta.add(mntmProfessor);
		mnConsulta.add(mntmConsultaDisciplina);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnAjuda.add(mntmAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		/**
		 *  IMAGENS E BOTOES
		 *  DA INTEFACE VISUAL
		 */
		
		
		
		
		
		/**
		 * Instanciando todas as telas e deixando invisiveis
		 */
		ALUNO = new CadAluno();
		FUNCIONARIO = new CadFuncionario();
		PROFESSOR = new CadProfessor();
		DISCIPLINA = new CadDisciplina();
		CONSULTAALUNO = new ConsultaAluno();
		CONSULTAFUNCIONARIO = new ConsultaFuncionario();
		CONSULTAPROFESSOR = new ConsultaProfessor();
		CONSULTADISCIPLINA = new ConsultaDisciplina();
		
		desktopPane.add(ALUNO);
		desktopPane.add(FUNCIONARIO);
		desktopPane.add(PROFESSOR);
		desktopPane.add(DISCIPLINA);
		desktopPane.add(CONSULTAALUNO);
		desktopPane.add(CONSULTAFUNCIONARIO);
		desktopPane.add(CONSULTAPROFESSOR);
		desktopPane.add(CONSULTADISCIPLINA);
		
		try {
			ALUNO.setMaximum(true);
			FUNCIONARIO.setMaximum(true);
			PROFESSOR.setMaximum(true);
			DISCIPLINA.setMaximum(true);
			CONSULTAALUNO.setMaximum(true);
			CONSULTAFUNCIONARIO.setMaximum(true);
			CONSULTAPROFESSOR.setMaximum(true);
			CONSULTADISCIPLINA.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ALUNO.setVisible(false);
		FUNCIONARIO.setVisible(false);
		PROFESSOR.setVisible(false);
		DISCIPLINA.setVisible(false);
		CONSULTAALUNO.setVisible(false);
		CONSULTAFUNCIONARIO.setVisible(false);
		CONSULTAPROFESSOR.setVisible(false);
		CONSULTADISCIPLINA.setVisible(false);
		// =======================================================
		
	}
}
