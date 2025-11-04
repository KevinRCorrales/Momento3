import java.util.Scanner;

public class EjecutarAscensor {
    public static void main(String[] args) {
        // Crear usuarios y simular un piso existente para cada uno
        Usuario objUsuario1 = new Usuario(1);
        // objUsuario2 y objUsuario3 simulan otros usuarios que solicitaron el ascensor más arriba que objUsuario1
        Usuario objUsuario2 = new Usuario(7);
        Usuario objUsuario3 = new Usuario(15);

        // Control del ascensor
        int[] pisoLlamadas = {objUsuario1.getPisoActual(), objUsuario2.getPisoActual(), objUsuario3.getPisoActual()};
        Usuario[] usuarios = {objUsuario1, objUsuario2, objUsuario3};
        System.out.println(pisoLlamadas.length);
        SistemaControl objSistemaControl = new SistemaControl(pisoLlamadas, usuarios);
        objSistemaControl.menuAscensor();
    }
}
