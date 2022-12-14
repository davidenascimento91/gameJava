package src.main;

import javax.swing.JFrame;

public class GameWindow {
  private JFrame jFrame;

  public GameWindow(GamePanel gamePanel) {
    jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.add(gamePanel);
    jFrame.setResizable(false);
    jFrame.pack();
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

}
