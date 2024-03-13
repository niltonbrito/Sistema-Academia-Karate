package business;

import dao.UsuarioDao;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UsuarioMD;
import swing.EstiloTabelaColumn;
import static view.FrmUsuarios.*;

/**
 *
 * @author nilton.brito
 */
public class UsuarioBS {

    UsuarioMD usuario = new UsuarioMD();
    UsuarioDao usuarioDao = new UsuarioDao();

    // Metodo para Adicionar usuários
    public void adicionarUsuario() {

        usuario.setNome(txtNome.getText());
        usuario.setCpf(txtCpf.getText());
        usuario.setCelular(txtCelular.getText());
        usuario.setSexo(cmbSexoUsuario.getSelectedItem().toString());
        usuario.setLogin(txtLogin.getText());
        usuario.setSenha(new String(txtSenha.getPassword()));
        usuario.setPerfil(cmbPerfil.getSelectedItem().toString());
        usuario.setStatus(cmbStatus.getSelectedItem().toString());

        if ((usuario.getNome().isEmpty()) || (usuario.getLogin().isEmpty()) || (usuario.getSenha().length() == 0) || (usuario.getPerfil().isEmpty())|| (usuario.getStatus().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            usuarioDao.adicionarUsuario(usuario);
            if (usuarioDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNome() + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparCampos();
            } else if (usuarioDao.erro.equals("Duplicate entry '" + usuario.getCpf() + "' for key 'cpf_usuario'")) {
                JOptionPane.showMessageDialog(null, "Cpf informado já cadastado.\nInforme outro Cpf.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                usuario.setCpf("");
            } else if (usuarioDao.erro.equals("Duplicate entry '" + usuario.getLogin() + "' for key 'login_usuario'")) {
                JOptionPane.showMessageDialog(null, "Login informado já cadastado.\nInforme outro login.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                usuario.setLogin(null);
            } else {
                JOptionPane.showMessageDialog(null, "Celular informado já cadastado.\nInforme outro celular.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                usuario.setCelular(null);
            }
        }
    }

    // Metodo para alterar dados do usuários com senha
    public void editarUsuario() {
        // Chamando o metodo alterar
        usuario.setId(txtId.getText());
        usuario.setNome(txtNome.getText());
        usuario.setCpf(txtCpf.getText());
        usuario.setCelular(txtCelular.getText());
        usuario.setSexo(cmbSexoUsuario.getSelectedItem().toString());
        usuario.setLogin(txtLogin.getText());
        usuario.setSenha(new String(txtSenha.getPassword()));
        usuario.setPerfil(cmbPerfil.getSelectedItem().toString());
        usuario.setStatus(cmbStatus.getSelectedItem().toString());

        if ((usuario.getId().isEmpty()) || (usuario.getNome().isEmpty()) || (usuario.getLogin().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            if (jCheckSenha.isSelected()) {
                usuarioDao.editarUsuarioComSenha(usuario);
            } else {
                usuarioDao.editarUsuarioSemSenha(usuario);
            }
            if (usuarioDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do usuário alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparCampos();
            } else if (usuarioDao.erro.equals("Duplicate entry '" + usuario.getCpf() + "' for key 'cpf_usuario'")) {
                JOptionPane.showMessageDialog(null, "Cpf informado já cadastado.\nInforme outro Cpf.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                usuario.setCpf("");
            } else if (usuarioDao.erro.equals("Duplicate entry '" + usuario.getCelular() + "' for key 'celular_usuario'")) {
                JOptionPane.showMessageDialog(null, "Celular informado já cadastado.\nInforme outro celular.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                usuario.setCpf("");
            } else {
                JOptionPane.showMessageDialog(null, "Login informado já cadastado.\nInforme outro Login.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                usuario.setCelular(null);
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarUsuario() {
        // Chamando o metodo pesquisar clientes

        usuario.setPesquisar(txtPesquisar.getText());
        usuarioDao.pesquisarUsuario(usuario);

        EstiloTabelaColumn estiloTabela = new EstiloTabelaColumn();
        estiloTabela.ajustarTabelaFrmUsuario();
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        usuarioDao.setarCampos();

        txtSenha.setEditable(false);
        if ((tabelaUsuario.getModel().getValueAt(usuarioDao.resultado, 6).toString().equalsIgnoreCase("admin")) && (tabelaUsuario.getModel().getValueAt(usuarioDao.resultado, 7).toString().equalsIgnoreCase("administrador"))) {
            cmbPerfil.setEnabled(false);
            cmbStatus.setEnabled(false);
            txtNome.setEditable(false);
            txtLogin.setEditable(false);
        } else {
            cmbPerfil.setEnabled(true);
            cmbStatus.setEnabled(true);
            txtNome.setEditable(true);
            txtLogin.setEditable(true);

        }
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnLimpar.setEnabled(true);
    }

    // Metodo para deletar usuários
    public void deletarUsuario() {

        usuario.setLogin(txtLogin.getText());
        usuario.setPerfil(cmbPerfil.getSelectedItem().toString());
        usuario.setId(txtId.getText());

        if (usuario.getLogin().isEmpty() || usuario.getPerfil().isEmpty() || usuario.getId().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else if ((usuario.getLogin().equalsIgnoreCase("admin")) && (usuario.getPerfil().equalsIgnoreCase("administrador"))) {
            JOptionPane.showMessageDialog(null, "Ação proibida, não e possivel deletar o Administrador do Sistema", "Aviso", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                usuarioDao.deletarUsuario(usuario);
                if (usuarioDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "usuario " + usuario.getNome() + " deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar deletar o usuario, erro: " + usuarioDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para limpar os campos do formularios   
    public void limparCampos() {

        txtId.setText(null);
        txtNome.setText(null);
        txtCpf.setText(null);
        txtCelular.setText(null);
        cmbSexoUsuario.setSelectedItem("");
        txtLogin.setText(null);
        txtSenha.setText(null);
        cmbPerfil.setSelectedItem("");
        cmbStatus.setSelectedItem("");
        txtDataCad.setText(null);
        txtPesquisar.setText(null);
        ((DefaultTableModel) tabelaUsuario.getModel()).setRowCount(0);
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnLimpar.setEnabled(false);

        txtNome.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);
    }
}
