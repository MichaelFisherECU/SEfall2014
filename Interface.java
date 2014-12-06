import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Interface extends JFrame{

	JButton raycastMode,clear,changeColor,paint,undo,pointNum,terminate;
	JPanel buttonArea,undoArea;
	GridBagLayout layout,jpanelLayout;
	GridBagConstraints c;
	Container content;
	ActionListener raycastButton, changeColorButton, undoButton, clearPolygon, points, paintAl, exitProgram;
	static PolygonArea pa;
	static Interface gui;
	
	Interface(String name)
	{
		super(name);
		pa = new PolygonArea();
		layout = new GridBagLayout();
		content = getContentPane();
		content.setLayout(layout);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		undoArea = new JPanel();
		undoArea.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonArea = new JPanel();
		raycastMode = new JButton("Ray Cast");
		changeColor = new JButton("Change Color");
		clear = new JButton("Clear Canvas");
		undo = new JButton("Undo Last");
		terminate = new JButton("Terminate");
	
		c = new GridBagConstraints();
		c.ipady = 500;
		c.gridx = 0;
		c.ipadx = 500;
		c.gridy = 0;
		content.add(pa,c);
		
		c.gridx = 1;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.ipady = 200;
		c.ipadx = 300;
		
		
		c.ipady = 25;
		c.ipadx = 80;
		c.gridx = 0;
		c.gridy = 1;
		content.add(buttonArea,c);
		
		c.ipady = 0;
		c.ipadx = 0;
		jpanelLayout = new GridBagLayout();
		buttonArea.setLayout(jpanelLayout);
		GridBagConstraints r = new GridBagConstraints();

		r.ipady = 25;
		r.ipadx = 100;
		buttonArea.add(raycastMode,r);
		r.ipadx = 50;
		buttonArea.add(clear,r);
		buttonArea.add(changeColor,r);
		
		r.gridx = 1;
		r.gridy = 0;
		r.ipadx = 10;
		r.ipady = 400;
		content.add(undoArea,r);
		
		r.gridx = 1;
		r.gridy = 1;
		r.ipadx = 25;
		r.ipady = 25;
		paint = new JButton("Paint Polygon");
		content.add(paint,r);
		

		pointNum = new JButton("Number of Points");
		GridBagLayout undoAreaLayout = new GridBagLayout();
		r = new GridBagConstraints();
		undoArea.setLayout(undoAreaLayout);
		r.gridx = 0;
		r.gridy = 0;
		r.ipady = 25;
		r.ipadx = 41;
		
		undoArea.add(undo,r);
		r.gridy = 1;
		r.gridx = 0;
		r.ipadx= 0;
		undoArea.add(pointNum,r);
		
		
		r.gridy = 2;
		r.ipadx = 41;
		undoArea.add(terminate,r);
		manageListeners(); //makes the acion listeners
		clear.addActionListener(clearPolygon);
		raycastMode.addActionListener(raycastButton);
		changeColor.addActionListener(changeColorButton);
		pointNum.addActionListener(points);
		paint.addActionListener(paintAl);
		undo.addActionListener(undoButton);
		terminate.addActionListener(exitProgram);
		
	
		pack();
	}

	public static void main(String[] args)
	{
		gui = new Interface("Version 1.0");
		gui.setVisible(true);
		gui.setSize(750,725);
	}
	private void manageListeners() {
			
			raycastButton = new ActionListener()//lets us start testing in/out
			{
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MouseClicker.setRayCastTime(true);
				}
				
			};
			
			clearPolygon = new ActionListener()//clears panel and enables drawing
			{
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MouseClicker.drawTime(false);
					MouseClicker.setDrawRay(false);
					pa.clearPolygon();
					//JOptionPane.showMessageDialog(null, "Polygon cleared");	
				}
			};
			
			changeColorButton = new ActionListener()//changes the color of polygon
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					pa.setColor(JColorChooser.showDialog( null, "Change Polygon Color", null));
				}
			};
			
			points = new ActionListener()//shows the number of points on current polygon
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Polygon has " + pa.getPoints() + " Points");
				}
			};
			
			paintAl = new ActionListener()//shows the number of points on current polygon
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					MouseClicker.setRayCastTime(false);
				}
			};
			
			undoButton = new ActionListener()//shows the number of points on current polygon
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					pa.undoPoint();
				}
			};
		
			exitProgram = new ActionListener()//shows the number of points on current polygon
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(ABORT);
				}
			};

		
	}
}

