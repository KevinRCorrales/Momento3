public class Usuario {
    private Piso pisoActual;

    public Usuario(Piso pisoActual) {
        this.pisoActual = pisoActual;
        // Generar llamada en el piso actual
        pisoActual.botonLlamar();
    }

    public Piso getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(Piso pisoActual) {
        this.pisoActual = pisoActual;
    }
}
