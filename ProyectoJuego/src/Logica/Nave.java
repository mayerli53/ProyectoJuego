package Logica;


public class Nave {
    private int velocidad;
    private int vidaMaxima = 4;
    private Disparos disparos;
    private Posicion posicion;

    public Nave(Posicion nuevaPosicion) {
        velocidad = 25;
        posicion = nuevaPosicion;
    }

    public void moverIzquierda(){
        if(posicion.getX() > 0) {
            posicion.setX(posicion.getX() - velocidad);
        }
    }

    public void moverDerechaJugador(){
        if (posicion.getX() < 675) {
            posicion.setX(posicion.getX() + velocidad);
        }
    }

    public Disparos disparar(){
        return new Disparos(posicion,velocidad);
    }


    public int PpsicionX(){
        return posicion.getX();
    }
    public int PosicionY(){
        return posicion.getY();
    }

    public Posicion obtenerPosicionParaBalas(){
        return posicion;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVelocidad() {
        return velocidad;
    }


    public Disparos getDisparos() {
        return disparos;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setDisparos(Disparos disparos) {
        this.disparos = disparos;
    }
}
