package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;
import com.zy.tank.entity.Dir;

public class BeautifulBullet extends Bullet {
	static {
		height = ResourceMgr.beautifulBulletD.getHeight();
		width = ResourceMgr.beautifulBulletD.getWidth();
	}
	
	public BeautifulBullet(int x, int y, Dir down, Group group, TankFrame tankFrame) {
		super(x, y, down, group, tankFrame);
	}
	
	public void paint(Graphics g) {
		if(!isAlive()) {
			tf.bullets.remove(this);
			return;
		}
	 
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.beautifulBulletL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.beautifulBulletR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.beautifulBulletU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.beautifulBulletD, x, y, null);
		}
		move();
	
	}
	private void move() {	
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
		
		if(x<0 || y<0 || x>tf.frameSizeX || y>tf.frameSizeY) {
			//System.out.println("position:("+x+","+y+")");
			setAlive(false);
		}
		
	}
}
