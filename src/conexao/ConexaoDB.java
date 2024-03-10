package conexao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nilton.brito
 */
public class ConexaoDB {

    public ConexaoDB() {
    }

    // MÉTODOS
    public static Connection conectar() {

        Connection conexao = null;

        //Variavel para conexão com banco de dados
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/akr_db?characterEncoding=utf-8";
        String user = "root";
        String password = "";
        try {
            //Indica o caminho da classe Driver na biblioteca do jdbc
            Class.forName(driver);
            //Faz a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException cnf) {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Classe JDBC Driver nao encontrada.", "Aviso de Falha", 0);
                System.exit(0);
            }
            return null;
        } catch (SQLException e) {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados.", "Aviso de Falha", 0);
                System.exit(0);
                return null;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    """
                    Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                    """ + erro.getMessage(), "Conexão", 3);
        }
        return null;
    }
}
