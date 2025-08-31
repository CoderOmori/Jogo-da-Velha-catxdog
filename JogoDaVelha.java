import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoDaVelha extends JFrame {

    private JButton[][] botoes = new JButton[3][3];
    private int[][] tabuleiroLogico = new int[3][3]; // 0=vazio, 1=gato, 2=cachorro

    private ImageIcon iconeGato;
    private ImageIcon iconeCachorro;

    private boolean turnoDoGato = true;
    private JLabel labelMensagem;
    private int jogadas = 0;

    public JogoDaVelha() {
        setTitle("Jogo da Velha Fofo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        carregarIcones();
        
        // --- Painel do Tabuleiro Customizado com Imagem ---
        PainelTabuleiroComImagem painelTabuleiro = new PainelTabuleiroComImagem();
        painelTabuleiro.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].addActionListener(new MarcadorDeTurno(i, j));
                botoes[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
                
                botoes[i][j].setOpaque(false);
                botoes[i][j].setContentAreaFilled(false);
                botoes[i][j].setBorderPainted(false);
                
                painelTabuleiro.add(botoes[i][j]);
            }
        }

        // --- Painel de Controle (Mensagem e Botão) ---
        JPanel painelControle = new JPanel();
        painelControle.setLayout(new FlowLayout());

        labelMensagem = new JLabel("Vez do Gatinho!");
        labelMensagem.setFont(new Font("Arial", Font.BOLD, 18));
        painelControle.add(labelMensagem);

        JButton botaoReiniciar = new JButton("Reiniciar");
        botaoReiniciar.addActionListener(e -> reiniciarJogo());
        painelControle.add(botaoReiniciar);

        add(painelControle, BorderLayout.NORTH);
        add(painelTabuleiro, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private void carregarIcones() {
        try {
            // Ajusta o carregamento para ser mais compatível com diferentes ambientes
            iconeGato = new ImageIcon(new ImageIcon("gatinho.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            iconeCachorro = new ImageIcon(new ImageIcon("cachorrinho.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não foi possível carregar as imagens: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private class MarcadorDeTurno implements ActionListener {
        private int linha, coluna;

        public MarcadorDeTurno(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (tabuleiroLogico[linha][coluna] != 0) {
                return;
            }

            int jogadorAtual = turnoDoGato ? 1 : 2;
            tabuleiroLogico[linha][coluna] = jogadorAtual;
            
            ImageIcon iconeAtual = turnoDoGato ? iconeGato : iconeCachorro;
            botoes[linha][coluna].setIcon(iconeAtual);
            
            // Adicionado: Define o ícone desabilitado para manter a cor.
            botoes[linha][coluna].setDisabledIcon(iconeAtual);
            
            botoes[linha][coluna].setEnabled(false);
            
            jogadas++;

            if (verificarVitoria(jogadorAtual)) {
                String vencedor = turnoDoGato ? "Gatinho" : "Cachorrinho";
                labelMensagem.setText(vencedor + " Venceu!");
                desabilitarBotoes();
            } else if (jogadas == 9) {
                labelMensagem.setText("Empate!");
            } else {
                turnoDoGato = !turnoDoGato;
                labelMensagem.setText("Vez do " + (turnoDoGato ? "Gatinho" : "Cachorrinho") + "!");
            }
        }
    }
    
    private boolean verificarVitoria(int jogador) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiroLogico[i][0] == jogador && tabuleiroLogico[i][1] == jogador && tabuleiroLogico[i][2] == jogador) {
                return true;
            }
        }

        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiroLogico[0][j] == jogador && tabuleiroLogico[1][j] == jogador && tabuleiroLogico[2][j] == jogador) {
                return true;
            }
        }

        // Verifica diagonais
        if (tabuleiroLogico[0][0] == jogador && tabuleiroLogico[1][1] == jogador && tabuleiroLogico[2][2] == jogador) {
            return true;
        }
        if (tabuleiroLogico[0][2] == jogador && tabuleiroLogico[1][1] == jogador && tabuleiroLogico[2][0] == jogador) {
            return true;
        }

        return false;
    }

    private void desabilitarBotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setEnabled(false);
            }
        }
    }

    private void reiniciarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiroLogico[i][j] = 0;
                botoes[i][j].setIcon(null);
                botoes[i][j].setEnabled(true);
            }
        }
        turnoDoGato = true;
        jogadas = 0;
        labelMensagem.setText("Vez do Gatinho!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JogoDaVelha::new);
    }
}