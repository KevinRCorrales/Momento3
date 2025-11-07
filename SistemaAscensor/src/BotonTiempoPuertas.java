public class BotonTiempoPuertas extends Boton{
    public BotonTiempoPuertas(boolean esPresionado, boolean malEstado) {
        super(esPresionado, malEstado);
    }

    @Override
    public void presionar() {
        System.out.println("Se esperará más tiempo para cerrar...");
        esPresionado = true;
    }

    @Override
    public String toString() {
        return "Mantener puertas más tiempo abiertas: -1";
    }
}
