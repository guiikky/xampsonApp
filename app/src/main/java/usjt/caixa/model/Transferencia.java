package usjt.caixa.model;

public class Transferencia {
    private Conta cop;
    private Conta cos;
    private String data;
    private double valor;

    public Transferencia(Conta cop, Conta cos, String data, double valor) {
        this.cop = cop;
        this.cos = cos;
        this.data = data;
        this.valor = valor;
    }

    public Conta getCop() {
        return cop;
    }

    public void setCop(Conta cop) {
        this.cop = cop;
    }

    public Conta getCos() {
        return cos;
    }

    public void setCos(Conta cos) {
        this.cos = cos;
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
}
