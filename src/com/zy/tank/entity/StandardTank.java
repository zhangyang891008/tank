package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFacade;
import com.zy.tank.TankFrame;

public class StandardTank extends Tank{

	static {
		width = ResourceMgr.standardTankD.getWidth();
		height = ResourceMgr.standardTankD.getHeight();
	}
	@Override
	public void paint(Graphics g) {
		if(!isAlive()) {
			TankFacade.getEnemyTanks().remove(this);
			return;
		}
		
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.standardTankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.standardTankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.standardTankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.standardTankD, x, y, null);
			break;
		}
		move();
 
		if(this.group == Group.Bad && random.nextInt(10)>8) {
			this.fire();
		}
		
		if(this.group == Group.Bad && random.nextInt(100)>95) {
			this.changeDir();
		}
	}
	private void changeDir() {
		dir = Dir.values()[random.nextInt(4)];
	}

	private void move() {
		if(!moving)
			return;
		switch(dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		
		boundCheck();
		
	}
	private void boundCheck() {
		if(x<0) {
			x=0;
		}
		if(y<0) {
			y=0;
		}
		if(x>tf.frameSizeX-this.width) {
			x = tf.frameSizeX - this.width;
		}
		if(y>tf.frameSizeY -this.height) {
			y = tf.frameSizeY -this.height;
		}
	}
	@Override
	public void fire() {
		fs.fire(this);
	}

	public StandardTank(int x, int y, Dir dir, Group g, TankFrame tf) {
		super(x, y, dir, g, tf);
		this.SPEED = 1;
	}
}
