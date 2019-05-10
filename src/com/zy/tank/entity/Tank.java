package com.zy.tank.entity;

import java.awt.Graphics;
import java.util.Random;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;
import com.zy.tank.firestrategy.DefaultFireStrategy;
import com.zy.tank.firestrategy.FireStrategy;
import com.zy.tank.firestrategy.FourDirFireStrategy;

public abstract class Tank{
	public static int SPEED = 4;
	public Dir dir = Dir.DOWN;
	public boolean moving = true;
	public int x;
	public int y;
	public TankFrame tf;
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
		this.group = g;
		this.tf = tf;
  
		if(group==Group.Good) {
			fs = new FourDirFireStrategy();
		}else {
			fs = new DefaultFireStrategy();
		}
	}
	
	public abstract void paint(Graphics g);
	 
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
