package usjt.caixa.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ContaRequester {
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public Conta[] getContas(String url) throws IOException {
        Conta[] contas = new Conta[5];
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String strJson = response.body().string();

        try {
            JSONArray lista = new JSONArray(strJson);
            JSONObject item = null;
            for (int i = 0; i < lista.length(); i++) {
                item = lista.getJSONObject(i);
                int conta = item.getInt("conta");
                int agencia = item.getInt("agencia");
                int senha = item.getInt("senha");
                contas[i] = new Conta(conta, agencia, senha);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException();
        }
        return contas;
    }

    public Conta getConta(String url) throws IOException {
        Conta conta = null;
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String strJson = response.body().string();
        JSONObject object = null;

        try {
            object = new JSONObject(strJson);
            int account = object.getInt("conta");
            int agencia = object.getInt("agencia");
            int senha = object.getInt("senha");
            Cliente cliente = (Cliente) object.get("cliente");
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException();
        }
        return conta;
    }

    public String validar(String url, Conta conta) throws IOException {
        JSONObject json = new JSONObject();
        try {
            json.put("conta", conta.getConta());
            json.put("agencia", conta.getAgencia());
            json.put("senha", conta.getSenha());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
