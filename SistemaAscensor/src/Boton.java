public class Boton {
    private boolean iluminacion;
    public Boton(boolean iluminacion) {
        this.iluminacion = iluminacion;
    }

    public void encender() {
        iluminacion = true;
    }

    public void apagar() {
        iluminacion = false;
    }

    public boolean estado() {
        return iluminacion;
    }
}
