package Week4;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private GameBoard gameBoard;

    public ButtonClickListener(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameButton button = (GameButton) e.getSource();
        gameBoard.handleButtonClick(button);
    }
}
