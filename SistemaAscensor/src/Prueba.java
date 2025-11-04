public class Prueba {
    public static void main(String[] args) {
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

        // Prueba de pisos para asegurar que se crearon con sus números correctos
        System.out.println(pisoArray[1].numeroPiso()); // Imprime 1
        System.out.println(pisoArray[15].numeroPiso()); // Imprime 15

    }
}
