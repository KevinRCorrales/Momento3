public class BotonPiso extends Boton {
    public BotonPiso(boolean esPresionado, boolean malEstado) {
        super(esPresionado, malEstado);
    }

    @Override
    public void presionar() {
        System.out.println("Solicitud recibida...");
        esPresionado = true;
    }
}
