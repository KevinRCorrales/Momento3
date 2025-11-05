import java.util.Scanner;

public class Ascensor {
    private int pisoAscensor;
    private boolean enMovimiento;
    private Puerta puerta;
    private Usuario usuario;
    private BotonAscensor[] botones;

    public Ascensor(int pisoAscensor, boolean enMovimiento, Puerta puerta, Usuario usuario, BotonAscensor[] botones) {
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
        for (BotonAscensor boton : botones) {
            System.out.println(boton.getPiso());
        }
        System.out.println("\nIngrese el piso al que quiere ir: ");
        Scanner sc = new Scanner(System.in);
        int pisoDestino = sc.nextInt();
        botones[pisoDestino - 1].presionar();
        puerta.cerrar();
        System.out.println("Iniciando recorrido...");
        pisoAscensor += diferencia;
        System.out.println("Recorrido finalizado...");
        usuario.setPisoActual(pisoAscensor);
        System.out.println("Abriendo puerta...");
        puerta.abrir();
        System.out.println("Puede salir...");
        puerta.cerrar();
        usuario.setPisoActual(pisoDestino);
    }

    public boolean getEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
}
