package src.entities;

import static src.utils.Constants.PlayerConstants.*;
import static src.utils.Constants.Directions.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Player extends Entity {

  private BufferedImage[][] animations;
  private int animationTick, animationIndex, animationSpeed = 15;
  private int playerAction = IDLE;
  private boolean right, left, up, down;
  private boolean attacking;
  private float speed = 2.0f;
  private boolean moving = false;

  public Player(float x, float y) {
    super(x, y);
    loadAnimations();
  }

  public void update() {
    updatePos();
    updateAnimationTick();
    setAnimation();
  }

  private void updatePos() {

    moving = false;

    if (left && !right) {
      x -= speed;
      moving = true;
    } else if (right && !left) {
      x += speed;
      moving = true;
    }

    if (up && !down) {
      y -= speed;
      moving = true;
    } else if (down && !up) {
      y += speed;
      moving = true;
    }
  }

  public void setAttack(boolean attacking) {
    this.attacking = attacking;
  }

  public void render(Graphics g) {

    g.drawImage(animations[playerAction][animationIndex], (int) x, (int) y, 256, 160, null);
  }

  private void loadAnimations() {

    InputStream is = getClass().getResourceAsStream("../res/player_sprites.png");
    try {
      BufferedImage img = ImageIO.read(is);
      animations = new BufferedImage[9][6];
      for (int j = 0; j < animations.length; j++) {

        for (int i = 0; i < animations[j].length; i++) {
          animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
        }
      }
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

  private void setAnimation() {
    int startAnimation = playerAction;
    if (moving) {
      playerAction = RUNNING;
    } else {
      playerAction = IDLE;
    }
    if (attacking) {
      playerAction = ATTACK_1;
    }

    if (startAnimation != playerAction) {
      resetAniTick();
    }
  }

  private void resetAniTick() {
    animationIndex = 0;
    animationTick = 0;
  }

  private void updateAnimationTick() {
    animationTick++;
    if (animationTick >= animationSpeed) {
      animationTick = 0;
      animationIndex++;
      if (animationIndex >= GetSpriteAmount(playerAction)) {
        animationIndex = 0;
        attacking = false;
      }

    }

  }

  public void resetDirBooleans() {
    this.down = false;
    this.up = false;
    this.right = false;
    this.left = false;
  }

  public boolean isRight() {
    return right;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  public boolean isLeft() {
    return left;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public boolean isUp() {
    return up;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public boolean isDown() {
    return down;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

}
