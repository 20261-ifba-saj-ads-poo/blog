import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteControle {
    private static final String IP = "10.26.103.66";
    private static final int PORTA = 12345;

    public static void main(String[] args) {
        System.out.println("Conectando ao jogo Greenfoot...");
        try (Socket socket = new Socket(IP, PORTA);
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Conectado com sucesso!");
            System.out.println("Use os comandos: W (cima), S (baixo), A (esquerda), D (direita)");
            System.out.println("Digite a letra e aperte ENTER para mover o seu boneco.");

            Scanner teclado = new Scanner(System.in);
            while (teclado.hasNextLine()) {
                String linha = teclado.nextLine().toUpperCase();
                if (linha.equals("SAIR")) {
                    break;
                }
                saida.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro na comunicação com o servidor: " + e.getMessage());
        }
    }
}
