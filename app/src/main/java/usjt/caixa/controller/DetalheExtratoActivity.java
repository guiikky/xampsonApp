package usjt.caixa.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import usjt.caixa.R;

public class DetalheExtratoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_extrato);
        Intent intent = getIntent();
        String date = intent.getStringExtra(ListaExtratoActivity.DATA);
        String operation = intent.getStringExtra(ListaExtratoActivity.OPERACAO);
        String value = intent.getStringExtra(ListaExtratoActivity.VALOR);

        TextView data = (TextView) findViewById(R.id.dataDetalhe);
        TextView operacao = (TextView) findViewById(R.id.operacaoDetalhe);
        TextView valor = (TextView) findViewById(R.id.valorDetalhe);

        data.setText(date);
        operacao.setText(operation);
        valor.setText(value);
    }
}
