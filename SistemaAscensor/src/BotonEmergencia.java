public class BotonEmergencia extends Boton{
    public BotonEmergencia(boolean esPresionado) {
        super(esPresionado);
    }

    @Override
    public void presionar() {
        System.out.println("DETENIENDO ASCENSOR Y AVISANDO AL EQUIPO DE SEGURIDAD!");
        esPresionado = true;
    }

    @Override
    public String toString() {
        return "Botón de Emergencia: 0";
    }
}
