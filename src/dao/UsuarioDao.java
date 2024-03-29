package dao;

import conexao.ConexaoDB;
import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import model.*;
import net.proteanit.sql.DbUtils;
import static view.FrmUsuarios.*;

/**
 *
 * @author nilton.brito
 */
public class UsuarioDao {

    private Connection conexao = null;
    PreparedStatement statement = null;
    public ResultSet resultSet = null;
    public int resultado;
    public String erro;

    /**
     * Creates new form TelaUsuario
     */
    public UsuarioDao() {
    }

    // Metodo para gerar data atual
    public String dataAtual() {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        return dataAgora;
    }
    
    // Metodo para Adicionar usuários
    public void adicionarUsuario(UsuarioMD usuario) {

        String sql = "insert into tbusuarios (nome_usuario, cpf_usuario, celular_usuario, sexo_usuario, login_usuario, senha_usuario, perfil_usuario, status_usuario, data_cadastro_usuario) values(?,?,?,?,?,md5(?),?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getCelular());
            statement.setString(4, usuario.getSexo());
            statement.setString(5, usuario.getLogin());
            statement.setString(6, usuario.getSenha());
            statement.setString(7, usuario.getPerfil());
            statement.setString(8, usuario.getStatus());
            statement.setString(9, dataAtual());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado
        } catch (SQLIntegrityConstraintViolationException e1) {
            erro = e1.getMessage();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
            }
        }
    }

    // Metodo para alterar dados do usuários
    public void editarUsuarioSemSenha(UsuarioMD usuario) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        String sql = "update tbusuarios set nome_usuario=?, cpf_usuario=?, celular_usuario=?, sexo_usuario=?, login_usuario=?, perfil_usuario=?, status_usuario=?, data_atualizacao_usuario=? where id_usuario=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getCelular());
            statement.setString(4, usuario.getSexo());
            statement.setString(5, usuario.getLogin());
            statement.setString(6, usuario.getPerfil());
            statement.setString(7, usuario.getStatus());
            statement.setString(8, dataAgora);
            statement.setString(9, usuario.getId());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
            System.out.println("teste " + erro);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar dados do usuários com senha
    public void editarUsuarioComSenha(UsuarioMD usuario) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        String sql = "update tbusuarios set nome_usuario=?,cpf_usuario=?,celular_usuario=?,sexo_usuario=?,login_usuario=?,senha_usuario= md5(?),perfil_usuario=?,status_usuario=?,data_atualizacao_usuario=? where id_usuario=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getCelular());
            statement.setString(4, usuario.getSexo());
            statement.setString(5, usuario.getLogin());
            statement.setString(6, usuario.getSenha());
            statement.setString(7, usuario.getPerfil());
            statement.setString(8, usuario.getStatus());
            statement.setString(9, dataAgora);
            statement.setString(10, usuario.getId());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarUsuario(UsuarioMD usuario) {
        String sql = "SELECT id_usuario as ID, nome_usuario as NOME, cpf_usuario as CPF, celular_usuario as CELULAR, sexo_usuario as SEXO, login_usuario as LOGIN, perfil_usuario as PERFIL, status_usuario as STATUS, data_cadastro_usuario as DATA_DE_CADASTRO, data_atualizacao_usuario as DATA_DE_ATUALIZAÇÃO from tbusuarios WHERE nome_usuario like ? order by nome_usuario";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, usuario.getPesquisar() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaUsuario.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para resultado os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        try {
            conexao = ConexaoDB.conectar();
            resultado = tabelaUsuario.getSelectedRow();
            txtId.setText(tabelaUsuario.getModel().getValueAt(resultado, 0).toString());
            txtNome.setText(tabelaUsuario.getModel().getValueAt(resultado, 1).toString());
            txtCpf.setText(tabelaUsuario.getModel().getValueAt(resultado, 2).toString());
            txtCelular.setText(tabelaUsuario.getModel().getValueAt(resultado, 3).toString());
            cmbSexoUsuario.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 4).toString());
            txtLogin.setText(tabelaUsuario.getModel().getValueAt(resultado, 5).toString());
            cmbPerfil.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 6).toString());
            cmbStatus.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 7).toString());
            txtDataCad.setText(tabelaUsuario.getModel().getValueAt(resultado, 8).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
            }
        }

    }

    // Metodo para deletar usuários
    public void deletarUsuario(UsuarioMD usuario) {

        String sql = "delete from tbusuarios where id_usuario=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getId());
            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para ID automatico
    public void gerarId(AtletaMD atletaMD) {

        int cont = 1;
        String ultimoId = "";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(atletaMD.getIdAtleta());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ultimoId = resultSet.getString(1);
            }

            if (resultSet.wasNull()) {
                txtId.setText("1");
            } else {
                cont += Integer.parseInt(ultimoId);
                txtId.setText(Integer.toString(cont));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao selecionar TIPO,\n erro: " + e, "Erro", 0);
        } finally {
            try {
                conexao.close();
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
