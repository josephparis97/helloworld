package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText mdp;
    private Button enreg;
    private Button dernier;

    private Controle controle;
    /*
    private void init(){
        login=findViewById(R.id.editTextlogin);
        mdp=findViewById(R.id.editTextmdp);
        enreg=findViewById(R.id.buttonenreg);
        dernier=findViewById(R.id.buttondernier);
        this.controle=Controle.getInstance(this);
    }
    */
    public void recupProfil()
    {
        login.setText(controle.getLogin());
        mdp.setText(controle.getMdp());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.editTextlogin);
        mdp=findViewById(R.id.editTextmdp);
        enreg=findViewById(R.id.buttonenreg);
        dernier=findViewById(R.id.buttondernier);
        this.controle=Controle.getInstance(this);

        controle.creerProfil("aze","gre");


        //controle.creerProfil("zef","sfz");
    }

}
