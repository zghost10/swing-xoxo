package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.XOButton;

public class Playing extends JPanel {

  private boolean isXTurn = true;
  private XOButton[] buttons = new XOButton[9];
  private JButton resetButton;
  private JButton exitButton;
  private JLabel statusLabel;
  private int xWins = 0;
  private int oWins = 0;

  public Playing(ActionListener showStart) {
    this.setLayout(new BorderLayout(10, 10));
    
    JPanel gamePanel = new JPanel();
    gamePanel.setLayout(new GridLayout(3, 3, 5, 5));

    for (int i = 0; i < 9; i++) {
      XOButton button = new XOButton();
      button.setText("");
      button.setPreferredSize(new Dimension(80, 80));
      buttons[i] = button;
      button.addActionListener(new ButtonClickListener(i));
      gamePanel.add(button);
    }

    statusLabel = new JLabel("Vez do jogador X");
    statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
    statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));

    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(1, 2, 20, 0));

    resetButton = new JButton("Reiniciar Jogo");
    resetButton.addActionListener(e -> resetGame());
    resetButton.setFont(new Font("Arial", Font.PLAIN, 16));

    exitButton = new JButton("Voltar para o menu");
    exitButton.addActionListener(showStart);
    exitButton.setFont(new Font("Arial", Font.PLAIN, 16));

    controlPanel.add(resetButton);
    controlPanel.add(exitButton);

    this.add(statusLabel, BorderLayout.NORTH);
    this.add(gamePanel, BorderLayout.CENTER);
    this.add(controlPanel, BorderLayout.SOUTH);

    this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  }

  private void checkForWinner() {
    int[][] winningCombinations = {
      {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
      {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
      {0, 4, 8}, {2, 4, 6}
    };

    for (int[] combination : winningCombinations) {
      String b1 = buttons[combination[0]].getText();
      String b2 = buttons[combination[1]].getText();
      String b3 = buttons[combination[2]].getText();
      
      if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
        JOptionPane.showMessageDialog(this, "Jogador " + b1 + " venceu!");
        updateScore(b1);
        resetGame();
        return;
      }
    }

    boolean allButtonsFilled = true;
    for (XOButton button : buttons) {
      if (button.getText().equals("")) {
        allButtonsFilled = false;
        break;
      }
    }
    if (allButtonsFilled) {
      JOptionPane.showMessageDialog(this, "Empate!");
      resetGame();
    }
  }

  private void resetGame() {
    for (XOButton button : buttons) {
      button.setText("");
    }
    isXTurn = true;
    statusLabel.setText("Vez do jogador X");
  }

  private void updateScore(String winner) {
    if (winner.equals("X")) {
      xWins++;
    } else {
      oWins++;
    }
    JOptionPane.showMessageDialog(this, "Placar - X: " + xWins + " O: " + oWins);
  }

  private class ButtonClickListener implements ActionListener {
    private int index;

    public ButtonClickListener(int index) {
      this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      XOButton button = buttons[index];
      
      if (!button.getText().equals("")) {
        return;
      }

      if (isXTurn) {
        button.setText("X");
        statusLabel.setText("Vez do jogador O");
      } else {
        button.setText("O");
        statusLabel.setText("Vez do jogador X");
      }

      isXTurn = !isXTurn;

      checkForWinner();
    }
  }
}
