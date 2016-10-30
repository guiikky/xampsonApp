package usjt.caixa.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import usjt.caixa.R;
import usjt.caixa.model.Conta;
import usjt.caixa.model.Data;
import usjt.caixa.model.DebitoAutomatico;
import usjt.caixa.model.Extrato;

public class MenuActivity extends AppCompatActivity {

    public static final String LISTA = "usjt.caixa.lista";
    public static final String SALDO = "usjt.caixa.saldo";
    public static final String CONTA = "usjt.caixa.conta";
    private Conta conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        int posicao = intent.getIntExtra(MainActivity.POSICAO, -1);
        conta = Data.listaDeContas()[posicao];
        TextView nome = (TextView) findViewById(R.id.nomeCliente);
        nome.setText(conta.getCliente().getNome());
    }

    public void extrato(View view) {
        Intent intent = new Intent(this, ListaExtratoActivity.class);
        Extrato[] lista = Data.listaDeExtrato(conta.getConta());
        intent.putExtra(LISTA, lista);
        startActivity(intent);
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
