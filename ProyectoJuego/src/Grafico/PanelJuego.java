package Grafico;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class PanelJuego extends JPanel implements ActionListener , KeyListener {

    public static final int TAMANO_OBJ = 45;
    public static final int COLUMNAS = 16;
    public static final int FILAS = 14;
    public static final int ANCHO = COLUMNAS * TAMANO_OBJ; //720
    public static final int ALTO = FILAS * TAMANO_OBJ; //630

    Image fondoJuego, imagenNave, imagenNaveAlienigena, imagenFilasAlienigena, balaJugador,imagenBalaEnemigo;
    Timer timer = new Timer(50, this);

    //Objetos
    Nave nave;
    NaveAlienigena naveAli;
    Alienigena alienigena;
    NaveAlienigena[][] filasAlienigena;
    ArrayList<Disparos> balasJugador = new ArrayList<>();
    ArrayList<Disparos> balasEnemigos = new ArrayList<>();
    Disparos disparoJugador;

    boolean balaVisible = false;
    boolean colision = false;


    public PanelJuego() {
        timer.start();
        setFocusable(true);
        addKeyListener(this);


        nave = new Nave(new Posicion(360,530));
        naveAli = new NaveAlienigena(new Posicion(9,25));
        alienigena = new Alienigena(new Posicion(230,150));
        disparoJugador = new Disparos(new Posicion(360,530),30);


        cargarImagenFondoJuego();
        colocarNave();
        colocarNaveAlienigena();
        cargarImagenesAlien();
        cargarImagenBalaJugador();
        cargarBalasEnemigos();
        generarBalasEnemigos(3);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondoJuego, 0, 0, this);
        g.drawImage(imagenNave, nave.PpsicionX(), nave.PosicionY(), this);
        g.drawImage(imagenNaveAlienigena,naveAli.getposicionX(), naveAli.getposicionY(), this );

        for (int i = 0; i < filasAlienigena.length; i++) {
            for (int j = 0; j < filasAlienigena[i].length; j++) {
                g.drawImage(imagenFilasAlienigena, filasAlienigena[i][j].getposicionX(), filasAlienigena[i][j].getposicionY(), this);

            }
        }

            g.drawImage(balaJugador, disparoJugador.getPosicionX(), disparoJugador.getPosicionY(), this);
//

        for(Disparos disparo : balasEnemigos){
            g.drawImage(imagenBalaEnemigo, disparo.getPosicionX(), disparo.getPosicionY(), this);

        }



    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Rectangle rectNave = new Rectangle(nave.PpsicionX(),nave.PosicionY(), TAMANO_OBJ, TAMANO_OBJ);
        Rectangle rectBala = new Rectangle(balasEnemigos.size(), balasEnemigos.size(), TAMANO_OBJ, TAMANO_OBJ);

        if(rectBala.intersects(rectNave)){
            
        }

        if (balaVisible) {
            disparoJugador.dispararArriba();
            balasJugador.add(nave.disparar());

            if (disparoJugador.getPosicionY() < 0) {
                balaVisible = false;

            }
        }

        for(Disparos disparo : balasEnemigos){
            disparo.dispararAbajo();

            if (disparo.getPosicionY() > ALTO) {
                disparo.setPosicionY(-100);
            }
        }

        disparoJugador.dispararArriba();

        nave.moverIzquierda();
        nave.moverDerechaJugador();
        naveAli.moverDerechaAlienigena();




        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        System.out.println(codigo);

        if (codigo == KeyEvent.VK_RIGHT) {
            nave.moverDerechaJugador();
        }
        if (codigo == KeyEvent.VK_LEFT) {
            nave.moverIzquierda();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int codigo2 = e.getKeyCode();
        System.out.println(codigo2);

        if (codigo2 == KeyEvent.VK_SPACE) {
            if (!balaVisible) {
                disparoJugador.setPosicionX(nave.PpsicionX() + (TAMANO_OBJ / 2));
                disparoJugador.setPosicionY(nave.PosicionY());

                balaVisible = true;
            }
        }

    }

    private void cargarImagenFondoJuego(){
        ImageIcon icono = new ImageIcon(PanelJuego.class.getResource("/Imagenes/Fondo/fondodejuegoo.png"));
        fondoJuego = icono.getImage().getScaledInstance(750, 600, Image.SCALE_SMOOTH);
    }

    private void colocarNave(){
//        int posicionX = (ANCHO / 2);
//        int posicionY = ALTO - (ANCHO / 9);
//
//        nave = new Nave(new Posicion(posicionX, posicionY));

        ImageIcon nave = new ImageIcon(PanelJuego.class.getResource("/Imagenes/Nave/naveJ.png"));
        imagenNave = nave.getImage().getScaledInstance(TAMANO_OBJ, TAMANO_OBJ, Image.SCALE_SMOOTH);
    }

    private void colocarNaveAlienigena(){

        ImageIcon naveA = new ImageIcon(PanelJuego.class.getResource("/Imagenes/Alien/ovni.png"));
        imagenNaveAlienigena = naveA.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
    }

    private void cargarImagenesAlien(){
        ImageIcon filasAli = new ImageIcon(PanelJuego.class.getResource("/Imagenes/Alien/filaAlien.png"));
        imagenFilasAlienigena = filasAli.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

        filasAlienigena = alienigena.generarAlienigenas(3,4);
    }

    public void cargarImagenBalaJugador(){
        ImageIcon bala = new ImageIcon(PanelJuego.class.getResource("/Imagenes/Balas/bala.png"));
        balaJugador = bala.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
    }

    private void cargarBalasEnemigos(){
        ImageIcon balaEnemigo = new ImageIcon(PanelJuego.class.getResource("/Imagenes/Balas/balaEnemigo.png"));
        imagenBalaEnemigo = balaEnemigo.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    }


    public int getTAMANO_OBJ() {
        return TAMANO_OBJ;
    }

    private void generarBalasEnemigos(int cantidad) {
        Random rand = new Random();

        for(int i = 0; i < cantidad; i++){
            int x = rand.nextInt(470);
            int y = rand.nextInt(180) - 180;
            balasEnemigos.add(new Disparos(new Posicion(x,y),4));

        }
    }



    public static void main(String[] args){
        JFrame ventanaDibujo = new JFrame("Juego Nave");
        JPanel panel = new PanelJuego();
        ventanaDibujo.add(panel);
        ventanaDibujo.setSize(ANCHO,ALTO);
        ventanaDibujo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaDibujo.setLocationRelativeTo(null);
        ventanaDibujo.setResizable(false);
//        panel.setBackground(Color.BLACK);
        ventanaDibujo.setVisible(true);
    }





}
