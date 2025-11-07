public class Puerta {
    private boolean abierta;

    public Puerta(boolean abierta) {
        this.abierta = abierta;
    }

    public void abrir() {
        System.out.println("Se ha abierto la puerta");
        abierta = true;
    }

    public void cerrar() {
        System.out.println("Se ha cerrado la puerta");
        abierta = false;
    }

    public boolean estaAbierta() {
        return abierta;
    }
}
