package model;

/**
 *
 * @author nilton.brito
 */
public class AtletaMD extends PessoaMD {

    private String clube;
    private String faixa;
    private String categoria;
    private String tipoAtleta;
    private String idAtleta;
    private String idPadrao;

    public AtletaMD() {
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoAtleta() {
        return tipoAtleta;
    }

    public void setTipoAtleta(String tipoAtleta) {
        this.tipoAtleta = tipoAtleta;
    }

    public String getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(String idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getIdPadrao() {
        return idPadrao;
    }

    public void setIdPadrao(String idPadrao) {
        this.idPadrao = idPadrao;
    }
}
