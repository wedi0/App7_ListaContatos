package br.edu.ifsp.dmos5.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.dmos5.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputUser, inputPassword;
    private Button btn_login, btn_newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

     public void initialize(){
         inputUser= findViewById(R.id.eddittext_username);
         inputPassword =findViewById(R.id.edittext_password);
         btn_login= findViewById(R.id.buttonLogin);
         btn_newUser = findViewById(R.id.buttonNewUser);

         btn_newUser.setOnClickListener(this);
         btn_login.setOnClickListener(this);
     }


    public static final String USUARIO = "user";
    public static final String SENHA = "senha";


    @Override
    public void onClick(View view) {
        if(view == btn_login){
            login();
        }
        if (view == btn_newUser){
            newUser();
        }
    }

    public void login(){
        if(inputUser.getText().toString().isEmpty() || inputPassword.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.InvalidLogin, Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, ContactsActivity.class);
            Bundle dados = new Bundle();
            dados.putString(USUARIO, inputUser.getText().toString());
            dados.putString(SENHA, inputPassword.getText().toString());
            intent.putExtras(dados);
            startActivity(intent);
        }
    }

    public void newUser(){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }





}
