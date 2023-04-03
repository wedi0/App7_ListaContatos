package br.edu.ifsp.dmos5.Model;

import java.util.List;

import br.edu.ifsp.dmos5.Model.Contact;
import br.edu.ifsp.dmos5.view.MD5.Criptografia;

public class User {
    private String username;
    private String senha;
    private List<Contact> contatos;




    public User(String username, String senha) {
        this.username = username;
        this.senha = criptografando(senha);

    }

    public String criptografando(String senha){

        return Criptografia.criptografarSenha(senha);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return Criptografia.criptografarSenha(senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Contact> getContatos() {
        return contatos;
    }

    public void setContatos(Contact contato) {
        contatos.add(contato);
    }
}
