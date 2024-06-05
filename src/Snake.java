import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Snake extends Component {

    private final ImageIcon left_mouth = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/headLeft.png")));
    private final ImageIcon right_mouth = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/headRight.png")));
    private final ImageIcon down_mouth = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/headDown.png")));
    private final ImageIcon up_mouth = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/headUp.png")));
    private final ImageIcon bodyVert = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/bodyVertically.png")));
    private final ImageIcon bodyHoriz = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/bodyHorizontally.png")));

    private final ArrayList<Point> snake;
    private final ArrayList<Direction> directions;
    private Direction direction;
    private final Point tail;
    private int fruitsEaten = 0;

    public Snake() {
        tail = new Point();
        direction = Direction.DOWN;
        snake = new ArrayList<>();
        directions = new ArrayList<>();

        snake.add(new Point(12, 12));
        snake.add(new Point(12, 11));
        snake.add(new Point(12, 10));
        snake.add(new Point(12, 9));

        for (int i = 0; i < snake.size(); i++) {
            directions.add(direction);
        }
    }

    public void drawSnake(Graphics g) {
        for (int i = 0; i < snake.size(); i++) {
            Direction segmentDirection = directions.get(i);
            if (i == 0) {
                if (segmentDirection == Direction.UP)
                    up_mouth.paintIcon(this, g, snake.get(i).x * Board.size, snake.get(i).y * Board.size);
                if (segmentDirection == Direction.DOWN)
                    down_mouth.paintIcon(this, g, snake.get(i).x * Board.size, snake.get(i).y * Board.size);
                if (segmentDirection == Direction.RIGHT)
                    right_mouth.paintIcon(this, g, snake.get(i).x * Board.size, snake.get(i).y * Board.size);
                if (segmentDirection == Direction.LEFT)
                    left_mouth.paintIcon(this, g, snake.get(i).x * Board.size, snake.get(i).y * Board.size);
            } else {
                if (segmentDirection == Direction.UP || segmentDirection == Direction.DOWN)
                    bodyVert.paintIcon(this, g, snake.get(i).x * Board.size + 3, snake.get(i).y * Board.size);
                if (segmentDirection == Direction.LEFT || segmentDirection == Direction.RIGHT)
                    bodyHoriz.paintIcon(this, g, snake.get(i).x * Board.size, snake.get(i).y * Board.size + 2);
            }
        }
    }

    public void moveSnake() {
        tail.setLocation(snake.get(snake.size() - 1));
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setLocation(snake.get(i - 1));
            directions.set(i, directions.get(i - 1));
        }

        switch (direction) {
            case UP -> snake.get(0).y--;
            case DOWN -> snake.get(0).y++;
            case RIGHT -> snake.get(0).x++;
            case LEFT -> snake.get(0).x--;
        }
        directions.set(0, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean deadSnake() {
        for (int i = 1; i < snake.size() - 1; i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                return true;
            }
        }

        if (snake.get(0).x < 0 || snake.get(0).x >= Board.width || snake.get(0).y < 0 || snake.get(0).y >= Board.height) {
            return true;
        }

        return false;
    }

    public int getFruitsEaten() {
        return fruitsEaten;
    }

    public boolean eating(Fruit fruit) {
        if (snake.get(0).x == fruit.getX() && snake.get(0).y == fruit.getY()) {
            snake.add(new Point(tail));
            directions.add(directions.get(directions.size() - 1));
            fruitsEaten++;
            MyFrame.score.setText("Your Score: " + fruitsEaten);
            return true;
        }

        return false;
    }
}