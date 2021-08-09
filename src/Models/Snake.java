package Models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;

import SwingShapes.Ellipse;

public class Snake {
	private int xLocation;
	private int yLocation;
	private Ellipse head;
	private LinkedList<Segment> segments = new LinkedList<Segment>();
	private Direction direction;
	private int speed;
	
	public Snake() {
		direction = Direction.UP;
		head = new Ellipse();
		head.setColor(Color.green);
		head.setSize(20,  20);
		speed = 4;
	}

	public int getXLocation() {
		return head.getXLocation();
	}

	public void setXLocation(int locationX) {
		head.setLocation(locationX, head.getYLocation());
	}

	public int getYLocation() {
		return head.getYLocation();
	}

	public void setYLocation(int locationY) {
		head.setLocation(head.getXLocation(), locationY);
	}
	
	public void addSegment() {
		segments.add(new Segment());
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
	
//	public void right() {
//		if (direction != Direction.LEFT) {
//			direction =  Direction.RIGHT;
//		}
//	}
//	
//	public void left() {
//		if (direction != Direction.RIGHT) {
//			direction =  Direction.LEFT;
//		}
//	}
//	
//	public void up() {
//		if (direction != Direction.DOWN) {
//			direction =  Direction.UP;
//		}
//	}
//	
//	public void down() {
//		if (direction != Direction.UP) {
//			direction =  Direction.DOWN;
//		}
//	}

	
	public void update() {
		switch (direction) {
			case LEFT:
			case RIGHT:
				head.setLocation(head.getXLocation() + direction.getVelocity() * speed, head.getYLocation());
				break;
			case UP:
			case DOWN:
				head.setLocation(head.getXLocation(), head.getYLocation() + direction.getVelocity() * speed);
				break;

		}
	}
	
	public void draw(Graphics2D g) {
		head.paint(g);
	}
}
