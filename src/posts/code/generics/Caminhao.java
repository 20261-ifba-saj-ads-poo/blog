
public class Caminhao extends Veiculo {
    public Caminhao(String modelo, MotorEletrico motor) {
        super(modelo, motor);
    }

    @Override
    public void ligar() {
        //erro de tipo
        IO.println("Caminhão Elétrico" + getModelo() + " com " + getMotor() + " está ligado com "+getMotor().getPotenciaKW()+" de Potencia" );
    }
    
}
