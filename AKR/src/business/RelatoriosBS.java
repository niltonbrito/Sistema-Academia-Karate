package business;

/**
 *
 * @author nilton.brito
 */
@SuppressWarnings("unchecked")
public class RelatoriosBS {
/*
    Connection conexao = null;
    public void relExames() {
        // Gerando um relatório de serviços
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do relat�rio", "Aten��o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // Usando a classe JasperPrint para prepara a impress�o de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/servicos.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, null, conexao);
                // a linha abaixo exibe o relat�rio atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, """
                                                   Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                                                   """ + e.getMessage(), "Conex�o", 3);
            }
        }
    }

    public void relUsuarios() {
        // Gerando um relat�rio de servi�os
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do relat�rio", "Aten��o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // Usando a classe JasperPrint para prepara a impress�o de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/uruarios.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, null, conexao);
                // a linha abaixo exibe o relat�rio atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, """
                                                   Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                                                   """ + e.getMessage(), "Conex�o", 3);
            }
        }
    }
    public void relAtletas() {

        // Gerando um relat�rio de clientes
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do relat�rio", "Aten��o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // Usando a classe JasperPrint para prepara a impress�o de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/clientes.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, null, conexao);
                // a linha abaixo exibe o relat�rio atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, """
                                                   Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                                                   """ + e.getMessage(), "Conex�o", 3);
            }
        }

    }

    // Metodo para imprimir uma OS
    public void imprimirOs() {

        // imprimindo uma OS de clientes
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao da OS?", "Aten��o", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // A classe HashMap para criar um filtro
                HashMap filtro = new HashMap();
                filtro.put("id_os", Integer.valueOf(TelaOs.txtOs.getText()));
                // Usando a classe JasperPrint para prepara a impress�o de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/ordemservico.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, filtro, conexao);
                // a linha abaixo exibe o relat�rio atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar a OS " + e);
            } finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }*/
}
