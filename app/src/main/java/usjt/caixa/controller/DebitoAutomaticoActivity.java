package usjt.caixa.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

import usjt.caixa.R;
import usjt.caixa.model.Conta;
import usjt.caixa.model.DebitoAutomatico;

public class DebitoAutomaticoActivity extends AppCompatActivity {

    private EditText ope;
    private EditText con;
    private EditText val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debito_automatico);
        ope = (EditText) findViewById(R.id.operadora);
        con = (EditText) findViewById(R.id.consumidor);
        val = (EditText) findViewById(R.id.valorDebito);
    }

    public void cadastrar(View view) {
        Intent intent = getIntent();
        int operadora = Integer.parseInt(ope.getText().toString());
        int consumidor = Integer.parseInt(con.getText().toString());
        double valor = Double.parseDouble(val.getText().toString());
        Conta conta = (Conta)intent.getSerializableExtra(MenuActivity.CONTA);
        Calendar cldr = Calendar.getInstance();
        String data = cldr.get(Calendar.DAY_OF_MONTH) + "/" + (cldr.get(Calendar.MONTH) + 1) + "/" + cldr.get(Calendar.YEAR);

        DebitoAutomatico debito = new DebitoAutomatico(operadora, consumidor, data, valor, conta);
    }
}
