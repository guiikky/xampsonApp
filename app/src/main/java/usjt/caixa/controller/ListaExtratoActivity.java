package usjt.caixa.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Arrays;

import usjt.caixa.R;
import usjt.caixa.model.Extrato;
import usjt.caixa.model.ExtratoAdapter;

public class ListaExtratoActivity extends AppCompatActivity {

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
    }
}
