package Models;

import java.awt.Color;
import java.awt.Graphics2D;

import SwingShapes.Ellipse;

public class Segment {
	private Ellipse segment;
	private Direction direction;
	
	public Segment(int startXLocation, int startYLocation, Color color) {
		segment = new Ellipse();
		segment.setColor(color);
		segment.setSize(20,  20);
		segment.setLocation(startXLocation, startYLocation);
	}

	public int getXLocation() {
		return segment.getXLocation();
	}

	public void setXLocation(int locationX) {
		segment.setLocation(locationX, segment.getYLocation());
	}

	public int getYLocation() {
		return segment.getYLocation();
	}

	public void setYLocation(int locationY) {
		segment.setLocation(segment.getXLocation(), locationY);
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public void setColor(Color color) {
		segment.setColor(color);
	}
	
	public void draw(Graphics2D g) {
		segment.paint(g);
	}
}
