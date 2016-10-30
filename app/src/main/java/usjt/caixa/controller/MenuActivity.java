package usjt.caixa.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import usjt.caixa.R;
import usjt.caixa.model.Conta;
import usjt.caixa.model.Data;
import usjt.caixa.model.Extrato;

public class MenuActivity extends AppCompatActivity {

    public static final String LISTA = "usjt.caixa.lista";
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
}
