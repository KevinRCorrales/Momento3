public class EjecutarAscensor2 {
    public static void main(String[] args) {
        // Crear pisos para el edificio con sus botones
        int pisos = 15;
        Piso[] pisoArray = new Piso[pisos];
        BotonAscensor[] botones = new BotonAscensor[pisos];
        for (int i = 0; i < pisos; i++) {
            // Iniciar todos los pisos de manera igual
            pisoArray[i] = new Piso(i + 1, new BotonPiso(false, false), new BotonPiso(false, false));
        }
        for (int i = 0; i < pisos; i++) {
            botones[i] = new BotonAscensor(false, false, pisoArray[i]);
        }
        BotonEmergencia botonEmergencia = new BotonEmergencia(false, false);
        BotonTiempoPuertas botonTiempoPuertas = new BotonTiempoPuertas(false, false);

        // Crear más usuarios para esta prueba
        Usuario objUsuario1 = new Usuario(pisoArray[7]);
        Usuario objUsuario2 = new Usuario(pisoArray[4]);
        Usuario objUsuario3 = new Usuario(pisoArray[14]);
        Usuario objUsuario4 = new Usuario(pisoArray[10]);
        Usuario objUsuario5 = new Usuario(pisoArray[1]);
        Usuario objUsuario6 = new Usuario(pisoArray[12]);
        Usuario[] usuarios = {objUsuario1, objUsuario2, objUsuario3, objUsuario4, objUsuario5, objUsuario6};

        // Crear ascensor y puerta
        Puerta puerta = new Puerta(false, false);
        Ascensor ascensor = new Ascensor(pisoArray[6], pisoArray, false, puerta, objUsuario1, botones,
                botonEmergencia, botonTiempoPuertas, false); // Simular un piso cualquiera para el objeto

        // Control del ascensor
        SistemaControl objSistemaControl = new SistemaControl(usuarios, ascensor);
        objSistemaControl.ejecutar();
    }
    
}
