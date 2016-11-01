package usjt.caixa.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CaixaRequester {
    OkHttpClient client = new OkHttpClient();
    private String url = "http://192.168.0.229:8080/Caixa";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public Conta getConta(int cont) {
        Conta contaLogada = null;
        try {
            Request request = new Request.Builder().url(url + "/conta1?conta=" + cont).build();
            Response response = client.newCall(request).execute();
            String retorno = response.body().string();
            JSONObject object = new JSONObject(retorno);
            int account = object.getInt("conta");
            int agencia = object.getInt("agencia");
            double saldo = object.getDouble("saldo");
            String cliente = object.getString("cliente");
            contaLogada = new Conta(account, agencia, saldo, new Cliente(cliente, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contaLogada;
    }

    public int validar(int conta, int agencia, int senha) {
        JSONObject json = new JSONObject();
        int contaLogada = -1;
        try {
            json.put("conta", conta);
            json.put("agencia", agencia);
            json.put("senha", senha);
            RequestBody body = RequestBody.create(JSON, json.toString());
            Request request = new Request.Builder().url(url + "/login1").post(body).build();
            Response response = client.newCall(request).execute();
            String retorno = response.body().string();
            JSONObject novo = new JSONObject(retorno);
            contaLogada = novo.getInt("conta");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contaLogada;
    }

    public Conta validar(int conta, int agencia) {
        Conta contaLogada = null;
        try {
            Request request = new Request.Builder().url(url + "/validar1?conta=" + conta + "&agencia=" + agencia).build();
            Response response = client.newCall(request).execute();
            String retorno = response.body().string();
            JSONObject object = new JSONObject(retorno);
            int account = object.getInt("conta");
            int agency = object.getInt("agencia");
            contaLogada = new Conta(account, agency);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contaLogada;
    }

    public void transferencia(int cop, int cos, String data, double valor) {
        JSONObject json = new JSONObject();
        try {
            json.put("cop", cop);
            json.put("cos", cos);
            json.put("data", data);
            json.put("valor", valor);
            RequestBody body = RequestBody.create(JSON, json.toString());
            Request request = new Request.Builder().url(url + "/transferencia1").post(body).build();
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Extrato> getExtrato(int cont) {
        ArrayList<Extrato> lista = new ArrayList<>();
        try {
            Request request = new Request.Builder().url(url + "/extrato1?conta=" + cont).build();
            Response response = client.newCall(request).execute();
            String retorno = response.body().string();
            JSONArray array = new JSONArray(retorno);
            for( int i = 0 ; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                String data = object.getString("data");
                String operacao = object.getString("operacao");
                double valor = object.getDouble("valor");
                lista.add(new Extrato(data, operacao, valor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
