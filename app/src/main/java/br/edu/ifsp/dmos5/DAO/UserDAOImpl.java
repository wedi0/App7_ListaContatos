package br.edu.ifsp.dmos5.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmos5.Model.Contact;

public class UserDAOImpl implements UserDAO{

    private List<Model.User> database;

    public UserDAOImpl() {

        database = new ArrayList<>();

        database.add(new Model.User("Wedi000", "senha123" ));
        database.add(new Model.User("TG", "senha123" ));
        database.add(new Model.User("VAG", "senha123" ));
        database.add(new Model.User("Ronaldo", "senha123" ));
        database.add(new Model.User("Kalica", "senha123" ));
        database.add(new Model.User("Funkeiro123", "senha123" ));
        database.add(new Model.User("RonaldinhoSoccer", "senha123" ));
        database.add(new Model.User("Wedi01", "senha123" ));
        database.add(new Model.User("McGui", "senha123" ));

    }
    @Override
    public void addUser(Model.User user) {
        if(user != null){
            database.add(user);
        }
    }

    @Override
    public Model.User findbyUsername(Model.User user) {

        return database.stream().filter(user1 -> user1.getUsername() == user.getUsername()).findAny().orElse(null);
    }

    @Override
    public List<Model.User> findAllUsers() {

        return database;
    }

    @Override
    public void addContacts(Contact contato, Model.User user) {
        user.setContatos(contato);
    }

    @Override
    public List<Contact> findAllContacts(Model.User user) {
        return user.getContatos();
    }
}
