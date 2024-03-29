package view;

import business.GerenteDeTelas;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author nilton.brito
 */
public class TelaPrincipal extends javax.swing.JFrame {

    GerenteDeTelas gerenteDeTelas;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        this.gerenteDeTelas = new GerenteDeTelas(painelDesktop);
    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            lbHora.setText(String.format(formato.format(sistemaHora), now));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new swing.PainelBordas();
        painelBordas = new swing.PainelBordas();
        lbUsConecatado = new javax.swing.JLabel();
        btnDesconectar = new javax.swing.JButton();
        painelDataHora = new javax.swing.JPanel();
        lbData = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btnCadastroUsuarios = new javax.swing.JButton();
        btnCadastroAtleta = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        btnCadastroExames = new javax.swing.JButton();
        btnCadastroDados = new javax.swing.JButton();
        painelDesktop = new swing.PainelDesktop();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AKR System");
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/principal/icon-50px.png")));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelPrincipal.setBackground(new java.awt.Color(242, 242, 242));

        painelBordas.setBackground(new java.awt.Color(153, 153, 255));
        painelBordas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbUsConecatado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbUsConecatado.setForeground(new java.awt.Color(255, 255, 255));
        lbUsConecatado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/conectado.png"))); // NOI18N
        lbUsConecatado.setText("USUÁRIO");
        lbUsConecatado.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        painelBordas.add(lbUsConecatado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 30));

        btnDesconectar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDesconectar.setForeground(new java.awt.Color(204, 0, 0));
        btnDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair.png"))); // NOI18N
        btnDesconectar.setText("DESCONECTAR...");
        btnDesconectar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        btnDesconectar.setContentAreaFilled(false);
        btnDesconectar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });
        painelBordas.add(btnDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        painelDataHora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        painelDataHora.setOpaque(false);

        lbData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbData.setText("DIA -MÊS - ANO");
        lbData.setPreferredSize(new java.awt.Dimension(225, 20));

        lbHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora.setText("HORA");
        lbHora.setPreferredSize(new java.awt.Dimension(225, 20));

        javax.swing.GroupLayout painelDataHoraLayout = new javax.swing.GroupLayout(painelDataHora);
        painelDataHora.setLayout(painelDataHoraLayout);
        painelDataHoraLayout.setHorizontalGroup(
            painelDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDataHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbData, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelDataHoraLayout.setVerticalGroup(
            painelDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDataHoraLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelBordas.add(painelDataHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 190, -1));

        painelBotoes.setOpaque(false);
        painelBotoes.setLayout(new java.awt.GridLayout());

        btnCadastroUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastroUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/usuario-1-64px.png"))); // NOI18N
        btnCadastroUsuarios.setMnemonic('u');
        btnCadastroUsuarios.setText("CADASTRO USUÁRIOS");
        btnCadastroUsuarios.setBorder(null);
        btnCadastroUsuarios.setContentAreaFilled(false);
        btnCadastroUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastroUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/usuario-2-64px.png"))); // NOI18N
        btnCadastroUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroUsuariosActionPerformed(evt);
            }
        });
        painelBotoes.add(btnCadastroUsuarios);

        btnCadastroAtleta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastroAtleta.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroAtleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/usuario-1-64px.png"))); // NOI18N
        btnCadastroAtleta.setMnemonic('c');
        btnCadastroAtleta.setText("CADASTRO ATLETA");
        btnCadastroAtleta.setBorder(null);
        btnCadastroAtleta.setContentAreaFilled(false);
        btnCadastroAtleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastroAtleta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroAtleta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/usuario-2-64px.png"))); // NOI18N
        btnCadastroAtleta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroAtleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroAtletaActionPerformed(evt);
            }
        });
        painelBotoes.add(btnCadastroAtleta);

        btnConsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/pesquisar-1-64px.png"))); // NOI18N
        btnConsulta.setMnemonic('s');
        btnConsulta.setText("CONSULTA");
        btnConsulta.setBorder(null);
        btnConsulta.setContentAreaFilled(false);
        btnConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsulta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsulta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/pesquisar-2-64px.png"))); // NOI18N
        btnConsulta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });
        painelBotoes.add(btnConsulta);

        btnCadastroExames.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastroExames.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroExames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/certificado-1-64px.png"))); // NOI18N
        btnCadastroExames.setMnemonic('e');
        btnCadastroExames.setText("EXAMES");
        btnCadastroExames.setBorder(null);
        btnCadastroExames.setContentAreaFilled(false);
        btnCadastroExames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastroExames.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroExames.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/certificado-2-64px.png"))); // NOI18N
        btnCadastroExames.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroExamesActionPerformed(evt);
            }
        });
        painelBotoes.add(btnCadastroExames);

        btnCadastroDados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastroDados.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/dados-1-64px.png"))); // NOI18N
        btnCadastroDados.setMnemonic('d');
        btnCadastroDados.setText("CADASTRO DE DADOS");
        btnCadastroDados.setBorder(null);
        btnCadastroDados.setContentAreaFilled(false);
        btnCadastroDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastroDados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroDados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/dados-2-64px.png"))); // NOI18N
        btnCadastroDados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroDadosActionPerformed(evt);
            }
        });
        painelBotoes.add(btnCadastroDados);

        painelBordas.add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 890, 90));

        painelDesktop.setBackground(new Color(0,0,0,0));
        painelDesktop.setOpaque(false);
        painelDesktop.setPreferredSize(new java.awt.Dimension(1348, 567));

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBordas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelBordas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(painelDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painelPrincipal);

        setSize(new java.awt.Dimension(1360, 725));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        lbData.setText(formato.format(sistemaData));

        //HORA DO SISTEMA
        Timer hr = new Timer(100, new TelaPrincipal.horas());
        hr.start();
    }//GEN-LAST:event_formWindowOpened

    private void btnCadastroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroUsuariosActionPerformed
        // TODO add your handling code here:
        gerenteDeTelas.abrirJanelas(FrmUsuarios.getInstancia());
    }//GEN-LAST:event_btnCadastroUsuariosActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Deseja fechar a sessão do usuário?", "Fechar Sessão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/icon-question.png"))) == JOptionPane.YES_OPTION) {
            System.exit(0);
            //this.dispose();
            //TelaLogin login = new TelaLogin();
            //login.setVisible(true);
        }
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnCadastroAtletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroAtletaActionPerformed
        // TODO add your handling code here:
        gerenteDeTelas.abrirJanelas(FrmAtleta.getInstancia());
    }//GEN-LAST:event_btnCadastroAtletaActionPerformed

    private void btnCadastroDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroDadosActionPerformed
        // TODO add your handling code here:
        gerenteDeTelas.abrirJanelas(FrmDados.getInstancia());
    }//GEN-LAST:event_btnCadastroDadosActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        // TODO add your handling code here:
        gerenteDeTelas.abrirJanelas(FrmPesquisa.getInstancia());
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnCadastroExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroExamesActionPerformed
        // TODO add your handling code here:
        gerenteDeTelas.abrirJanelas(FrmExames.getInstancia());
    }//GEN-LAST:event_btnCadastroExamesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCadastroAtleta;
    public static javax.swing.JButton btnCadastroDados;
    public static javax.swing.JButton btnCadastroExames;
    public static javax.swing.JButton btnCadastroUsuarios;
    public static javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    public static javax.swing.JLabel lbUsConecatado;
    private swing.PainelBordas painelBordas;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDataHora;
    private swing.PainelDesktop painelDesktop;
    private swing.PainelBordas painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
