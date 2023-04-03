package br.edu.ifsp.dmos5.DAO;

import java.util.List;

import br.edu.ifsp.dmos5.Model.Contact;
import br.edu.ifsp.dmos5.Model.User;

public interface UserDAO {

    void addUser(User user);

    User findbyUsername(String nome);

    List<User> findAllUsers();

    void addContacts(Contact contato, User user);

    List<Contact> findAllContacts(User user);

}
