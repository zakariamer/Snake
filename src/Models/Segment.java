package Models;

import java.awt.Color;
import java.awt.Graphics2D;

import SwingShapes.Rectangle;

public class Segment {
	private Rectangle segment;
	
	public Segment(int startXLocation, int startYLocation, boolean isHead) {
		segment = new Ellipse();
		if(isHead){
			segment.setColor(new Color(0,0,225)); //head segment color (bright blue)
		}else{
			segment.setColor(new Color(0,0,139));	//tail segment color(dark blue)
		}

		segment.setSize(20,  20);
		segment.setLocation(startXLocation, startYLocation);
	}

	public int getXLocation() {
		return segment.getXLocation();
	}

	public int getYLocation() {
		return segment.getYLocation();
	}
	
	public void setColor(Color color) {
		segment.setColor(color);
	}
	
	public void draw(Graphics2D g) {
		segment.paint(g);
	}
}
