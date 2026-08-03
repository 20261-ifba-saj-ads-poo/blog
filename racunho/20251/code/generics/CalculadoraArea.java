public class CalculadoraArea<T extends FormaGeometrica> {
    private T forma;

    public CalculadoraArea(T forma) {
        this.forma = forma;
    }

    public double calcular() {
        return forma.calcularArea();
    }
}