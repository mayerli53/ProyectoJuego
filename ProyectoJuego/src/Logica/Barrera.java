package Logica;

public class Barrera {
    private Posicion posicion;
    private int vidas = 20;

    public Barrera(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicionBarrera(){
        return posicion;
    }

    public void reducirVidas(){
        vidas = vidas - 1;
    }

    public int getVidas() {
        return vidas;
    }
}
