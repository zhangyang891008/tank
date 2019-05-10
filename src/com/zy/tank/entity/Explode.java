package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;

public class Explode{
	private int x,y;
	TankFrame tf;
	int step = 0;
	
	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if(step<ResourceMgr.explodes.length) {
			g.drawImage(ResourceMgr.explodes[step++], x, y, null);
			
		}else {
			tf.explodes.remove(this);
		}
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
	
}
