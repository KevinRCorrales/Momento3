import java.util.Scanner;

public class EjecutarAscensor {
    public static void main(String[] args) {
        // Crear pisos para el edificio con sus botones
        int pisos = 15;
        Piso[] pisoArray = new Piso[pisos];
        BotonAscensor[] botones = new BotonAscensor[pisos];
        for (int i = 0; i < pisos; i++) {
            // Iniciar todos los pisos de manera igual
            pisoArray[i] = new Piso(i + 1, false, false, new Boton[]{new BotonPiso(false)});
            if (i == 0) {
                pisoArray[i].setEsPrimero(true);
            } else if (i == 14) {
                pisoArray[i].setEsUltimo(true);
            } else { // 2 botones para los pisos intermedios (subida y bajada)
                pisoArray[i].setBotones(new Boton[]{new BotonPiso(false), new BotonPiso(false)});
            }
        }
        for (int i = 0; i < pisos; i++) {
            botones[i] = new BotonAscensor(false, pisoArray[i]);
        }
        // Crear usuarios y simular un piso existente para cada uno
        Usuario objUsuario1 = new Usuario(pisoArray[0], pisoArray[13]);
        // objUsuario2 y objUsuario3 simulan otros usuarios que solicitaron el ascensor más arriba que objUsuario1
        Usuario objUsuario2 = new Usuario(pisoArray[8], pisoArray[2]);
        Usuario objUsuario3 = new Usuario(pisoArray[14], pisoArray[4]);
        Usuario[] usuarios = {objUsuario1, objUsuario2, objUsuario3};

        // Crear ascensor y puerta
        Puerta puerta = new Puerta(false);
        Ascensor ascensor = new Ascensor(7, false, puerta, usuarios[0], botones); // Simular un piso cualquiera para el objeto

        // Control del ascensor
        int[] pisoLlamadas = {objUsuario1.getPisoActual().getNumero(), objUsuario2.getPisoActual().getNumero(), objUsuario3.getPisoActual().getNumero()};
        SistemaControl objSistemaControl = new SistemaControl(pisoLlamadas, usuarios, ascensor, pisoArray);
        objSistemaControl.menuAscensor();
    }
}
