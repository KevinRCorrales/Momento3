public class Ascensor {
    private int pisoAscensor;
    private boolean enMovimiento;
    private Puerta puerta;
    private Usuario usuario;
    private Boton[] botones;

    public Ascensor(int pisoAscensor, boolean enMovimiento, Puerta puerta, Usuario usuario, Boton[] botones) {
        this.pisoAscensor = pisoAscensor;
        this.enMovimiento = enMovimiento;
        this.puerta = puerta;
        this.usuario = usuario;
        this.botones = botones;
    }

    public int getPisoAscensor() {
        return pisoAscensor;
    }

    public void recorrerPisos(int diferencia) {
        System.out.println("Entra al ascensor antes de que cierre...");
        puerta.cerrar();
        System.out.println("Iniciando recorrido...");
        pisoAscensor += diferencia;
        System.out.println("Recorrido finalizado...");
        usuario.setPisoActual(pisoAscensor);
        System.out.println("Abriendo puerta...");
        puerta.abrir();
        System.out.println("Puede salir...");
        puerta.cerrar();
    }

    public boolean getEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
}
