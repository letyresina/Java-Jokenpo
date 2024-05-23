package br.com.fiap.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.fiap.bean.Jogo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {

	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo;
	private JMenuItem miJogo, miSair;

	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}
	
	// inicializando componentes
	private void inicializarComponentes() {
		setTitle("Jogo: Pedra, Papel ou Tesoura");
		setBackground(Color.blue);
		setBounds(0, 0, 400, 450);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		
		miJogo = new JMenuItem("Jogo");
		miSair = new JMenuItem("Sair");
		
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnArquivo.add(miJogo);
		mnArquivo.add(miSair);
	}
	
	// definindo eventos
	private void definirEventos() {
		// encerra o programa
		miSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// indo para a tela de jogo
		miJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogo jogo1 = new Jogo();
				contentPane.removeAll();
				contentPane.add(jogo1);
				contentPane.validate();
			}
		});
	}
	
	// classe main
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2,
						(tela.height - frame.getSize().height / 2));
		frame.setVisible(true);
	}
}
