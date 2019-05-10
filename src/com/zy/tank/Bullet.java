package com.zy.tank;

import java.awt.Graphics;

public class Bullet {

	public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
	public static final int WIDTH = ResourceMgr.bulletD.getWidth();
	private int x,y;
	private Dir dir;
	TankFrame tf;
	private static int SPEED=15;
	private boolean alive = true;
	private Group group;
	public Bullet(int x, int y, Dir down, Group group,TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = down;
		this.group = group;
		this.tf = tankFrame;
		
		tf.bullets.add(this);
	}
	
	public void paint(Graphics g) {
		if(!isAlive()) {
			tf.bullets.remove(this);
			return;
		}
	 
		//g.fillOval(x, y, 20, 20);
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
		}
		move();
	
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
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
		
		if(x<0 || y<0 || x>tf.frameSizeX || y>tf.frameSizeY) {
			//System.out.println("position:("+x+","+y+")");
			setAlive(false);
		}
		
	}
	
	public void collide(Tank tank) {
		if(this.group ==tank.getGroup()) {
			return;
		}
		if(this.x>tank.getX() && this.x<tank.getX()+Tank.WIDTH && y>tank.getY() && y<tank.getY()+Tank.HEIGHT) {
			tf.enemyTanks.remove(tank);
			tf.bullets.remove(this);
			tf.explodes.add(new Explode(tank.getX(), tank.getY(), tf));
		}
	}

}
