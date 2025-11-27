package Logica;

import Grafico.PanelJuego;

import java.util.Random;

public class Alienigena {

    private NaveAlienigena[][] filasAlienigena;
    private Posicion posicion;

    public Alienigena(Posicion posicion) {
        this.posicion = posicion;
    }

    public Disparos dispararJugador() {
        Random aleatorio = new Random();
        NaveAlienigena naveAlienigena = null;
        int fila;
        int columna;

        while (naveAlienigena == null) {
            fila = aleatorio.nextInt(filasAlienigena.length);
            columna = aleatorio.nextInt(filasAlienigena[0].length);
            naveAlienigena = filasAlienigena[fila][columna];
        }

        return naveAlienigena.disparar();
    }

    public NaveAlienigena[][] generarAlienigenas(int filas, int columnas) {
        filasAlienigena = new NaveAlienigena[filas][columnas];
        int espacio = 25;

        for (int i = 0; i < filasAlienigena.length; i++) {
            for (int j = 0; j < filasAlienigena[0].length; j++) {
                filasAlienigena[i][j] = new NaveAlienigena(new Posicion(
                        (j * (PanelJuego.TAMANO_OBJ + espacio)) + posicion.getX(),
                        (i * (PanelJuego.TAMANO_OBJ + espacio)) + posicion.getY()));
            }
        }
        return filasAlienigena;
    }


}
