package model;

import javax.swing.JTable;

/**
 *
 * @author nilton.brito
 */
public abstract class PessoaMD {

    private String id;
    private String nome;
    private String cpf;
    private String rg;
    private String celular;
    private String telefone;
    private String email;
    private String dataNasc;
    private String idade;
    private String sexo;
    public EnderecoMD endereco;

    private String dataCad;
    private String pesquisar;
    private String dataCadAtuali;
    private String abreviado;
    private String estado;

    private JTable tabelaPessoa;

    public PessoaMD() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    public String getDataCadAtuali() {
        return dataCadAtuali;
    }

    public void setDataCadAtuali(String dataCadAtuali) {
        this.dataCadAtuali = dataCadAtuali;
    }

    public JTable getTabelaPessoa() {
        return tabelaPessoa;
    }

    public void setTabelaPessoa(JTable tabelaPessoa) {
        this.tabelaPessoa = tabelaPessoa;
    }

    public String getAbreviado() {
        return abreviado;
    }

    public void setAbreviado(String abreviado) {
        this.abreviado = abreviado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
