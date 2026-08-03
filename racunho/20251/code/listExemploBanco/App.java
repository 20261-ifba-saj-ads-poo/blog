import br.edu.ifba.saj.ads.poo.sistemabanco.Agencia;
import br.edu.ifba.saj.ads.poo.sistemabanco.Conta;

public class App {

    
    public static void main(String[] args) throws Exception {

        Agencia ag1 = new Agencia(2);    
        int numeroConta1 = ag1.criarConta("Leandro");
        int numeroConta2 = ag1.criarConta("Isabela");
        Conta conta1 = ag1.getConta(numeroConta1);
        Conta conta2 = ag1.getConta(numeroConta2);
        //Somente mesmo pacote pode chamar o new
        //Conta conta3 = new Conta(0, null);// erro
        
        conta1.deposita(100.0);
        conta2.deposita(10.0);

        conta1.transferir(conta2, 50);
        System.out.println(conta1.toString());
        System.out.println(conta2);
        System.out.println("ag1.totalContas():"+ag1.totalContas());
        System.out.println("ag1.totalDinheiro():"+ag1.totalDinheiro());
        
        
    }
}
