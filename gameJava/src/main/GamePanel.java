package src.main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.inputs.KeyboardInputs;
import src.inputs.MouseInputs;
import static src.utils.Constants.PlayerConstants.*;
import static src.utils.Constants.Directions.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
  private MouseInputs mouseInputs;
  private BufferedImage img;
  private BufferedImage[][] animations;
  private int animationTick, animationIndex, animationSpeed = 15;
  private float xDelta = 100, yDelta = 100;
  private int playerAction = IDLE;
  private int playerDir = -1;
  private boolean moving = false;

  public GamePanel() {
    mouseInputs = new MouseInputs(this);
    importImg();
    loadAnimations();
    setPanelSize();
    addKeyListener(new KeyboardInputs(this));
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);
  }

  private void loadAnimations() {
    animations = new BufferedImage[9][6];
    for (int j = 0; j < animations.length; j++) {

      for (int i = 0; i < animations[j].length; i++) {
        animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
      }
    }

  }

  private void importImg() {
    InputStream is = getClass().getResourceAsStream("../res/player_sprites.png");
    try {
      this.img = ImageIO.read(is);
    } catch (IOException e) {

      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  private void setPanelSize() {
    Dimension size = new Dimension(1280, 800);
    setMinimumSize(size);
    setPreferredSize(size);
    setMaximumSize(size);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    updateAnimationTick();
    setAnimation();
    updatePos();
    g.drawImage(animations[playerAction][animationIndex], (int) xDelta, (int) yDelta, 256, 160, null);

  }

  private void updatePos() {
    if (moving) {
      switch (playerDir) {
        case LEFT:
          xDelta -= 5;
          break;
        case RIGHT:
          xDelta += 5;
          break;
        case UP:
          yDelta -= 5;
          break;
        case DOWN:
          yDelta += 5;
          break;

      }
    }
  }

  private void setAnimation() {
    if (moving) {
      playerAction = RUNNING;
    } else {
      playerAction = IDLE;
    }
  }

  private void updateAnimationTick() {

    animationTick++;
    if (animationTick >= animationSpeed) {
      animationTick = 0;
      animationIndex++;
      if (animationIndex >= GetSpriteAmount(playerAction)) {
        animationIndex = 0;
      }

    }

  }

  public void setDirection(int direction) {
    this.playerDir = direction;
  }

  public void setMoving(boolean moving) {
    this.moving = moving;
  }

}
