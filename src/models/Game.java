package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Views.GameEnd;
import Views.Playing;
import Views.StartMenu;

public class Game extends JFrame {
  private JPanel currentPanel;
  private JButton startButton;

  private StartMenu startMenu;
  private Playing playing = new Playing();
  private GameEnd gameEnd = new GameEnd();

  public Game() {
    this.setVisible(true);
    this.setSize(600, 480);
    this.setLocation(500, 200);

    startButton = new JButton("Start game");

    startButton.addActionListener((ActionListener) new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        startGame();
      }
  });

    startMenu = new StartMenu(startButton);
    currentPanel = startMenu;
    this.add(currentPanel);
  }

  public void startGame(){
    this.remove(currentPanel);
    currentPanel = playing;
    this.add(currentPanel);

    // Rerendering the frame
    this.revalidate();
    this.repaint();
  }

  public void showWinner(){
    this.remove(currentPanel);
    currentPanel = gameEnd;
    this.add(currentPanel);

    // Rerendering the frame
    this.revalidate();
    this.repaint();
  }
}
