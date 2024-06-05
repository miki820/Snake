import java.io.*;
import java.util.Scanner;

// Class to manage scores
public class ScoreManager{

    private int highScore;

    public ScoreManager() {
        loadHighScore();
    }

    // Load the high score from file or initialize it to 0 if file doesn't exist
    private void loadHighScore() {
        try {
            File highScoreFile = new File("Scores.txt");
            if (highScoreFile.exists()) {
                Scanner scanner = new Scanner(highScoreFile);
                if (scanner.hasNextLine()) {
                    highScore = scanner.nextInt();
                }
                scanner.close();
            } else {
                highScore = 0;
                saveHighScore();
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem with input/output with file");
        }
    }

    // Update the high score if the current score is higher
    public void updateHighScore(int currentScore) {
        if (currentScore > highScore) {
            highScore = currentScore;
            saveHighScore();
        }
    }

    // Save the high score to file
    private void saveHighScore() {
        try {
            FileWriter writer = new FileWriter("Scores.txt");
            writer.write(Integer.toString(highScore));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Problem with input/output with file");
        }
    }

    public int getHighScore() {
        return highScore;
    }
}