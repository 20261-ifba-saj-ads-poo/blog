public class ConverterExtenso2Digitos extends ConverterExtenso1Digito {
    private int numero;
    private String[] porExtenso =  { "", "Dez", "Vinte", "Trinta", "Quarenta", "Cinquenta"}; 
    
    public ConverterExtenso2Digitos(int numero){
        super(numero%10);
        this.numero = numero;
    }

    @Override
    public String toString() {
        if(numero%10 == 0){
            return porExtenso[numero / 10];
        }else{
            return porExtenso[numero / 10] +" e "+ super.toString();
        }

    }
    
}
