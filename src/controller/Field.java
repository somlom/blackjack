import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Field extends JPanel implements KeyListener {
    // Spielfeldgröße
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private String[] state = new String[]{"Down","Down","Down"};

    // Position und Größe der Schlange
    private int snakeX;
    private int snakeY;
    private int snakeSize;

    public Field() {
        // Fenstereinstellungen
        setSize(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        setVisible(true);
        addKeyListener(this);

        // Startposition und Größe der Schlange
        snakeX = WIDTH / 2;
        snakeY = HEIGHT / 2;
        snakeSize = 20;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrund zeichnen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Gitter zeichnen
        g.setColor(Color.GRAY);
        for (int x = 0; x < WIDTH; x += snakeSize) {
            g.drawLine(x, 0, x, HEIGHT);
        }
        for (int y = 0; y < HEIGHT; y += snakeSize) {
            g.drawLine(0, y, WIDTH, y);
        }

        // Schlange zeichnen
        g.setColor(Color.GREEN);
        g.fillRect(snakeX, snakeY, snakeSize, snakeSize);
    }

    public void add_length(){

        // Create a new array with the desired length
        String[] newArray = new String[state.length+1];

        // Copy the elements from the original array to the new array
        int lengthToCopy = Math.min(state.length, state.length+1);
        System.arraycopy(state, 0, newArray, 0, lengthToCopy);
        newArray[newArray.length-1]=newArray[newArray.length-2];

        // Update the reference to the new array
        state = newArray;
        for (String i : newArray) {
            System.out.println(i);
        }
    }

    public void update_state(String direction){
        for (int i = 1; i < state.length; i++) {
            state[i-1]=state[i];
        }
        state[state.length-1]=direction;
    }

    public void keyPressed(KeyEvent e) {
        // Tastatureingabe verarbeiten
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);

        if (keyCode >=37 && keyCode<=40 ) {
            snakeY += snakeSize;
        }

        // Spielfeld neu zeichnen
        repaint();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {}
}
