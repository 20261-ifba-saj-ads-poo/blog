import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.*;

public class MeuMundo extends World {
    private static final int PORTA = 12345;
    private Map<Integer, ClienteHandler> clientes = new HashMap<>();
    private int proximoId = 1;

    public MeuMundo() {    
        super(600, 400, 1); 
        prepararMundo();
        iniciarServidor();
    }

    private void prepararMundo() {
        showText("Aguardando conexões na porta " + PORTA, 300, 20);
    }

    private void iniciarServidor() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
                while (true) {
                    Socket socket = serverSocket.accept();
                    int id = proximoId++;
                    
                    // Cria o personagem no mundo (Thread do Greenfoot precisa gerenciar com cuidado, 
                    // mas para adicionar objetos simples o Greenfoot geralmente aceita de forma thread-safe básica)
                    ClienteHandler handler = new ClienteHandler(socket, id, this);
                    clientes.put(id, handler);
                    new Thread(handler).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Método sincronizado para adicionar o jogador com segurança no loop do Greenfoot
    public synchronized void adicionarJogadorNoMundo(Personagem novoJogador) {
        addObject(novoJogador, 300, 200);
    }
}
