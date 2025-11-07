public class Boton {
    protected boolean esPresionado; // protected para permitir acceso en clases hijas
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
}
