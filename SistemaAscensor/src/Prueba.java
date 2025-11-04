public class Prueba {
    public static void main(String[] args) {
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

        // Prueba de pisos para asegurar que se crearon con sus números correctos
        System.out.println(pisoArray[0].numeroPiso()); // Imprime 1
        System.out.println(pisoArray[14].numeroPiso()); // Imprime 15

    }
}
