import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class AppContaAtomic {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("console.encoding", "UTF-8");
        Locale.setDefault(Locale.of("pt", "BR"));
    }
    static Logger LOGGER = Logger.getLogger(AppContaAtomic.class.getName());

    public static void main(String[] args) throws InterruptedException {

        ContaAtomic contaAtomic = new ContaAtomic();
        final int NUM_THREADS = 1000000;
        
        LOGGER.info("Testando Saque com ContaAtomic");
        LOGGER.info("Criando e iniciando as threads");
        processaMultiplos(contaAtomic, NUM_THREADS, () -> {
                contaAtomic.saca(100);
        });

        LOGGER.info("contaAtomic saldo:" + contaAtomic.getSaldo());

        LOGGER.info("Tesando deposita com ContaAtomic");
        LOGGER.info("Criando e iniciando as threads");

        processaMultiplos(contaAtomic, NUM_THREADS, () -> {
                contaAtomic.deposita(100);
        });

        LOGGER.info("contaAtomic saldo:" + contaAtomic.getSaldo());

        LOGGER.info("Zerando as contas");
        LOGGER.info("Criando e iniciando as threads");
        processaMultiplos(contaAtomic, NUM_THREADS, () -> {
                contaAtomic.saca(100);
        });

        LOGGER.info("contaAtomic saldo:" + contaAtomic.getSaldo());

    }

    private static void processaMultiplos(ContaAtomic contaAtomic, final int NUM_THREADS, Runnable operacao)
            throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(NUM_THREADS);
        LOGGER.info("Criando e iniciando as threads");
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    operacao.run();
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();        
    }
}
