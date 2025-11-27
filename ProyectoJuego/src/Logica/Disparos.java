package Logica;

import Grafico.PanelJuego;

import java.awt.*;

import static Grafico.PanelJuego.TAMANO_OBJ;

public class Disparos {

    private int velocidad;
    private Posicion posicion;
    private boolean visible;

    public Disparos(Posicion posicion, int velocidad) {
        this.velocidad = velocidad;
        this.posicion = posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public Posicion getPosicionBala() {
        return posicion;
    }

    public void dispararArriba() {
        posicion.setY(posicion.getY() - velocidad);
//        System.out.println("Disparo Arriba");
        if(posicion.getY() < 0){
            visible = false;
        }
    }

    public void dispararAbajo() {
        posicion.setY(posicion.getY() + velocidad);
        if (posicion.getY() < 630){
            visible = false;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public int getPosicionX() {
        return posicion.getX();
    }

    public int getPosicionY() {
        return posicion.getY();
    }

    public void setPosicionX(int posicionX) {
        this.posicion.setX(posicionX);
    }
    public void setPosicionY(int posicionY) {
        this.posicion.setY(posicionY);
    }

//    public Rectangle obtenerArea() {
//        int area = 24;
//        Rectangle rectBala = new Rectangle(getPosicionBala().getX(),
//                getPosicionBala().getY(),
//                PanelJuego.TAMANO_OBJ - area,
//                PanelJuego.TAMANO_OBJ- area
//        );
//        return rectBala;
//    }

    public Rectangle obtenerArea() {
        return new Rectangle(getPosicionX(), getPosicionY(), PanelJuego.TAMANO_OBJ, PanelJuego.TAMANO_OBJ);
    }
}
