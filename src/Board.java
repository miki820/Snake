import java.awt.*;

public class Board {
    public static int width = 25;
    public static int height = 25;
    public static int size = 20;

    public static void drawBoard(Graphics g) {
        g.setColor(new Color(237, 223, 178));
        g.fillRect(0, 0, width * size, height * size);
    }
}
