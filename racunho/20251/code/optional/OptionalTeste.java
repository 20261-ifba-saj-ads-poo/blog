
import java.util.Optional;

public class OptionalTeste {
   public static void main(String[] args) {
      ClasseA classea1 = new ClasseA();
      classea1.setClasseB(new ClasseB("aaa"));
      //acessando diretamente
      System.out.println("classea1.getClasseB().getNome():"+classea1.getClasseB().getNome());
      //acessando pelo método que retorna o Optional<ClasseB>
      System.out.println("map(ClasseB::getNome)"+classea1.getOptionalClasseB().map(ClasseB::getNome).orElse("Sem nome"));      
      System.out.println("map(t -> t.getNome()).orElse"+classea1.getOptionalClasseB().map(t -> t.getNome()).orElse("Sem nome"));      
      System.out.println("flatMap"+classea1.getOptionalClasseB().flatMap(t -> Optional.ofNullable(t.getNome())).orElse("Sem nome"));

      if (classea1.getClasseB() != null) {
         System.out.println("if"+classea1.getClasseB().getNome());
      }else{
         System.out.println("Sem nome");
      }

   }

   private static Cliente buscaCliente(String string) {
      return null;
   }
}
