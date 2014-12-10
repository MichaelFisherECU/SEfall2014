import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;

import org.junit.Test;


public class testInterface {
	static Interface gui;
	Polygon poly2;
	final static Dimension guiDimension = new Dimension(750,725);
	
	@Test
	public void testAddition() {
		int x = 3 + 3;
		assertEquals(x, 6);	
	}
	@Test
	public void testNumPoints() {  
	
//		Polygon newPoly = new Polygon();
//	
//		assertEquals(newPoly.npoints, 0);  //Tests to see if polygon has zero point
//		
//		newPoly.addPoint(1, 2);
//		assertEquals(newPoly.npoints, 1); //Tests to see if polygon has one point
//		
//		newPoly.reset();
//		assertEquals(newPoly.npoints, 0); //Tests to see if reset() sets num of points to zero
//		
		
		PolygonArea pa = new PolygonArea();

		gui = new Interface("Version 1.1");
		gui.setVisible(true);
		gui.setSize(guiDimension);
		

		
		
		
		
		pa.addtoPoly(1,2);		
		assertEquals(pa.getPoints(), 1); 	//Tests addtoPoly to see if polygon has one added point
		
		pa.undoPoint();
		assertEquals(pa.getPoints(), 0); 	//Tests to see if undoPoint removes one point from the polygon
//		pa.undoPoint();
		assertEquals(pa.getPoints(), 0); 	//Tests to see if undoPoint removes one point from the polygon
											//Message stating polygon is empty should be shown
		
		
		for (int i = 1; i <= 10; i++){
			pa.addtoPoly(i,i + 1);
			assertEquals(pa.getPoints(), i);  //Adds 11 points and uses getPoints to see if the correct number of points are added
		}
		
		pa.undoPoint();
		assertEquals(pa.getPoints(), 9);  //Checks undoPoint function again with higher number of points
		
		pa.clearPolygon();
		assertEquals(pa.getPoints(), 0); 	//Tests to see if polygon has zero points after clearing the polygon
		
		pa.addtoPoly(25,25);
		pa.addtoPoly(25,50);
		pa.addtoPoly(50,50);
		pa.addtoPoly(50,25);
		pa.addtoPoly(60,200);
		pa.addtoPoly(1000,1000);
		pa.addtoPoly(50,25);
		
		
		int x = 1;
		int y = 1;
		Point pnt = new Point(x, y);
		
		

	//	assertEquals(PolygonArea.checkIntersections(pa.poly2, pnt),PolygonArea.tintersections%2 != 0);
		pnt = new Point(25, 25);
		PolygonArea.checkIntersections(pa.poly2, pnt);//Tests on line of polygon
		
		pnt = new Point(26, 26);
		PolygonArea.checkIntersections(pa.poly2, pnt);//Tests inside of polygon
		
		pnt = new Point(1, 1);
		PolygonArea.checkIntersections(pa.poly2, pnt);  //Tests outside of polygon

//		pa.addtoPoly(60,200);
//		pa.addtoPoly(1000,1000);
//		pa.addtoPoly(50,25);
		
		pnt = new Point(100, 100);
		PolygonArea.checkIntersections(pa.poly2, pnt);  //Tests outside of polygon
		
		//**Cleanup Later**
//		Interface gui = new Interface("Version 1.0");
//		gui.setVisible(true);
//		gui.setSize(750,725);
//		
//		PolygonArea pa2 = new PolygonArea();
//		for (int i = 1; i <= 10; i++){
//			pa.addtoPoly(i,i + 1);
//			assertEquals(pa.getPoints(), i);
//		}
		
	}
	
}
