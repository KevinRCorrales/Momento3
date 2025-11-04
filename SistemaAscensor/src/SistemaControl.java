import java.util.Scanner;

public class SistemaControl {
    private int[] pisoLlamadas;
    private Usuario[] usuarios;
    private Ascensor ascensor;

    public SistemaControl(int[] pisoLlamadas, Usuario[] usuarios) {
        ascensor = new Ascensor(7, false); // Simular un piso cualquiera para el objeto
        this.pisoLlamadas = pisoLlamadas;
        this.usuarios = usuarios;
    }

    public void llamarAscensor() {

    }

    public void menuAscensor() {
        Scanner sc = new Scanner(System.in);
        int solicitud; // Inicializar variable para almacenar lecturas

        // Crear pisos para el edificio
        int pisos = 15;
        Piso[] pisoArray = new Piso[pisos];
        for (int i = 0; i < pisos; i++) {
            if (i == 0) {
                pisoArray[i] = new Piso(1, false, true);
            } else if (i == 14) {
                pisoArray[i] = new Piso(15, false, true);
            } else {
                pisoArray[i] = new Piso(i, false, false);
            }
        }
        // Usar el primer usuario para mí
        boolean usuarioPrimerPiso = pisoArray[usuarios[0].getPisoActual() - 1].esPrimerPiso();
        boolean usuarioUltimoPiso = pisoArray[usuarios[0].getPisoActual() - 1].esUltimoPiso();
        // Crear botón de piso apagado
        Boton botonSubir = new BotonPiso(false);
        Boton botonBajar  = new BotonPiso(false);
        while(true){
            System.out.println("Piso actual del ascensor: " + ascensor.getPisoAscensor());
            System.out.println("Usted desea:");
            if (usuarioPrimerPiso){
                System.out.println("1. Subir");
            } else if (usuarioUltimoPiso) {
                System.out.println("1. Bajar");
            } else {
                System.out.println("1. Subir");
                System.out.println("2. Bajar");
            }
            System.out.println("0. Salir de la solicitud de ascensor.");
            System.out.println("Ingrese la solicitud: ");
            solicitud = sc.nextInt();
            if (solicitud == 0) {
                System.exit(0);
            } else if (solicitud == 1 && usuarioPrimerPiso) {
                botonSubir.presionar();
            } else if (solicitud == 1 && usuarioUltimoPiso) {
                botonBajar.presionar();
            } else if ((usuarioUltimoPiso || usuarioPrimerPiso) && solicitud > 1) { // Evitar solicitudes de tipo 2 a usuarios en primer o último piso
                System.out.println("Solicitud incorrecta");
            } else if (solicitud == 1) { // Cuando el usuario está simplemente en un piso intermedio
                botonSubir.presionar();
            } else if (solicitud == 2) {
                botonBajar.presionar();
            } else {
                System.out.println("Solicitud incorrecta");
            }

            // Ejecutar ascensor si la solicitud fue correcta
            if (botonSubir.senialPresionado() || botonBajar.senialPresionado()) {
                this.llamarAscensor();
            }
        }
    }
}
