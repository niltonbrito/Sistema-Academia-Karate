package business;

import dao.PesquisaAtletaDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PesquisasMD;
import swing.EstiloTabelaColumn;
import static view.FrmPeaquisaAtleta.*;

/**
 *
 * @author nilton.brito
 */
public class PesquisaAtletaBS {

        PesquisasMD pesquisaMD = new PesquisasMD();
    EstiloTabelaColumn estiloTabela = new EstiloTabelaColumn();
    // Metodo para Consultar atleta com filtos
    public void pesquisarAtleta() {
        // Chamando o metodo pesquisar atleta


        pesquisaMD.setNomePesquisaAtleta(txtNomePesquisaAtleta.getText());
        pesquisaMD.setClubePesquisaAtleta(cmbClubePesquisaAtleta.getSelectedItem().toString());
        
        if ((pesquisaMD.getNomePesquisaAtleta().isEmpty()) && (pesquisaMD.getClubePesquisaAtleta().equals(""))) {
            JOptionPane.showMessageDialog(null, "Informe o nome ou clube do Atleta!", "Aviso", 0);
        } else {

            if (!(pesquisaMD.getNomePesquisaAtleta().isEmpty()) && !(pesquisaMD.getClubePesquisaAtleta().equals(""))) {

                PesquisaAtletaDao pesquisaDao = new PesquisaAtletaDao();
                pesquisaDao.pesquisarAtletaFull(pesquisaMD);
                estiloTabela.ajustarTabelaFrmPesquisaAtleta();

            } else if (!pesquisaMD.getClubePesquisaAtleta().equals("")) {

                PesquisaAtletaDao pesquisaDao = new PesquisaAtletaDao();
                pesquisaDao.pesquisarAtletaClube(pesquisaMD);
                estiloTabela.ajustarTabelaFrmPesquisaAtleta();

            } else if (!pesquisaMD.getNomePesquisaAtleta().isEmpty()) {

                PesquisaAtletaDao pesquisaDao = new PesquisaAtletaDao();
                pesquisaDao.pesquisarAtletaNome(pesquisaMD);
                estiloTabela.ajustarTabelaFrmPesquisaAtleta();

            }
        }
    }

    // Metodo para limpar os campos do formularios   

    public void limparCampos() {

        txtNomePesquisaAtleta.setText("");
        txtNomePesquisaAtleta.requestFocus();
        cmbClubePesquisaAtleta.setSelectedItem("");
        txtTotalPesquisaAtleta.setText("");

        ((DefaultTableModel) tabelaPesquisaAtleta.getModel()).setRowCount(0);
        btnLimparPesquisaAtleta.setEnabled(false);
    }
}
