public class BotonAscensor extends Boton {
    private Piso piso;
    public BotonAscensor(boolean esPresionado, Piso piso) {
        super(esPresionado);
        this.piso = piso;
    }

    public Piso getPiso() {
        return piso;
    }
}
