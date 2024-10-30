package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartMenu extends JPanel {

    public StartMenu(ActionListener startAction, ActionListener instructionsAction) {
        this.setLayout(new BorderLayout(10, 10));
        
        JLabel title = new JLabel("XOXO GAME");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton startButton = new JButton("Iniciar Jogo");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.addActionListener(startAction);
        buttonPanel.add(startButton);

        JButton instructionsButton = new JButton("Instruções");
        instructionsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        instructionsButton.addActionListener(instructionsAction);
        buttonPanel.add(instructionsButton);
  
        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }
}
