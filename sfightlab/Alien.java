//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private int speed;
  private Image image;
  private int yCount = 4;
  private String direction = "LEFT";

  public Alien()
  {
    this(0,0,30,30,0);
  }

  public Alien(int x, int y)
  {
    this(x,y,30,30,0);
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,30,30,s);
  }

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w,h);
    speed=s;
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      System.out.println("\n----------ALIEN ERROR BEGINS----------\n");
      e.printStackTrace();
      System.out.println("\n----------ALIEN ERROR ENDS----------\n");
    }
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  private void setDirection(String direction) {
    this.direction = direction;
  }

  public void move(String direction)
  {
    if(direction.equals("DOWN")) {
      setY(getY() + getSpeed());
    }
    if(direction.equals("LEFT")) {
      setX(getX() - getSpeed());
    }
    if(direction.equals("RIGHT")) {
      setX(getX() + getSpeed());
    }
  }

  public void move()
  {
    /*if(getX() <= getWidth() && goingLeft) {
      if(getY() < yCount*getHeight())
        move("DOWN");
      else {
        goingLeft = false;
        yCount += 2;
      }
    }
    else if(getX() + getWidth() >= 800 && !goingLeft) {
      if(getY() < yCount*getHeight())
        move("DOWN");
      else {
        goingLeft = true;
        yCount += 2;
      }
    }
    else {
      if(goingLeft)
        move("LEFT");
      else
        move("RIGHT");
    }*/
    //setX(getX()+speed);
    if((getX() < 10 && "LEFT".equals(direction)) || (getX() > 750 && "RIGHT".equals(direction)))
    {
      move("DOWN");
      if(getY() >= yCount*getHeight()) {
        if("LEFT".equals(direction))
          direction = "RIGHT";
        else
          direction = "LEFT";
        yCount += 2;
      }
    } else
      move(direction);
  }

  public void draw( Graphics window )
  { 
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
