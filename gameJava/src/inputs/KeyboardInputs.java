package src.inputs;

import java.awt.event.KeyListener;

import src.main.GamePanel;
import static src.utils.Constants.Directions.*;

import java.awt.event.KeyEvent;

public class KeyboardInputs implements KeyListener {

  private GamePanel gamePanel;

  public KeyboardInputs(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_A:
        System.out.println("A key is pressed");
        gamePanel.setDirection(LEFT);
        gamePanel.setMoving(true);
        break;
      case KeyEvent.VK_W:
        System.out.println("W key is pressed");
        gamePanel.setDirection(UP);
        gamePanel.setMoving(true);
        break;
      case KeyEvent.VK_S:
        System.out.println("S key is pressed");
        gamePanel.setDirection(DOWN);
        gamePanel.setMoving(true);
        break;
      case KeyEvent.VK_D:
        System.out.println("D key is pressed");
        gamePanel.setDirection(RIGHT);
        gamePanel.setMoving(true);
        break;
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_A:
      case KeyEvent.VK_W:
      case KeyEvent.VK_S:
      case KeyEvent.VK_D:
        gamePanel.setMoving(false);

    }

  }

}
