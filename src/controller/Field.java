package src.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Field extends JPanel implements KeyListener {
    // // Spielfeldgröße
    private static final int WIDTH_ = 10;
    private static final int HEIGHT_ = WIDTH_;
    private String[] state = new String[]{"Down","Down","Down"};

    // Position und Größe der Schlange
    private int snakeX;
    private int snakeY;
    private int snakeSize;

    public Field() {
        // Fenstereinstellungen
        setSize(WIDTH_, HEIGHT_);
        setBackground(Color.BLACK);
        setVisible(true);
        addKeyListener(this);

        // Startposition und Größe der Schlange
        snakeX = WIDTH_ / 2;
        snakeY = HEIGHT_ / 2;
        snakeSize = 20;
    }
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Hintergrund zeichnen
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());

    // Gitter zeichnen
    g.setColor(Color.GRAY);
    for (int x = 0; x < getWidth(); x += snakeSize) {
        g.drawLine(x, 0, x, getHeight());
    }
    for (int y = 0; y < getHeight(); y += snakeSize) {
        g.drawLine(0, y, getWidth(), y);
    }

    // Schlange zeichnen
    g.setColor(Color.GREEN);
    int snakeGridX = (snakeX / snakeSize) * snakeSize; // Runden der X-Position zur nächsten Gitterlinie
    int snakeGridY = (snakeY / snakeSize) * snakeSize; // Runden der Y-Position zur nächsten Gitterlinie
    g.fillRect(snakeGridX, snakeGridY, snakeSize, snakeSize);
}



    public void update_state(String direction){

        // Create a new array with the desired length
        String[] newArray = new String[state.length+1];

        // Copy the elements from the original array to the new array
        int lengthToCopy = Math.min(state.length, state.length+1);
        System.arraycopy(state, 0, newArray, 0, lengthToCopy);
        newArray[newArray.length-1]=direction;

        // Update the reference to the new array
        state = newArray;
        for (String i : newArray) {
            System.out.println(i);
        }
    }

public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    
    if (keyCode == KeyEvent.VK_UP) {
        snakeY -= snakeSize;
    } else if (keyCode == KeyEvent.VK_DOWN) {
        snakeY += snakeSize;
    } else if (keyCode == KeyEvent.VK_LEFT) {
        snakeX -= snakeSize;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
        snakeX += snakeSize;
    }
    
    repaint();
}


    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {}
}