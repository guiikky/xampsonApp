package usjt.caixa.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import usjt.caixa.R;
import usjt.caixa.model.Data;

public class MainActivity extends AppCompatActivity {

    public static final String POSICAO = "usjt.caixa.posicao";
    private EditText account;
    private EditText agency;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = (EditText) findViewById(R.id.conta);
        agency = (EditText) findViewById(R.id.agencia);
        password = (EditText) findViewById(R.id.senha);
    }

    public void logar(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        int conta = Integer.parseInt(account.getText().toString());
        int agencia = Integer.parseInt(agency.getText().toString());
        int senha = Integer.parseInt(password.getText().toString());

        int posicao = Data.vereficaDados(conta, agencia, senha);
        if (posicao != -1) {
            intent.putExtra(POSICAO, posicao);
            startActivity(intent);
        }
    }
}