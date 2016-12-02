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
import java.awt.Font;

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
		//setIconImage(new ImageIcon(getClass().getResource("icon\\logoGF32.png")).getImage());//Ícone do Programa
		setIconImage(new ImageIcon("icon\\sisAcademic64.png").getImage());

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
		
		JButton btnCadAluno = new JButton("Aluno");
		btnCadAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ALUNO.setVisible(true);
				ALUNO.alternaBotoes(false);
				ALUNO.setEditable(true);
				ALUNO.setTitle("Cadastro de Aluno");
				desktopPane.moveToFront(ALUNO);
			}
		});
		btnCadAluno.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCadAluno.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadAluno.setIcon(new ImageIcon(Principal.class.getResource("/icon/add.png")));
		btnCadAluno.setBounds(146, 48, 170, 80);
		panelInicial.add(btnCadAluno);
		
		JButton btnCadProfessor = new JButton("Professor");
		btnCadProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PROFESSOR.setVisible(true);
				PROFESSOR.alternaBotoes(false);
				PROFESSOR.setEditable(true);
				PROFESSOR.setTitle("Cadastro de Professor");
				desktopPane.moveToFront(PROFESSOR);
			}
		});
		btnCadProfessor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCadProfessor.setIcon(new ImageIcon(Principal.class.getResource("/icon/add.png")));
		btnCadProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadProfessor.setBounds(146, 168, 170, 80);
		panelInicial.add(btnCadProfessor);
		
		JButton btnCadFuncionario = new JButton("Funcionario");
		btnCadFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FUNCIONARIO.setVisible(true);
				FUNCIONARIO.alternaBotoes(false);
				FUNCIONARIO.setEditable(true);
				FUNCIONARIO.setTitle("Cadastro de Funcionário");
				desktopPane.moveToFront(FUNCIONARIO);
			}
		});
		btnCadFuncionario.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCadFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/icon/add.png")));
		btnCadFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadFuncionario.setBounds(146, 288, 170, 80);
		panelInicial.add(btnCadFuncionario);
		
		JButton btnCadDisciplina = new JButton("Disciplina");
		btnCadDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DISCIPLINA.setVisible(true);
				DISCIPLINA.alternaBotoes(false);
				DISCIPLINA.setEditable(true);
				DISCIPLINA.setTitle("Cadastro de Disciplina");
				desktopPane.moveToFront(DISCIPLINA);
			}
		});
		btnCadDisciplina.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCadDisciplina.setIcon(new ImageIcon(Principal.class.getResource("/icon/book.png")));
		btnCadDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadDisciplina.setBounds(146, 408, 170, 80);
		panelInicial.add(btnCadDisciplina);
		
		JButton btnConsultaAluno = new JButton("Aluno");
		btnConsultaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAALUNO.setVisible(true);
				CONSULTAALUNO.setTitle("Consulta de Alunos");
				CONSULTAALUNO.preencherTabela();
				desktopPane.moveToFront(CONSULTAALUNO);
			}
		});
		btnConsultaAluno.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsultaAluno.setIcon(new ImageIcon(Principal.class.getResource("/icon/consultar.png")));
		btnConsultaAluno.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultaAluno.setBounds(983, 48, 170, 80);
		panelInicial.add(btnConsultaAluno);
		
		JButton btnConsultaProfessor = new JButton("Professor");
		btnConsultaProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAPROFESSOR.setVisible(true);
				CONSULTAPROFESSOR.setTitle("Consulta de Professores");
				CONSULTAPROFESSOR.preencherTabela();
				desktopPane.moveToFront(CONSULTAPROFESSOR);
			}
		});
		btnConsultaProfessor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsultaProfessor.setIcon(new ImageIcon(Principal.class.getResource("/icon/consultar.png")));
		btnConsultaProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultaProfessor.setBounds(983, 168, 170, 80);
		panelInicial.add(btnConsultaProfessor);
		
		JButton btnConsultaFuncionario = new JButton("Funcionario");
		btnConsultaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAFUNCIONARIO.setVisible(true);
				CONSULTAFUNCIONARIO.setTitle("Consulta de Funcionários");
				CONSULTAFUNCIONARIO.preencherTabela();
				desktopPane.moveToFront(CONSULTAFUNCIONARIO);
			}
		});
		btnConsultaFuncionario.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsultaFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/icon/consultar.png")));
		btnConsultaFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultaFuncionario.setBounds(983, 288, 170, 80);
		panelInicial.add(btnConsultaFuncionario);
		
		JButton btnConsultaDisciplina = new JButton("Disciplina");
		btnConsultaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTADISCIPLINA.setVisible(true);
				CONSULTADISCIPLINA.setTitle("Consulta de Disciplinas");
				CONSULTADISCIPLINA.preencherTabela();
				desktopPane.moveToFront(CONSULTADISCIPLINA);
			}
		});
		btnConsultaDisciplina.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsultaDisciplina.setIcon(new ImageIcon(Principal.class.getResource("/icon/bookLoupe.png")));
		btnConsultaDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultaDisciplina.setBounds(983, 408, 170, 80);
		panelInicial.add(btnConsultaDisciplina);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(Principal.class.getResource("/icon/sisAcademic.png")));
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
