package com.zy.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int x = 200,y=200;
	Tank tank = new Tank(x, y, Dir.DOWN, this);
	
    public TankFrame() {
    	setTitle("tank war");
    	setVisible(true);
    	setSize(600, 800);
    	this.addKeyListener(new MyKeyListener());
    	this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
    		
		});
	}

	@Override
	public void paint(Graphics g) {
		tank.paint(g);
	}
	
	class MyKeyListener extends KeyAdapter{
		boolean RIGHT = false;
		boolean LEFT = false;
		boolean UP = false;
		boolean DOWN = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_RIGHT:
				RIGHT = true;
				System.out.println("right");
				break;
			case KeyEvent.VK_LEFT:
				LEFT = true;
				break;
			case KeyEvent.VK_UP:
				UP = true;
				break;
			case KeyEvent.VK_DOWN:
				DOWN = true;
				break;
			}
			
			setTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_RIGHT:
				RIGHT = false;
				break;
			case KeyEvent.VK_LEFT:
				LEFT = false;
				break;
			case KeyEvent.VK_UP:
				UP = false;
				break;
			case KeyEvent.VK_DOWN:
				DOWN = false;
				break;
			}
			
			setTankDir();
		}

		private void setTankDir() {
			if(!LEFT && !RIGHT && !UP && !DOWN) tank.setMoving(false);
			else {
				tank.setMoving(true);
				if(RIGHT) tank.setDir(Dir.RIGHT);
				if(LEFT)  tank.setDir(Dir.LEFT);
				if(UP) tank.setDir(Dir.UP);
				if(DOWN) tank.setDir(Dir.DOWN);
			}
		
			
		}
		
	}

}
