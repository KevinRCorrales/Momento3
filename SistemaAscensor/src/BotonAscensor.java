public class BotonAscensor extends Boton {
    Piso piso;
    public BotonAscensor(boolean esPresionado, Piso piso) {
        super(esPresionado);
        this.piso = piso;
    }
}
