public class Piso {
    private int numero;
    private boolean esUltimo;
    private boolean esPrimero;
    private Boton boton;

    public Piso(int numero, boolean esUltimo, boolean esPrimero, Boton boton) {
        this.numero = numero;
        this.esUltimo = esUltimo;
        this.esPrimero = esPrimero;
        this.boton = boton;
    }

    public boolean esUltimoPiso() {
        return esUltimo;
    }

    public boolean esPrimerPiso() {
        return esPrimero;
    }

    public void setEsPrimero(boolean esPrimero) {
        this.esPrimero = esPrimero;
    }

    public void setEsUltimo(boolean esUltimo) {
        this.esUltimo = esUltimo;
    }

    public void setBoton(Boton boton) {
        this.boton = boton;
    }

    public void botonLlamar() {
        boton.presionar();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Piso: " + numero;
    }
}
