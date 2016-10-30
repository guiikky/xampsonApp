package usjt.caixa.model;

import java.util.ArrayList;

public class Data {

    public static Conta[] listaDeContas() {
        Conta lista[] = new Conta[5];
        lista[0] = new Conta(2145987, 9999, 9630, 5000.0, new Cliente("Walter White", 1));
        lista[1] = new Conta(2385998, 9999, 7845, 300.0, new Cliente("Han Solo", 1));
        lista[2] = new Conta(2395784, 9999, 2389, 20.0, new Cliente("Han Solo", 1));
        lista[3] = new Conta(2398468, 9999, 4748, 150.0, new Cliente("Peter Parker", 1));
        lista[4] = new Conta(2587415, 9999, 5689, 800.0, new Cliente("Lisa Simpson", 2));
        return lista;
    }

    public static int vereficaDados(int conta, int agencia, int senha) {
        Conta lista[] = listaDeContas();
        Conta account = new Conta(conta, agencia, senha);
        for (int i = 0; i < lista.length; i++) {
            if (account.equals(lista[i])) {
                return i;
            }
        }
        return -1;
    }

    public static Extrato[] listaDeExtrato() {
        Extrato[] lista = new Extrato[24];
        lista[0] = new Extrato("27/10/2016", "Transferencia", 70, 2145987);
        lista[1] = new Extrato("27/10/2016", "Saque", 50, 2145987);
        lista[2] = new Extrato("27/10/2016", "DebitoAutomatico", 100, 2145987);
        lista[3] = new Extrato("27/10/2016", "Transferencia", 20, 2385998);
        lista[4] = new Extrato("27/10/2016", "Saque", 200, 2385998);
        lista[5] = new Extrato("27/10/2016", "DebitoAutomatico", 80, 2385998);
        lista[6] = new Extrato("27/10/2016", "Transferencia", 70, 2395784);
        lista[7] = new Extrato("27/10/2016", "Saque", 40, 2395784);
        lista[8] = new Extrato("27/10/2016", "DebitoAutomatico", 300, 2395784);
        lista[9] = new Extrato("27/10/2016", "Transferencia", 500, 2398468);
        lista[10] = new Extrato("27/10/2016", "Saque", 60, 2398468);
        lista[11] = new Extrato("27/10/2016", "DebitoAutomatico", 100, 2398468);
        lista[12] = new Extrato("27/10/2016", "Transferencia", 70, 2587415);
        lista[13] = new Extrato("27/10/2016", "Saque", 50, 2587415);
        lista[14] = new Extrato("27/10/2016", "DebitoAutomatico", 400, 2587415);
        lista[15] = new Extrato("31/10/2016", "Transferencia", 70, 2145987);
        lista[16] = new Extrato("30/10/2016", "Saque", 50, 2145987);
        lista[17] = new Extrato("26/10/2016", "DebitoAutomatico", 100, 2145987);
        lista[18] = new Extrato("31/10/2016", "Transferencia", 70, 2145987);
        lista[19] = new Extrato("30/10/2016", "Saque", 50, 2145987);
        lista[20] = new Extrato("26/10/2016", "DebitoAutomatico", 100, 2145987);
        lista[21] = new Extrato("31/10/2016", "Transferencia", 70, 2145987);
        lista[22] = new Extrato("30/10/2016", "Saque", 50, 2145987);
        lista[23] = new Extrato("26/10/2016", "DebitoAutomatico", 100, 2145987);
        return lista;
    }

    public static Extrato[] listaDeExtrato(int conta) {
        ArrayList<Extrato> lista = new ArrayList<>();
        Extrato[] vet = listaDeExtrato();
        for (int i = 0; i < vet.length; i++) {
            if (vet[i].getConta() == conta) {
                lista.add(vet[i]);
            }
        }
        return lista.toArray(new Extrato[0]);
    }


}
