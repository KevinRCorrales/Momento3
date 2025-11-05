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

    public void setBotones(Boton[] botones) {
        this.botones = botones;
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
