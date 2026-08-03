import java.util.concurrent.atomic.AtomicInteger;

public class ContaAtomic extends Conta {
    protected AtomicInteger saldoAtomico;

    public ContaAtomic() {
        setSaldo(0);
    }

    public void deposita(int valor) {
        saldoAtomico.addAndGet(valor);
    }

    public void saca(int valor) {
        saldoAtomico.getAndUpdate(saldoAtual -> {
            if (saldoAtual >= valor) {
                return saldoAtual - valor;
            }
            return saldoAtual; // Não altera se não tiver saldo suficiente
        });
    }

    public int getSaldo() {
        return saldoAtomico.get();
    }

    @Override
    public void setSaldo(int saldo) {
        // Evitar criar nova instância se já existir
        if (this.saldoAtomico == null) {
            this.saldoAtomico = new AtomicInteger(saldo);
        } else {
            this.saldoAtomico.set(saldo);
        }
    }

}
