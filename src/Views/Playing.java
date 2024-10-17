package Views;

import javax.swing.JPanel;

import models.XOButton;

public class Playing extends JPanel {
  public Playing() {

    /********************************************/
    // Creates 9 XButtons (personalized button)  /
    /********************************************/

    for(int i = 0; i < 9; i++){
      XOButton button = new XOButton();
      button.setText("X");
      button.setSize(2,2);
      this.add(button);
    }
  }
}
