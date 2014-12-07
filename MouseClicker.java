import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClicker implements MouseListener{

	static Boolean drawMe = true;
	private static Boolean drawRay = false;
	static Boolean rayCastTime = false;

	//Gets the location of the mouse click
	@Override
	public void mouseClicked(MouseEvent arg0){
	
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
	static void drawTime(boolean b) {
		drawMe = b;
	}
	public static Boolean getDrawRay() {
		return drawRay;
	}
	
	public static void setDrawRay(Boolean b)
	{
		drawRay = b;
	}
	public static void setRayCastTime(boolean b) {
		rayCastTime = b;
		
	}
};
	
