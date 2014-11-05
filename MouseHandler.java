import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class MouseHandler implements MouseListener{

	static Boolean drawMe = false;
	int xValue, yValue;
	//Gets the location of the mouse click and shows us
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(drawMe == true)//if the polygon has been drawn.
		{
			//TODO raycast
			
		}
		else//keep adding to the polygon
		{
			xValue = arg0.getX();
			yValue = arg0.getY();
			//JOptionPane.showMessageDialog(null, xValue + " " + yValue);
			DrawPanel.addtoPoly(xValue,yValue);
			
			
			
			
		}
		
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
