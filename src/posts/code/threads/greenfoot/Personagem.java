import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Personagem extends Actor {
    private int id;

    public Personagem(int id) {
        this.id = id;
        // Cria uma imagem simples para o personagem do cliente
        GreenfootImage img = new GreenfootImage(30, 30);
        img.setColor(Color.BLUE);
        img.fill();
        img.setColor(Color.WHITE);
        img.drawString("C" + id, 5, 20);
        setImage(img);
    }

    public void mover(String comando) {
        int x = getX();
        int y = getY();
        
        if (comando.equalsIgnoreCase("W")) y -= 10;
        if (comando.equalsIgnoreCase("S")) y += 10;
        if (comando.equalsIgnoreCase("A")) x -= 10;
        if (comando.equalsIgnoreCase("D")) x += 10;
        
        setLocation(x, y);
    }
}
