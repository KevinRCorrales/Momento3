import java.util.Scanner;

public class Ascensor {
    private Piso pisoAscensor;
    private Piso[] pisosEdificio;
    private boolean enMovimiento;
    private Puerta puerta;
    private Usuario usuario;
    private BotonAscensor[] botones;
    private boolean subiendo;

    public Ascensor(Piso pisoAscensor, Piso[] pisosEdificio, boolean enMovimiento, Puerta puerta, Usuario usuario, BotonAscensor[] botones, boolean subiendo) {
        this.pisoAscensor = pisoAscensor;
        this.pisosEdificio = pisosEdificio;
        this.enMovimiento = enMovimiento;
        this.puerta = puerta;
        this.usuario = usuario;
        this.botones = botones;
        this.subiendo = subiendo;
    }

    public Piso getPisoAscensor() {
        return pisoAscensor;
    }

    public void recorrerPisos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Atendiendo solicitud del usuario en el piso: " + usuario.getPisoActual());
        System.out.println("Entra al ascensor antes de que cierre...");
        for (BotonAscensor boton : botones) {
            System.out.println(boton.getPiso());
        }
        System.out.println("\nIngrese el piso al que quiere ir: ");
        Piso pisoDestino = pisosEdificio[sc.nextInt() - 1];
        botones[pisoDestino.getNumero() - 1].presionar();
        puerta.cerrar();
        System.out.println("Iniciando recorrido...");
        pisoAscensor = pisoDestino;
        System.out.println("Recorrido finalizado...");
        System.out.println("Abriendo puerta...");
        puerta.abrir();
        System.out.println("Puede salir...");
        puerta.cerrar();
        usuario.setPisoActual(pisoDestino);
        System.out.println("Usuario y ascensor ahora en el piso: " + usuario.getPisoActual().getNumero());
        System.out.println("------Buscando siguiente usuario--------\n");
    }

    public boolean getEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }

    public boolean getSubiendo() {
        return subiendo;
    }

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        // Setter para definir el nuevo usuario en el que se basará la petición
        this.usuario = usuario;
    }

    public void setPisoAscensor(Piso pisoAscensor) {
        this.pisoAscensor = pisoAscensor;
    }
}
