package com.zy.tank;

import java.awt.Graphics;
import java.util.Random;

public class Tank {
	private static int SPEED = 2;
	private Dir dir = Dir.DOWN;
	private boolean moving = true;
	private int x;
	private int y;
	private TankFrame tf;
	private boolean alive = true;
	private Group g;
	
	public static int getSPEED() {
		return SPEED;
	}

	public static void setSPEED(int sPEED) {
		SPEED = sPEED;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}

	public Tank(int x, int y, Dir dir,Group g, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.g = g;
		this.tf = tf;
	}
	
	public void paint(Graphics g){
		if(!isAlive()) {
			tf.enemyTanks.remove(this);
			return;
		}
		
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, x, y, null);
			//g.fillRect(x, y, 50, 50);
			break;
		}
		move();
		
		//添加随机fire
		if(new Random().nextInt(10)>8) {
			this.fire();
		}
	}

	private void move() {
		if(!moving)
			return;
		int initx = x;
		int inity = y;
		switch(dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		if(x<0||y<0|x>(tf.frameSizeX-ResourceMgr.tankD.getWidth())|y>(tf.frameSizeY-ResourceMgr.tankD.getHeight())) {
			x = initx;
			y = inity;
		}
	}

	public void fire() {
		int bx = x+ResourceMgr.tankD.getWidth()/2 -ResourceMgr.bulletD.getWidth()/2;
		int by = y+ResourceMgr.tankD.getHeight()/2 - ResourceMgr.bulletD.getHeight()/2;
		tf.bullets.add(new Bullet(bx, by, dir,g,tf));
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Group getG() {
		return g;
	}

	public void setG(Group g) {
		this.g = g;
	}
	
}
