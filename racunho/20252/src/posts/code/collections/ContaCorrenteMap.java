import java.util.HashMap;
import java.util.Map;

class ContaCorrenteMap {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente();
        c1.deposita(10000);
        ContaCorrente c2 = new ContaCorrente();
        c2.deposita(3000);
        // cria o mapa
        Map<String, ContaCorrente> mapaDeContas = new HashMap<>();
        // adiciona duas chaves e seus respectivos valores
        mapaDeContas.put("diretor", c1);
        mapaDeContas.put("gerente", c2);
        // qual a conta do diretor? (sem casting!)
        ContaCorrente contaDoDiretor = mapaDeContas.get("diretor");
        System.out.println(contaDoDiretor.getSaldo());
            
    }
}
class ContaCorrente {
    private double saldo;   

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

}
