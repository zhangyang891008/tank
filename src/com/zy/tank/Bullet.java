package com.zy.tank;

import java.awt.Graphics;
import java.util.List;


public class Bullet {

	private int x,y;
	private Dir dir;
	TankFrame tf;
	private static int SPEED=15;
	private boolean alive = true;
	private Group g;
	public Bullet(int x, int y, Dir down, Group g,TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = down;
		this.g = g;
		this.tf = tankFrame;
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
		
		List<Tank> tanks = tf.getTanks();
		for(Tank tank:tanks) {
			if(tank.getG()!=this.g) {
				int tank_X = tank.getX();
				int tank_Y = tank.getY();
				if(tank_X-x<-5 && tank_Y-y<-5) {
					tf.explodes.add(new Explode(tank.getX(), tank.getY(), tf));
					tank.setAlive(false);
					this.setAlive(false);
					//explode action
					System.out.println("explode :"+tank.getG()+","+this.g);
				}
			}
		}
	}

}
