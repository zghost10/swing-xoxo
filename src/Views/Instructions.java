package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Instructions extends JPanel {

    public Instructions(ActionListener backAction) {
        this.setLayout(new BorderLayout(10, 10));

        JLabel instructionsTitle = new JLabel("Instruções do Jogo");
        instructionsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        instructionsTitle.setFont(new Font("Arial", Font.BOLD, 28));
        instructionsTitle.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JTextArea instructionsText = new JTextArea();
        instructionsText.setText(
            "1. O jogo é disputado em um tabuleiro 3x3.\n" +
            "2. Dois jogadores se alternam para marcar X ou O.\n" +
            "3. O primeiro jogador a alinhar 3 marcas na horizontal,\n" +
            "   vertical ou diagonal vence.\n" +
            "4. Se todas as células forem preenchidas sem um vencedor,\n" +
            "   o jogo termina em empate."
        );
        instructionsText.setFont(new Font("Arial", Font.PLAIN, 16));
        instructionsText.setEditable(false);
        instructionsText.setBackground(this.getBackground());
        instructionsText.setMargin(new Insets(10, 10, 10, 10));

        JButton backButton = new JButton("Voltar ao Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(backAction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        this.add(instructionsTitle, BorderLayout.NORTH);
        this.add(new JScrollPane(instructionsText), BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }
}
