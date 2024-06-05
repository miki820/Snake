import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Fruit extends Component {
    private final ImageIcon fruit = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/apple.png")));

    private static final int width = 25;
    private static final int height = 25;
    private static final int size = 20;
    private static int fruitX = (int) (Math.random() * width);
    private static int fruitY = (int) (Math.random() * height);


    public Fruit() {
        fruitX = (int) (Math.random() * width);
        fruitY = (int) (Math.random() * height);
    }

    public void drawFruit(Graphics g) {
        fruit.paintIcon(this, g, fruitX * size, fruitY * size);
    }

    public int getX() {
        return fruitX;
    }

    public int getY() {
        return fruitY;
    }
}