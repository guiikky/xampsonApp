package usjt.caixa.model;

import android.widget.TextView;

public class ViewHolder {
    private TextView data, operacao, valor;

    public ViewHolder(TextView data, TextView operacao, TextView valor) {
        this.data = data;
        this.operacao = operacao;
        this.valor = valor;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    public TextView getOperacao() {
        return operacao;
    }

    public void setOperacao(TextView operacao) {
        this.operacao = operacao;
    }

    public TextView getValor() {
        return valor;
    }

    public void setValor(TextView valor) {
        this.valor = valor;
    }
}

