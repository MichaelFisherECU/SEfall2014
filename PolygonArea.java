import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * The main method that includes the panel in which the polygon is drawn. Includes all neccessary methods to operate on the polygon.
 */
public class PolygonArea extends JPanel{

	private static Color polyColor;
	private static Polygon poly2;
	static MouseClicker click;
	static int lineX;
	static int lineY;
	
	PolygonArea()
	{
		polyColor = Color.black;
		click = new MouseClicker();
		addMouseListener(click);
		setBorder(BorderFactory.createLineBorder(Color.black));
		poly2 = new Polygon();
	}
	
	
	// paint(g) updates g to the current color, shape, and polygon
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(polyColor);
		g.drawPolygon(poly2);
		g.fillPolygon(poly2);
	}
	
	
	//addtoPoly(x,y) adds a vertex to poly2 at position x, y
	
	public void addtoPoly(int x, int y)
	{
		poly2.addPoint(x, y);
		repaint();
	}
	
	
	// setColor(c) changes the color of the polygon to c
	
	public void setColor(Color c)
	{
		polyColor = c;
		repaint();
	}
	
	
	// clearPolygon() clears the canvas

	public void clearPolygon() 
	{
		
		poly2.reset();
		repaint();
	}

	
	// getPoints() returns the number of vertices
	
	public int getPoints() 
	{	
		return poly2.npoints;
	}
	
	
	// rayCast(x, y) performs a raycast at position x,y
	
	public static void rayCast(int x, int y)//raycast operation
	{	
		lineX = x;
		lineY = y;
		checkIntersections(poly2, new Point(lineX, lineY));
		click.setDrawRay(false);
	}
	
	
	// checkIntersections(p, ray) checks if ray intersects p

	public static void checkIntersections(Polygon p, Point ray)
	{
		int tintersections = 0;
		Line2D rayLine = new Line2D.Double(ray.getX(), ray.getY(), 512, ray.getY());
		Line2D curLine = new Line2D.Double();
	
		for(int i = 0; i < p.npoints; i++)//all points in polygon
		{
			if(i == (p.npoints-1))//use line from last point to first. connects them.
			{
				curLine = new Line2D.Double(
						p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0]);
			}
			else
			{
				curLine = new Line2D.Double(
						p.xpoints[i], p.ypoints[i], p.xpoints[i+1], p.ypoints[i+1]);
			}
			tintersections += checkIntersect(rayLine, curLine);//increment intersection count
		}
		if(tintersections%2 != 0)//lies in polygon
		{
			JOptionPane.showMessageDialog(null, "Click lies in Polygon");
		}
		else
		{
			if(p.npoints == 0 || p == null)		//polygon not drawn
			{
				JOptionPane.showMessageDialog(null, "Polygon not drawn");
			}
			else		//does not lie in polygon
			{
				JOptionPane.showMessageDialog(null, "Click does not lie in Polygon");
			}
		}	
	}
	
	
	// checkIntersect(l1, l2) returns 1 if l1 intersects l2 and 0 otherwise
	
	private static int checkIntersect(Line2D l1, Line2D l2)
	{
		if(l1.intersectsLine(l2))
		{
			return 1;	
		}
		else
			return 0;
	}
	
	
	// undoPoint() deletes the last vertex drawn and does nothing if no vertices exist
	
	public void undoPoint()
	{
		int temp = poly2.npoints;
		if(temp == 0)//empty
		{
			JOptionPane.showMessageDialog(null, "Polygon Empty");
			return;
		}
		else if(temp < 1)//not empty
		{
			return;
		}
		Polygon newPoly = new Polygon();
		for(int i = 0; i < temp-1; i++)//creates a new polygon with n-1 points
		{
			newPoly.addPoint(poly2.xpoints[i],poly2.ypoints[i]);
			repaint();
		}
		poly2 = newPoly;
	}
}

