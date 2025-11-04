import java.util.Scanner;

public class EjecutarAscensor {
    public static void main(String[] args) {
        // Scanner para leer solicitudes
        Scanner sc = new Scanner(System.in);
        int solicitud; // Inicializar variable para almacenar lecturas

        // Crear pisos para el edificio y los botones del ascensor
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

        // Control del ascensor
        SistemaControl objSistemaControl = new SistemaControl(pisoArray);

        // Crear usuario y simular un piso existente
        Usuario objUsuario1 = new Usuario(1);
        // - 1 para acceder al elemento correcto del array que va de 0 a 14
        boolean usuarioPrimerPiso = pisoArray[objUsuario1.getPisoActual() - 1].esPrimerPiso();
        boolean usuarioUltimoPiso = pisoArray[objUsuario1.getPisoActual() - 1].esUltimoPiso();
        while(true){
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
                // Presionar el botón de subir
                System.out.println();
            } else if (solicitud == 1 && usuarioUltimoPiso) {
                System.out.println();
            } else if ((usuarioUltimoPiso || usuarioPrimerPiso) && solicitud > 1) { // Evitar solicitudes de tipo 2 a usuarios en primer o último piso
                System.out.println("Solicitud incorrecta");
            } else if (solicitud == 1) { // Cuando el usuario está simplemente en un piso intermedio
                System.out.println();
            } else if (solicitud == 2) {
                System.out.println();
            } else {
                System.out.println("Solicitud incorrecta");
            }
        }

    }
}
