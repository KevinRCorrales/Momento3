public class Ascensor {
    private int pisoAscensor;
    private BotonPiso[] botonPiso;

    public Ascensor(BotonPiso[] botonPiso, int pisoAscensor) {
        this.botonPiso = botonPiso;
        this.pisoAscensor = pisoAscensor;
    }

    public int getPisoAscensor() {
        return pisoAscensor;
    }

    public int bajarPiso() {
        pisoAscensor--;
        return pisoAscensor;
    }

    public int subirPiso() {
        pisoAscensor++;
        return pisoAscensor;
    }
}
