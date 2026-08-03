package code.taxonomialineu;

import java.util.Optional;

public class Filo {
    private String nome;
    private Reino reino;
    public Filo(String nome, Reino reino) {
        this.nome = nome;
        this.reino = reino;
    }
    @Override
    public String toString() {
        return Optional.ofNullable(reino).orElse(new Reino("")).toString()+"\nFilo " + nome;
    }
    
    
    
}
