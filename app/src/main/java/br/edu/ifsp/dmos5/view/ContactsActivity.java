package br.edu.ifsp.dmos5.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.dmos5.R;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TextView contactName, telefone;
    private Button btn_newContact;


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

    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
