package src.main;

import javax.swing.JPanel;
import src.inputs.KeyboardInputs;
import src.inputs.MouseInputs;
import java.awt.Graphics;
import java.awt.Dimension;

public class GamePanel extends JPanel {
  private MouseInputs mouseInputs;
  private Game game;

  public GamePanel(Game game) {
    this.game = game;
    mouseInputs = new MouseInputs(this);

    setPanelSize();
    addKeyListener(new KeyboardInputs(this));
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);
  }

  private void setPanelSize() {
    Dimension size = new Dimension(1280, 800);
    setMinimumSize(size);
    setPreferredSize(size);
    setMaximumSize(size);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    game.render(g);

  }

  public Game getGame() {
    return this.game;
  }

}
