package swing;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author nilton.brito
 */
public class JOptionPaneCustom {
    
    public Icon icone(String path, int width, int heigth){
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
}
