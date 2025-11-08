public class Puerta {
    private boolean abierta;
    private boolean malEstado;

    public Puerta(boolean abierta, boolean malEstado) {
        this.abierta = abierta;
        this.malEstado = malEstado;
    }

    public boolean getAbierta() {
        return abierta;
    }

    public void abrir() {
        System.out.println("Se ha abierto la puerta");
        abierta = true;
    }

    public void cerrar() {
        System.out.println("Se ha cerrado la puerta");
        abierta = false;
    }

    public void setMalEstado(boolean malEstado) {
        this.malEstado = malEstado;
    }

    public boolean getMalEstado() {
        return malEstado;
    }
}
