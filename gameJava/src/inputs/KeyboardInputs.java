package src.inputs;

import java.awt.event.KeyListener;

import src.main.GamePanel;

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
    // TODO Auto-generated method stub

  }

  @Override
  public void keyReleased(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_A:
        System.out.println("A key is pressed");
        gamePanel.changeXDelta(-1);
        break;
      case KeyEvent.VK_W:
        System.out.println("W key is pressed");
        gamePanel.changeYDelta(-1);
        break;
      case KeyEvent.VK_S:
        System.out.println("S key is pressed");
        gamePanel.changeYDelta(+1);
        break;
      case KeyEvent.VK_D:
        System.out.println("D key is pressed");
        gamePanel.changeXDelta(+1);
        break;
    }

  }

}
