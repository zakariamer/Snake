package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUIControls.Window;
import Models.Direction;
import Models.Snake;

public class Game extends JPanel {
	private Timer timer;
	private Snake snake;
	private final int GRID_SIZE = 20;
	private Direction nextDirection = null;

	public Game() {
		Window.setTitle("Snake");
		setDoubleBuffered(true);

		snake = new Snake();
		snake.setXLocation(180);
		snake.setYLocation(300);
		timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (nextDirection != null) {
					if (snake.getXLocation() % GRID_SIZE == 0 && snake.getYLocation() % GRID_SIZE == 0) {
						snake.setDirection(nextDirection);
						nextDirection = null;
					}
				}
				snake.update();
				repaint();
			}
		});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					if (snake.getDirection() != Direction.RIGHT) {
						nextDirection = Direction.LEFT;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					if (snake.getDirection() != Direction.LEFT) {
						nextDirection = Direction.RIGHT;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					if (snake.getDirection() != Direction.DOWN) {
						nextDirection = Direction.UP;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					if (snake.getDirection() != Direction.UP) {
						nextDirection = Direction.DOWN;
					}
				}
			}

		});

		this.setFocusable(true);

	}

	public void startGame() {
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;
		drawGrid(brush);
		snake.draw(brush);
	}

	private void drawGrid(Graphics2D g) {
		Color oldColor = g.getColor();
		int numberOfRows = this.getWidth() / GRID_SIZE;
		int numberOfColumns = this.getHeight() / GRID_SIZE;
		int counter = 0;
		for (int i = 0; i < numberOfColumns; i++) {
			for (int j = 0; j < numberOfRows; j++) {
				Color gridColor = counter % 2 == 0 ? Color.black : Color.white;
				g.setColor(gridColor);
				g.fillRect(j * GRID_SIZE, i * GRID_SIZE, GRID_SIZE, GRID_SIZE);
				counter++;
			}
		}
		g.setColor(oldColor);
	}

}
