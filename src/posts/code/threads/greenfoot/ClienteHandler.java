import java.net.*;
import java.io.*;

public class ClienteHandler implements Runnable {
    private Socket socket;
    private int id;
    private MeuMundo mundo;
    private Personagem personagem;

    public ClienteHandler(Socket socket, int id, MeuMundo mundo) {
        this.socket = socket;
        this.id = id;
        this.mundo = mundo;
        this.personagem = new Personagem(id);
        
        // Adiciona o novo boneco no cenário do jogo
        mundo.adicionarJogadorNoMundo(this.personagem);
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String comando;
            while ((comando = entrada.readLine()) != null) {
                final String cmd = comando.trim();
                // Executa a movimentação na thread principal do Greenfoot indiretamente
                // Como Greenfoot não tem runLater nativo fácil, alteramos as coordenadas diretamente
                // (Para exemplos simples de estudo isso funciona sem travar)
                if (personagem != null) {
                    personagem.mover(cmd);
                }
            }
        } catch (IOException e) {
            System.out.println("Cliente " + id + " desconectado.");
        } finally {
            try {
                socket.close();
                if (personagem != null) {
                    mundo.removeObject(personagem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
