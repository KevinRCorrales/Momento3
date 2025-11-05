import java.util.Scanner;

public class EjecutarAscensor {
    public static void main(String[] args) {
        // Crear pisos para el edificio con sus botones
        int pisos = 15;
        Piso[] pisoArray = new Piso[pisos];
        Boton[] botones = new Boton[pisos];
        for (int i = 0; i < pisos; i++) {
            if (i == 0) {
                pisoArray[i] = new Piso(1, false, true, new Boton[]{new BotonPiso(false)});
            } else if (i == 14) {
                pisoArray[i] = new Piso(15, false, true, new Boton[]{new BotonPiso(false)});
            } else { // 2 botones para los pisos intermedios (subida y bajada)
                pisoArray[i] = new Piso(i, false, false, new Boton[]{new BotonPiso(false), new BotonPiso(false)});
            }
        }
        for (int i = 0; i < pisos; i++) {
            botones[i] = new BotonAscensor(false, pisoArray[i]);
        }
        // Crear usuarios y simular un piso existente para cada uno
        Usuario objUsuario1 = new Usuario(1);
        // objUsuario2 y objUsuario3 simulan otros usuarios que solicitaron el ascensor más arriba que objUsuario1
        Usuario objUsuario2 = new Usuario(7);
        Usuario objUsuario3 = new Usuario(15);
        Usuario[] usuarios = {objUsuario1, objUsuario2, objUsuario3};

        // Crear ascensor y puerta
        Puerta puerta = new Puerta(false);
        Ascensor ascensor = new Ascensor(7, false, puerta, usuarios[0], botones); // Simular un piso cualquiera para el objeto

        // Control del ascensor
        int[] pisoLlamadas = {objUsuario1.getPisoActual(), objUsuario2.getPisoActual(), objUsuario3.getPisoActual()};
        System.out.println(pisoLlamadas.length);
        SistemaControl objSistemaControl = new SistemaControl(pisoLlamadas, usuarios, ascensor, pisoArray);
        objSistemaControl.menuAscensor();
    }
}
