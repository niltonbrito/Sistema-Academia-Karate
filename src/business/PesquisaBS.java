package business;

import dao.PesquisaDao;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PesquisaMD;
import swing.EstiloTabelaColumn;
import static view.FrmPesquisa.*;

/**
 *
 * @author nilton.brito
 */
public class PesquisaBS {

    PesquisaMD pesquisaMD = new PesquisaMD();
    PesquisaDao pesquisaDao = new PesquisaDao();
    EstiloTabelaColumn estiloTabela = new EstiloTabelaColumn();

    // Metodo para Consultar atleta com filtos
    public void pesquisar() {
        // Chamando o metodo pesquisar atleta

        pesquisaMD.setNomeAtleta(txtNomeAtleta.getText());
        pesquisaMD.setClubeAtleta(cmbClubePesquisaAtleta.getSelectedItem().toString());

        if ((pesquisaMD.getNomeAtleta().isEmpty()) && (pesquisaMD.getClubeAtleta().equals(""))) {
            JOptionPane.showMessageDialog(null, "Informe o nome ou clube do Atleta!", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/principal/icon-information.png")));
        } else {
            if (!(pesquisaMD.getNomeAtleta().isEmpty()) && !(pesquisaMD.getClubeAtleta().equals(""))) {
                pesquisaDao.pesquisaFull(pesquisaMD);
            } else if (!pesquisaMD.getClubeAtleta().equals("")) {
                pesquisaDao.pesquisaClube(pesquisaMD);
            } else if (!pesquisaMD.getNomeAtleta().isEmpty()) {
                pesquisaDao.pesquisaNome(pesquisaMD);
            }
            estiloTabela.ajustarTabelaFrmPesquisaAtleta();
            txtTotalAtleta.setText(Integer.toString(tabelaFrmPesquisa.getRowCount()));
        }
    }

    // Metodo para limpar os campos do formularios   
    public void limparCampos() {

        txtNomeAtleta.setText("");
        txtNomeAtleta.requestFocus();
        cmbClubePesquisaAtleta.setSelectedItem("");
        txtTotalAtleta.setText("");

        ((DefaultTableModel) tabelaFrmPesquisa.getModel()).setRowCount(0);
        btnLimpar.setEnabled(false);
    }
}
