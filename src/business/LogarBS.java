package business;

import dao.LogarDao;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.*;
import model.LogarMD;
import static view.FrmAtleta.*;
import static view.TelaLogin.*;
import view.TelaPrincipal;
import static view.TelaPrincipal.*;

/**
 *
 * @author nilton.brito
 */
public class LogarBS {

    LogarMD logarMD = new LogarMD();
    LogarDao logarDao = new LogarDao();
    public static int validar;

    // Método responsável pela autenticação e gestão de perfil do usuário
    public void logarBS() {

        logarMD.setLogin(txtUsuario.getText());
        logarMD.setSenha(new String(txtSenha.getPassword()));

        if (logarMD.getLogin().isEmpty() && logarMD.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
        } else {
            logarDao.logar(logarMD);
            try {
                // Se existir se a senha e usuario e correspondente
                if (logarDao.resultSet.next()) {
                    // A linha abaixo obtem o conteudo do campo perfil da tabela tbusuarios
                    String status = logarDao.resultSet.getString(10);
                    String user = logarDao.resultSet.getString(3);
                    if (status.equalsIgnoreCase("ATIVO")) {
                        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema, " + user, "Boas Vindas", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                        validar = 1;
                        // A linha abaixo obtem o conteudo do campo perfil da tabela tbusuarios
                        String perfil = logarDao.resultSet.getString(9);
                        // A linha abaixo exibe o painel principal
                        TelaPrincipal principal = new TelaPrincipal();
                        principal.setVisible(true);
                        // A estrutura abaixo faz o tratamento do perfil do usuario
                        if (perfil.equalsIgnoreCase("administrador")) {
                            btnDeletarTudo.setEnabled(true);
                            lbUsConecatado.setText(user);
                            lbUsConecatado.setForeground(Color.ORANGE);
                        } else if (perfil.equalsIgnoreCase("gerente")) {
                            btnDeletarTudo.setVisible(false);
                            btnCadastroUsuarios.setVisible(true);
                            btnCadastroAtleta.setVisible(true);
                            btnCadastroExames.setVisible(true);
                            btnCadastroDados.setVisible(false);
                            lbUsConecatado.setText(user);
                            lbUsConecatado.setForeground(Color.BLUE);
                        } else if (perfil.equalsIgnoreCase("professor")) {
                            btnDeletarTudo.setVisible(false);
                            btnCadastroUsuarios.setVisible(false);
                            btnCadastroAtleta.setVisible(true);
                            btnCadastroExames.setVisible(false);
                            btnCadastroDados.setVisible(false);
                            lbUsConecatado.setText(user);
                            lbUsConecatado.setForeground(Color.GREEN);
                        } else {
                            btnDeletarTudo.setVisible(false);
                            btnCadastroUsuarios.setVisible(false);
                            btnCadastroAtleta.setVisible(false);
                            btnCadastroExames.setVisible(false);
                            btnCadastroDados.setVisible(false);
                            lbUsConecatado.setText(user);
                            lbUsConecatado.setForeground(Color.WHITE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário com acesso bloqueado", "Aviso", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                    }
                } else {
                    //System.out.println("conteudo2 "+resultset.next());
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)", "Aviso", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            } catch (Exception e) {

            }
        }

    }

    public void capsLockStatus() {
        try {
            boolean capsLockAtivado = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
            if (capsLockAtivado) {
                alertaCapsLook.setText("A tecla CapsLook está ativada");
            } else {
                alertaCapsLook.setText(null);
            }
        } catch (Exception e) {
        }
    }
}