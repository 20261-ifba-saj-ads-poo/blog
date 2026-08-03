package code.taxonomialineu;

import java.util.Optional;

public class Familia {
    private String nome;
    private Ordem ordem;
    public Familia(String nome, Ordem ordem) {
        this.nome = nome;
        this.ordem = ordem;
    }
    @Override
    public String toString() {
        return Optional.ofNullable(ordem).orElse(new Ordem("", null)).toString()+"\nFamilia " + nome;
    }

    
    

}
