package usjt.caixa.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import usjt.caixa.R;
import usjt.caixa.model.CaixaRequester;
import usjt.caixa.model.Conta;
import usjt.caixa.model.Extrato;

public class MenuActivity extends AppCompatActivity {

    public static final String LISTA = "usjt.caixa.lista";
    public static final String SALDO = "usjt.caixa.saldo";
    public static final String CONTA = "usjt.caixa.conta";
    private Activity atividade = this;
    private Extrato[] lista;
    private CaixaRequester requester;
    private Conta conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        conta = (Conta)intent.getSerializableExtra(MainActivity.CONTA);
        TextView nome = (TextView) findViewById(R.id.nomeCliente);
        nome.setText(conta.getCliente().getNome());
    }

    public void extrato(View view) {

        requester = new CaixaRequester();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lista = requester.getExtrato(conta.getConta()).toArray(new Extrato[0]);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(atividade, ListaExtratoActivity.class);
                        intent.putExtra(LISTA, lista);
                        startActivity(intent);
                    }
                });
            }
        }).start();
    }

    public void saldo(View view) {
        Intent intent = new Intent(this, SaldoActivity.class);
        intent.putExtra(SALDO, "R$" + conta.getSaldo());
        startActivity(intent);
    }

    public void transferencia(View view){
        Intent intent = new Intent(this, TransferenciaActivity.class);
        intent.putExtra(CONTA, conta);
        startActivity(intent);
    }

    public void debitoAutomatico(View view) {
        Intent intent = new Intent(this, DebitoAutomaticoActivity.class);
        intent.putExtra(CONTA, conta);
        startActivity(intent);
    }
}
