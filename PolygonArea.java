import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PolygonArea extends JPanel{

	private static Color polyColor;
	private static Polygon poly2;
	static MouseClicker click;
	static int lineX;
	static int lineY;
	static int intersectNum = 0;
	int intersections = 0;
		
	PolygonArea()
	{
		polyColor = Color.black;
		click = new MouseClicker();
		addMouseListener(click);
		setBorder(BorderFactory.createLineBorder(Color.black));
		poly2 = new Polygon();
	}
	
	public void paint(Graphics g)//updates polygon per click
	{
		super.paint(g);
		g.setColor(polyColor);
		g.drawPolygon(poly2);
		g.fillPolygon(poly2);
		//repaint();//Questionable
	}
	
	public void addtoPoly(int x, int y)//adds a point to the polygon
	{
		poly2.addPoint(x, y);
		repaint();
	}
	
	public void setColor(Color c)
	{
		polyColor = c;
		repaint();
	}

	public void clearPolygon() {
		
		poly2.reset();
		repaint();
	}

	public int getPoints() {
		
		return poly2.npoints;
	}
	
	//Sets the raycast's parameters
	public static void rayCast(int x, int y)
	{	
		lineX = x;
		lineY = y;
		checkIntersections(poly2, new Point(lineX, lineY));
		//g.drawLine(lineX, lineY, 512 ,lineY);
		click.setDrawRay(false);
		
		
	
	}
	//Ryan's method to check the amount of intersections
	public static void checkIntersections(Polygon p, Point ray)
	{
		int tintersections = 0;
		Line2D rayLine = new Line2D.Double(ray.getX(), ray.getY(), 512, ray.getY());
		Line2D curLine = new Line2D.Double();
	
		for(int i = 0; i < p.npoints; i++)
		{
			if(i == (p.npoints-1))//use line from last point to first. connects them.
			{
				curLine = new Line2D.Double(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0]);
			}
			else
			{
				curLine = new Line2D.Double(p.xpoints[i], p.ypoints[i], p.xpoints[i+1], p.ypoints[i+1]);
			}
			
			tintersections += checkIntersect(rayLine, curLine);
		}
		if(tintersections%2 != 0)
		{
			System.out.println("In");
			JOptionPane.showMessageDialog(null, "Click lies in Polygon");
		}
		else
		{
			if(p.npoints == 0 || p == null)
			{
				JOptionPane.showMessageDialog(null, "Polygon not drawn");
			}
			else
			{
				System.out.println("Not in");
				JOptionPane.showMessageDialog(null, "Click does not lie in Polygon");
			}
		}	
	}
	private static int checkIntersect(Line2D l1, Line2D l2)
	{
		if(l1.intersectsLine(l2))
		{
			return 1;	
		}
		else
			return 0;
	}
	public void undoPoint()
	{
		int temp = poly2.npoints;
		if(temp == 0)
		{
			JOptionPane.showMessageDialog(null, "Polygon Empty");
			return;
		}
		else if(temp < 1)
		{
			return;
		}
		Polygon newPoly = new Polygon();
		for(int i = 0; i < temp-1; i++)
		{
			newPoly.addPoint(poly2.xpoints[i],poly2.ypoints[i]);
			repaint();
		}
		poly2 = newPoly;
	}
}
