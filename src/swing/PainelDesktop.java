package swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

/**
 *
 * @author nilton.brito
 */
public class PainelDesktop extends javax.swing.JDesktopPane{

    Image img = new ImageIcon(getClass().getResource("/imagens/principal/background.jpg")).getImage();

    @Override
    public void paintChildren(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintChildren(g);
    }
}
