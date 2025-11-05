public class Puerta {
    private boolean abierta;

    public Puerta(boolean abierta) {
        this.abierta = abierta;
    }

    public void abrir() {
        abierta = true;
    }

    public void cerrar() {
        abierta = false;
    }

    public boolean estaAbierta() {
        return abierta;
    }
}
