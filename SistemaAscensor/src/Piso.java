public class Piso {
    private int numero;
    private boolean esUltimo;
    private boolean esPrimero;
    private Boton[] botones;

    public Piso(int numero, boolean esUltimo, boolean esPrimero, Boton[] botones) {
        this.numero = numero;
        this.esUltimo = esUltimo;
        this.esPrimero = esPrimero;
        this.botones = botones;
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

    public Boton botonSubir() {
        if (esPrimero) {
            return botones[0];
        } else if (!esPrimero && !esUltimo) {
            return botones[1];
        }
        return null; // Retornar que el botón no es válido
    }

    public Boton botonBajar() {
        if (esUltimo) {
            return botones[0];
        } else if (!esUltimo && !esPrimero) {
            return botones[1];
        }
        return null; // Tampoco válido
    }
}
