package br.com.gfsoft.sisacademic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JMenu mnTteste = new JMenu("tteste");
		menuBar.add(mnTteste);
		
		JMenuItem mntmDsfsd = new JMenuItem("dsfsd");
		mntmDsfsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (aluno == null) {
		            aluno = new CadAluno();
		            desktopPane.add(aluno);
		            aluno.setVisible(true);
		        } else {
		            aluno.setVisible(true);
		            desktopPane.moveToFront(aluno);
		        }
				
			}
		});
		mnTteste.add(mntmDsfsd);
	}
}
