import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.controller.Field;

import javax.swing.JButton;

public class Window {
    private JFrame mainFrame;
    private static JLabel headerLabel;
    private static Field field;
    private static JPanel controlPanel;
    private int previous_state = 40;

    public Window() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.showEvent();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING");
        mainFrame.setSize(1920, 1080);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        field = new Field();
        field.setSize(100, 100);

        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setFocusable(true);

        mainFrame.add(headerLabel);
        mainFrame.add(field);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

private void showEvent() {
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

                if (!(Math.pow(previous_state - keyCode, 2) == 4 || previous_state - keyCode == 0)) {
                    if (keyCode == KeyEvent.VK_UP) {
                        field.update_state("Up");
                    } else if (keyCode == KeyEvent.VK_DOWN) {
                        field.update_state("Down");
                    } else if (keyCode == KeyEvent.VK_LEFT) {
                        field.update_state("Left");
                    } else if (keyCode == KeyEvent.VK_RIGHT) {
                        field.update_state("Right");
                    }
                }
                previous_state = keyCode;
            }
        });

        mainFrame.setVisible(true);
        controlPanel.requestFocus();
        
        new javax.swing.Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int keyCode = previous_state;

                if (keyCode == KeyEvent.VK_UP) {
                    field.update_state("Up");
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    field.update_state("Down");
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    field.update_state("Left");
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    field.update_state("Right");
                }
                
                mainFrame.repaint();
            }
        }).start();
    }

    /*private void showEvent() {
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

                if (!(Math.pow(previous_state - keyCode, 2) == 4 || previous_state - keyCode == 0)) {
                    if (keyCode == KeyEvent.VK_UP) {
                        field.update_state("Up");
                    } else if (keyCode == KeyEvent.VK_DOWN) {
                        field.update_state("Down");
                    } else if (keyCode == KeyEvent.VK_LEFT) {
                        field.update_state("Left");
                    } else if (keyCode == KeyEvent.VK_RIGHT) {
                        field.update_state("Right");
                    }
                }
                previous_state = keyCode;
            }
        });
            controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout());
            controlPanel.setFocusable(true);

            mainFrame.add(headerLabel);
            mainFrame.add(field);
            mainFrame.add(controlPanel);
            mainFrame.setVisible(true);

            controlPanel.requestFocus();
            controlPanel.setFocusable(true);
            controlPanel.requestFocusInWindow();
            controlPanel.requestFocusInWindow();
            controlPanel.setFocusable(true);
            controlPanel.requestFocusInWindow();
  
    }*/

    public class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();

            if (command.equals("up") && previous_state != 40) {
                field.update_state("Up");
            } else if (command.equals("down") && previous_state != 38) {
                field.update_state("Down");
            } else if (command.equals("right") && previous_state != 37) {
                field.update_state("Right");
            } else if (command.equals("left") && previous_state != 39) {
                field.update_state("Left");
            }
        }
    }
}