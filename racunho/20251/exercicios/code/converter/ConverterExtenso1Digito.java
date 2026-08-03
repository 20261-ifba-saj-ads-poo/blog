public class ConverterExtenso1Digito extends ConverterExtenso {
    private int numero;
    private String[] porExtenso =  { "Zero", "Um", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove"}; 
    public ConverterExtenso1Digito(int numero){
        this.numero = numero;
    }

    @Override
    public String toString() {
        return porExtenso[numero%10];
    }
}
