import java.util.Optional;

public class Genero {
    private String nome;
    private Optional<Familia> familia;
    public Genero(String nome, Familia familia) {
        this.nome = nome;
        this.familia = Optional.ofNullable(familia);
    }
    public Optional<Familia> getFamilia() {
        return familia;
    }

    public String getNome() {        
        return familia.map(Familia::getNome).orElse(" Familia Não informado") + "\nGenero " + nome ;
    }


}
