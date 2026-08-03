package code.taxonomialineu;


public class Principal {
    public static void main(String[] args) {
        
        Reino reino = new Reino("Animalia");
        Filo filo = new Filo("Chordata", reino);
        Classe classe = new Classe("Mammalia", filo);
        Ordem ordem = new Ordem("Primata", classe);
        Familia familia = new Familia("Hominidae", ordem);
        Genero genero = new Genero("Homo", familia);
        Especie especie = new Especie("Homo sapiens ", genero);

        System.out.println(especie.getDescricao());   
        
        
    }
}
