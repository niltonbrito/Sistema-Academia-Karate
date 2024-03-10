package business;

import dao.DadosDao;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DadosMD;
import static view.FrmDados.*;

/**
 *
 * @author nilto
 */
public class DadosBS {

    DadosMD dados = new DadosMD();
    DadosDao dadosDao = new DadosDao();

    // Metodo para Adicionar usuários
    public void adicionarCategoria() {

        dados.setTxtIdCategoria(txtIdCategoria.getText());
        dados.setTxtNomeCategoria(txtNomeCategoria.getText());

        if ((dados.getTxtIdCategoria().isEmpty()) || (dados.getTxtNomeCategoria().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            dadosDao.adicionarCategoria(dados);
            if (dadosDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparCampos();
            } else if (dadosDao.erro.equals("Duplicate entry '" + dados.getTxtIdCategoria() + "' for key 'id_categoria_dados'")) {
                JOptionPane.showMessageDialog(null, "O número de ID informada já cadastado.\nInforme outra número de ID.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                dados.setTxtIdCategoria(null);
            } else {
                JOptionPane.showMessageDialog(null, "Categoria informado já cadastada.\nInforme outra categoria.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                dados.setTxtIdCategoria(null);
            }
        }
    }
// Metodo para alterar dados do usuários

    public void editarCategoria() {
        // Chamando o metodo alterar

        txtIdCategoria.setEditable(false);

        dados.setTxtIdCategoria(txtIdCategoria.getText());
        dados.setTxtNomeCategoria(txtNomeCategoria.getText());

        if ((dados.getTxtIdCategoria().isEmpty()) || (dados.getTxtNomeCategoria().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar dados da categoria", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                dadosDao.editarCategoria(dados);
                if (dadosDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados da categoria alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar alterar a categoria, erro: " + dadosDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para deletar usuários
    public void deletarCategoria() {
        dados.setTxtIdCategoria(txtIdCategoria.getText());
        dados.setTxtNomeCategoria(txtNomeCategoria.getText());

        if ((dados.getTxtIdCategoria().isEmpty()) || (dados.getTxtNomeCategoria().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta categoria?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                dadosDao.deletarCategoria(dados);
                if (dadosDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar deletar a categoria, erro: " + dadosDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarCategoria() {
        // Chamando o metodo pesquisar categoria
        dadosDao.pesquisarCategoria();
        tabelaCategoria.getColumnModel().getColumn(0).setWidth(104);
        tabelaCategoria.getColumnModel().getColumn(1).setPreferredWidth(400);
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        dadosDao.setarCampos();

        txtIdCategoria.setEditable(false);
        btnAdinionarCategoria.setEnabled(false);
        btnEditarCategoria.setEnabled(true);
        btnApagarCategoria.setEnabled(true);
        btnLimparCategoria.setEnabled(true);
    }

    // Metodo para limpar os campos do formularios   
    public void limparCampos() {

        txtIdCategoria.setText("");
        txtNomeCategoria.setText("");

        ((DefaultTableModel) tabelaCategoria.getModel()).setRowCount(0);
        btnAdinionarCategoria.setEnabled(true);
        btnEditarCategoria.setEnabled(false);
        btnApagarCategoria.setEnabled(false);
        btnLimparCategoria.setEnabled(false);

        txtIdCategoria.setEditable(true);
        txtIdCategoria.requestFocus();
    }

    // Metodo para Adicionar usuários
    public void adicionarParametro() {

        dados.setTxtIdParametro(txtIdParametro.getText());
        dados.setTxtNomeParametro(txtNomeParametro.getText());
        dados.setTxtIdadeMinParametro(txtIdadeMinParametro.getText());
        dados.setTxtIdadeMaxParametro(txtIdadeMaxParametro.getText());
        dados.setTxtIdMinParametro(txtIdMinParametro.getText());
        dados.setTxtIdMaxParametro(txtIdMaxParametro.getText());
        dados.setTxtSexoParametro(txtSexoParametro.getText());

        if ((dados.getTxtIdParametro().isEmpty()) || (dados.getTxtNomeParametro().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            dadosDao.adicionarParametro(dados);
            if (dadosDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Parâmetro da categoria cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparParametro();
            } else if (dadosDao.erro.equals("Duplicate entry '" + dados.getTxtNomeParametro() + "' for key 'num_parametro'")) {
                JOptionPane.showMessageDialog(null, "O número de indetificação informada já cadastado.\nInforme outro número de indetificação.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                dados.setTxtIdParametro(null);
            } else {
                JOptionPane.showMessageDialog(null, "Nome do parâmetro da categoria informado já cadastada.\nInforme outro nome.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                dados.setTxtIdParametro(null);
            }
        }
    }
// Metodo para alterar dados do usuários

    public void editarParametro() {
        // Chamando o metodo alterar

        txtIdParametro.setEditable(false);

        dados.setTxtIdParametro(txtIdParametro.getText());
        dados.setTxtNomeParametro(txtNomeParametro.getText());
        dados.setTxtIdadeMinParametro(txtIdadeMinParametro.getText());
        dados.setTxtIdadeMaxParametro(txtIdadeMaxParametro.getText());
        dados.setTxtIdMinParametro(txtIdMinParametro.getText());
        dados.setTxtIdMaxParametro(txtIdMaxParametro.getText());
        dados.setTxtSexoParametro(txtSexoParametro.getText());

        if ((dados.getTxtIdParametro().isEmpty()) || (dados.getTxtNomeParametro().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar parâmetro da categoria", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                dadosDao.editarParametro(dados);
                if (dadosDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Parâmetro da categoria alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparParametro();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar alterar o parâmetro, erro: " + dadosDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para deletar usuários
    public void deletarParametro() {

        dados.setTxtIdParametro(txtIdParametro.getText());
        dados.setTxtNomeParametro(txtNomeParametro.getText());

        if ((dados.getTxtIdParametro().isEmpty()) || (dados.getTxtNomeParametro().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este parâmetro?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                dadosDao.deletarParametro(dados);
                if (dadosDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Parâmetro deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparParametro();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar deletar o parâmetro, erro: " + dadosDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarParametro() {
        // Chamando o metodo pesquisar categoria
        dadosDao.pesquisarParametro();
        tabelaParametro.getColumnModel().getColumn(0).setWidth(80);
        tabelaParametro.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaParametro.getColumnModel().getColumn(2).setWidth(100);
        tabelaParametro.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelaParametro.getColumnModel().getColumn(4).setWidth(100);
        tabelaParametro.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabelaParametro.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarParametro() {
        dadosDao.setarParametro();

        txtIdParametro.setEditable(false);
        btnAdicionarParametro.setEnabled(false);
        btnEditarParametro.setEnabled(true);
        btnApagarParametro.setEnabled(true);
        btnLimparParametro.setEnabled(true);
    }

    // Metodo para limpar os campos do formularios   
    public void limparParametro() {

        txtIdParametro.setText("");
        txtNomeParametro.setText("");
        txtIdadeMinParametro.setText("");
        txtIdadeMaxParametro.setText("");
        txtIdMinParametro.setText("");
        txtIdMaxParametro.setText("");
        txtSexoParametro.setText("");

        ((DefaultTableModel) tabelaParametro.getModel()).setRowCount(0);
        btnAdicionarParametro.setEnabled(true);
        btnEditarParametro.setEnabled(false);
        btnApagarParametro.setEnabled(false);
        btnLimparParametro.setEnabled(false);

        txtIdParametro.setEditable(true);
        txtIdParametro.requestFocus();
    }

    // Metodo para Adicionar usuários
    public void adicionarFaixa() {

        dados.setTxtIdFaixa(txtIdFaixa.getText());
        dados.setTxtNomeFaixa(txtNomeFaixa.getText());
        dados.setTxtGrauFaixa(txtGrauFaixa.getText());
        dados.setTxtMenorIdadeFaixa(txtMenorIdadeFaixa.getText());
        dados.setTxtMaiorIdadeFaixa(txtMaiorIdadeFaixa.getText());

        if ((dados.getTxtIdFaixa().isEmpty()) || (dados.getTxtNomeFaixa().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            dadosDao.adicionarFaixa(dados);
            if (dadosDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Faixa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparFaixa();
            } else if (dadosDao.erro.equals("Duplicate entry '" + dados.getTxtNomeFaixa() + "' for key 'id_faixa'")) {
                JOptionPane.showMessageDialog(null, "O número de indetificação informada já cadastado.\nInforme outro número de indetificação.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                dados.setTxtIdFaixa(null);
            } else {
                JOptionPane.showMessageDialog(null, "Nome da faixa informado já cadastada.\nInforme outro nome.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                dados.setTxtIdFaixa(null);
            }
        }
    }
// Metodo para alterar dados do usuários

    public void editarFaixa() {
        // Chamando o metodo alterar

        txtIdFaixa.setEditable(false);

        dados.setTxtIdFaixa(txtIdFaixa.getText());
        dados.setTxtNomeFaixa(txtNomeFaixa.getText());
        dados.setTxtGrauFaixa(txtGrauFaixa.getText());
        dados.setTxtMenorIdadeFaixa(txtMenorIdadeFaixa.getText());
        dados.setTxtMaiorIdadeFaixa(txtMaiorIdadeFaixa.getText());

        if ((dados.getTxtIdFaixa().isEmpty()) || (dados.getTxtNomeFaixa().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar dados da faixa?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                dadosDao.editarFaixa(dados);
                if (dadosDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Faixa alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparFaixa();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar alterar o faixa, erro: " + dadosDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para deletar usuários
    public void deletarFaixa() {
        dados.setTxtIdFaixa(txtIdFaixa.getText());
        dados.setTxtNomeFaixa(txtNomeFaixa.getText());

        if ((dados.getTxtIdFaixa().isEmpty()) || (dados.getTxtNomeFaixa().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta faixa?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                dadosDao.deletarFaixa(dados);
                if (dadosDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Faixa deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparFaixa();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar deletar a faixa, erro: " + dadosDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarFaixa() {
        // Chamando o metodo pesquisar categoria
        dadosDao.pesquisarFaixa();
        tabelaFaixa.getColumnModel().getColumn(0).setWidth(70);
        tabelaFaixa.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaFaixa.getColumnModel().getColumn(2).setWidth(100);
        tabelaFaixa.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelaFaixa.getColumnModel().getColumn(4).setWidth(100);
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarFaixa() {
        dadosDao.setarFaixa();

        txtIdFaixa.setEditable(false);
        btnAdicionarFaixa.setEnabled(false);
        btnEditarFaixa.setEnabled(true);
        btnApagarFaixa.setEnabled(true);
        btnLimparFaixa.setEnabled(true);
    }

    // Metodo para limpar os campos do formularios   
    public void limparFaixa() {

        txtIdFaixa.setText("");
        txtNomeFaixa.setText("");
        txtGrauFaixa.setText("");
        txtMenorIdadeFaixa.setText("");
        txtMaiorIdadeFaixa.setText("");

        ((DefaultTableModel) tabelaFaixa.getModel()).setRowCount(0);
        btnAdicionarFaixa.setEnabled(true);
        btnEditarFaixa.setEnabled(false);
        btnApagarFaixa.setEnabled(false);
        btnLimparFaixa.setEnabled(false);

        txtIdFaixa.setEditable(true);
        txtIdFaixa.requestFocus();
    }
}
