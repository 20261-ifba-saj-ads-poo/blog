import java.util.logging.Logger;
import java.util.stream.IntStream;

public class AppConta {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }
    static Logger LOGGER = Logger.getLogger(AppConta.class.getName());

    public static void main(String[] args) throws Exception {
        LOGGER.info("Testa Saca");
        Conta conta = new Conta();
        testaSacaConta(conta);
        Conta contaSynchronized = new ContaSynchronized();
        testaSacaConta(contaSynchronized);

        Thread.sleep(2000);
        LOGGER.info("conta saldo:" + conta.getSaldo());
        LOGGER.info("contaSynchronized saldo:" + contaSynchronized.getSaldo());
        LOGGER.info("Testa Deposita");
        conta.setSaldo(0);
        contaSynchronized.setSaldo(0);
        
        testaDepositaConta(conta);
        testaDepositaConta(contaSynchronized);
        Thread.sleep(2000);
        LOGGER.info("conta saldo:" + conta.getSaldo());
        LOGGER.info("contaSynchronized saldo:" + contaSynchronized.getSaldo());
        Thread.sleep(2000);
        LOGGER.info("contaSynchronized saldo:" + contaSynchronized.getSaldo());
        Thread.sleep(2000);
        LOGGER.info("contaSynchronized saldo:" + contaSynchronized.getSaldo());
        Thread.sleep(2000);
        LOGGER.info("contaSynchronized saldo:" + contaSynchronized.getSaldo());
    }

    private static void testaSacaConta(Conta conta) {
        IntStream.rangeClosed(1, 1000000).forEach(i -> {
            Thread.startVirtualThread(() -> {
                conta.saca(100);
            });
        });
    }
    private static void testaDepositaConta(Conta conta) {
        IntStream.rangeClosed(1, 1000000).forEach(i -> {
            Thread.startVirtualThread(() -> {
                conta.deposita(100);
            });
        });
    }
}
