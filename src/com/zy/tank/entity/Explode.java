package com.zy.tank.entity;

import com.zy.tank.TankFrame;

public abstract class Explode extends BaseObject{
	int step = 0;
	
	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
}
