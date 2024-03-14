package business;

import dao.ExameDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ExameMD;
import model.MetodosCrud;
import swing.EstiloTabelaColumn;
import static view.FrmExames.*;

/**
 *
 * @author nilton.brito
 */
public class ExameBS implements MetodosCrud {

    ExameMD exameMD = new ExameMD();
    ExameDao exameDao = new ExameDao();
    EstiloTabelaColumn estiloTabela = new EstiloTabelaColumn();

    // Chamando o metodo pesquisar atleta na tabela atleta
    @Override
    public void pesquisar() {
        try {
            exameMD.setPesquisar(txtPesquisar.getText());
            String tipo = "";
            String tipoBanco = "";
            String tipoClube = "";
            if (jRadioBtnDangayExame.isSelected()) {
                tipo = "id_dangay as ID_DANGAY";
                tipoBanco = "dangay";
                tipoClube = "clube_atleta as CLUBE";
            } else if (jRadioBtnYudanshaExame.isSelected()) {
                tipo = "id_yudansha as ID_YUDANSHA";
                tipoBanco = "yudansha";
                tipoClube = "clube_atleta as CLUBE";
            } else {
                tipo = "id_cbksc as ID_CBKSC";
                tipoBanco = "cbksc";
                tipoClube = "estado_atleta as ESTADO";
            }
            exameMD.setTipoAtleta("SELECT " + tipo + ", nome_atleta as NOME, " + tipoClube + ",faixa_atleta as FAIXA, id_atleta as ID_ATLETA from tb_atletas WHERE id_" + tipoBanco + " like ? or nome_atleta like ? order by 'asc'");
            exameDao.pesquisarAtleta(exameMD);
            estiloTabela.ajustarTabelaFrmExamePesquisaAtleta();
            txtTotalAtleta.setText(Integer.toString(jTableFrmExamePesquisaAtleta.getRowCount()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao pesquisar atleta\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCamposAtleta() {
        try {
            exameDao.setarCamposAtleta();

            txtIdAtleta.setEditable(false);
            txtNomeAtletaExame.setEditable(false);
            cmbClubeExame.setEnabled(false);
            btnPesquisarExame.setEnabled(false);
            btnAdicionarExame.setEnabled(true);

            List<String> listaFaixa = new ArrayList<>();
            listaFaixa.add("AMARELA");
            listaFaixa.add("VERMELHA");
            listaFaixa.add("LARANJA");
            listaFaixa.add("VERDE");
            listaFaixa.add("VERDE I");
            listaFaixa.add("VERDE II");
            listaFaixa.add("VERDE III");
            listaFaixa.add("ROXA");
            listaFaixa.add("MARROM");
            listaFaixa.add("PRETA");
            listaFaixa.add("1º DAN");
            listaFaixa.add("2º DAN");
            listaFaixa.add("3º DAN");
            listaFaixa.add("4º DAN");
            listaFaixa.add("5º DAN");
            listaFaixa.add("6º DAN");
            listaFaixa.add("7º DAN");
            listaFaixa.add("8º DAN");
            listaFaixa.add("9º DAN");
            listaFaixa.add("10º DAN");

            String faixa = jTableFrmExamePesquisaAtleta.getModel().getValueAt(exameDao.resultado, 3).toString();

            for (int i = 0; i < listaFaixa.size() - 1; i++) {
                if (listaFaixa.get(i).equals(faixa)) {
                    cmbFaixaExame.setSelectedItem(listaFaixa.get(i + 1));
                    break; // Interrompe o loop quando encontra a faixa
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao preencher os campos da tabela\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para setar o tipo de cadastro do atleta
    public void setarTipoAtleta() {
        try {
            String clube = jTableFrmExamePesquisaAtleta.getModel().getValueAt(exameDao.resultado, 2).toString();
            String faixa = jTableFrmExamePesquisaAtleta.getModel().getValueAt(exameDao.resultado, 3).toString();

            if (clube.equals("DO ACRE")
                    || clube.equals("DE ALAGOAS")
                    || clube.equals("DO AMAPÁ")
                    || clube.equals("DO AMAZONAS")
                    || clube.equals("DA BAHIA")
                    || clube.equals("DO CEARÁ")
                    || clube.equals("DO DISTRITO FEDERAL")
                    || clube.equals("DO ESPIRITO SANTO")
                    || clube.equals("DE GOIÁS")
                    || clube.equals("DO MATO GROSSO")
                    || clube.equals("DO MATO GROSSO DO SUL")
                    || clube.equals("DE MINAS GERAIS")
                    || clube.equals("DO PARÁ")
                    || clube.equals("DA PARAÍBA")
                    || clube.equals("DO PARANÁ")
                    || clube.equals("DO PARÁ")
                    || clube.equals("DE PERNAMBUCO")
                    || clube.equals("DO PIAUÍ")
                    || clube.equals("DO RIO DE JANEIRO")
                    || clube.equals("DO RIO GRANDE DO NORTE")
                    || clube.equals("DO RIO GRANDE DO SUL")
                    || clube.equals("DE RONDÔNIA")
                    || clube.equals("DE RORAIMA")
                    || clube.equals("DE SANTA CATARINA")
                    || clube.equals("DE SÃO PAULO")
                    || clube.equals("DE SERGIPE")
                    || clube.equals("DO TOCANTINS")) {
                jRadioBtnCBKSCExame.setSelected(true);
                cmbClubeExame.setSelectedItem(clube);
            } else if (faixa.equals("BRANCA")
                    || faixa.equals("AMARELA")
                    || faixa.equals("VERMELHA")
                    || faixa.equals("LARANJA")
                    || faixa.equals("VERDE")
                    || faixa.equals("VERDE I")
                    || faixa.equals("VERDE II")
                    || faixa.equals("VERDE III")
                    || faixa.equals("ROXA")) {
                jRadioBtnDangayExame.setSelected(true);
            } else {
                jRadioBtnYudanshaExame.setSelected(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao setar o tipo de atleta\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    @Override
    public void adicionar() {

        try {
            exameMD.setFaixa(cmbFaixaExame.getSelectedItem().toString());
            exameMD.setDataExame(txtDataExame.getText());
            exameMD.setId(txtIdGeral.getText());
            String nome;
            String tipoTabela;
            if (exameMD.getFaixa().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
            } else {
                if (jRadioBtnDangayExame.isSelected()) {
                    nome = "dangay";
                    tipoTabela = "tbexamesdangay";
                } else if (jRadioBtnYudanshaExame.isSelected()) {
                    nome = "yudansha";
                    tipoTabela = "tbexamesyudansha";
                } else {
                    nome = "cbksc";
                    tipoTabela = "tbexamescbksc";
                }
                exameMD.setTipoExame("INSERT INTO " + tipoTabela + " (faixa_exame, data_exame, id_atleta, data_cadastro_exame) VALUES (?,?,?,?)");
                exameDao.adicionarExame(exameMD);
                if (exameDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Cadastro do exame " + nome + "\n realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    alterarFaixa();
                    limparCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Exame do Atleta\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Chamando o metodo alterar Exame
    @Override
    public void editar() {

        try {
            exameMD.setIdAtleta(txtIdAtleta.getText());
            exameMD.setNome(txtNomeAtletaExame.getText());
            exameMD.setClube(cmbClubeExame.getSelectedItem().toString());
            exameMD.setFaixa(cmbFaixaExame.getSelectedItem().toString());
            exameMD.setDataExame(txtDataExame.getText());
            exameMD.setIdExame(txtIdExame.getText());

            if (exameMD.getIdAtleta().isEmpty()
                    || exameMD.getNome().isEmpty()
                    || exameMD.getClube().isEmpty()
                    || exameMD.getFaixa().isEmpty()
                    || exameMD.getIdExame().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
            } else {
                int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar dados do exame", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
                if (confirma == JOptionPane.YES_OPTION) {
                    String tipoTabela;
                    if (jRadioBtnDangayExame.isSelected()) {
                        tipoTabela = "tbexamesdangay";
                    } else if (jRadioBtnYudanshaExame.isSelected()) {
                        tipoTabela = "tbexamesyudansha";
                    } else {
                        tipoTabela = "tbexamescbksc";
                    }
                    exameMD.setTipoExame("update " + tipoTabela + " set faixa_exame=?, data_exame=? where id_exame=?");
                    exameDao.editarExame(exameMD);
                    if (exameDao.resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Dados do exame alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                        limparCampos();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar alterar dados do exame.\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Chamando o metodo alterar faixa na tabela atleta
    public void alterarFaixa() {
        try {
            exameMD.setId(txtIdGeral.getText());
            exameMD.setFaixa(cmbFaixaExame.getSelectedItem().toString());

            exameMD.setTipoExame("update tb_atletas set faixa_atleta=?, data_atualizacao_atleta=? where id_atleta=?");
            exameDao.alterarFaixa(exameMD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar alterar dados da faixa.\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para Consultar atleta com filtos
    public void pesquisarExame() {
        // Chamando o metodo pesquisar atleta

        try {
            exameMD.setIdAtleta(txtIdAtleta.getText());
            exameMD.setNome(txtNomeAtletaExame.getText());
            exameMD.setClube(cmbClubeExame.getSelectedItem().toString());
            exameMD.setFaixa(cmbFaixaExame.getSelectedItem().toString());
            exameMD.setDataExame(txtDataExame.getText());

            String mascara;
            String tipo;
            String tipoTabela;
            String tipoClube;
            if (jRadioBtnDangayExame.isSelected()) {
                mascara = "DANGAY";
                tipo = "dangay";
                tipoTabela = "tbexamesdangay";
                tipoClube = "A.clube_atleta as CLUBE_DANGAY";
            } else if (jRadioBtnYudanshaExame.isSelected()) {
                mascara = "YUDANSHA";
                tipo = "yudansha";
                tipoTabela = "tbexamesyudansha";
                tipoClube = "A.clube_atleta as CLUBE_YUDANSHA";
            } else {
                mascara = "CBKSC";
                tipo = "cbksc";
                tipoTabela = "tbexamescbksc";
                tipoClube = "A.estado_atleta as ESTADO";
            }

            if (exameMD.getIdAtleta().isEmpty()
                    && exameMD.getNome().isEmpty()
                    && exameMD.getClube().isEmpty()
                    && exameMD.getFaixa().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID, Nome, Clube ou Faixa " + mascara + " do Atleta!", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
            } else {
                if (!exameMD.getNome().isEmpty() && !exameMD.getClube().isEmpty() && !exameMD.getFaixa().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.nome_atleta like ? and A.clube_atleta like ? and B.faixa_exame like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaNomeClubeFaixa(exameMD);
                } else if (!exameMD.getNome().isEmpty() && !exameMD.getClube().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.nome_atleta like ? and A.clube_atleta like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaNomeClube(exameMD);
                } else if (!exameMD.getNome().isEmpty() && !exameMD.getFaixa().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.nome_atleta like ? and B.faixa_exame like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaNomeFaixa(exameMD);
                } else if (!exameMD.getClube().isEmpty() && !exameMD.getFaixa().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.clube_atleta like ? and B.faixa_exame like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaClubeFaixa(exameMD);
                } else if (!exameMD.getNome().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.nome_atleta like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaNome(exameMD);
                } else if (!exameMD.getClube().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.clube_atleta like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaClube(exameMD);
                } else if (!exameMD.getFaixa().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE B.faixa_exame like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaFaixa(exameMD);
                } else if (!exameMD.getIdAtleta().isEmpty()) {
                    exameMD.setTipoExame("SELECT A.id_" + tipo + " as ID_" + mascara + ", A.nome_atleta as NOME_" + mascara + ", " + tipoClube + ", B.faixa_exame as FAIXA_" + mascara + ", B.data_exame as DATA_EXAME , B.id_exame as ID_EXAME, A.id_atleta as ID_ATLETA FROM tb_atletas as A INNER JOIN " + tipoTabela + " as B ON B.id_atleta = A.id_atleta WHERE A.id_" + tipo + " like ? ORDER by A.nome_atleta");
                    exameDao.pesquisaId(exameMD);
                }
                estiloTabela.ajustarTabelaFrmExamePesquisaExame();
                txtTotalExame.setText(Integer.toString(jTableFrmExamePesquisaExame.getRowCount()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao pesquisar exame.\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    @Override
    public void setarCampos() {

        try {
            exameDao.setarCampos();

            txtIdAtleta.setEditable(false);
            txtNomeAtletaExame.setEditable(false);
            cmbClubeExame.setEnabled(false);
            btnPesquisarExame.setEnabled(false);
            btnAdicionarExame.setEnabled(false);
            btnEditarDataExame.setEnabled(true);
            btnApagarExame.setEnabled(true);
            btnLimparPesquisaExame.setEnabled(true);
            btnImprimirExame.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao preencher os campos da tabela\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para deletar exame
    @Override
    public void deletar() {

        try {
            exameMD.setIdExame(txtIdExame.getText());
            exameMD.setNome(txtNomeAtletaExame.getText());

            if (exameMD.getId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
            } else {
                int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este atleta", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
                if (confirma == JOptionPane.YES_OPTION) {
                    if (jRadioBtnDangayExame.isSelected()) {
                        exameMD.setTipoExame("delete from tbexamesdangay where id_exame=?");
                    } else if (jRadioBtnYudanshaExame.isSelected()) {
                        exameMD.setTipoExame("delete from tbexamesyudansha where id_exame=?");
                    } else {
                        exameMD.setTipoExame("delete from tbexamescbksc where id_exame=?");
                    }
                    exameDao.deletarExame(exameMD);
                    if (exameDao.resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Exame do atleta: " + exameMD.getNome() + " deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                        limparCampos();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar deletar exame.\n Erro: " + e, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para imprimir Certificados
    public void imprimirExame() {

        try {
            exameMD.setIdExame(txtIdExame.getText());
            int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do Certificado?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {

                if (cmbFaixaExame.getSelectedItem().toString().equals("AMARELA")) {
                    exameMD.setCorCertificado("reports/amarelo.jasper");
                } else if (cmbFaixaExame.getSelectedItem().toString().equals("VERMELHA")) {
                    exameMD.setCorCertificado("reports/vermelho.jasper");
                } else if (cmbFaixaExame.getSelectedItem().toString().equals("LARANJA")) {
                    exameMD.setCorCertificado("reports/laranja.jasper");
                } else if (cmbFaixaExame.getSelectedItem().toString().equals("VERDE")
                        || cmbFaixaExame.getSelectedItem().toString().equals("VERDE I")
                        || cmbFaixaExame.getSelectedItem().toString().equals("VERDE II")
                        || cmbFaixaExame.getSelectedItem().toString().equals("VERDE III")) {
                    exameMD.setCorCertificado("reports/verde.jasper");
                } else if (cmbFaixaExame.getSelectedItem().toString().equals("ROXA")) {
                    exameMD.setCorCertificado("reports/roxa.jasper");
                } else if (cmbFaixaExame.getSelectedItem().toString().equals("MARROM")) {
                    exameMD.setCorCertificado("reports/marrom.jasper");
                } else if (cmbClubeExame.getSelectedItem().toString().equals("DA BAHIA")
                        || cmbClubeExame.getSelectedItem().toString().equals("DE GOIÁS")
                        || cmbClubeExame.getSelectedItem().toString().equals("DE MINAS GERAIS")
                        || cmbClubeExame.getSelectedItem().toString().equals("DE PERNAMBUCO")
                        || cmbClubeExame.getSelectedItem().toString().equals("DE SÃO PAULO")
                        || cmbClubeExame.getSelectedItem().toString().equals("DE TOCANTINS")
                        || cmbClubeExame.getSelectedItem().toString().equals("DO DISTRITO FEDERAL")
                        || cmbClubeExame.getSelectedItem().toString().equals("DO PARÁ ")
                        || cmbClubeExame.getSelectedItem().toString().equals("DO RIO DE JANEIRO")
                        || cmbClubeExame.getSelectedItem().toString().equals("DO RIO GRANDE DO SUL")) {
                    exameMD.setCorCertificado("reports/cbksc.jasper");
                } else {
                    exameMD.setCorCertificado("reports/yudansha.jasper");
                }
                exameDao.imprimirExame(exameMD);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o Certificado.\n Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para limpar os campos do formularios  
    @Override
    public void limparCampos() {

        txtIdAtleta.setText("");
        txtIdAtleta.requestFocus();
        txtNomeAtletaExame.setText("");
        cmbClubeExame.setSelectedItem("");
        cmbFaixaExame.setSelectedItem("");
        txtDataExame.setText("");
        txtTotalAtleta.setText("");
        txtTotalExame.setText("");
        txtPesquisar.setText("");
        txtIdGeral.setText("");

        ((DefaultTableModel) jTableFrmExamePesquisaAtleta.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableFrmExamePesquisaExame.getModel()).setRowCount(0);

        txtIdAtleta.setEditable(true);
        txtNomeAtletaExame.setEditable(true);
        cmbClubeExame.setEnabled(true);
        btnPesquisarExame.setEnabled(true);
        btnAdicionarExame.setEnabled(false);
        btnEditarDataExame.setEnabled(false);
        btnApagarExame.setEnabled(false);
        btnLimparPesquisaExame.setEnabled(false);
        btnImprimirExame.setEnabled(false);
        jRadioBtnDangayExame.setSelected(true);
    }

}
