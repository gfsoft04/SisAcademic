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

	private JPanel contentPane;

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
		setBounds(100, 100, 525, 411);
		setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
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
		mnArquivo.add(mntmCadProfessor);

		JMenuItem mntmCadFuncinario = new JMenuItem("Cadastro de Funcion\u00E1rio");
		mnArquivo.add(mntmCadFuncinario);

		JMenuItem mntmCadDisciplina = new JMenuItem("Cadastro de Disciplina");
		mnArquivo.add(mntmCadDisciplina);

		JMenuItem mntmCadTurma = new JMenuItem("Cadastro de Turma");
		mnArquivo.add(mntmCadTurma);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);

		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);

		JMenuItem mntmConsultaAluno = new JMenuItem("Aluno");
		mnConsulta.add(mntmConsultaAluno);

		JMenuItem mntmConsultaProfessor = new JMenuItem("Professor");
		mnConsulta.add(mntmConsultaProfessor);

		JMenuItem mntmConsultaFuncionario = new JMenuItem("Funcion\u00E1rio");
		mnConsulta.add(mntmConsultaFuncionario);

		JMenuItem mntmConsultaDisciplina = new JMenuItem("Disciplina");
		mnConsulta.add(mntmConsultaDisciplina);

		JMenuItem mntmConsultaTurma = new JMenuItem("Turma");
		mnConsulta.add(mntmConsultaTurma);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnAjuda.add(mntmAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
	}
}
