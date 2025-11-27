package Logica;

import Grafico.PanelJuego;

import java.awt.*;

import static Grafico.PanelJuego.TAMANO_OBJ;

public class NaveAlienigena {
    private int velocidad_Nave = 2;
    private int velocidad = 3;
    private Posicion posicion;
    private NaveAlienigena naveAlienigena;


    public NaveAlienigena(Posicion posicion) {
        this.posicion = posicion;
    }

    public NaveAlienigena generarNaveAlienigena() {
        naveAlienigena = new NaveAlienigena(new Posicion(-TAMANO_OBJ, 0));
        return naveAlienigena;
    }

    public void moverDerechaAlienigena(){
        posicion.setX(posicion.getX() + velocidad);
    }

    public Posicion getPosicionNaveAlienigena() {
        return posicion;
    }

    public int getposicionX(){
        return posicion.getX();
    }

    public int getposicionY(){
        return posicion.getY();
    }

    public Disparos disparar() {
        return new Disparos(new Posicion(getposicionX(),getposicionY()),velocidad);
    }

//    public Rectangle obtenerArea() {
//        int area = 24;
//        Rectangle rectNali = new Rectangle(getPosicionNaveAlienigena().getX(),
//                getPosicionNaveAlienigena().getY(),
//                PanelJuego.TAMANO_OBJ - area,
//                PanelJuego.TAMANO_OBJ- area
//        );
//        return rectNali;
//    }

    public Rectangle obtenerArea() {
        return new Rectangle(getposicionX(), getposicionY(), PanelJuego.TAMANO_OBJ, PanelJuego.TAMANO_OBJ);
    }
}
