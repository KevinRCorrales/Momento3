public class Piso {
    private int numero;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso(int numero, Boton botonSubir, Boton botonBajar) {
        this.numero = numero;
        this.botonSubir = botonSubir;
        this.botonBajar = botonBajar;
    }

    public void botonSubirLlamar() {
        botonSubir.presionar();
    }

    public void botonBajarLlamar() {
        botonBajar.presionar();
    }

    public int getNumero() {
        return numero;
    }

    public boolean esPrimerPiso() {
        return numero == 1;
    }

    public boolean esUltimoPiso() {
        return numero == 15;
    }

    @Override
    public String toString() {
        return "Piso: " + numero;
    }
}
