package usjt.caixa.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

import usjt.caixa.R;
import usjt.caixa.model.Conta;
import usjt.caixa.model.Transferencia;

public class TransferenciaActivity extends AppCompatActivity {

    private EditText con;
    private EditText age;
    private EditText val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);
        con = (EditText) findViewById(R.id.contaTransferencia);
        age = (EditText) findViewById(R.id.agenciaTransferencia);
        val = (EditText) findViewById(R.id.valorTransferencia);
    }

    public void transferir(View view) {
        Intent intent = getIntent();
        int conta = Integer.parseInt(con.getText().toString());
        int agencia = Integer.parseInt(age.getText().toString());
        double valor = Double.parseDouble(val.getText().toString());
        Conta account = (Conta)intent.getSerializableExtra(MenuActivity.CONTA);
        Calendar cldr = Calendar.getInstance();
        String data = cldr.get(Calendar.DAY_OF_MONTH) + "/" + (cldr.get(Calendar.MONTH) + 1) + "/" + cldr.get(Calendar.YEAR);

        Transferencia transferencia = new Transferencia(account, new Conta(conta, agencia), data, valor);
    }
}
