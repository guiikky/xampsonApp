package usjt.caixa.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import usjt.caixa.R;
import usjt.caixa.model.CaixaRequester;
import usjt.caixa.model.Conta;

public class MainActivity extends AppCompatActivity {

    public static final String CONTA = "usjt.caixa.conta";
    private CaixaRequester requester;
    private Conta contaLogada;
    private Intent intent;
    private int idConta;
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
        final int conta = Integer.parseInt(account.getText().toString());
        final int agencia = Integer.parseInt(agency.getText().toString());
        final int senha = Integer.parseInt(password.getText().toString());
        intent = new Intent(this, MenuActivity.class);
        requester = new CaixaRequester();
        new Thread(new Runnable() {
            @Override
            public void run() {
                idConta = requester.validar(conta, agencia, senha);
//                if(idConta!=-1) {
                    contaLogada = requester.getConta(idConta);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra(CONTA, contaLogada);
                            startActivity(intent);
                        }
                    });
//                }
            }
        }).start();
    }
}