package com.zy.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Group;

public class TankFrame extends Frame{
 
	private static final long serialVersionUID = 1L;
	
	public static int frameSizeX = 800;
	public static int frameSizeY = 800;
	
    public TankFrame() {
    	 
    	setTitle("tank war");
    	setVisible(true);
    	setSize(frameSizeX, frameSizeY);
    	setBackground(Color.BLACK);
    	this.addKeyListener(new MyKeyListener());
    	this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
    		
		});
    	TankFacade.setTank(TankFacade.factory.createTank(200, 200, Dir.DOWN, Group.Good));
	}

	@Override
	public void paint(Graphics g) {
		TankFacade.paint(g);
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
			case KeyEvent.VK_CONTROL:
				System.out.println("control....");
				TankFacade.getTank().fire();
				break;
			}
				
			setTankDir();
		}

		private void setTankDir() {
			if(!LEFT && !RIGHT && !UP && !DOWN) TankFacade.getTank().setMoving(false);
			else {
				TankFacade.getTank().setMoving(true);
				if(RIGHT) TankFacade.getTank().setDir(Dir.RIGHT);
				if(LEFT)  TankFacade.getTank().setDir(Dir.LEFT);
				if(UP) TankFacade.getTank().setDir(Dir.UP);
				if(DOWN) TankFacade.getTank().setDir(Dir.DOWN);
			}
		}
		
	}
}
