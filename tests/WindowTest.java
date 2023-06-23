import org.junit.jupiter.api.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import UI.Window;

public class WindowTest {

    @Test
    public void testButtonClickListener() throws AWTException, InterruptedException {
        Window window = new Window();
        window.main(null);
        // Simulate button clicks
        simulateClick(KeyEvent.VK_UP);
        assertEquals("Up", Window.statusLabel.getText());

        simulateClick(KeyEvent.VK_DOWN);
        assertEquals("Down", Window.statusLabel.getText());

        simulateClick(KeyEvent.VK_RIGHT);
        assertEquals("Right", Window.statusLabel.getText());

        simulateClick(KeyEvent.VK_LEFT);
        assertEquals("Left", Window.statusLabel.getText());
    }

    @Test
    public void testKeyPressListener() throws AWTException, InterruptedException {
        Window window = new Window();
        window.main(null);
        // Simulate key presses
        simulateClick(KeyEvent.VK_UP);
        System.out.println(Window.statusLabel);
        assertEquals("Up", Window.statusLabel.getText());

        simulateClick(KeyEvent.VK_DOWN);
        assertEquals("Down", Window.statusLabel.getText());

        simulateClick(KeyEvent.VK_RIGHT);
        assertEquals("Right", Window.statusLabel.getText());

        simulateClick(KeyEvent.VK_LEFT);
        assertEquals("Left", Window.statusLabel.getText());
    }

    void simulateClick(int keyCode) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.setAutoDelay(1000);

        // Press and release the specified key
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);

        // Wait for the UI to update
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
