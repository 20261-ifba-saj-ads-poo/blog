
public class ContaSynchronized extends Conta {

    public synchronized void deposita(int valor) {
        super.deposita(valor);
    }

    public synchronized void saca(int valor) {
        super.saca(valor);
    }
}
