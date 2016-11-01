package usjt.caixa.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

import usjt.caixa.R;
import usjt.caixa.model.CaixaRequester;
import usjt.caixa.model.Conta;

public class TransferenciaActivity extends AppCompatActivity {

    private EditText con;
    private EditText age;
    private EditText val;
    private CaixaRequester requester;
    private Activity atividade = this;
    private Conta cos;
    private Conta cop;

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
        final int conta = Integer.parseInt(con.getText().toString());
        final int agencia = Integer.parseInt(age.getText().toString());
        final double valor = Double.parseDouble(val.getText().toString());
        Calendar cldr = Calendar.getInstance();
        final String data = cldr.get(Calendar.DAY_OF_MONTH) + "/" + (cldr.get(Calendar.MONTH) + 1) + "/" + cldr.get(Calendar.YEAR);
        cop = (Conta)intent.getSerializableExtra(MenuActivity.CONTA);

        requester = new CaixaRequester();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cos = requester.validar(conta, agencia);
                if(cos.getConta()!= -1){
                    requester.transferencia(cop.getConta(), cos.getConta(), data, valor);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            atividade.finish();
                        }
                    });
                }
            }
        }).start();
    }
}
