public class SistemaControl {
    Piso[] pisos;
    public SistemaControl(Piso[] pisos) {
        // Crear un objeto ascensor y asignarle botones por piso
        BotonPiso[] botonPiso = new BotonPiso[pisos.length];
        for (int i = 0; i < botonPiso.length; i++) {
            botonPiso[i] = new BotonPiso(false);
        }
        Ascensor ascensor = new Ascensor(botonPiso);
    }


}
