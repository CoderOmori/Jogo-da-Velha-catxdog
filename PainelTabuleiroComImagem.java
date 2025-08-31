import java.awt.*;
import javax.swing.*;

public class PainelTabuleiroComImagem extends JPanel {
    private Image imagemFundo;

    public PainelTabuleiroComImagem() {
        ImageIcon iconTabuleiro = new ImageIcon("tabuleiro.png");
        this.imagemFundo = iconTabuleiro.getImage();
        if (this.imagemFundo == null) {
            System.err.println("Erro: Imagem do tabuleiro não encontrada.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            g.drawImage(imagemFundo, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}