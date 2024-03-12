package view;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author nilton.brito
 */
public class TelaSplash extends javax.swing.JFrame {

    TelaSplash splash = this;

    /**
     * Creates new form TelaSplash
     */
    public TelaSplash() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        startThread();
    }

    //FUNÇÃO PARA INICIAR O PROGRESSO COM SPLASH
    void startThread() {
        Thread hi = new Thread(new Runnable() {
            @Override
            //CHAMAR O FORMULÁRIO DE LOGIN
            public void run() {
                TelaLogin telaLogin = new TelaLogin(splash);
                telaLogin.setVisible(true);
                dispose();
            }
        });
        hi.start();
    }

    public JProgressBar getJBarProgresso() {
        return barProgresso;
    }

    public JLabel getJLabelProgresso() {
        return lbProgresso;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBordas = new swing.PainelBordas();
        lbTitulo = new javax.swing.JLabel();
        lbInfo1 = new javax.swing.JLabel();
        lbInfo2 = new javax.swing.JLabel();
        lbInfo3 = new javax.swing.JLabel();
        lbInfo4 = new javax.swing.JLabel();
        painelProgresso = new javax.swing.JPanel();
        lbProgresso = new javax.swing.JLabel();
        barProgresso = new javax.swing.JProgressBar();
        lbGap = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        lbJava = new javax.swing.JLabel();
        lbMysql = new javax.swing.JLabel();
        lbGnu = new javax.swing.JLabel();
        lbSplash = new swing.JLabelBordas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKR System");
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSplash.class.getResource("/imagens/principal/icon-50px.png")));
        setUndecorated(true);
        setResizable(false);

        painelBordas.setBackground(new java.awt.Color(255, 255, 255));
        painelBordas.setPreferredSize(new java.awt.Dimension(820, 532));
        painelBordas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lbTitulo.setText("BANDAMPLA SISTEMA E AUTOMAÇÃO");
        painelBordas.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        lbInfo1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        lbInfo1.setForeground(new java.awt.Color(0, 0, 0));
        lbInfo1.setText("Sistema Desenvolvido por Nilton Brito");
        painelBordas.add(lbInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        lbInfo2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        lbInfo2.setForeground(new java.awt.Color(0, 0, 0));
        lbInfo2.setText("GERENCIAMENTO DE IMPRESSÃO DE CERTIFICADOS EM JAVA E MYSQL");
        painelBordas.add(lbInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        lbInfo3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        lbInfo3.setForeground(new java.awt.Color(0, 0, 0));
        lbInfo3.setText("SALVADOR  - BAHIA");
        painelBordas.add(lbInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        lbInfo4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        lbInfo4.setForeground(new java.awt.Color(0, 0, 0));
        lbInfo4.setText("DEZEMBRO - 2023");
        painelBordas.add(lbInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        painelProgresso.setOpaque(false);

        lbProgresso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbProgresso.setForeground(new java.awt.Color(0, 0, 0));
        lbProgresso.setText("Carregando Sistema");

        javax.swing.GroupLayout painelProgressoLayout = new javax.swing.GroupLayout(painelProgresso);
        painelProgresso.setLayout(painelProgressoLayout);
        painelProgressoLayout.setHorizontalGroup(
            painelProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProgressoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProgresso)
                    .addComponent(barProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelProgressoLayout.setVerticalGroup(
            painelProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProgressoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelBordas.add(painelProgresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 300, 50));

        lbGap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/adesivo-Grap.png"))); // NOI18N
        painelBordas.add(lbGap, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 180, 190));

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/logomenor.png"))); // NOI18N
        painelBordas.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, 190));

        lbJava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/adesivo-Java.png"))); // NOI18N
        painelBordas.add(lbJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 70, 190));

        lbMysql.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMysql.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/adesivo-Mysql.png"))); // NOI18N
        painelBordas.add(lbMysql, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 150, 190));

        lbGnu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGnu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/adesivo-Gnu.png"))); // NOI18N
        painelBordas.add(lbGnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, 190));

        lbSplash.setBackground(new java.awt.Color(255, 255, 255));
        lbSplash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSplash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/splash.jpg"))); // NOI18N
        painelBordas.add(lbSplash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBordas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBordas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(820, 532));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barProgresso;
    private javax.swing.JLabel lbGap;
    private javax.swing.JLabel lbGnu;
    private javax.swing.JLabel lbInfo1;
    private javax.swing.JLabel lbInfo2;
    private javax.swing.JLabel lbInfo3;
    private javax.swing.JLabel lbInfo4;
    private javax.swing.JLabel lbJava;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbMysql;
    private javax.swing.JLabel lbProgresso;
    private swing.JLabelBordas lbSplash;
    private javax.swing.JLabel lbTitulo;
    private swing.PainelBordas painelBordas;
    private javax.swing.JPanel painelProgresso;
    // End of variables declaration//GEN-END:variables
}
