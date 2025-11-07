public class Usuario {
    private Piso pisoActual;

    public Usuario(Piso pisoActual) {
        this.pisoActual = pisoActual;
        // Generar llamada en el piso actual
        if (pisoActual.esPrimerPiso()) {
            pisoActual.botonSubirLlamar();
        } else if (pisoActual.esUltimoPiso()) {
            pisoActual.botonBajarLlamar();
        } else  {
            pisoActual.botonSubirLlamar();
        }
    }

    public Piso getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(Piso pisoActual) {
        this.pisoActual = pisoActual;
    }
}
