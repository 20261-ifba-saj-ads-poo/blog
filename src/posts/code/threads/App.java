public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("inicio main");        
        MinhaThread ta = new MinhaThread("TA"); 
        ta.start();
        MinhaThread tb = new MinhaThread("TB"); 
        tb.start();
        Thread t1 = new Thread(new MeuRunnable("RA")); 
        t1.start();
        Thread t2 = new Thread(new MeuRunnable("RB")); 
        t2.start();
        System.out.println("fim main");
    }
}
