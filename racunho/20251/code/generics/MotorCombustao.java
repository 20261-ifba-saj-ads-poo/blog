public class MotorCombustao {
    private int cilindradas;

    public MotorCombustao(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "Motor Combustão (" + cilindradas + "cc)";
    }
}