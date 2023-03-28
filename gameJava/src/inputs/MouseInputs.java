package src.inputs;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import src.entities.Player;
import src.main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener {

  private GamePanel gamePanel;
  private Player player;

  public MouseInputs(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    this.player = gamePanel.getGame().getPlayer();

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      player.setAttack(true);
    }

  }

  @Override
  public void mousePressed(MouseEvent e) {

    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {

    System.out.println("mouse Move");

  }

}
