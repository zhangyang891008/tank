package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;

public abstract class Bullet{

	public static int height = ResourceMgr.bulletD.getHeight();
	public static int width = ResourceMgr.bulletD.getWidth();
	int x,y;
	Dir dir;
	TankFrame tf;
	static int SPEED=15;
	boolean alive = true;
	Group group;
 
	public Bullet(int x, int y, Dir down, Group group,TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = down;
		this.group = group;
		this.tf = tankFrame;
		tf.bullets.add(this);
	}
	
	public abstract void paint(Graphics g);

	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void collide(Tank tank) {
		if(this.group ==tank.getGroup()) {
			return;
		}
		if(this.x>tank.getX() && this.x<tank.getX()+tank.width && y>tank.getY() && y<tank.getY()+tank.height) {
			tf.enemyTanks.remove(tank);
			tf.bullets.remove(this);
			tf.explodes.add(tf.factory.createExplode(tank.getX(), tank.getY(), tf));
		}
	}

}
