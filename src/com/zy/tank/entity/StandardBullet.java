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
	
	public StandardBullet(int x, int y, Dir down, Group group) {
		super(x, y, down, group);
	}
	
	public void paint(Graphics g) {
		if(!isAlive()) {
			TankFacade.remove(this);
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
  
}
