package br.edu.ifsp.dmos5.DAO;

import java.util.List;

import br.edu.ifsp.dmos5.Model.Contact;

public interface UserDAO {

    void addUser(Model.User user);

    Model.User findbyUsername(Model.User user);

    List<Model.User> findAllUsers();

    void addContacts(Contact contato, Model.User user);

    List<Contact> findAllContacts(Model.User user);

}
