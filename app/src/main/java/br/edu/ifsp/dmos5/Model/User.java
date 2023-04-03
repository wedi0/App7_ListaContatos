package Model;

import java.util.List;

import br.edu.ifsp.dmos5.Model.Contact;

public class User {
    private String username;
    private String senha;
    private List<Contact> contatos;



    public User(String username, String senha) {
        this.username = username;
        this.senha = senha;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
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
