package com.zy.tank.factory;

import com.zy.tank.TankFrame;
import com.zy.tank.entity.BeautifulBullet;
import com.zy.tank.entity.BeautifulExplode;
import com.zy.tank.entity.BeautifulTank;
import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Explode;
import com.zy.tank.entity.Group;
import com.zy.tank.entity.Tank;

public class BeautifulWarFactory extends WarFactory{
 
	@Override
	public Tank createTank(int x, int y, Dir dir,Group g) {
		Tank tank = new BeautifulTank(x, y, dir, g);
		return tank;
	}

	@Override
	public Bullet creatBullet(int x, int y, Dir down, Group group) {
		Bullet bullet = new BeautifulBullet(x, y, down, group);
		return bullet;
	}

	@Override
	public Explode createExplode(int x, int y) {
		Explode explode = new BeautifulExplode(x, y);
		return explode;
	}

}
