package br.edu.ifsp.dmos5.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.dmos5.DAO.UserDAO;
import br.edu.ifsp.dmos5.DAO.UserDAOImpl;
import br.edu.ifsp.dmos5.Model.User;
import br.edu.ifsp.dmos5.R;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputNome, inputPassword, inputConfPassword;
    private Button btn_salvar;
    private UserDAOImpl dados;
    private User anyUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        initializer();
    }

    public void initializer(){
        inputNome= findViewById(R.id.eddittext_newUser);
        inputPassword =findViewById(R.id.edittext_newSenha);
        inputConfPassword =findViewById(R.id.edittext_ConfnewSenha);
        btn_salvar = findViewById(R.id.buttonCadUser);

        btn_salvar.setOnClickListener(this);
    }

    public boolean checkPassword(String password1, String password2){

        if(password1.equals(password2)){
            return true;
        }else{
            return false;
        }

    }

    public boolean checkUser(UserDAOImpl dados, String nome){

        if(dados.findbyUsername(nome).getUsername().equals(nome)){
            return false;
        }else{
            return true;
        }

    }



    @Override
    public void onClick(View view) {
        executeBtn();
    }

    private void executeBtn() {
        dados = new UserDAOImpl();
        if(inputNome.getText().toString().isEmpty() || inputPassword.toString().isEmpty() || inputConfPassword.toString().isEmpty()) {
            Toast.makeText(this, R.string.campoVazio, Toast.LENGTH_SHORT).show();
            return;
        }else if (!checkPassword(inputPassword.toString(), inputConfPassword.toString())) {
            Toast.makeText(this, R.string.senha_diferente, Toast.LENGTH_SHORT).show();
            return;
        } else if (!checkUser(dados, inputNome.getText().toString())){
            Toast.makeText(this,R.string.usuarioJaExiste, Toast.LENGTH_SHORT).show();
            return;
        }else{
            anyUser = new User(inputNome.getText().toString(),inputPassword.toString());
            dados.addUser(anyUser);
            Toast.makeText(this, R.string.criacaoDeUserCompleta, Toast.LENGTH_LONG).show();
        }

    }
}
