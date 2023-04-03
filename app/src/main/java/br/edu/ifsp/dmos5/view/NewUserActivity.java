package br.edu.ifsp.dmos5.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.dmos5.R;

public class NewUserActivity extends AppCompatActivity {
    private EditText inputUser, inputPassword;
    private Button btn_salvar;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_newuser);
        initializer();
    }

    public void initializer(){
        inputUser= findViewById(R.id.eddittext_);
        inputPassword =findViewById(R.id.edittext_password);
        btn_login= findViewById(R.id.buttonLogin);
        btn_newUser = findViewById(R.id.buttonNewUser);
    }
}
