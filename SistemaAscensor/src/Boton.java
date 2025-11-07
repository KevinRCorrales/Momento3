public class Boton {
    private boolean esPresionado;
    public Boton(boolean esPresionado) {
        this.esPresionado = esPresionado;
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
}
