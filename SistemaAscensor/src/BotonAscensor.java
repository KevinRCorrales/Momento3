public class BotonAscensor extends Boton {
    Piso piso;
    public BotonAscensor(boolean iluminacion, Piso piso) {
        super(iluminacion);
        this.piso = piso;
    }
}
