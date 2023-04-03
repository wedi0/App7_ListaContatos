package br.edu.ifsp.dmos5.DAO;

import android.graphics.ColorSpace;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmos5.Model.Contact;
import br.edu.ifsp.dmos5.Model.User;

public class UserDAOImpl implements UserDAO{
    /* Instanciando usando singleton */
    private static List<User> database = null;

    public UserDAOImpl() {}

    public static List<User> getInstance(){
        if(database == null){
            database = new ArrayList<>();

            database.add(new User("Wedi000", "senha123" ));
            database.add(new User("TG", "senha123" ));
            database.add(new User("VAG", "senha123" ));
            database.add(new User("Ronaldo", "senha123" ));
            database.add(new User("Kalica", "senha123" ));
            database.add(new User("Funkeiro123", "senha123" ));
            database.add(new User("RonaldinhoSoccer", "senha123" ));
            database.add(new User("Wedi01", "senha123" ));
            database.add(new User("McGui", "senha123" ));
        }
        return database;
    }

    @Override
    public void addUser(User user) {


        if(user != null){
            database.add(user);
        }
    }

    @Override
    public User findbyUsername(String nome) {

        return database.stream().filter(user -> user.getUsername().equals(nome))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> findAllUsers() {

        return database;
    }

    @Override
    public void addContacts(Contact contato, User user) {
        user.setContatos(contato);
    }

    @Override
    public List<Contact> findAllContacts(User user) {
        return user.getContatos();
    }
}
