package code.taxonomialineu;

import java.util.Optional;

public class Classe {
    private String nome;
    private Filo filo;
    public Classe(String nome, Filo filo) {
        this.nome = nome;
        this.filo = filo;
    }
    @Override
    public String toString() {
        return Optional.ofNullable(filo).orElse(new Filo("", null)).toString()+"\nClasse " + nome;
    }

}
