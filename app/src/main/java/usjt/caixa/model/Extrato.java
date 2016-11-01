package usjt.caixa.model;

import java.io.Serializable;

public class Extrato implements Comparable<Extrato>, Serializable {
    private int id;
    private String data;
    private String operacao;
    private double valor;
    private int conta;

    public Extrato(int id, String data, String operacao, double valor, int conta) {
        this.id = id;
        this.data = data;
        this.operacao = operacao;
        this.valor = valor;
        this.conta = conta;
    }

    public Extrato(String data, String operacao, double valor, int conta) {
        this.data = data;
        this.operacao = operacao;
        this.valor = valor;
        this.conta = conta;
    }

    public Extrato(String data, String operacao, double valor) {
        this.data = data;
        this.operacao = operacao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    @Override
    public int compareTo(Extrato o) {
        return getData().compareTo(o.getData());
    }
}
