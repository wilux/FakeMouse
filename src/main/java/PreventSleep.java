import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PreventSleep {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                    int x = (int) mousePosition.getX();
                    int y = (int) mousePosition.getY();

                    // Mueve el mouse 1 píxel y regresa a su posición original
                    robot.mouseMove(x + 1, y);
                    robot.mouseMove(x, y);
                }
            }, 0, 30000); // Repite cada 30 segundos (ajustable)

            System.out.println("Simulación de movimiento de mouse iniciada. Presione Ctrl+C para detener.");
        } catch (AWTException e) {
            System.err.println("Error al inicializar el Robot: " + e.getMessage());
        }
    }
}
