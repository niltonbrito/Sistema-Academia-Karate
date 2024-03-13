package swing;

import static view.FrmAtleta.*;
import static view.FrmExames.*;
import static view.FrmPesquisa.*;
import static view.FrmUsuarios.*;

/**
 *
 * @author nilton.brito
 */
public class EstiloTabelaColumn {

    public void ajustarTabelaFrmUsuario() {
        tabelaUsuario.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabelaUsuario.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelaUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabelaUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelaUsuario.getColumnModel().getColumn(4).setPreferredWidth(70);
        tabelaUsuario.getColumnModel().getColumn(5).setPreferredWidth(120);
        tabelaUsuario.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabelaUsuario.getColumnModel().getColumn(7).setPreferredWidth(70);
        tabelaUsuario.getColumnModel().getColumn(8).setPreferredWidth(130);
        tabelaUsuario.getColumnModel().getColumn(9).setPreferredWidth(130);
    }

    public void ajustarTabelaFrmAtleta() {
        tabelaAtleta.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabelaAtleta.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaAtleta.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabelaAtleta.getColumnModel().getColumn(3).setPreferredWidth(350);
        tabelaAtleta.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabelaAtleta.getColumnModel().getColumn(5).setPreferredWidth(120);
        tabelaAtleta.getColumnModel().getColumn(6).setPreferredWidth(150);
        tabelaAtleta.getColumnModel().getColumn(7).setPreferredWidth(60);
        tabelaAtleta.getColumnModel().getColumn(8).setPreferredWidth(250);
        tabelaAtleta.getColumnModel().getColumn(9).setPreferredWidth(100);
        tabelaAtleta.getColumnModel().getColumn(10).setPreferredWidth(200);
        tabelaAtleta.getColumnModel().getColumn(11).setPreferredWidth(200);
        tabelaAtleta.getColumnModel().getColumn(12).setPreferredWidth(200);
        tabelaAtleta.getColumnModel().getColumn(13).setPreferredWidth(200);
        tabelaAtleta.getColumnModel().getColumn(14).setMinWidth(0);        
        tabelaAtleta.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    public void ajustarTabelaFrmPesquisaAtleta() {
        tabelaFrmPesquisa.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabelaFrmPesquisa.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabelaFrmPesquisa.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabelaFrmPesquisa.getColumnModel().getColumn(3).setPreferredWidth(250);
        tabelaFrmPesquisa.getColumnModel().getColumn(4).setPreferredWidth(250);
        tabelaFrmPesquisa.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabelaFrmPesquisa.getColumnModel().getColumn(6).setPreferredWidth(60);
        tabelaFrmPesquisa.getColumnModel().getColumn(7).setPreferredWidth(100);
        tabelaFrmPesquisa.getColumnModel().getColumn(8).setPreferredWidth(250);
        tabelaFrmPesquisa.getColumnModel().getColumn(9).setPreferredWidth(150);
    }

    public void ajustarTabelaFrmExamePesquisaExame() {
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(5).setMinWidth(0);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(5).setMaxWidth(0);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(6).setMinWidth(0);
        jTableFrmExamePesquisaExame.getColumnModel().getColumn(6).setMaxWidth(0);
    }
    
    public void ajustarTabelaFrmExamePesquisaAtleta() {
        jTableFrmExamePesquisaAtleta.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableFrmExamePesquisaAtleta.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTableFrmExamePesquisaAtleta.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableFrmExamePesquisaAtleta.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTableFrmExamePesquisaAtleta.getColumnModel().getColumn(4).setMinWidth(0);
        jTableFrmExamePesquisaAtleta.getColumnModel().getColumn(4).setMaxWidth(0);
    }
}
