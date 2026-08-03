
import java.util.Optional;

public class Especie {
    private String nome;
    private Optional<Genero> genero;

    public Especie(String nome, Genero genero) {
        this.nome = nome;
        this.genero = Optional.ofNullable(genero);
    }

    public Optional<Genero> getGenero() {
        return genero;
    }

    public String getNome() {
        return genero.map(Genero::getNome).orElse(" Genero Não informado") + "\n Espécie " + nome ;
    }

}
