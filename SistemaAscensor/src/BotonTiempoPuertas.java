public class BotonTiempoPuertas extends Boton{
    public BotonTiempoPuertas(boolean esPresionado) {
        super(esPresionado);
    }

    @Override
    public void presionar() {
        System.out.println("Esperando más tiempo para cerrar...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        esPresionado = true;
    }

    @Override
    public String toString() {
        return "Mantener puertas más tiempo abiertas: -1";
    }
}
