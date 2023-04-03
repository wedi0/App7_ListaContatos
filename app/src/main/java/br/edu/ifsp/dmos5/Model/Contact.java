package br.edu.ifsp.dmos5.Model;

public class Contact {

    private String apelido;
    private String nomeCompleto;
    private String telefone;

    public Contact(String apelido, String nomeCompleto, String telefone) {
        this.apelido = apelido;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
