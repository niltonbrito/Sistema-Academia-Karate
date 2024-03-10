package dao;

import conexao.ConexaoDB;
import java.awt.Toolkit;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.ExameMD;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static view.FrmExames.*;

/**
 *
 * @author nilton.brito
 */
public class ExameDao {

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

    // Metodo para Consultar clientes com filtos
    public void pesquisarAtleta(ExameMD exameMD) {

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoAtleta());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getPesquisar() + "%");
            statement.setString(2, exameMD.getPesquisar() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaAtleta.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void setarCamposAtleta() {

        try {
            conexao = ConexaoDB.conectar();
            resultado = jTableFrmExamePesquisaAtleta.getSelectedRow();

            txtIdAtleta.setText(jTableFrmExamePesquisaAtleta.getModel().getValueAt(resultado, 0).toString());
            txtNomeAtletaExame.setText(jTableFrmExamePesquisaAtleta.getModel().getValueAt(resultado, 1).toString());
            cmbClubeExame.setSelectedItem(jTableFrmExamePesquisaAtleta.getModel().getValueAt(resultado, 2).toString());
//            cmbFaixaExame.setSelectedItem(jTableFrmExamePesquisaAtleta.getModel().getValueAt(resultado, 3).toString());
            txtIdGeral.setText(jTableFrmExamePesquisaAtleta.getModel().getValueAt(resultado, 4).toString());

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

    public void adicionarExame(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            statement.setString(1, exameMD.getFaixa());
            statement.setString(2, exameMD.getDataExame());
            statement.setString(3, exameMD.getId());
            statement.setString(4, dataAtual());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar faixa do exame
    public void editarExame(ExameMD exameMD) {

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            statement.setString(1, exameMD.getFaixa());
            statement.setString(2, exameMD.getDataExame());
            statement.setString(3, exameMD.getIdExame());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar faixa do atleta
    public void alterarFaixa(ExameMD exameMD) {

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            statement.setString(1, exameMD.getFaixa());
            statement.setString(2, dataAtual());
            statement.setString(3, exameMD.getId());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Método consulta simples com 1 campo de pesquisa
    public void pesquisaNomeClubeFaixa(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getNome() + "%");
            statement.setString(2, exameMD.getClube() + "%");
            statement.setString(3, exameMD.getFaixa() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Consultar exame com filtos com os tres campos preenchidos
    public void pesquisaNomeClube(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getNome() + "%");
            statement.setString(2, exameMD.getClube() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Consultar exame com filtos com os dois campos preenchidos
    public void pesquisaNomeFaixa(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getNome() + "%");
            statement.setString(2, exameMD.getFaixa() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Consultar exame com filtos com os dois campos preenchidos
    public void pesquisaClubeFaixa(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getClube() + "%");
            statement.setString(2, exameMD.getFaixa() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Método consulta simples com 1 campo de pesquisa
    public void pesquisaNome(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getNome() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Consultar exame com filtos com os dois campos preenchidos
    public void pesquisaClube(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getClube() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Método consulta simples com 1 campo de pesquisa
    public void pesquisaFaixa(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getFaixa() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Método consulta simples com 1 campo de pesquisa
    public void pesquisaId(ExameMD exameMD) {
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            // Passando o conteúdo da caixa de pesquisa para o like ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, exameMD.getIdAtleta() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            jTableFrmExamePesquisaExame.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void setarCampos() {

        try {
            conexao = ConexaoDB.conectar();
            resultado = jTableFrmExamePesquisaExame.getSelectedRow();

            txtIdAtleta.setText(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 0).toString());
            txtNomeAtletaExame.setText(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 1).toString());
            cmbClubeExame.setSelectedItem(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 2).toString());
            cmbFaixaExame.setSelectedItem(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 3).toString());
            txtDataExame.setText(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 4).toString());
            txtIdExame.setText(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 5).toString());
            txtIdGeral.setText(jTableFrmExamePesquisaExame.getModel().getValueAt(resultado, 6).toString());
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

    // Metodo para imprimir uma certificado
    public void imprimirExame(ExameMD exameMD) {

        // Imprimindo ralatorio com o framework jasperreports
        try {
            conexao = ConexaoDB.conectar();
            // A classe HashMap para criar um mapa de parâmetros com filtro
            HashMap filtro = new HashMap();
            filtro.put("id", Integer.valueOf(exameMD.getIdExame()));
            // Carregue o arquivo .jrxml (relatório compilado)
            // JasperReport relatorio = JasperCompileManager.compileReport(exameMD.getCorCertificado());

            // Preencha o relatório com os parâmetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(exameMD.getCorCertificado(), filtro, conexao);
            // a linha abaixo exibe o relatório atraves da classe JasperViewer
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("CERTIFICADO - FAIXA: " +exameMD.getFaixa()+" - "+ txtNomeAtletaExame.getText());
            jasperViewer.setSize(900, 700);
            jasperViewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/principal/icon-50px.png")));
            jasperViewer.setLocationRelativeTo(null);
            jasperViewer.setZoomRatio(0.75f);
            jasperViewer.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o Certificado.\n Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getErrorCode());
            }
        }
    }
    // Metodo para deletar usuários

    public void deletarExame(ExameMD exameMD) {

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(exameMD.getTipoExame());
            statement.setString(1, exameMD.getIdExame());
            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
