package business;

import dao.PesquisasDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PesquisasMD;
import static view.FrmPeaquisaAtleta.*;

/**
 *
 * @author nilton.brito
 */
public class PesquisasBS {

    // Metodo para Consultar atleta com filtos
    public void pesquisarAtleta() {
        // Chamando o metodo pesquisar atleta

        PesquisasMD pesquisaMD = new PesquisasMD();

        pesquisaMD.setNomePesquisaAtleta(txtNomePesquisaAtleta.getText());
        pesquisaMD.setClubePesquisaAtleta(cmbClubePesquisaAtleta.getSelectedItem().toString());
        if (!(pesquisaMD.getNomePesquisaAtleta().isEmpty()) || !(pesquisaMD.getClubePesquisaAtleta().equals(""))) {

            if (!(pesquisaMD.getNomePesquisaAtleta().isEmpty()) && !(pesquisaMD.getClubePesquisaAtleta().equals(""))) {
                PesquisasDao pesquisaDao = new PesquisasDao();
                pesquisaDao.pesquisarAtletaFull(pesquisaMD);
                ajustarTabela();
            }
            if (!pesquisaMD.getNomePesquisaAtleta().isEmpty()) {
                PesquisasDao pesquisaDao = new PesquisasDao();
                pesquisaDao.pesquisarAtletaNome(pesquisaMD);
                ajustarTabela();
            }
            if (!pesquisaMD.getClubePesquisaAtleta().equals("")) {
                PesquisasDao pesquisaDao = new PesquisasDao();
                pesquisaDao.pesquisarAtletaClube(pesquisaMD);
                ajustarTabela();
            }
            txtTotalPesquisaAtleta.setText(Integer.toString(tabelaPesquisaAtleta.getRowCount()));
        } else {
            JOptionPane.showMessageDialog(null, "Informe o nome ou clube do Atleta!", "Aviso", 0);
        }
    }

    public void ajustarTabela() {
        tabelaPesquisaAtleta.getColumnModel().getColumn(0).setWidth(140);
        tabelaPesquisaAtleta.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabelaPesquisaAtleta.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabelaPesquisaAtleta.getColumnModel().getColumn(3).setPreferredWidth(250);
        tabelaPesquisaAtleta.getColumnModel().getColumn(4).setPreferredWidth(250);
        tabelaPesquisaAtleta.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabelaPesquisaAtleta.getColumnModel().getColumn(6).setPreferredWidth(60);
        tabelaPesquisaAtleta.getColumnModel().getColumn(7).setPreferredWidth(100);
        tabelaPesquisaAtleta.getColumnModel().getColumn(8).setPreferredWidth(250);
        tabelaPesquisaAtleta.getColumnModel().getColumn(9).setPreferredWidth(150);
    }
    // Metodo para limpar os campos do formularios   

    public void limparCampos() {

        txtNomePesquisaAtleta.setText("");
        txtNomePesquisaAtleta.requestFocus();
        cmbClubePesquisaAtleta.setSelectedItem("");
        txtTotalPesquisaAtleta.setText("");

        ((DefaultTableModel) tabelaPesquisaAtleta.getModel()).setRowCount(0);
    }
}
