import java.util.Scanner;

public class EjecutarAscensor {
    public static void main(String[] args) {
        // Scanner para leer solicitudes
        Scanner sc = new Scanner(System.in);
        int solicitud; // Inicializar variable para almacenar lecturas

        // Crear pisos para el edificio y los botones del ascensor
        int pisos = 16; // 16; pero se usarán 15 en el bucle
        Piso[] pisoArray = new Piso[pisos];
        // i = 1 para no iniciar con un piso 0
        // Uso de < en vez de <= para evitar usar el piso 16
        for (int i = 1; i < pisos; i++) {
            if (i == 1) {
                pisoArray[i] = new Piso(1, false, true);
            } else if (i == 15) {
                pisoArray[i] = new Piso(15, false, true);
            } else {
                pisoArray[i] = new Piso(i, false, false);
            }
        }
        // Crear usuario y simular un piso existente
        Usuario objUsuario1 = new Usuario(1);
        boolean usuarioPrimerPiso = pisoArray[objUsuario1.getPisoActual()].esPrimerPiso();
        boolean usuarioUltimoPiso = pisoArray[objUsuario1.getPisoActual()].esUltimoPiso();
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
