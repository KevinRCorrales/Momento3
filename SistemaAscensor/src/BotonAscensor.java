public class BotonAscensor extends Boton {
    Piso numeroPiso;
    public BotonAscensor(boolean esPresionado, Piso numeroPiso) {
        super(esPresionado);
        this.numeroPiso = numeroPiso;
    }
}
