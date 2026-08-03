package code.taxonomialineu;

import java.util.Optional;

public class Ordem {
    private String nome;
    private Classe classe;
    public Ordem(String nome, Classe classe) {
        this.nome = nome;
        this.classe = classe;
    }
    @Override
    public String toString() {
        return Optional.ofNullable(classe).orElse(new Classe("", null)).toString()+"\nOrdem "+ nome;
    }


}
