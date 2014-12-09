import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Implements MouseListener for recording mouse input. 
 * The only implemented method used is the MouseClicked, 
 * therefore only stationary input is recorded.
 */

public class MouseClicker implements MouseListener{

	static Boolean draw = true;
	private static Boolean drawRay = false;
	static Boolean rayCastTime = false;

	// mouseClicked(arg0) gets the location of the mouse click at arg0
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if(rayCastTime)//if the polygon has been drawn.
		{
			PolygonArea.rayCast(arg0.getX(), arg0.getY());
			setDrawRay(true);
			
		}
		else//keep adding to the polygon
		{
			Interface.pa.addtoPoly(arg0.getX(), arg0.getY());
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	// drawTime(b) sets draw to b
	
	static void drawTime(boolean b) 
	{
		draw = b;
	}
	
	
	// getDrawRay() returns the status of the ray cast
	
	public static Boolean getDrawRay() {
		return drawRay;
	}
	
	
	// setDrawRay(b) sets drawRay to b
	
	public static void setDrawRay(Boolean b)
	{
		drawRay = b;
	}
	
	
	// setRayCastTime(b) sets rayCastTime to b
	
	public static void setRayCastTime(boolean b) 
	{
		rayCastTime = b;
	}
}
	
