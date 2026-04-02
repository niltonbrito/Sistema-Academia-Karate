package business;

import dao.LogarDao;
import java.awt.Color;
import javax.swing.*;
import model.LogarMD;
import static view.TelaLogin.txtSenha;
import static view.TelaLogin.txtUsuario;
import view.TelaPrincipal;
import static view.TelaPrincipal.*;

/**
 *
 * @author nilton.brito
 */
public class LogarBS {

    public static int validar;

    // Método responsável pela autenticação e gestão de perfil do usuário
    public void logarBS() {

        LogarMD logarMD = new LogarMD();
        logarMD.setLogin(txtUsuario.getText());
        logarMD.setSenha(new String(txtSenha.getPassword()));

        if (logarMD.getLogin().isEmpty() && logarMD.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE,  new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
        } else {
            LogarDao logarDao = new LogarDao();
            logarDao.logar(logarMD);
            try {
                // Se existir se a senha e usuario e correspondente
                if (logarDao.resultSet.next()) {
                    // A linha abaixo obtem o conteudo do campo perfil da tabela tbusuarios
                    String status = logarDao.resultSet.getString(10);
                    if (status.equalsIgnoreCase("ATIVO")) {
                        String user = logarDao.resultSet.getString(3);
                        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema, " + user, "Boas Vindas", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                        validar = 1;
                        // A linha abaixo obtem o conteudo do campo perfil da tabela tbusuarios
                        String perfil = logarDao.resultSet.getString(9);
                        // A linha abaixo exibe o painel principal
                        TelaPrincipal principal = new TelaPrincipal();
                        principal.setVisible(true);
                        // A estrutura abaixo faz o tratamento do perfil do usuario
                        if (perfil.equalsIgnoreCase("administrador")) {
//                        menRelatorios.setEnabled(true);
//                        menCadUsuario.setEnabled(true);
//                        menCadEstoque.setEnabled(true);
//                        menCadEmpresa.setEnabled(true);
//                        menConfSistema.setEnabled(true);
//                        menPropSistema.setEnabled(true);
                            lbUsConecatado.setText(logarDao.resultSet.getString(3));
                            lbUsConecatado.setForeground(Color.getHSBColor(0, 102, 102));
                        } else if (perfil.equalsIgnoreCase("gerente")) {
//                        menRelatorios.setEnabled(true);
//                        menCadUsuario.setEnabled(true);
//                        menCadEstoque.setEnabled(true);
//                        menCadEmpresa.setEnabled(true);
//                        menConfSistema.setEnabled(true);
//                        menPropSistema.setEnabled(false);
                            lbUsConecatado.setText(logarDao.resultSet.getString(3));
                            lbUsConecatado.setForeground(Color.BLUE);
                        } else if (perfil.equalsIgnoreCase("professor")) {
//                        menRelatorios.setEnabled(false);
//                        menCadUsuario.setEnabled(false);
//                        menCadEstoque.setEnabled(true);
//                        menConfSistema.setEnabled(false);
//                        menPropSistema.setEnabled(false);
                            lbUsConecatado.setText(logarDao.resultSet.getString(3));
                        } else {
//                        menCadastro.setEnabled(false);
//                        menRelatorios.setEnabled(false);
//                        menOpcoes.setEnabled(false);
                            lbUsConecatado.setText(logarDao.resultSet.getString(3));
                            lbUsConecatado.setForeground(Color.red);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário com acesso bloqueado", "Aviso", JOptionPane.ERROR_MESSAGE,  new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                    }
                } else {
                    //System.out.println("conteudo2 "+resultset.next());
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)", "Aviso", JOptionPane.ERROR_MESSAGE,  new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            } catch (Exception e) {

            }
        }

    }

}
