package src.main;

import javax.swing.JPanel;

import src.inputs.KeyboardInputs;
import src.inputs.MouseInputs;

import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel {
  private MouseInputs mouseInputs;
  private int xDelta = 100, yDelta = 100;
  private Color rectColor = Color.red;

  public GamePanel() {
    mouseInputs = new MouseInputs(this);
    addKeyListener(new KeyboardInputs(this));
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(rectColor);
    g.fillRect(xDelta, yDelta, 200, 50);
  }

  public void setRectPos(int x, int y) {
    this.xDelta = x;
    this.yDelta = y;
    repaint();
  }

  public void changeRectColor() {
    if (this.rectColor == Color.red) {
      this.rectColor = Color.BLUE;
    } else {
      this.rectColor = Color.red;
    }
    repaint();
  }

  public void changeXDelta(int value) {
    this.xDelta += value;
    repaint();
  }

  public void changeYDelta(int value) {
    this.yDelta += value;
    repaint();
  }

}
