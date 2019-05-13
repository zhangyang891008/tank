package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFacade;
import com.zy.tank.TankFrame;
import com.zy.tank.entity.Dir;

public class StandardBullet extends Bullet {
	static {
		height = ResourceMgr.bulletD.getHeight();
		width = ResourceMgr.bulletD.getWidth();
	}
	
	public StandardBullet(int x, int y, Dir down, Group group, TankFrame tankFrame) {
		super(x, y, down, group, tankFrame);
	}
	
	public void paint(Graphics g) {
		if(!isAlive()) {
			TankFacade.getBullets().remove(this);
			return;
		}
	 
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
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
