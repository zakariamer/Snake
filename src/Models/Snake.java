package Models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;

import SwingShapes.Ellipse;

public class Snake {
	private LinkedList<Segment> segments = new LinkedList<Segment>();
	private Direction direction;
	private int speed;

	public Snake(int startXLocation, int startYLocation) {
		direction = Direction.UP;
		segments.add(new Segment(startXLocation, startYLocation, Color.green));
	}

	public int getXLocation() {
		return segments.get(0).getXLocation();
	}

	public void setXLocation(int locationX) {
		segments.get(0).setXLocation(locationX);
	}

	public int getYLocation() {
		return segments.get(0).getYLocation();
	}

	public void setYLocation(int locationY) {
		segments.get(0).setYLocation(locationY);
	}

	public void addSegment() {
		Segment tail = segments.get(segments.size() - 1);
		switch (direction) {
			case LEFT:
				segments.add(new Segment(tail.getXLocation() - 20, tail.getYLocation(), new Color(0, 130, 255)));
				break;
			case RIGHT:
				segments.add(new Segment(tail.getXLocation() + 20, tail.getYLocation(), new Color(0, 130, 255)));
				break;
			case UP:
				segments.add(new Segment(tail.getXLocation(), tail.getYLocation() - 20, new Color(0, 130, 255)));
				break;
			case DOWN:
				segments.add(new Segment(tail.getXLocation(), tail.getYLocation() + 20, new Color(0, 130, 255)));
				break;
			}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void update() {
		Segment head = segments.get(0);
		head.setColor(new Color(0, 130, 255));
		segments.remove(segments.size() - 1);
		int newXLocation = head.getXLocation();
		int newYLocation = head.getYLocation();
		switch (direction) {
			case LEFT:
				newXLocation -= 20;
				break;
			case RIGHT:
				newXLocation += 20;
				break;
			case UP:
				newYLocation -= 20;
				break;
			case DOWN:
				newYLocation += 20;
				break;
		}
		segments.add(0, new Segment(newXLocation, newYLocation, Color.green));
	}

	public void draw(Graphics2D g) {
		for (Segment segment : segments) {
			segment.draw(g);
		}
	}
}
