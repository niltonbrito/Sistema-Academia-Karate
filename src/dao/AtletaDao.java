package dao;

import conexao.ConexaoDB;
import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.AtletaMD;
import net.proteanit.sql.DbUtils;
import static view.FrmAtleta.*;

/**
 *
 * @author nilton.brito
 */
public class AtletaDao {

    private Connection conexao = null;
    PreparedStatement statement = null;
    public ResultSet resultSet = null;
    public int resultado;
    public String erro;

    public AtletaDao() {
    }

    // Metodo para gerar data atual
    public String dataAtual() {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        return dataAgora;
    }

    // Metodo para Adicionar atleta
    public void adicionarAtleta(AtletaMD atletaMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(atletaMD.getTipoAtleta());
            if (jRadioBtnDangayAtleta.isSelected()) {
                statement.setString(1, atletaMD.getIdAtleta());
                statement.setString(2, atletaMD.getIdPadrao());
                statement.setString(3, atletaMD.getIdPadrao());
            } else if (jRadioBtnYudanshaAtleta.isSelected()) {
                statement.setString(1, atletaMD.getIdPadrao());
                statement.setString(2, atletaMD.getIdAtleta());
                statement.setString(3, atletaMD.getIdPadrao());
            }else{
                statement.setString(1, atletaMD.getIdPadrao());
                statement.setString(2, atletaMD.getIdPadrao());
                statement.setString(3, atletaMD.getIdAtleta());
            }
            statement.setString(4, atletaMD.getNome());
            statement.setString(5, atletaMD.getCpf());
            statement.setString(6, atletaMD.getSexo());
            statement.setString(7, atletaMD.getDataNasc());
            statement.setString(8, atletaMD.getIdade());
            statement.setString(9, atletaMD.getClube());
            statement.setString(10, atletaMD.getFaixa());
            statement.setString(11, atletaMD.getEstado());
            statement.setString(12, atletaMD.getCategoria());
            statement.setString(13, dataAtual());
            statement.setString(14, atletaMD.getAbreviado());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar dados do atleta
    public void editarAtleta(AtletaMD atletaMD) {

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(atletaMD.getTipoAtleta());
            statement.setInt(1, Integer.parseInt(atletaMD.getIdAtleta()));
            statement.setString(2, atletaMD.getNome());
            statement.setString(3, atletaMD.getCpf());
            statement.setString(4, atletaMD.getSexo());
            statement.setString(5, atletaMD.getDataNasc());
            statement.setString(6, atletaMD.getIdade());
            statement.setString(7, atletaMD.getClube());
            statement.setString(8, atletaMD.getFaixa());
            statement.setString(9, atletaMD.getEstado());
            statement.setString(10, atletaMD.getCategoria());
            statement.setString(11, dataAtual());
            statement.setString(12, atletaMD.getAbreviado());
            statement.setString(13, atletaMD.getId());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para deletar atleta
    public void deletarAtleta(AtletaMD atletaMD) {

        String sql = "delete from tb_atletas where id_atleta=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, atletaMD.getId());
            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para deletar atleta
    public void deletarTodosAtletas() {

        String sql = "delete * from tb_atletas";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    // Metodo para Consultar atleta com filtos
    public void pesquisarAtleta(AtletaMD atletaMD) {

        String sql = "SELECT id_dangay as ID_DANGAY, id_yudansha as ID_YUDANSHA, id_cbksc as ID_CBKSC, nome_atleta as NOME, cpf_atleta as CPF, sexo_atleta as SEXO, data_nasc_atleta as DATA_NASC, idade_atleta as IDADE, clube_atleta as CLUBE, faixa_atleta as FAIXA, estado_atleta as ESTADO, categoria_atleta as CATEGORIA, data_cadastro_atleta as DATA_CADASTRO, data_atualizacao_atleta as DATA_ATUALIZAÇÃO ,id_atleta as ID_GERAL from tb_atletas WHERE id_dangay like ? or id_yudansha like ? or nome_atleta like ? order by 'asc'";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, atletaMD.getPesquisar() + "%");
            statement.setString(2, atletaMD.getPesquisar() + "%");
            statement.setString(3, atletaMD.getPesquisar() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaAtleta.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
                statement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        try {
            conexao = ConexaoDB.conectar();
            resultado = tabelaAtleta.getSelectedRow();

            txtIdDangay.setText(tabelaAtleta.getModel().getValueAt(resultado, 0).toString());
            txtIdYudannsha.setText(tabelaAtleta.getModel().getValueAt(resultado, 1).toString());
            txtIdCbksc.setText(tabelaAtleta.getModel().getValueAt(resultado, 2).toString());
            txtNome.setText(tabelaAtleta.getModel().getValueAt(resultado, 3).toString());
            txtCpf.setText(tabelaAtleta.getModel().getValueAt(resultado, 4).toString());
            cmbSexoAtleta.setSelectedItem(tabelaAtleta.getModel().getValueAt(resultado, 5).toString());
            txtIdade.setText(tabelaAtleta.getModel().getValueAt(resultado, 7).toString());
            txtNascimento.setText(tabelaAtleta.getModel().getValueAt(resultado, 6).toString());
            cmbClubeAtleta.setSelectedItem(tabelaAtleta.getModel().getValueAt(resultado, 8).toString());
            cmbFaixaAtleta.setSelectedItem(tabelaAtleta.getModel().getValueAt(resultado, 9).toString());
            cmbEstadoAtleta.setSelectedItem(tabelaAtleta.getModel().getValueAt(resultado, 10).toString());
            txtCategoria.setText(tabelaAtleta.getModel().getValueAt(resultado, 11).toString());
            txtDataCad.setText(tabelaAtleta.getModel().getValueAt(resultado, 12).toString());
            txtId.setText(tabelaAtleta.getModel().getValueAt(resultado, 14).toString());
        } catch (Exception e) {
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
                txtIdAtleta.setText("1");
            } else {
                cont += Integer.parseInt(ultimoId);
                txtIdAtleta.setText(Integer.toString(cont));
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
