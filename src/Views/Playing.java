package Views;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.XOButton;

public class Playing extends JPanel {

  private boolean isXTurn = true;
  private XOButton[] buttons = new XOButton[9];

  public Playing() {
    this.setLayout(new GridLayout(3, 3));

    for (int i = 0; i < 9; i++) {
      XOButton button = new XOButton();
      button.setText("");
      buttons[i] = button;
      button.addActionListener(new ButtonClickListener(i));
      this.add(button);
    }
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
      } else {
        button.setText("O");
      }

      isXTurn = !isXTurn;

      checkForWinner();
    }
  }
}
