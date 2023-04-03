package br.edu.ifsp.dmos5.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dmos5.DAO.UserDAO;
import br.edu.ifsp.dmos5.DAO.UserDAOImpl;
import br.edu.ifsp.dmos5.Model.Contact;
import br.edu.ifsp.dmos5.Model.User;
import br.edu.ifsp.dmos5.R;
import br.edu.ifsp.dmos5.view.MD5.Criptografia;
import br.edu.ifsp.dmos5.view.adapter.ContactSpinnerAdapter;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TextView contactName, telefone;
    private Button btn_newContact;
    private User user;
    private Spinner spinner;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initialize();


    }

    public void initialize(){

        contactName = findViewById(R.id.textview_contactName);
        telefone = findViewById(R.id.textview_Telefone);
        btn_newContact = findViewById(R.id.buttonNewContact);

        btn_newContact.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = (User) getIntent().getSerializableExtra("user");
        Bundle dados = getIntent().getExtras();
        String usuario = dados.getString(MainActivity.USUARIO);
        String senha = dados.getString(MainActivity.SENHA);

        UserDAO daoUser = (UserDAO) UserDAOImpl.getInstance();
        User user = daoUser.findbyUsername(usuario);

        if(!login(usuario, senha)){
            Toast.makeText(this, R.string.loginInvalid, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        pupulateSpinner(user);
    }

    private void pupulateSpinner(User user) {

        List<Contact> contatos;
        if(user.getContatos() == null){
            contatos = new ArrayList<>();
        }else{
            contatos = user.getContatos();
        }
        if(contatos.size() == 0 || contatos.get(0) != null){
            contatos.add(0,null);
        }
        ContactSpinnerAdapter adapter = new  ContactSpinnerAdapter(this, android.R.layout.simple_spinner_item, contatos);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        executeButton();
    }

    public void executeButton(){
        Intent intent = new Intent(this, NewContactActivity.class);
        Bundle parametros = getIntent().getExtras();
        intent.putExtras(parametros);
        startActivity(intent);
        finish();
    }

    public boolean login(String usuario, String senha){
        UserDAO dao = (UserDAO) UserDAOImpl.getInstance();
        User user = dao.findbyUsername(usuario);


        if(user.getSenha().equals(Criptografia.criptografarSenha(senha))){
            return true;
        }else {
            return false;
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Contact contact = ((ContactSpinnerAdapter) adapterView.getAdapter()).getItem(i);
        if(contact != null){
            openDetailsActivity(contact);
        }
    }

    private void openDetailsActivity(Contact contact) {
        if (contact != null) {
            contactName.setText(contact.getNomeCompleto());
            telefone.setText(contact.getTelefone());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner.setSelection(0);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
