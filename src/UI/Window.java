package UI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public Window() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(3, 1)); // 3 rows in 1 col

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setFocusable(true); // Set the panel focusable

        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        headerLabel.setText("Control in action: Button");

        JButton upButton = new JButton("\u2191");
        JButton downButton = new JButton("\u2193");
        JButton rightButton = new JButton("\u2192");
        JButton leftButton = new JButton("\u2190");

        upButton.setActionCommand("up");
        downButton.setActionCommand("down");
        rightButton.setActionCommand("right");
        leftButton.setActionCommand("left");

        upButton.addActionListener(new ButtonClickListener());
        downButton.addActionListener(new ButtonClickListener());
        rightButton.addActionListener(new ButtonClickListener());
        leftButton.addActionListener(new ButtonClickListener());

        controlPanel.add(upButton);
        controlPanel.add(downButton);
        controlPanel.add(rightButton);
        controlPanel.add(leftButton);

        controlPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
                    statusLabel.setText("Up");
                } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                    statusLabel.setText("Down");
                } else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                    statusLabel.setText("Left");
                } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                    statusLabel.setText("Right");
                }
            }
        });

        mainFrame.setVisible(true);
        controlPanel.requestFocus(); // Request focus for the controlPanel
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();

            if (command.equals("up")) {
                statusLabel.setText("Up");
            } else if (command.equals("down")) {
                statusLabel.setText("Down");
            } else if (command.equals("right")) {
                statusLabel.setText("Right");
            } else if (command.equals("left")) {
                statusLabel.setText("Left");
            }
        }
    }
}
