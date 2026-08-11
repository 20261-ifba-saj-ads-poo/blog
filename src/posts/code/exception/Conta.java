
public class Conta {
    double saldo;

    public Conta(double saldo) {
        if(saldo < 0){
            throw new IllegalArgumentException("Saldo não pode ser negativo!");
        }
        this.saldo = saldo;
    }

    void sacar(double quantidade) throws SaldoInsuficienteException {
        if (quantidade > saldo) {
            throw new SaldoInsuficienteException(this);            
        }
        saldo -= quantidade;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        
        try {
            Conta c1 = new Conta(-100);
            c1.sacar(100);
            IO.println("Saque realizado com sucesso");
            IO.println("Saldo atual:" + c1.getSaldo());
        } catch (SaldoInsuficienteException e) {         
              
            IO.println("Saque não pode ser realizado");
            IO.println("Saldo atual: " + e.getConta().getSaldo());
        } catch (Exception ex) {
            IO.println("Conta não pode ser criada");
        }
        
    }
}

class SaldoInsuficienteException extends Exception {
    Conta conta;

    SaldoInsuficienteException(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

}