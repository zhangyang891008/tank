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
	
	public static int WIDTH = ResourceMgr.tankD.getWidth();
	public static int HEIGHT = ResourceMgr.tankD.getHeight();
	
	Random random = new Random();
	
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
		if(this.g == Group.Bad && random.nextInt(10)>8) {
			this.fire();
		}
		
		if(this.g == Group.Bad && random.nextInt(100)>95) {
			this.changeDir();
		}
	}

	private void changeDir() {
		dir = Dir.values()[random.nextInt(4)];
	}

	private void move() {
		if(!moving)
			return;
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
		
		boundCheck();
		
	}

	private void boundCheck() {
		if(x<0) {
			x=0;
		}
		if(y<0) {
			y=0;
		}
		if(x>tf.frameSizeX-Tank.WIDTH) {
			x = tf.frameSizeX - Tank.WIDTH;
		}
		if(y>tf.frameSizeY - Tank.HEIGHT) {
			y = tf.frameSizeY - Tank.HEIGHT;
		}
	}

	public void fire() {
		int bx = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int by = y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
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
