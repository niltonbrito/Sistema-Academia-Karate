package business;

import dao.AtletaDao;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AtletaMD;
import swing.EstiloTabelaColumn;
import static view.FrmAtleta.*;

/**
 *
 * @author nilton.brito
 */
public class AtletaBS {

    AtletaMD atletaMD = new AtletaMD();
    AtletaDao atletaDao = new AtletaDao();
    EstiloTabelaColumn estilotabela = new EstiloTabelaColumn();

    // Metodo para Adicionar atleta
    public void adicionarAtleta() {

        atletaMD.setIdAtleta(txtIdAtleta.getText());
        atletaMD.setNome(txtNome.getText());
        atletaMD.setId(txtIdAtleta.getText());
        atletaMD.setIdPadrao("0");
        atletaMD.setNome(txtNome.getText());
        atletaMD.setSexo(cmbSexoAtleta.getSelectedItem().toString());
        atletaMD.setDataNasc(txtNascimento.getText());
        atletaMD.setIdade(txtIdade.getText());
        atletaMD.setCpf(txtCpf.getText());
        atletaMD.setClube(cmbClubeAtleta.getSelectedItem().toString());
        atletaMD.setFaixa(cmbFaixaAtleta.getSelectedItem().toString());
        atletaMD.setEstado(cmbEstadoAtleta.getSelectedItem().toString());
        atletaMD.setCategoria(txtCategoria.getText());

        if (txtNome.getText().length() <= 25) {
            atletaMD.setAbreviado(txtNome.getText());
        } else {
            atletaMD.setAbreviado(abreviarNome(txtNome.getText()));
        }
        if (atletaMD.getIdAtleta().isEmpty()
                || atletaMD.getNome().isEmpty()
                || atletaMD.getCpf().isEmpty()
                || atletaMD.getDataNasc().isEmpty()
                || atletaMD.getIdade().isEmpty()
                || atletaMD.getSexo().isEmpty()
                || atletaMD.getClube().isEmpty()
                || atletaMD.getFaixa().isEmpty()
                || atletaMD.getEstado().isEmpty()
                || atletaMD.getCategoria().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            atletaMD.setTipoAtleta("INSERT INTO tb_atletas(id_dangay, id_yudansha, id_cbksc, nome_atleta, cpf_atleta, sexo_atleta, data_nasc_atleta, idade_atleta, clube_atleta, faixa_atleta,estado_atleta, categoria_atleta, data_cadastro_atleta,nome_abreviado_atleta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            atletaDao.adicionarAtleta(atletaMD);
            if (atletaDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Atleta " + atletaMD.getNome() + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparCampos();
            } else if (atletaDao.erro.equals("Duplicate entry '" + atletaMD.getCpf() + "' for key 'cpf_atleta'")) {
                JOptionPane.showMessageDialog(null, "Cpf informado já cadastado.\nInforme outro Cpf.", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                atletaMD.setCpf("");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao tentar adicionar atleta,\n Erro: " + atletaDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
            }
        }
    }

    // Metodo para alterar dados do atleta
    public void editarAtleta() {
        // Chamando o metodo alterar
        atletaMD.setIdAtleta(txtIdAtleta.getText());
        atletaMD.setNome(txtNome.getText());
        atletaMD.setNome(txtNome.getText());
        atletaMD.setSexo(cmbSexoAtleta.getSelectedItem().toString());
        atletaMD.setDataNasc(txtNascimento.getText());
        atletaMD.setIdade(txtIdade.getText());
        atletaMD.setCpf(txtCpf.getText());
        atletaMD.setClube(cmbClubeAtleta.getSelectedItem().toString());
        atletaMD.setFaixa(cmbFaixaAtleta.getSelectedItem().toString());
        atletaMD.setEstado(cmbEstadoAtleta.getSelectedItem().toString());
        atletaMD.setCategoria(txtCategoria.getText());
        atletaMD.setId(txtId.getText());

        if (txtNome.getText().length() <= 25) {
            atletaMD.setAbreviado(txtNome.getText());
        } else {
            atletaMD.setAbreviado(abreviarNome(txtNome.getText()));
        }
        if (atletaMD.getIdAtleta().isEmpty()
                || atletaMD.getNome().isEmpty()
                || atletaMD.getCpf().isEmpty()
                || atletaMD.getDataNasc().isEmpty()
                || atletaMD.getIdade().isEmpty()
                || atletaMD.getSexo().isEmpty()
                || atletaMD.getClube().isEmpty()
                || atletaMD.getFaixa().isEmpty()
                || atletaMD.getEstado().isEmpty()
                || atletaMD.getCategoria().isEmpty()
                || atletaMD.getId().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar dados do atleta", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                String tipo;
                if (jRadioBtnDangayAtleta.isSelected()) {
                    tipo = "id_dangay";
                    if (txtIdDangay.getText().equals("0")) {
                        atletaMD.setIdAtleta(txtIdAtleta.getText());
                    } else {
                        atletaMD.setIdAtleta(txtIdDangay.getText());
                    }
                } else if (jRadioBtnYudanshaAtleta.isSelected()) {
                    tipo = "id_yudansha";
                    if (txtIdYudannsha.getText().equals("0")) {
                        atletaMD.setIdAtleta(txtIdAtleta.getText());
                    } else {
                        atletaMD.setIdAtleta(txtIdYudannsha.getText());
                    }
                } else {
                    tipo = "id_cbksc";
                    if (txtIdCbksc.getText().equals("0")) {
                        atletaMD.setIdAtleta(txtIdAtleta.getText());
                    } else {
                        atletaMD.setIdAtleta(txtIdCbksc.getText());
                    }
                }
                atletaMD.setTipoAtleta("update tb_atletas set " + tipo + "=?,nome_atleta=?, cpf_atleta=?,sexo_atleta=?,data_nasc_atleta=?,idade_atleta=?,clube_atleta=?,faixa_atleta=?,estado_atleta=?,categoria_atleta=?,data_atualizacao_atleta=?, nome_abreviado_atleta=? where id_atleta=?");
                atletaDao.editarAtleta(atletaMD);
                if (atletaDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do atleta alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar alterar dados do atleta,\n Erro: " + atletaDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para deletar atleta
    public void deletarAtleta() {

        atletaMD.setId(txtId.getText());
        atletaMD.setNome(txtNome.getText());

        if (atletaMD.getId().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
        } else {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este atleta", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
            if (confirma == JOptionPane.YES_OPTION) {
                atletaDao.deletarAtleta(atletaMD);
                if (atletaDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Atleta " + atletaMD.getNome() + " deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar deletar o atleta,\n Erro: " + atletaDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
                }
            }
        }
    }

    // Metodo para deletar atleta
    public void deletarTodosAtletas() {

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover TODOS\n os atletas da BASE de DADOS,\n Se continuar esta ação e irrevesível.", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-question.png")));
        if (confirma == JOptionPane.YES_OPTION) {
            atletaDao.deletarTodosAtletas();
            if (atletaDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "BASE de DADOS apagada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-confim.png")));
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao tentar deletar a BASE de DADOS,\n Erro: " + atletaDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
            }
        }
    }

    public static String abreviarNome(String nome) {

        String[] partes = txtNome.getText().split(" ");
        StringBuilder abreviado = new StringBuilder();

        abreviado.append(partes[0]); // Primeiro nome

        for (int i = 1; i < partes.length - 1; i++) {
            if (!partes[i].equalsIgnoreCase("de")
                    && !partes[i].equalsIgnoreCase("da")
                    && !partes[i].equalsIgnoreCase("do")
                    && !partes[i].equalsIgnoreCase("das")
                    && !partes[i].equalsIgnoreCase("dos")) {
                abreviado.append(" ").append(partes[i].charAt(0)).append(".");
            }
        }

        abreviado.append(" ").append(partes[partes.length - 1]); // Último nome
        return abreviado.toString();
    }

    // Metodo para Consultar atleta com filtos
    public void pesquisarAtleta() {
        // Chamando o metodo pesquisar clientes
        atletaMD.setPesquisar(txtPesquisar.getText());

        atletaDao.pesquisarAtleta(atletaMD);
        estilotabela.ajustarTabelaFrmAtleta();
        txtTotalAtleta.setText(Integer.toString(tabelaAtleta.getRowCount()));
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        try {
            txtIdDangay.setVisible(false);
            lbIdDangay.setVisible(false);
            txtIdYudannsha.setVisible(false);
            lbIdYudannsha.setVisible(false);
            txtIdCbksc.setVisible(false);
            lbIdCbksc.setVisible(false);

            atletaDao.setarCampos();

            btnAdicionar.setEnabled(false);
            btnEditar.setEnabled(true);
            btnDeletar.setEnabled(true);
            btnLimpar.setEnabled(true);
            calcularIdade();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao setar dados na tabela,\n Erro: " + atletaDao.erro, "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-error.png")));
        }
    }

    // Metodo para calcular idade do atleta
    public void calcularIdade() {

        try {
            LocalDate dataAtual = LocalDate.now(); //Data atual do sistema
            DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(txtNascimento.getText(), formatada);
            Period periodo = Period.between(dataAtual, dataNasc);

            if (dataNasc.isAfter(dataAtual)) {
                JOptionPane.showMessageDialog(null, "Ano de nascimento não pode ser maior que a ano atual! ", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
                txtNascimento.setText("");
                txtNascimento.requestFocus();
            } else if ((dataNasc.getYear() < 1900) || (dataNasc.getYear() > dataAtual.getYear())) {
                JOptionPane.showMessageDialog(null, "Ano de nascimento inválido! ", "Atenção", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-warning.png")));
                txtNascimento.setText("");
                txtNascimento.requestFocus();
            } else {
                txtIdade.setText(String.valueOf(Math.abs(periodo.getYears())));
                if (Integer.parseInt(txtIdade.getText()) < 16) {
                    jRadioBtnYudanshaAtleta.setEnabled(false);
                    jRadioBtnCbkscAtleta.setEnabled(false);
                } else {
                    jRadioBtnYudanshaAtleta.setEnabled(true);
                    jRadioBtnCbkscAtleta.setEnabled(true);
                }
            }
        } catch (Exception e) {
        }
    }

    // Metodo para gerar ID do atleta
    public void gerarId() {
        if (jRadioBtnDangayAtleta.isSelected()) {
            atletaMD.setIdAtleta("SELECT MAX(tb_atletas.id_dangay) FROM tb_atletas");
            atletaDao.gerarId(atletaMD);
        } else if (jRadioBtnYudanshaAtleta.isSelected()) {
            atletaMD.setIdAtleta("SELECT MAX(tb_atletas.id_yudansha) FROM tb_atletas");
            atletaDao.gerarId(atletaMD);
        } else {
            atletaMD.setIdAtleta("SELECT MAX(tb_atletas.id_cbksc) FROM tb_atletas");
            atletaDao.gerarId(atletaMD);
        }
    }

    // Metodo para setar o tipo de cadastro do atleta
    public void setarTipoCadastro() {
        try {
            String faixa = tabelaAtleta.getModel().getValueAt(atletaDao.resultado, 9).toString();

            if (faixa.equals("AMARELA")
                    || faixa.equals("VERMELHA")
                    || faixa.equals("LARANJA")
                    || faixa.equals("VERDE")
                    || faixa.equals("VERDE I")
                    || faixa.equals("VERDE II")
                    || faixa.equals("VERDE III")
                    || faixa.equals("ROXA")
                    || faixa.equals("MARROM")) {
                jRadioBtnDangayAtleta.setSelected(true);
                cmbFaixaAtleta.setSelectedItem(tabelaAtleta.getModel().getValueAt(atletaDao.resultado, 9).toString());
            } else {
                jRadioBtnYudanshaAtleta.setSelected(true);
                cmbFaixaAtleta.setSelectedItem(tabelaAtleta.getModel().getValueAt(atletaDao.resultado, 9).toString());
            }
        } catch (Exception e) {
        }
    }

    // Metodo para setar a categoria do atleta
    public void setarCategoria() {
        try {
            if (!txtIdade.getText().isEmpty() && !cmbSexoAtleta.getSelectedItem().toString().isEmpty() && !cmbFaixaAtleta.getSelectedItem().toString().isEmpty()) {
                if (cmbSexoAtleta.getSelectedItem().equals("MASCULINO")) {
                    if (jRadioBtnDangayAtleta.isSelected()) {
                        if (cmbFaixaAtleta.getSelectedItem().toString().equals("BRANCA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("AMARELA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERMELHA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("LARANJA")) {
                            if (Integer.parseInt(txtIdade.getText()) <= 5) {
                                txtCategoria.setText("FRAUDINHA (5 ANOS - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 6 && Integer.parseInt(txtIdade.getText()) <= 7) {
                                txtCategoria.setText("PETIZ - A (6 - 7 ANOS - BRA / LAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 8 && Integer.parseInt(txtIdade.getText()) <= 9) {
                                txtCategoria.setText("MIRIM - A (8 - 9 ANOS - BRA / LAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 10 && Integer.parseInt(txtIdade.getText()) <= 11) {
                                txtCategoria.setText("INFANTIL - A (10 - 11 ANOS - BRA / LAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 12 && Integer.parseInt(txtIdade.getText()) <= 13) {
                                txtCategoria.setText("INFANTO - A (12 - 13 ANOS - BRA / LAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 14 && Integer.parseInt(txtIdade.getText()) <= 15) {
                                txtCategoria.setText("INFANTO -JUVENIL - A (14 - 15 ANOS - BRA / LAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 16 && Integer.parseInt(txtIdade.getText()) <= 17) {
                                txtCategoria.setText("JUVENIL - A (16 - 17 ANOS - BRA / LAR - MASCULINO)");
                            } else {
                                txtCategoria.setText("ADULTO COLORIDA - A (> 18 ANOS - BRA / LAR - MASCULINO)");
                            }
                        } else if (cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE I")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE II")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE III")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("ROXA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("MARROM")) {
                            if (Integer.parseInt(txtIdade.getText()) >= 6 && Integer.parseInt(txtIdade.getText()) <= 7) {
                                txtCategoria.setText("PETIZ - B (6 - 7 ANOS - VERD / MAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 8 && Integer.parseInt(txtIdade.getText()) <= 9) {
                                txtCategoria.setText("MIRIM - B (8 - 9 ANOS - VERD / MAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 10 && Integer.parseInt(txtIdade.getText()) <= 11) {
                                txtCategoria.setText("INFANTIL - B (10 - 11 ANOS - VERD / MAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 12 && Integer.parseInt(txtIdade.getText()) <= 13) {
                                txtCategoria.setText("INFANTO - B (12 - 13 ANOS - VERD / MAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 14 && Integer.parseInt(txtIdade.getText()) <= 15) {
                                txtCategoria.setText("INFANTO -JUVENIL - B (14 - 15 ANOS - VERD / MAR - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 16 && Integer.parseInt(txtIdade.getText()) <= 17) {
                                txtCategoria.setText("JUVENIL - B (16 - 17 ANOS - VERD / MAR - MASCULINO)");
                            } else {
                                txtCategoria.setText("ADULTO COLORIDA - B (> 18 ANOS - VERD / MAR - MASCULINO)");
                            }
                        }
                    } else {
                        if (cmbFaixaAtleta.getSelectedItem().toString().equals("PRETA")) {
                            if (Integer.parseInt(txtIdade.getText()) >= 16 && Integer.parseInt(txtIdade.getText()) <= 17) {
                                txtCategoria.setText("JUVENIL - C (16 - 17 ANOS - PRETA - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 18 && Integer.parseInt(txtIdade.getText()) <= 21) {
                                txtCategoria.setText("ADULTA PRETA - A (18 - 21 ANOS - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 22 && Integer.parseInt(txtIdade.getText()) <= 29) {
                                txtCategoria.setText("ADULTO PRETA - B (22 - 29 ANOS - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 30 && Integer.parseInt(txtIdade.getText()) <= 39) {
                                txtCategoria.setText("ADULTO PRETA - C (30 - 39 ANOS - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 40 && Integer.parseInt(txtIdade.getText()) <= 49) {
                                txtCategoria.setText("ADULTO PRETA - D (40 - 49 ANOS - MASCULINO)");
                            } else if (Integer.parseInt(txtIdade.getText()) > 50) {
                                txtCategoria.setText("ADULTO PRETA - E (> 50 ANOS - MASCULINO)");
                            } else {
                                JOptionPane.showMessageDialog(null, "Idade incompativel com a faixa escolhida!", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                            }
                        } else if (cmbFaixaAtleta.getSelectedItem().toString().equals("1º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("2º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("3º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("4º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("5º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("6º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("7º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("8º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("9º DAN")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("10º DAN")) {
                            if (Integer.parseInt(txtIdade.getText()) > 18) {
                                txtCategoria.setText("CATEGORIA ESPECIAL - MASCULINO");
                            } else {
                                JOptionPane.showMessageDialog(null, "Idade incompativel com a faixa escolhida!", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                            }
                        }
                    }
                } else {
                    if (jRadioBtnDangayAtleta.isSelected()) {
                        if (cmbFaixaAtleta.getSelectedItem().toString().equals("BRANCA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("AMARELA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERMELHA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("LARANJA")) {
                            if (Integer.parseInt(txtIdade.getText()) <= 5) {
                                txtCategoria.setText("FRAUDINHA (5 ANOS - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 6 && Integer.parseInt(txtIdade.getText()) <= 7) {
                                txtCategoria.setText("PETIZ - A (6 - 7 ANOS - BRA / LAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 8 && Integer.parseInt(txtIdade.getText()) <= 9) {
                                txtCategoria.setText("MIRIM - A (8 - 9 ANOS - BRA / LAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 10 && Integer.parseInt(txtIdade.getText()) <= 11) {
                                txtCategoria.setText("INFANTIL - A (10 - 11 ANOS - BRA / LAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 12 && Integer.parseInt(txtIdade.getText()) <= 13) {
                                txtCategoria.setText("INFANTO - A (12 - 13 ANOS - BRA / LAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 14 && Integer.parseInt(txtIdade.getText()) <= 15) {
                                txtCategoria.setText("INFANTO -JUVENIL - A (14 - 15 ANOS - BRA / LAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 16 && Integer.parseInt(txtIdade.getText()) <= 17) {
                                txtCategoria.setText("JUVENIL - A (16 - 17 ANOS - BRA / LAR - FEMININO)");
                            } else {
                                txtCategoria.setText("ADULTO COLORIDA - A (> 18 ANOS - BRA / LAR - FEMININO)");
                            }
                        } else if (cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE I")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE II")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("VERDE III")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("ROXA")
                                || cmbFaixaAtleta.getSelectedItem().toString().equals("MARROM")) {
                            if (Integer.parseInt(txtIdade.getText()) >= 6 && Integer.parseInt(txtIdade.getText()) <= 7) {
                                txtCategoria.setText("PETIZ - B (6 - 7 ANOS - VERD / MAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 8 && Integer.parseInt(txtIdade.getText()) <= 9) {
                                txtCategoria.setText("MIRIM - B (8 - 9 ANOS - VERD / MAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 10 && Integer.parseInt(txtIdade.getText()) <= 11) {
                                txtCategoria.setText("INFANTIL - B (10 - 11 ANOS - VERD / MAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 12 && Integer.parseInt(txtIdade.getText()) <= 13) {
                                txtCategoria.setText("INFANTO - B (12 - 13 ANOS - VERD / MAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 14 && Integer.parseInt(txtIdade.getText()) <= 15) {
                                txtCategoria.setText("INFANTO -JUVENIL - B (14 - 15 ANOS - VERD / MAR - FEMININO)");
                            } else if (Integer.parseInt(txtIdade.getText()) >= 16 && Integer.parseInt(txtIdade.getText()) <= 17) {
                                txtCategoria.setText("JUVENIL - B (16 - 17 ANOS - VERD / MAR - FEMININO)");
                            } else {
                                txtCategoria.setText("ADULTO COLORIDA - B (> 18 ANOS - VERD / MAR - FEMININO)");
                            }
                        } else {
                            if (cmbFaixaAtleta.getSelectedItem().toString().equals("PRETA")) {
                                if (Integer.parseInt(txtIdade.getText()) >= 16 && Integer.parseInt(txtIdade.getText()) <= 17) {
                                    txtCategoria.setText("JUVENIL - C (16 - 17 ANOS - PRETA - FEMININO)");
                                } else if (Integer.parseInt(txtIdade.getText()) >= 18 && Integer.parseInt(txtIdade.getText()) <= 26) {
                                    txtCategoria.setText("ADULTA PRETA - A (18 - 26 ANOS - FEMININO");
                                } else if (Integer.parseInt(txtIdade.getText()) >= 27 && Integer.parseInt(txtIdade.getText()) <= 34) {
                                    txtCategoria.setText("ADULTO PRETA - B (27 - 34 ANOS - FEMININO)");
                                } else if (Integer.parseInt(txtIdade.getText()) > 35) {
                                    txtCategoria.setText("ADULTO PRETA - E (> 35 ANOS - FEMININO)");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Idade incompatível com a faixa escolhida!", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                                }
                            } else if (cmbFaixaAtleta.getSelectedItem().toString().equals("1º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("2º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("3º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("4º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("5º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("6º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("7º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("8º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("9º DAN")
                                    || cmbFaixaAtleta.getSelectedItem().toString().equals("10º DAN")) {
                                if (Integer.parseInt(txtIdade.getText()) > 18) {
                                    txtCategoria.setText("CATEGORIA ESPECIAL - FEMININO");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Idade incompatível com a faixa escolhida!", "Aviso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    // Metodo para limpar os campos do formularios   
    public void limparCampos() {

        txtIdAtleta.setText("");
        txtNome.setText("");
        txtNascimento.setText("");
        txtIdade.setText("");
        txtCpf.setText("");
        cmbSexoAtleta.setSelectedItem("");
        cmbClubeAtleta.setSelectedItem("");
        cmbFaixaAtleta.setSelectedItem("");
        cmbEstadoAtleta.setSelectedItem("");
        txtCategoria.setText("");
        txtDataCad.setText("");
        txtTotalAtleta.setText("");
        txtPesquisar.setText("");
        estilotabela.ajustarTabelaFrmAtleta();
        ((DefaultTableModel) tabelaAtleta.getModel()).setRowCount(0);

        jRadioBtnDangayAtleta.setSelected(true);
        jRadioBtnYudanshaAtleta.setEnabled(true);
        jRadioBtnCbkscAtleta.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnLimpar.setEnabled(false);

        txtIdDangay.setText("");
        txtIdDangay.setVisible(false);
        lbIdDangay.setVisible(false);
        txtIdYudannsha.setText("");
        txtIdYudannsha.setVisible(false);
        lbIdYudannsha.setVisible(false);
        txtIdCbksc.setText("");
        txtIdCbksc.setVisible(false);
        lbIdCbksc.setVisible(false);
        txtId.setText("");
        gerarId();
        txtNome.requestFocus();
    }
}
