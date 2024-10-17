package Views;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameEnd extends JPanel {
  public GameEnd() {
    JLabel title = new JLabel();
    title.setText("O vencedor é: ");

    this.add(title);
  }
}
