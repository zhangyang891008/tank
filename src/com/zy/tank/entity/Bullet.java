package com.zy.tank.entity;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFacade;
import com.zy.tank.TankFrame;

public abstract class Bullet extends BaseObject{

	public static int height = ResourceMgr.bulletD.getHeight();
	public static int width = ResourceMgr.bulletD.getWidth();
	Dir dir;
	static int SPEED=15;
	boolean alive = true;
	Group group;
 
	public Bullet(int x, int y, Dir down, Group group) {
		this.x = x;
		this.y = y;
		this.dir = down;
		this.group = group;
		TankFacade.add(this);
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void move() {	
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
		
		if(x<0 || y<0 || x>TankFrame.frameSizeX || y>TankFrame.frameSizeY) {
			setAlive(false);
		}
	}
	
	public Group getGroup() {
		return this.group;
	}

}
