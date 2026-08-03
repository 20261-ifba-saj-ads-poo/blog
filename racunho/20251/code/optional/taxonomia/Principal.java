import java.util.Optional;

public class Principal {
    public static void main(String[] args) {

        Reino reino = new Reino("Animalia");
        Filo filo = new Filo("Chordata", reino);
        Classe classe = new Classe("Mammalia", filo);
        Ordem ordem = new Ordem("Primata", classe);
        Familia familia = new Familia("Hominidae", ordem);
        Genero genero = new Genero("Homo", familia);
        Especie especie = new Especie("Homo sapiens ", genero);

        String nomeReino = Optional.ofNullable(especie)
                .flatMap(Especie::getGenero)
                .flatMap(Genero::getFamilia)
                .flatMap(Familia::getOrdem)
                .flatMap(Ordem::getClasse)
                .flatMap(Classe::getFilo)
                .flatMap(Filo::getReino)
                .map(Reino::getNome)
                .orElse("Reino não encontrado");

        System.out.println("Reino da especie: "+nomeReino);

    }
}
