package EntradaJuego;

import Grafico.PanelJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JPanel implements ActionListener, MouseListener, KeyListener {

    Image imagenF;
    JLabel salirJuego, titulo, inicio,pulsar;
    JButton iniciarJuego, salida;
    int x, y;
    int opcion = 0;


    public Inicio() {
        setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
        cargarImagenFondo();
        salirLetra();
        letraTitulo();
        iniciarJuego2();
        salirJuego();

        iniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        add(salirJuego);
        add(titulo);
        add(salida);
        add(iniciarJuego);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenF, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void cargarImagenFondo() {
        ImageIcon imagenFondo = new ImageIcon(Inicio.class.getResource("/Imagenes/Fondo/fondodejuegoo.png"));
        imagenF = imagenFondo.getImage().getScaledInstance(720,630,Image.SCALE_SMOOTH);
    }

    private void salirLetra() {
        salirJuego = new JLabel("X");
        salirJuego.setForeground(Color.ORANGE);
        salirJuego.setFont(new Font("Monserrat", Font.BOLD, 35));
        salirJuego.setBounds(680, 10, 35, 35);
    }

    private void letraTitulo(){
        titulo = new JLabel("Nave Espacial");
        titulo.setForeground(Color.ORANGE);
        titulo.setFont(new Font("Showcard Gothic", Font.BOLD, 80));
        titulo.setBounds(70,150,700,80);
    }

    private void salirJuego() {
        salida = new JButton("Salir");
        salida.setBackground(Color.ORANGE);
        salida.setFont(new Font("Monserrat", Font.BOLD, 50));
        salida.setBounds(270, 380, 190, 50);
    }

    private void iniciarJuego2(){
        iniciarJuego = new JButton("Iniciar Juego");
        iniciarJuego.setBackground(Color.ORANGE);
        iniciarJuego.setFont(new Font("Monserrat", Font.BOLD, 50));
        iniciarJuego.setBounds(200,280,350,50);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo2 = e.getKeyCode();
        System.out.println(codigo2);


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (salirJuego.getBounds().contains(e.getX(), e.getY())) {
            System.exit(0);
        }

        if(inicio.getBounds().contains(e.getX(),e.getY())){
            PanelJuego panel = new PanelJuego();
            panel.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (salirJuego.getBounds().contains(e.getX(), e.getY())) {
            salirJuego.setForeground(Color.RED);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panelE = new Inicio();
        frame.add(panelE);
        frame.setSize(720,630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        panelE.setBounds(0, 0, 720, 630); // Asegurar que el panel ocupa toda la ventana
        frame.setLayout(null); // Desactivar el layout predeterminado
        frame.setVisible(true);

    }
}
