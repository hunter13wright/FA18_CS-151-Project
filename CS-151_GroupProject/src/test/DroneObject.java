package test;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class DroneObject extends JComponent implements GameObject, PlayableObject
{
	private static int minY = 0, maxY;
	private static Image img;
	private double x, y;
	private double v;
	
	public static void setMax(int maxY) { DroneObject.maxY = maxY; }
	
	public static void setImage(Image img) { DroneObject.img = img; }
	
	public void draw(Graphics2D g2) { g2.drawImage(img, (int)x, (int)y, null); }

	public void move() { y += v; }
	
	public void changeDir() { v = -v; }
	
	public double getLeft() { return x; }

	public double getRight() { return x + img.getWidth(null); }

	public double getTop() { return y; }

	public double getBottom() { return y + img.getHeight(null); }
	
	public boolean checkBounds() { return (getTop() >= minY && getBottom() <= maxY); }
	
	public boolean intersects(GameObject o)
	{
		return getBottom() > o.getTop() && getTop() < o.getBottom() &&
				getLeft() > o.getRight() && getRight() < o.getLeft();
	}

	public DroneObject(double x, double y, double v)
	{
		this.x = x;
		this.y = y;
		this.v = v;
	}
}
