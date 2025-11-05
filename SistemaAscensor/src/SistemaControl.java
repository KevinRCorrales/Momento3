import java.util.Scanner;

public class SistemaControl {
    private int[] pisoLlamadas;
    private Usuario[] usuarios;
    private Ascensor ascensor;
    private Piso[] pisos;

    public SistemaControl(int[] pisoLlamadas, Usuario[] usuarios, Ascensor ascensor, Piso[] pisos) {
        this.pisoLlamadas = pisoLlamadas;
        this.usuarios = usuarios;
        this.ascensor = ascensor;
        this.pisos = pisos;
    }

    public void llamarAscensor() {
        int pisoAscensor = ascensor.getPisoAscensor();
        if (!ascensor.getEnMovimiento()) {
            // Iniciar movimiento hacia el piso de la primera solicitud
            ascensor.setEnMovimiento(true);
            ascensor.recorrerPisos();
            System.out.println("Usuario ahora en el piso: " + usuarios[0].getPisoActual());
        } else { // Si el ascensor ya está en movimiento
            // Verificar si hay solicitudes hacia la misma dirección
        }
        //System.out.println(diferencias[0] + " " + diferencias[1] + " " + diferencias[2]); // (linea de debugeo)
    }

    public void menuAscensor() {
        Scanner sc = new Scanner(System.in);
        int solicitud; // Inicializar variable para almacenar lecturas

        while(true){
            // Usar el primer usuario para mí
            Piso pisoUsuario = pisos[usuarios[0].getPisoActual().getNumero() -1];
            boolean usuarioPrimerPiso = pisoUsuario.esPrimerPiso();
            boolean usuarioUltimoPiso = pisoUsuario.esUltimoPiso();
            // Crear botones disponibles
            Boton botonSubir = pisoUsuario.botonSubir();
            Boton botonBajar = pisoUsuario.botonBajar();
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
