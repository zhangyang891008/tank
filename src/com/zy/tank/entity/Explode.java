package com.zy.tank.entity;

public abstract class Explode extends BaseObject{
	int step = 0;
	
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
