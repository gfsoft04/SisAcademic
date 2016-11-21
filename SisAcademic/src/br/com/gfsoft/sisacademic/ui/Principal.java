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

	public static CadAluno ALUNO;
	public static CadFuncionario FUNCIONARIO;
	public static CadProfessor PROFESSOR;
	public static CadDisciplina DISCIPLINA;
	public static ConsultaAluno CONSULTAPESSOA;
	public static ConsultaDisciplina CONSULTADISCIPLINA;

	
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

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
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
				PROFESSOR.setTitle("Cadastro de Professor");
				desktopPane.moveToFront(PROFESSOR);
			}
		});
		mnArquivo.add(mntmCadProfessor);

		JMenuItem mntmCadFuncinario = new JMenuItem("Cadastro de Funcion\u00E1rio");
		mntmCadFuncinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FUNCIONARIO.setVisible(true);
				FUNCIONARIO.setTitle("Cadastro de Funcionário");
				desktopPane.moveToFront(FUNCIONARIO);
			}
		});
		mnArquivo.add(mntmCadFuncinario);

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

		JMenuItem mntmConsultaPessoa = new JMenuItem("Pessoa");
		mntmConsultaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTAPESSOA.setVisible(true);
				CONSULTAPESSOA.setTitle("Consulta");
				CONSULTAPESSOA.preencherTabela();
				desktopPane.moveToFront(CONSULTAPESSOA);
			}
		});
		mnConsulta.add(mntmConsultaPessoa);

		JMenuItem mntmConsultaDisciplina = new JMenuItem("Disciplina");
		mntmConsultaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CONSULTADISCIPLINA.setVisible(true);
				CONSULTADISCIPLINA.setTitle("Consulta Disciplinas");
				CONSULTADISCIPLINA.preencherTabela();
				desktopPane.moveToFront(CONSULTADISCIPLINA);
			}
		});
		mnConsulta.add(mntmConsultaDisciplina);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnAjuda.add(mntmAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		
		/**
		 * Instanciando todas as telas e deixando invisiveis
		 */
		ALUNO = new CadAluno();
		FUNCIONARIO = new CadFuncionario();
		PROFESSOR = new CadProfessor();
		DISCIPLINA = new CadDisciplina();
		CONSULTAPESSOA = new ConsultaAluno();
		CONSULTADISCIPLINA = new ConsultaDisciplina();
		
		desktopPane.add(ALUNO);
		desktopPane.add(FUNCIONARIO);
		desktopPane.add(PROFESSOR);
		desktopPane.add(DISCIPLINA);
		desktopPane.add(CONSULTAPESSOA);
		desktopPane.add(CONSULTADISCIPLINA);
		
		try {
			ALUNO.setMaximum(true);
			FUNCIONARIO.setMaximum(true);
			PROFESSOR.setMaximum(true);
			DISCIPLINA.setMaximum(true);
			CONSULTAPESSOA.setMaximum(true);
			CONSULTADISCIPLINA.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ALUNO.setVisible(false);
		FUNCIONARIO.setVisible(false);
		PROFESSOR.setVisible(false);
		DISCIPLINA.setVisible(false);
		CONSULTAPESSOA.setVisible(false);
		CONSULTADISCIPLINA.setVisible(false);
		// =======================================================
		
	}
		
}
