public class Usuario {
    private Piso pisoActual;
    private Piso pisoDestino;

    public Usuario(Piso pisoActual, Piso pisoDestino) {
        this.pisoActual = pisoActual;
        this.pisoDestino = pisoDestino;
    }

    public Piso getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(Piso pisoActual) {
        this.pisoActual = pisoActual;
    }

    public Piso getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(Piso pisoDestino) {
        this.pisoDestino = pisoDestino;
    }
}
