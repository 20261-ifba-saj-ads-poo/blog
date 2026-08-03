import java.io.FileNotFoundException;

public class AbrirArquivo {
    public static void metodo()  {
        try {
            new java.io.FileInputStream("arquivo.txt");            
        } catch (Exception e) {
            IO.println("Arquivo nao encontrado");
        }
    }
    public static void main(String[] args)  {
        metodo();
        IO.print("FINAL");
    }
}