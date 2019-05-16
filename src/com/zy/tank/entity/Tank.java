package com.zy.tank.entity;

import java.util.Random;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;
import com.zy.tank.firestrategy.DefaultFireStrategy;
import com.zy.tank.firestrategy.FireStrategy;
import com.zy.tank.firestrategy.FourDirFireStrategy;

public abstract class Tank extends BaseObject{
	public static int SPEED = 4;
	public Dir dir = Dir.DOWN;
	public boolean moving = true;
	public boolean alive = true;
	public Group group;
	FireStrategy fs ;
	public static int width = ResourceMgr.goodTankD.getWidth();
	public static int height = ResourceMgr.goodTankD.getHeight();
	
	public  int oldx;
	public  int oldy;
		
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
 

	public Tank(int x, int y, Dir dir,Group g) {
		if(x<0)x=0;
		if(y<0)y=0;
		
		oldx  = x;
		oldy = y;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = g;
		
		if(group==Group.Good) {
			fs = new FourDirFireStrategy();
		}else {
			fs = new DefaultFireStrategy();
		}
	}
	
	public void boundCheck() {
		if(x<0) {
			x=0;
		}
		if(y<0) {
			y=0;
		}
		if(x>TankFrame.frameSizeX-this.width) {
			x = TankFrame.frameSizeX - this.width;
		}
		if(y>TankFrame.frameSizeY -this.height) {
			y = TankFrame.frameSizeY -this.height;
		}
	}
	 
	public abstract void fire();
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public void resetPos() {
		x = oldx;
		y = oldy;
	}
 
}
