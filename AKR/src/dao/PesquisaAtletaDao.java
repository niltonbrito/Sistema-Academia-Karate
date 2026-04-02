package dao;

import conexao.ConexaoDB;
import java.sql.*;
import javax.swing.JOptionPane;
import model.PesquisasMD;
import net.proteanit.sql.DbUtils;
import static view.FrmPeaquisaAtleta.*;

/**
 *
 * @author nilton.brito
 */
public class PesquisaAtletaDao {

    private Connection conexao = null;
    PreparedStatement statement = null;
    public ResultSet resultSet = null;
    public int resultado;
    public String erro;

    // Metodo para Consultar Faixa com filtos
    public void pesquisarAtletaNome(PesquisasMD pesquisaMD) {

        String sql = "SELECT id_dangay as ID_DANGAY, id_yudansha as ID_YUDANSHA, id_cbksc as ID_CBKSC, clube_atleta as CLUBE, nome_atleta as NOME, sexo_atleta as SEXO, idade_atleta as IDADE, data_nasc_atleta as DATA_NASC, categoria_atleta as CATEGORIA, faixa_atleta as FAIXA FROM `tb_atletas` WHERE nome_atleta like ? order by nome_atleta";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, pesquisaMD.getNomePesquisaAtleta() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaPesquisaAtleta.setModel(DbUtils.resultSetToTableModel(resultSet));
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
    // Metodo para Consultar Faixa com filtos
    public void pesquisarAtletaClube(PesquisasMD pesquisaMD) {

        String sql = "SELECT id_dangay as ID_DANGAY, id_yudansha as ID_YUDANSHA, id_cbksc as ID_CBKSC, clube_atleta as CLUBE, nome_atleta as NOME, sexo_atleta as SEXO, idade_atleta as IDADE, data_nasc_atleta as DATA_NASC, categoria_atleta as CATEGORIA, faixa_atleta as FAIXA FROM `tb_atletas` WHERE clube_atleta like ? order by nome_atleta";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, pesquisaMD.getClubePesquisaAtleta() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaPesquisaAtleta.setModel(DbUtils.resultSetToTableModel(resultSet));
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

    // Metodo para Consultar Faixa com filtos
    public void pesquisarAtletaFull(PesquisasMD pesquisaMD) {

        String sql = "SELECT id_dangay as ID_DANGAY, id_yudansha as ID_YUDANSHA, id_cbksc as ID_CBKSC, clube_atleta as CLUBE, nome_atleta as NOME, sexo_atleta as SEXO, idade_atleta as IDADE, data_nasc_atleta as DATA_NASC, categoria_atleta as CATEGORIA, faixa_atleta as FAIXA FROM `tb_atletas` WHERE nome_atleta like ? and clube_atleta like ? order by nome_atleta";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, pesquisaMD.getNomePesquisaAtleta() + "%");
            statement.setString(2, pesquisaMD.getClubePesquisaAtleta() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaPesquisaAtleta.setModel(DbUtils.resultSetToTableModel(resultSet));
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
}
