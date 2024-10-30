package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Views.GameEnd;
import Views.Instructions;
import Views.Playing;
import Views.StartMenu;

public class Game extends JFrame {
  private JPanel currentPanel;

  private StartMenu startMenu;
  private Playing playing = new Playing(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
      showStart();
    }
  });
  private GameEnd gameEnd = new GameEnd();
  private Instructions instructions = new Instructions(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
      showStart();
    }
  });

  public Game() {
    this.setVisible(true);
    this.setSize(600, 480);
    this.setLocation(500, 200);

    startMenu = new StartMenu(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          startGame();
        }
      },
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          showInstructions();
        }
      }
    );
    currentPanel = startMenu;
    this.add(currentPanel);
  }

  public void showStart(){
    this.remove(currentPanel);
    currentPanel = startMenu;
    this.add(currentPanel);

    // Rerendering the frame
    this.revalidate();
    this.repaint();
  }

  public void startGame(){
    this.remove(currentPanel);
    currentPanel = playing;
    this.add(currentPanel);

    // Rerendering the frame
    this.revalidate();
    this.repaint();
  }

  public void showInstructions(){
    this.remove(currentPanel);
    currentPanel = instructions;
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
