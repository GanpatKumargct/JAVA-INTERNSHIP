package Week4;

import javax.swing.*;
import java.awt.*;

public class MemoryGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainMenu = new JFrame("Memory Game");
            mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenu.setSize(200, 200);
            mainMenu.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
            buttonPanel.setBackground(Color.LIGHT_GRAY);

            JButton newGameButton = new JButton("New Game");
            newGameButton.setFont(new Font("Arial", Font.BOLD, 20));
            newGameButton.addActionListener(e -> {
                mainMenu.dispose();
                GameBoard gameBoard = new GameBoard();
                gameBoard.setVisible(true);
            });

            JButton helpButton = new JButton("Help");
            helpButton.setFont(new Font("Arial", Font.BOLD, 20));
            helpButton.addActionListener(e -> {
                HelpWindow helpWindow = new HelpWindow();
                helpWindow.setVisible(true);
            });

            buttonPanel.add(newGameButton);
            buttonPanel.add(helpButton);
            mainMenu.add(buttonPanel, BorderLayout.CENTER);

            mainMenu.setVisible(true);
        });
    }
}
