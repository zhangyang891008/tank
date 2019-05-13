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
 

	public Tank(int x, int y, Dir dir,Group g, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = g;
		this.tf = tf;
  
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
		if(x>tf.frameSizeX-this.width) {
			x = tf.frameSizeX - this.width;
		}
		if(y>tf.frameSizeY -this.height) {
			y = tf.frameSizeY -this.height;
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
 
}
