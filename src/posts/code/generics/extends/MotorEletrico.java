public class MotorEletrico extends Motor {
    private int potenciaKW;

    public int getPotenciaKW() {
        return potenciaKW;
    }

    public MotorEletrico(int potenciaKW) {
        this.potenciaKW = potenciaKW;
    }

    @Override
    public String toString() {
        return "Motor Elétrico (" + potenciaKW + "kW)";
    }
}