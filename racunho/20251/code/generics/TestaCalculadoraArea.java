public class TestaCalculadoraArea {
    public static void main(String[] args) {
        // Criando formas geométricas
        Circulo circulo = new Circulo(5.0);
        Retangulo retangulo = new Retangulo(4.0, 6.0);

        // Calculando áreas
        CalculadoraArea<Circulo> calculadoraCirculo = new CalculadoraArea<>(circulo);
        CalculadoraArea<Retangulo> calculadoraRetangulo = new CalculadoraArea<>(retangulo);

        System.out.println("Área do círculo: " + calculadoraCirculo.calcular());
        System.out.println("Área do retângulo: " + calculadoraRetangulo.calcular());
    }
}