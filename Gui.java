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
//Actionlisteners added 10/21/14

public class Gui extends JFrame {

	JButton draw,clear,changeColor,canvasArea,calcArea,undo,pointNum;
	JPanel buttonArea,undoArea;
	GridBagLayout layout,jpanelLayout;
	GridBagConstraints c;
	Container content;
	ActionListener drawButton, changeColorButton, calculateAreaButton, undoButton, clearPolygon, points;
	DrawPanel dp;
	
	Gui(String name)
	{
		super(name);
		//setResizable(false);
		layout = new GridBagLayout();
		//create jpanel layout for the button area.
		content = getContentPane();
		content.setLayout(layout);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		undoArea = new JPanel();
		undoArea.setBorder(BorderFactory.createLineBorder(Color.black));
		canvasArea = new JButton("Canvas Area");
		canvasArea.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonArea = new JPanel();
		//buttonArea.setBorder(BorderFactory.createLineBorder(Color.black));
		draw = new JButton("Draw");
		changeColor = new JButton("Change Color");
		clear = new JButton("Clear Canvas");
	
		c = new GridBagConstraints();
		c.ipady = 500;
		c.gridx = 0;
		c.ipadx = 500;
		c.gridy = 0;
		dp = new DrawPanel();
		content.add(dp,c);
		
		c.gridx = 1;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.ipady = 200;
		c.ipadx = 300;
		//content.add(undoArea,c);
		
		
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
		buttonArea.add(draw,r);
		r.ipadx = 50;
		buttonArea.add(clear,r);
		buttonArea.add(changeColor,r);
		
		r.gridx = 1;
		r.gridy = 0;
		r.ipadx = 10;
		r.ipady = 465;
		content.add(undoArea,r);
		
		r.gridx = 1;
		r.gridy = 1;
		r.ipadx = 25;
		r.ipady = 25;
		calcArea = new JButton("Calculate Area");
		content.add(calcArea,r);
		
		undo = new JButton("Undo Last");
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
		manageListeners(); //makes the acion listeners
		clear.addActionListener(clearPolygon);
		draw.addActionListener(drawButton);
		changeColor.addActionListener(changeColorButton);
		pointNum.addActionListener(points);
	
		pack();
	}
	//creats all the action listeners
	private void manageListeners() {
		
		drawButton = new ActionListener()//lets us start testing in/out
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MouseHandler.drawMe = true;
			}
			
		};
		
		clearPolygon = new ActionListener()//clears panel and enables drawing
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MouseHandler.drawMe = false;
				DrawPanel.poly2.reset();
				JOptionPane.showMessageDialog(null, "Polygon cleared");	
			}
		};
		
		changeColorButton = new ActionListener()//changes the color of polygon
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawPanel.polyColor = JColorChooser.showDialog( null, "Change Polygon Color", null);
			}
		};
		
		points = new ActionListener()//shows the number of points on current polygon
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Polygon has " + DrawPanel.poly2.npoints + " Points");
			}
		};
		
	}

	public static void main(String[] args)
	{
		Gui test = new Gui("Polygon Dimension Analysis Tool");
		test.setSize(725,675);
		test.setVisible(true);
	}
	
}
