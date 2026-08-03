package code.taxonomialineu;

import java.util.Optional;

public class Especie {
    private String nome;
    private Optional<Genero> genero;

    public Especie(String nome, Genero genero) {
        this.nome = nome;
        this.genero = Optional.ofNullable(genero);
    }

    public String getDescricao() {

        return genero.map(Genero::getNome).orElse("") + "\nEspecie " + nome;
    }

}
