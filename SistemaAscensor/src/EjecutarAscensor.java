public class EjecutarAscensor {
    public static void main(String[] args) {
        // Crear pisos para el edificio con sus botones
        int pisos = 15;
        Piso[] pisoArray = new Piso[pisos];
        BotonAscensor[] botones = new BotonAscensor[pisos];
        for (int i = 0; i < pisos; i++) {
            // Iniciar todos los pisos de manera igual
            pisoArray[i] = new Piso(i + 1, new BotonPiso(false));
        }
        for (int i = 0; i < pisos; i++) {
            botones[i] = new BotonAscensor(false, pisoArray[i]);
        }
        // Crear botón de emergencia para el ascensor
        BotonEmergencia botonEmergencia = new BotonEmergencia(false);

        // Crear usuarios y simular un piso existente para cada uno
        Usuario objUsuario1 = new Usuario(pisoArray[0]);
        // objUsuario2 y objUsuario3 simulan otros usuarios que solicitaron el ascensor más arriba que objUsuario1
        Usuario objUsuario2 = new Usuario(pisoArray[8]);
        Usuario objUsuario3 = new Usuario(pisoArray[14]);
        Usuario[] usuarios = {objUsuario1, objUsuario2, objUsuario3};

        // Crear ascensor y puerta
        Puerta puerta = new Puerta(false);
        Ascensor ascensor = new Ascensor(pisoArray[6], pisoArray, false, puerta, objUsuario1, botones, botonEmergencia, false); // Simular un piso cualquiera para el objeto

        // Control del ascensor
        SistemaControl objSistemaControl = new SistemaControl(usuarios, ascensor);
        objSistemaControl.ejecutar();
    }
}
