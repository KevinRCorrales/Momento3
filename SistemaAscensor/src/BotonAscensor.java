public class BotonAscensor extends Boton {
    private Piso piso;
    public BotonAscensor(boolean esPresionado, boolean malEstado, Piso piso) {
        super(esPresionado, malEstado);
        this.piso = piso;
    }

    public Piso getPiso() {
        return piso;
    }
}
