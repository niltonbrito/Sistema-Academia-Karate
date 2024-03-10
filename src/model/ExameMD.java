package model;

/**
 *
 * @author nilton.brito
 */
public class ExameMD extends AtletaMD {

    private String idExame;
    private String dataExame;
    private String tipoExame;
    private String corCertificado;

    public ExameMD() {
    }

    public String getIdExame() {
        return idExame;
    }

    public void setIdExame(String idExame) {
        this.idExame = idExame;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getCorCertificado() {
        return corCertificado;
    }

    public void setCorCertificado(String corCertificado) {
        this.corCertificado = corCertificado;
    }

}
