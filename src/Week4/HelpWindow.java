package Week4;

import javax.swing.*;
import java.awt.*;

public class HelpWindow extends JFrame {
    public HelpWindow() {
        setTitle("How to Play");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JTextArea instructions = new JTextArea(
                "Memory Game Instructions:\n\n" +
                        "1. Click on a button to reveal the symbol hidden underneath it.\n" +
                        "2. Click on a second button to reveal its symbol.\n" +
                        "3. If the symbols match, the buttons will stay revealed, and you score points.\n" +
                        "4. If they don't match, the symbols will be hidden again after a short delay, and you lose points.\n" +
                        "5. Continue clicking buttons to find all matching pairs.\n" +
                        "6. The game ends when all pairs are matched. A congratulatory message will appear, and you'll be given the option to play again."
        );
        instructions.setFont(new Font("Arial", Font.PLAIN, 14));
        instructions.setEditable(false);
        instructions.setBackground(Color.LIGHT_GRAY);
        add(new JScrollPane(instructions), BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }
}

