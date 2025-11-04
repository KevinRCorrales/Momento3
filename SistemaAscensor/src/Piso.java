public class Piso {
    private int numero;
    private boolean esUltimo;
    private boolean esPrimero;

    public Piso(int numero, boolean esUltimo, boolean esPrimero) {
        this.numero = numero;
        this.esUltimo = esUltimo;
        this.esPrimero = esPrimero;
    }

    public int numeroPiso() {
        return numero;
    }

    public boolean esUltimoPiso() {
        return esUltimo;
    }

    public boolean esPrimerPiso() {
        return esPrimero;
    }
}
