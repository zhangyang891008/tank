package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFacade;
import com.zy.tank.TankFrame;

public abstract class Explode{
	 int x,y;
	 TankFrame tf;
	int step = 0;
	
	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	
	public abstract void paint(Graphics g);
	
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
	
}
