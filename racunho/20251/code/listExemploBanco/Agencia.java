package br.edu.ifba.saj.ads.poo.sistemabanco;

import java.util.ArrayList;


public class Agencia {
    private int numero;
    private ArrayList<Conta> contas;
    
    public Agencia(int numero) {
        this.numero = numero;
        contas = new ArrayList<>();
    }
    
    public int getNumero() {
        return numero;
    }

    public Conta criarConta(String cliente){
        //calcula o numero da nova conta
        int numeroConta = numero*100;
        numeroConta+= contas.size();
        //instancia nova conta com o numero calculado
        Conta novConta = new Conta(numeroConta, cliente);
        //guardo nova conta na minha lista de contas
        contas.add(novConta);
        //devolvo a conta para quem pediu
        return novConta;
    }

    public int totalContas() {
        return contas.size();
    }

    public double totalDinheiro() {
        double total = 0;
        for (int i = 0; i < contas.size(); i++) {
            total+= contas.get(i).getSaldo();
            
        }
        return total;
    }  
    public Conta getConta(int numeroConta) {
        // buscar a conta que tem o numero igual a numeroConta
        for (int i = 0; i < contas.size(); i++) {
            Conta c = contas.get(i);
            if(c.getNumero() == numeroConta){
                return c;
            }
        }
        return null;
        
  }
}
