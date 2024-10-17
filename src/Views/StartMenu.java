package Views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JPanel {
  public StartMenu(JButton startButton) {
    JLabel title = new JLabel();
    title.setText("XOXO GAME");

    this.add(title);
    this.add(startButton);
  }
}
