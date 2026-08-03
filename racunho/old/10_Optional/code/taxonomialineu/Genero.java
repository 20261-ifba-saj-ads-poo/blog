package code.taxonomialineu;

import java.util.Optional;

public class Genero {
    private String nome;
    private Familia familia;
    public Genero(String nome, Familia familia) {
        this.nome = nome;
        this.familia = familia;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return Optional.ofNullable(familia).orElse(new Familia("", null)).toString()+"\nGenero "+ nome;
    }

    

}
