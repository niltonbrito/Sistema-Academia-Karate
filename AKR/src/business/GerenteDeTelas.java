package business;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author nilton.brito
 */
public class GerenteDeTelas {

    private static JDesktopPane panelDesktop;

    public GerenteDeTelas(JDesktopPane panelDesktop) {
        GerenteDeTelas.panelDesktop = panelDesktop;
    }

    public void abrirJanelas(JInternalFrame jInternalFrame) {
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            panelDesktop.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }
    }
}
