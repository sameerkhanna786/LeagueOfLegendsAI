import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

public class Mouse_Coordinates_Getter {
    static double x = MouseInfo.getPointerInfo().getLocation().x;
    static double y = MouseInfo.getPointerInfo().getLocation().y;
    Robot robot = new Robot();

    public static void main(String[] args) throws AWTException {
        new Mouse_Coordinates_Getter();
    }

    public Mouse_Coordinates_Getter() throws AWTException {
        Robot robot = new Robot();
        int counter = 0;
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        while (true) {
            robot.delay(500);
            int temp_x = MouseInfo.getPointerInfo().getLocation().x;
            int temp_y = MouseInfo.getPointerInfo().getLocation().y;

            if (temp_x == x && temp_x == x) {
                counter++;
                if (counter > 40) {
                    counter = 0;
                    System.out.println("Coordinates found. Here are the coordinates: X: " + x + " and Y: " + y);
                }
            } else {
                x = temp_x;
                y = temp_y;
            }

        }
    }
}

