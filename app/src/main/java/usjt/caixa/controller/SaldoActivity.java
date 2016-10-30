package usjt.caixa.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import usjt.caixa.R;

public class SaldoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);
        Intent intent = getIntent();
        String valor = intent.getStringExtra(MenuActivity.SALDO);

        TextView saldo = (TextView) findViewById(R.id.saldo);
        saldo.setText("Saldo: " + valor);
    }
}
