package src.controller;
import java.awt.*;
import java.awt.event.*;

public class Field extends Frame implements KeyListener {
    // Spielfeldgröße
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    // Position und Größe der Schlange
    private int snakeX;
    private int snakeY;
    private int snakeSize;

    public Field() {
        // Fenstereinstellungen
        setSize(WIDTH, HEIGHT);
        setTitle("Snake Game");
        setVisible(true);
        addKeyListener(this);

        // Startposition und Größe der Schlange
        snakeX = WIDTH / 2;
        snakeY = HEIGHT / 2;
        snakeSize = 1;
    }

    public void paint(Graphics g) {
        // Hintergrund zeichnen
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Schlange zeichnen
        g.setColor(Color.GREEN);
        g.fillRect(snakeX, snakeY, snakeSize, snakeSize);
    }

    public void keyPressed(KeyEvent e) {
        // Tastatureingabe verarbeiten
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            snakeX -= snakeSize;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            snakeX += snakeSize;
        } else if (keyCode == KeyEvent.VK_UP) {
            snakeY -= snakeSize;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            snakeY += snakeSize;
        }

        // Spielfeld neu zeichnen
        repaint();
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        Field game = new Field();
    }
}
