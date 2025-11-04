public class Ascensor {
    private int pisoAscensor;
    private boolean enMovimiento;

    public Ascensor(int pisoAscensor, boolean enMovimiento) {
        this.pisoAscensor = pisoAscensor;
        this.enMovimiento = enMovimiento;
    }

    public int getPisoAscensor() {
        return pisoAscensor;
    }

    public void recorrerPisos(int diferencia) {
        pisoAscensor += diferencia;
    }

    public boolean getEnMovimiento() {
        return enMovimiento;
    }
}
