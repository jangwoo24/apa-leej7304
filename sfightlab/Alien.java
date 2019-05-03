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

  public void draw( Graphics window )
  { 
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
