package com.zy.tank;

import java.awt.Graphics;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Bullet {

	private int x,y;
	private Dir dir;
	TankFrame tf;
	private static int SPEED=15;
	private boolean alive = true;
	public Bullet(int x, int y, Dir down, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = down;
		this.tf = tankFrame;
	}
	
	public void paint(Graphics g) {
		//判断坦克还在屏幕中的时候再进行绘制
		if(isAlive()) {
			g.fillOval(x, y, 20, 20);
			move();
		}
	}

	public boolean isAlive() {
		if(x<0 || y<0 || x>tf.frameSizeX || y>tf.frameSizeY) {
			System.out.println("position:("+x+","+y+")");
			return false;
		}
		return true;
	}

	private void move() {	
		switch(dir) {
		case LEFT:
			x-= SPEED;
			break;
		case RIGHT:
			x+=SPEED;
			break;
		case UP:
			y-=SPEED;
			break;
		case DOWN:
			y+=SPEED;
			break;
		}
		
	}

}
