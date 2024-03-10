package dao;

import conexao.ConexaoDB;
import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.DadosMD;
import net.proteanit.sql.DbUtils;
import static view.FrmDados.*;

/**
 *
 * @author nilto
 */
public class DadosDao {

    private Connection conexao = null;
    PreparedStatement statement = null;
    public ResultSet resultSet = null;
    public int resultado;
    public String erro;

    public String dataAtual() {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        return dataAgora;
    }

    // Metodo para Adicionar categoria
    public void adicionarCategoria(DadosMD dados) {

        String sql = "insert into tbdados (id_categoria_dados,categoria_dados,data_cadastro_dados) values (?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdCategoria());
            statement.setString(2, dados.getTxtNomeCategoria());
            statement.setString(3, dataAtual());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado
        } catch (SQLIntegrityConstraintViolationException e1) {
            erro = e1.getMessage();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar dados da categoria
    public void editarCategoria(DadosMD dados) {

        String sql = "update tbdados set categoria_dados = ?,data_atualizacao_dados = ? where id_categoria_dados = ?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            //statement.setString(1, dados.getTxtIdCategoria());
            statement.setString(1, dados.getTxtNomeCategoria());
            statement.setString(2, dataAtual());
            statement.setString(3, dados.getTxtIdCategoria());

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

    // Metodo para deletar categoria
    public void deletarCategoria(DadosMD dados) {

        String sql = "delete from tbdados where id_categoria_dados = ?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdCategoria());
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

    // Metodo para Consultar categoria com filtos
    public void pesquisarCategoria() {

        String sql = "SELECT id_categoria_dados AS ID, categoria_dados as CATEGORIA FROM tbdados order by categoria_dados";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaCategoria.setModel(DbUtils.resultSetToTableModel(resultSet));
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
            resultado = tabelaCategoria.getSelectedRow();

            txtIdCategoria.setText(tabelaCategoria.getModel().getValueAt(resultado, 0).toString());
            txtNomeCategoria.setText(tabelaCategoria.getModel().getValueAt(resultado, 1).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

    // Metodo para Adicionar Parametro
    public void adicionarParametro(DadosMD dados) {

        String sql = "insert into tbparametro (id_parametro,nome_parametro,idade_min_parametro,idade_max_parametro,id_min_parametro,id_max_parametro,sexo_parametro,data_cadastro_parametro) values (?,?,?,?,?,?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdParametro());
            statement.setString(2, dados.getTxtNomeParametro());
            statement.setString(3, dados.getTxtIdadeMinParametro());
            statement.setString(4, dados.getTxtIdadeMaxParametro());
            statement.setString(5, dados.getTxtIdMinParametro());
            statement.setString(6, dados.getTxtIdMaxParametro());
            statement.setString(7, dados.getTxtSexoParametro());
            statement.setString(8, dataAtual());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado
        } catch (SQLIntegrityConstraintViolationException e1) {
            erro = e1.getMessage();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar dados do Parametro
    public void editarParametro(DadosMD dados) {

        String sql = "update tbparametro set id_parametro = ?,nome_parametro = ?,idade_min_parametro = ?,idade_max_parametro = ?,id_min_parametro = ?,id_max_parametro = ?,sexo_parametro = ?,data_atualizacao_parametro = ? where id_parametro = ?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdParametro());
            statement.setString(2, dados.getTxtNomeParametro());
            statement.setString(3, dados.getTxtIdadeMinParametro());
            statement.setString(4, dados.getTxtIdadeMaxParametro());
            statement.setString(5, dados.getTxtIdMinParametro());
            statement.setString(6, dados.getTxtIdMaxParametro());
            statement.setString(7, dados.getTxtSexoParametro());
            statement.setString(8, dataAtual());
            statement.setString(9, dados.getTxtIdParametro());

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

    // Metodo para deletar Parametro
    public void deletarParametro(DadosMD dados) {

        String sql = "delete from tbparametro where id_parametro = ? or nome_parametro = ?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdParametro());
            statement.setString(2, dados.getTxtNomeParametro());
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

    // Metodo para Consultar Parametro com filtos
    public void pesquisarParametro() {

        String sql = "SELECT id_parametro as Nº,nome_parametro as NOME_CATEGORIA,idade_min_parametro as IDDADE_MIN,idade_max_parametro as IDADE_MAX,id_min_parametro as ID_MAX_FAIXA,id_max_parametro as ID_MAX_FAIXA, sexo_parametro as SEXO FROM tbparametro order by nome_parametro";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaParametro.setModel(DbUtils.resultSetToTableModel(resultSet));
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

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarParametro() {
        try {
            conexao = ConexaoDB.conectar();
            resultado = tabelaParametro.getSelectedRow();

            txtIdParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 0).toString());
            txtNomeParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 1).toString());
            txtIdadeMinParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 2).toString());
            txtIdadeMaxParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 3).toString());
            txtIdMinParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 4).toString());
            txtIdMaxParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 5).toString());
            txtSexoParametro.setText(tabelaParametro.getModel().getValueAt(resultado, 6).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Adicionar Faixa
    public void adicionarFaixa(DadosMD dados) {

        String sql = "insert into tbfaixa (id_faixa, nome_faixa, grau_faixa, menor_idade_faixa, maior_idade_faixa, data_cadastro_faixa) values (?,?,?,?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdFaixa());
            statement.setString(2, dados.getTxtNomeFaixa());
            statement.setString(3, dados.getTxtGrauFaixa());
            statement.setString(4, dados.getTxtMenorIdadeFaixa());
            statement.setString(5, dados.getTxtMaiorIdadeFaixa());
            statement.setString(6, dataAtual());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado
        } catch (SQLIntegrityConstraintViolationException e1) {
            erro = e1.getMessage();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar dados da Faixa
    public void editarFaixa(DadosMD dados) {

        String sql = "update tbfaixa set id_faixa = ?,nome_faixa = ?,grau_faixa = ?,menor_idade_faixa = ?,menor_idade_faixa = ?,data_atualizacao_faixa = ? where id_faixa = ?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdFaixa());
            statement.setString(2, dados.getTxtNomeFaixa());
            statement.setString(3, dados.getTxtGrauFaixa());
            statement.setString(4, dados.getTxtMenorIdadeFaixa());
            statement.setString(5, dados.getTxtMaiorIdadeFaixa());
            statement.setString(6, dataAtual());
            statement.setString(7, dados.getTxtIdFaixa());

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

    // Metodo para deletar Faixa
    public void deletarFaixa(DadosMD dados) {

        String sql = "delete from tbfaixa where id_faixa = ? or nome_faixa = ?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, dados.getTxtIdFaixa());
            statement.setString(2, dados.getTxtNomeFaixa());
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

    // Metodo para Consultar Faixa com filtos
    public void pesquisarFaixa() {

        String sql = "SELECT id_faixa as ID,nome_faixa as FAIXA,grau_faixa as GRAU,menor_idade_faixa as MENOR_IDADE_FAIXA,maior_idade_faixa as MAIOR_IDADE_FAIXA FROM tbfaixa order by nome_faixa";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaFaixa.setModel(DbUtils.resultSetToTableModel(resultSet));
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

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarFaixa() {
        try {
            conexao = ConexaoDB.conectar();
            resultado = tabelaFaixa.getSelectedRow();

            txtIdFaixa.setText(tabelaFaixa.getModel().getValueAt(resultado, 0).toString());
            txtNomeFaixa.setText(tabelaFaixa.getModel().getValueAt(resultado, 1).toString());
            txtGrauFaixa.setText(tabelaFaixa.getModel().getValueAt(resultado, 2).toString());
            txtMenorIdadeFaixa.setText(tabelaFaixa.getModel().getValueAt(resultado, 3).toString());
            txtMaiorIdadeFaixa.setText(tabelaFaixa.getModel().getValueAt(resultado, 4).toString());
        } catch (Exception e) {
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
