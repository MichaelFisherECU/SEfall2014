import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DrawPanel extends JPanel{

	static Color polyColor;
	static Polygon poly2;
	static Boolean drawTime;
	MouseHandler mh = new MouseHandler();
	
	DrawPanel()
	{
		//setBackground(Color.blue);
		polyColor = Color.black;
		setBorder(BorderFactory.createLineBorder(Color.black));
		poly2 = new Polygon();
		drawTime = false;
		addMouseListener(mh);
		
		
	}
	public void paint(Graphics g)//updates polygon per click
	{
		super.paint(g);
		g.setColor(polyColor);
		g.drawPolygon(poly2);
		repaint();
	}
	public static void addtoPoly(int x, int y)//adds a point to the polygon
	{
		poly2.addPoint(x, y);		
	}
	
	public static void undoPoint()
	{
		//TODO remove last point in array
	}
}
