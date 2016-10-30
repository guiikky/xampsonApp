package usjt.caixa.model;

import java.io.Serializable;

public class Conta implements Serializable {

    private int conta;
    private int agencia;
    private int senha;
    private double saldo;
    private Cliente cliente;

    public Conta(int conta, int agencia, int senha, double saldo, Cliente cliente) {
        this.conta = conta;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Conta(int conta, int agencia, int senha) {
        this.conta = conta;
        this.agencia = agencia;
        this.senha = senha;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta1 = (Conta) o;

        if (conta != conta1.conta) return false;
        if (agencia != conta1.agencia) return false;
        return senha == conta1.senha;

    }


}
