package usjt.caixa.model;

public class DebitoAutomatico {
    private int id;
    private int operadora;
    private int consumidor;
    private String data;
    private double valor;
    private Conta conta;

    public DebitoAutomatico(int id, int operadora, int consumidor, String data, double valor, Conta conta) {
        this.id = id;
        this.operadora = operadora;
        this.consumidor = consumidor;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
    }

    public DebitoAutomatico(int operadora, int consumidor, String data, double valor, Conta conta) {
        this.operadora = operadora;
        this.consumidor = consumidor;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOperadora() {
        return operadora;
    }

    public void setOperadora(int operadora) {
        this.operadora = operadora;
    }

    public int getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(int consumidor) {
        this.consumidor = consumidor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}