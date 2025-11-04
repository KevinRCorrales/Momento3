public class SistemaControl {
    private Piso[] pisos;
    private int[] pisoLlamadas;
    private Ascensor ascensor;

    public SistemaControl(Piso[] pisos, int[] pisoLlamadas) {
        // Crear un objeto ascensor y asignarle botones por piso
        BotonPiso[] botonPiso = new BotonPiso[pisos.length];
        for (int i = 0; i < botonPiso.length; i++) {
            botonPiso[i] = new BotonPiso(false);
        }
        ascensor = new Ascensor(botonPiso, 7); // Simular un piso cualquiera para el objeto

        this.pisoLlamadas = pisoLlamadas;
    }

    public void llamarAscensor() {
        int pisoAscensor = ascensor.getPisoAscensor();
        int[] diferencias = new int[pisoLlamadas.length];
        for (int i = 0; i < pisoLlamadas.length; i++) {
            if (pisoLlamadas[i] > pisoAscensor) {
                diferencias[i] = pisoLlamadas[i] - pisoAscensor;
            } else {
                diferencias[i] = pisoAscensor - pisoLlamadas[i];
            }
        }
    }
}
