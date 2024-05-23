package br.com.fiap.bean;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Jogo extends JPanel{
	
	// inicializando a pontuação com 0 
	private int pontuacaoJogador = 0, pontuacaoIA = 0;
	
	// componentes
	private JLabel lbPontuacaoJogador, lbPontuacaoIA, lbImagem, lbImagemIA, lbResultado;
	
	private JRadioButton rbPedra, rbPapel, rbTesoura;
	private ButtonGroup buttonGroup;
	
	private JButton btJogar;
	
	private ImageIcon imagemPedra, imagemPapel, imagemTesoura, imagemBranco;
	
	public Jogo() {
		inicializarComponentes();
		definirEventos();
		
		// para que, ao usuário clicar no radio button desejado, mude instantamente
		imagemInstantanea();
	}
	
	public void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.white);
		
		// programando componentes
		
		// pontuação do jogador
		lbPontuacaoJogador = new JLabel(String.valueOf(pontuacaoJogador), JLabel.RIGHT);
		lbPontuacaoJogador.setFont(new Font("Verdana", Font.BOLD, 14));
		lbPontuacaoJogador.setForeground(Color.black);
		
		// pontuação da IA
		lbPontuacaoIA = new JLabel(String.valueOf(pontuacaoIA), JLabel.RIGHT);
		lbPontuacaoIA.setFont(new Font("Verdana", Font.BOLD, 14));
		lbPontuacaoIA.setForeground(Color.black);
		
	
		
		// botão de radio para pedra
		rbPedra = new JRadioButton("Pedra", true);
		rbPedra.setFont(new Font("Verdana", Font.BOLD, 12));
		rbPedra.setForeground(Color.black);
		rbPedra.setBackground(getBackground());
		
		// botão de radio para papel
		rbPapel = new JRadioButton("Papel");
		rbPapel.setFont(new Font("Verdana", Font.BOLD, 12));
		rbPapel.setForeground(Color.black);
		rbPapel.setBackground(getBackground());
		
		// botão de radio para tesoura
		rbTesoura = new JRadioButton("Tesoura");
		rbTesoura.setFont(new Font("Verdana", Font.BOLD, 12));
		rbTesoura.setForeground(Color.black);
		rbTesoura.setBackground(getBackground());
		
		// botao jogar
		btJogar = new JButton("Jogar");
		btJogar.setFont(new Font("Verdana", Font.BOLD, 12));
		btJogar.setForeground(Color.white);
		btJogar.setBackground(Color.black);
		
		// imagem jogador
		imagemPedra = new ImageIcon(getClass().getResource("imagens/pedra.png"));
		imagemPapel = new ImageIcon(getClass().getResource("imagens/papel.png"));
		imagemTesoura = new ImageIcon(getClass().getResource("imagens/tesoura.png"));
	 
		lbImagem = new JLabel(imagemPedra);	
		
		lbImagem.setBounds(20, 30, 180, 190);
		
		// imagem IA -> não preciso definir insta porque nesse caso vai ser random.
		imagemBranco = new ImageIcon(getClass().getResource("imagens/branco.png"));
		
		lbImagemIA = new JLabel(imagemBranco);
		
		lbImagemIA.setBounds(200, 30, 180, 190);	
		
		// adicionando cada botão de radio no grupo de botão
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbPedra);
		buttonGroup.add(rbPapel);
		buttonGroup.add(rbTesoura);
		
		// setando onde eles vao ficar
		lbPontuacaoJogador.setBounds(80, 8, 20, 20);
		lbPontuacaoIA.setBounds(60, 8, 230, 20);
		
		
		rbPedra.setBounds(10, 230, 100, 25);
		rbPapel.setBounds(10, 260, 100, 25);
		rbTesoura.setBounds(10, 290, 100, 25);
		
		btJogar.setBounds(140, 350, 100, 30);
		
		// adicionando em tela
		add(lbPontuacaoJogador);
		add(lbPontuacaoIA);
		
		
		add(rbPedra);
		add(rbPapel);
		add(rbTesoura);
		
		add(lbImagem);
		add(lbImagemIA);
		
		add(btJogar);
		
		// resultado
		lbResultado = new JLabel("", JLabel.CENTER);
		lbResultado.setFont(new Font("Verdana", Font.BOLD, 14));
		lbResultado.setForeground(Color.black);
		lbResultado.setBounds(100, 130, 180, 190);
		add(lbResultado);
	}
	
	private void definirEventos() {
		btJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// usuário clicou, o botão sumiu
				btJogar.setVisible(false);
				
				// no momento em que o usuário clica em jogar, é necessário que retorne um número aleatório para definir imagem
				int opcaoIA = (int)(Math.random() * 4);
				
				if (opcaoIA == 1) {
					lbImagemIA.setIcon(imagemPedra);
				} else if (opcaoIA == 2) {
					lbImagemIA.setIcon(imagemPapel);
				} else {
					lbImagemIA.setIcon(imagemTesoura);
				}
				
				// logica de jogo para caso a pedra esteja selecionada
				
				// escondendo a imagem chamando o metódo
				esconderImagem();
			}
		});
	}
	
	private void imagemInstantanea() {
		rbPedra.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        lbImagem.setIcon(imagemPedra);
		    }
		});

		rbPapel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        lbImagem.setIcon(imagemPapel);
		    }
		});

		rbTesoura.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        lbImagem.setIcon(imagemTesoura);
		    }
		});
	}
	
	// metodo de esconder a imagem da IA
	private void esconderImagem() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbImagemIA.setIcon(imagemBranco);
				btJogar.setVisible(true);
				lbResultado.setVisible(false);
			}
		};
		Timer timer = new Timer(2000, action);
		timer.setRepeats(false);
		timer.start();
	}
}
