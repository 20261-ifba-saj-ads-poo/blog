
import java.util.Optional;

public class OptionalTesteCliente {
   public static void main(String[] args) {
      Cliente cliente1 = new Cliente("Leandro", null, new CNH());
      System.out.println(cliente1.getPassaport());
      System.out.println(cliente1.getCnh()
         .map(CNH::getNumero).orElse("Sem numero de CNH"));
      Cliente cliente2 = new Cliente("Leandro2", "0000", null);
      System.out.println(cliente2.getPassaport());
      System.out.println(cliente2.getCnh());
   }
}
