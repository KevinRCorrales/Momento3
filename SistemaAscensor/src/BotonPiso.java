public class BotonPiso extends Boton {
    public BotonPiso(boolean esPresionado) {
        super(esPresionado);
    }

    @Override
    public void presionar() {
        System.out.println("Solicitud recibida...");
    }
}
