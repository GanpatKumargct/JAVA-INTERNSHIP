package Week4;

import javax.swing.*;
import java.awt.*;



public class GameButton extends JButton {
    private String symbol;
    private boolean revealed;

    public GameButton(String symbol) {
        this.symbol = symbol;
        this.revealed = false;
        setBackground(Color.MAGENTA);
        setFont(new Font("BOLD", Font.BOLD, 40));
        setForeground(Color.DARK_GRAY);  // Set text color to make it visible
        setFocusPainted(false); // Removes the focus border around the button
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void reveal() {
        setText(symbol);
        revealed = true;
    }

    public void hide() {
        setText("");
        revealed = false;
    }

    public void disableButton() {
        setEnabled(false);
    }

    public void resetButton(String newSymbol) {
        this.symbol = newSymbol;
        this.revealed = false;
        setText("");
        setEnabled(true);
    }
}
