public class SistemaControl {
    private Usuario[] usuarios;
    private Ascensor ascensor;

    public SistemaControl(Usuario[] usuarios, Ascensor ascensor) {
        this.usuarios = usuarios;
        this.ascensor = ascensor;
    }

    public void ejecutar() {
        // Crear las llamadas de piso en el orden de cada usuario
        int[] pisoLlamadas = new int[usuarios.length];

        for (int i = 0; i < usuarios.length; i++) {
            pisoLlamadas[i] = usuarios[i].getPisoActual().getNumero();
        }

        // Verificar que no hayan partes en mal estado desde el comienzo
        if (malEstado()) {
            atenderEmergencia();
        } else {
            // Comenzar el movimiento del ascensor con el primer usuario en la lista
            Piso pisoInicialAscensor = ascensor.getPisoAscensor();
            System.out.println("Ascensor en piso: " + pisoInicialAscensor.getNumero());
            ascensor.setEnMovimiento(true);
            Usuario usuarioActual = usuarios[0];
            Piso pisoUsuarioActual = usuarioActual.getPisoActual();
            // Ir al piso de dicho usuario
            ascensor.setPisoAscensor(pisoUsuarioActual);
            System.out.println("Ascensor en el piso del usuario...");
            ascensor.setUsuario(usuarioActual);
            ascensor.recorrerPisos();
            pisoLlamadas[0] = 0; // Marcar como ya atendido

            /*Continuar con los demás usuarios a partir del movimiento del ascensor
             * Ya que el ascensor fue puesto en movimiento con el primer usuario, se verificará si hay más
             * solicitudes y hacía que dirección fue el ascensor con el primer usuario, para definir
             * la dirección a donde debe seguir el ascensor para mejorar la eficiencia, y que apenas termine
             * dicha dirección, pueda invertirla y hacer un recorrido para quienes estaban en pisos aún no
             * recorridos.*/

            // Movimiento del ascensor
            ascensor.setSubiendo(pisoUsuarioActual.getNumero() < usuarioActual.getPisoActual().getNumero());
            // Pequeña verificación de si el ascensor si detectó si está subiendo o bajando de manera correcta
            if (ascensor.getSubiendo()) {
                System.out.println("El ascensor está subiendo");
            } else if (ascensor.getEnMovimiento()) {
                System.out.println("El ascensor está bajando");
            }

            if (pisoLlamadas.length == 1) {
                System.out.println("No hay más solicitudes...");
                //System.exit(0); // Salir de la ejecución sin errores
            } else {
                // Continuar si hay más llamadas y si el ascensor no ha sido detenido por una emergencia
                while (quedanSolicitudes(pisoLlamadas)) {
                    pisoInicialAscensor = ascensor.getPisoAscensor();
                    System.out.println("Ascensor en el piso: " + pisoInicialAscensor.getNumero());
                    if (ascensor.getSubiendo()) {
                        for (int i = 0; i < pisoLlamadas.length; i++) {
                            // Verificar que el piso es mayor al actual, que no haya sido atendido y que el ascensor no haya sido detenido por emergencia o por daños
                            if (pisoLlamadas[i] >= pisoInicialAscensor.getNumero() && pisoLlamadas[i] != 0 && ascensor.getEnMovimiento() && !malEstado()) {
                                ascensor.setUsuario(usuarios[i]);
                                ascensor.recorrerPisos();
                                pisoLlamadas[i] = 0;
                            }
                        }
                        ascensor.setSubiendo(false); // después de subir cambiar la dirección
                    } else {
                        for (int i = 0; i < pisoLlamadas.length; i++) {
                            // Que sea menor al actual
                            if (pisoLlamadas[i] <= pisoInicialAscensor.getNumero() && pisoLlamadas[i] != 0 && ascensor.getEnMovimiento() && !malEstado()) {
                                ascensor.setUsuario(usuarios[i]);
                                ascensor.recorrerPisos();
                                pisoLlamadas[i] = 0;
                            }
                        }
                        ascensor.setSubiendo(true);
                    }
                }
            }
            atenderEmergencia(); // Verificar que el botón de emergencia haya sido presionado
        }
    }

    public boolean quedanSolicitudes(int[] pisoLlamadas) {
        for (int pisoLlamada : pisoLlamadas) {
            if (pisoLlamada != 0 && ascensor.getEnMovimiento()) {
                System.out.println("Aún hay solicitudes por atender...");
                return true;
            }
        }
        if (ascensor.getEnMovimiento()) {
            System.out.println("No hay más solicitudes...");
        }
        ascensor.setEnMovimiento(false);
        return false;
    }

    public void atenderEmergencia() {
        if (ascensor.getBotonEmergencia().senialPresionado() || malEstado()) {
            System.out.println("SE DETECTÓ UN ELEMENTO DEFECTUOSO O SE PRESIONÓ EL BOTÓN DE EMERGENCIA!");
            System.out.println("Parando en el piso más cercano");
            if (!ascensor.getPuerta().getAbierta()) {
                ascensor.getPuerta().abrir();
            }
            System.out.println("Por favor, salir del ascensor...");
            System.out.println("Ascensor detenido en el piso: " + ascensor.getPisoAscensor().getNumero());
        }
    }

    public boolean malEstado() {
        if (ascensor.getPuerta().getMalEstado() || ascensor.getBotonEmergencia().getMalEstado() || ascensor.getBotonTiempoPuertas().getMalEstado()) {
            return true;
        }
        for (Boton boton : ascensor.getBotones()) {
            if (boton.getMalEstado()) {
                return true;
            }
        }
        return false;
    }
}
