public class Piso {
    private int numero;
    private Boton boton;

    public Piso(int numero, Boton boton) {
        this.numero = numero;
        this.boton = boton;
    }

    public void botonLlamar() {
        boton.presionar();
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Piso: " + numero;
    }
}
