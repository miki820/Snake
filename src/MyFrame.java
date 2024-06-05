import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class MyFrame extends JFrame {

    public static JLabel score;
    public static JLabel bestScore;
    public static JLabel logoLabel;
    public static JPanel topPanel;
    public static JPanel scorePanel;
    private final ImageIcon logo;

    public MyFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");

        topPanel = new JPanel();
        topPanel.setBackground(new Color(223, 197, 244));
        topPanel.setOpaque(true);
        topPanel.setLayout(new BorderLayout());

        logo = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/logo.png")));
        logoLabel = new JLabel(logo, SwingConstants.LEFT);

        score = new JLabel("Your Score: ", SwingConstants.RIGHT);
        score.setFont(new Font("Neue Helvetica", Font.BOLD, 20));
        score.setBackground(new Color(223, 197, 244));
        score.setOpaque(true);

        bestScore = new JLabel("Best score is: ", SwingConstants.RIGHT);
        bestScore.setFont(new Font("Neue Helvetica", Font.BOLD, 20));
        bestScore.setBackground(new Color(223, 197, 244));
        bestScore.setOpaque(true);

        scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.setBackground(new Color(223, 197, 244));
        scorePanel.add(score);
        scorePanel.add(bestScore);

        scorePanel.setBorder(new EmptyBorder(0, 0, 0, 10));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(scorePanel, BorderLayout.EAST);
        topPanel.setBorder(new EmptyBorder(0, 0, 5, 0));

        URL iconURL = getClass().getResource("/images/icon.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(iconURL);
        setIconImage(icon);

        Game game = new Game();
        add(game);

        add(topPanel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
