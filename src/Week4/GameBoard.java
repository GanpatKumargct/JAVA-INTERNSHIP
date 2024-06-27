package Week4;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard extends JFrame {
    private GameButton[][] buttons;
    private String[] symbols;
    private GameButton firstButton, secondButton;
    private boolean checkingPair;
    private int moves;
    private JLabel scoreLabel;
    private int score;

    public GameBoard() {
        setTitle("Memory Game");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.pink);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.BLUE);
        add(scoreLabel, BorderLayout.NORTH);

        JPanel gamePanel = new JPanel(new GridLayout(4, 4));
        gamePanel.setBackground(Color.BLUE);
        add(gamePanel, BorderLayout.CENTER);

        symbols = new String[]{
                "A", "B", "C", "D",
                "E", "F", "G", "H"
        };

        ArrayList<String> symbolsList = new ArrayList<>();
        for (String symbol : symbols) {
            symbolsList.add(symbol);
            symbolsList.add(symbol);
        }
        Collections.shuffle(symbolsList);

        buttons = new GameButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new GameButton(symbolsList.get(i * 4 + j));
                buttons[i][j].addActionListener(new ButtonClickListener(this));
                gamePanel.add(buttons[i][j]);
            }
        }

        setVisible(true);
        checkingPair = false;
        moves = 0;
        score = 0;
    }

    public void handleButtonClick(GameButton button) {
        if (checkingPair || button.isRevealed()) {
            return;
        }

        button.reveal();

        if (firstButton == null) {
            firstButton = button;
        } else {
            secondButton = button;
            checkingPair = true;
            Timer timer = new Timer(500, e -> checkPair());
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void checkPair() {
        if (firstButton.getSymbol().equals(secondButton.getSymbol())) {
            firstButton.disableButton();
            secondButton.disableButton();
            score += 10;
        } else {
            firstButton.hide();
            secondButton.hide();
            score -= 5;
        }

        firstButton = null;
        secondButton = null;
        checkingPair = false;
        scoreLabel.setText("Score: " + score);

        if (isGameOver()) {
            JOptionPane.showMessageDialog(this, "Congratulations! You've matched all pairs.");
            int option = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        }
    }

    private boolean isGameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (buttons[i][j].isEnabled()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        ArrayList<String> symbolsList = new ArrayList<>();
        for (String symbol : symbols) {
            symbolsList.add(symbol);
            symbolsList.add(symbol);
        }
        Collections.shuffle(symbolsList);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].resetButton(symbolsList.get(i * 4 + j));
            }
        }

        moves = 0;
        score = 0;
        scoreLabel.setText("Score: " + score);
        firstButton = null;
        secondButton = null;
        checkingPair = false;
    }
}
