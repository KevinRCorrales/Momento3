public class Boton {
    // protected para permitir acceso en clases hijas
    protected boolean esPresionado;
    protected boolean malEstado;
    public Boton(boolean esPresionado, boolean malEstado) {
        this.esPresionado = esPresionado;
        this.malEstado = malEstado;
    }

    public void presionar() {
        System.out.println("Luz del botón encendida");
        System.out.println("Timbre de aviso");
        esPresionado = true;
    }

    public boolean senialPresionado() {
        return esPresionado;
    }

    public void setEsPresionado(boolean esPresionado) {
        this.esPresionado = esPresionado;
    }

    public void setMalEstado(boolean malEstado) {
        this.malEstado = malEstado;
    }

    public boolean getMalEstado() {
        return malEstado;
    }
}
