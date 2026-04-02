package dao;

import java.sql.*;
import conexao.ConexaoDB;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import model.LogarMD;

/**
 *
 * @author nilton.brito
 */
public class LogarDao {

    Connection conexao;
    PreparedStatement statement = null;
    public static ResultSet resultSet = null;

    public LogarDao() {
    }
    
    //Método responsável pela autenticação
    public void logar(LogarMD logarMD) {

        conexao = ConexaoDB.conectar();
        String sql = "select * from tbusuarios where login_usuario = ? and senha_usuario = md5(?)";
        try {
            statement = conexao.prepareStatement(sql);
            statement.setString(1, logarMD.getLogin());
            statement.setString(2, logarMD.getSenha());
            // A linha abaixo realiza a consulta Query
            resultSet = statement.executeQuery();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
