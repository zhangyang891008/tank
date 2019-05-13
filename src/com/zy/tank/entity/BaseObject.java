package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.TankFrame;

public abstract class BaseObject {
	
	public int x;
	public int y;
	public TankFrame tf;
	
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
