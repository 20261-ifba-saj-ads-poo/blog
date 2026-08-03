
public class Moto extends Veiculo {
    public Moto(String modelo, MotorCombustao motor) {
        super(modelo, motor);
    }

    @Override
    public void ligar() {
        //erro de tipo
        IO.println("Moto " + getModelo() + " com " + getMotor() + " está ligada com "+getMotor().getCilindradas()+" Cilindradas" );
    }
}
