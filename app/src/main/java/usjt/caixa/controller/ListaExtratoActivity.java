package usjt.caixa.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Arrays;

import usjt.caixa.R;
import usjt.caixa.model.Extrato;
import usjt.caixa.model.ExtratoAdapter;

public class ListaExtratoActivity extends AppCompatActivity {

    public static final String DATA = "usjt.caixa.data";
    public static final String OPERACAO = "usjt.caixa.eoperacao";
    public static final String VALOR = "usjt.caixa.valor";
    private Activity atividade;
    private Extrato[] lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_extrato);
        atividade = this;
        Intent intent = getIntent();
        lista = (Extrato[]) intent.getSerializableExtra(MenuActivity.LISTA);
        Arrays.sort(lista);
        BaseAdapter adapter = new ExtratoAdapter(this, lista);
        ListView listView = (ListView) findViewById(R.id.lista_extratos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(atividade, DetalheExtratoActivity.class);
                intent.putExtra(DATA, lista[position].getData());
                intent.putExtra(OPERACAO, lista[position].getOperacao());
                intent.putExtra(VALOR, "R$" + lista[position].getValor());
                startActivity(intent);
            }
        });
    }
}
