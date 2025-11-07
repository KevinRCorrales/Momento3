import java.util.Scanner;

public class Ascensor {
    private Piso pisoAscensor;
    private Piso[] pisosEdificio;
    private boolean enMovimiento;
    private Puerta puerta;
    private Usuario usuario;
    private BotonAscensor[] botones;
    private BotonEmergencia botonEmergencia;
    private BotonTiempoPuertas botonTiempoPuertas;
    private boolean subiendo;

    public Ascensor(Piso pisoAscensor, Piso[] pisosEdificio, boolean enMovimiento, Puerta puerta, Usuario usuario, BotonAscensor[] botones,
                    BotonEmergencia botonEmergencia, BotonTiempoPuertas botonTiempoPuertas, boolean subiendo) {
        this.pisoAscensor = pisoAscensor;
        this.pisosEdificio = pisosEdificio;
        this.enMovimiento = enMovimiento;
        this.puerta = puerta;
        this.usuario = usuario;
        this.botones = botones;
        this.botonEmergencia = botonEmergencia;
        this.botonTiempoPuertas = botonTiempoPuertas;
        this.subiendo = subiendo;
    }

    public void recorrerPisos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Atendiendo solicitud del usuario en el piso: " + usuario.getPisoActual().getNumero());
        puerta.abrir();
        System.out.println("Entra al ascensor antes de que cierre...");
        for (BotonAscensor boton : botones) {
            System.out.println(boton.getPiso());
        }
        System.out.println(botonEmergencia);
        System.out.println(botonTiempoPuertas);
        System.out.println("\nIngrese el piso al que quiere ir: ");
        boolean ingresoValido = false;
        do {
            int ingreso = sc.nextInt();
            if (ingreso == 0) {
                botonEmergencia.presionar();
                setEnMovimiento(false);
                ingresoValido = true;
            } else if (ingreso == -1) {
                botonTiempoPuertas.presionar();
                System.out.println("Ahora puede ingresar el piso:");
            } else if (ingreso < 0 || ingreso > botones.length) {
                System.out.println("Piso no válido, vuelva a ingresar un piso válido:");
            } else {
                Piso pisoDestino = pisosEdificio[ingreso - 1];
                botones[pisoDestino.getNumero() - 1].presionar();
                if (botonTiempoPuertas.senialPresionado()) {
                    System.out.println("Esperando más tiempo para cerrar...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    botonTiempoPuertas.setEsPresionado(false);
                }
                puerta.cerrar();
                System.out.println("Iniciando recorrido...");
                pisoAscensor = pisoDestino;
                System.out.println("Recorrido finalizado...");
                System.out.println("Abriendo puerta...");
                puerta.abrir();
                System.out.println("Puede salir...");
                puerta.cerrar();
                usuario.setPisoActual(pisoDestino);
                System.out.println("Usuario y ascensor ahora en el piso: " + usuario.getPisoActual().getNumero());
                System.out.println("------Buscando siguiente usuario--------\n");
                ingresoValido = true;
            }
        } while (!ingresoValido);
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }

    public boolean getEnMovimiento() {
        return enMovimiento;
    }

    public boolean getSubiendo() {
        return subiendo;
    }

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }

    public void setUsuario(Usuario usuario) {
        // Setter para definir el nuevo usuario en el que se basará la petición
        this.usuario = usuario;
    }

    public void setPisoAscensor(Piso pisoAscensor) {
        this.pisoAscensor = pisoAscensor;
    }

    public Piso getPisoAscensor() {
        return pisoAscensor;
    }

    public Boton getBotonEmergencia() {
        return botonEmergencia;
    }

    public Boton getBotonTiempoPuertas() {
        return botonTiempoPuertas;
    }

    public Boton[] getBotones() {
        return botones;
    }

    public Puerta getPuerta() {
        return puerta;
    }
}
