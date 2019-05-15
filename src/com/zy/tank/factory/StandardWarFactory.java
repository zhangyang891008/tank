package com.zy.tank.factory;

import com.zy.tank.TankFrame;
import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Explode;
import com.zy.tank.entity.Group;
import com.zy.tank.entity.StandardBullet;
import com.zy.tank.entity.StandardExplode;
import com.zy.tank.entity.StandardTank;
import com.zy.tank.entity.Tank;

public class StandardWarFactory extends WarFactory{

	@Override
	public Tank createTank(int x, int y, Dir dir,Group g) {
		Tank tank = new StandardTank(x, y, dir, g);
		return tank;
	}

	@Override
	public Bullet creatBullet(int x, int y, Dir down, Group group) {
		Bullet bullet = new StandardBullet(x, y, down, group);
		return bullet;
	}

	@Override
	public Explode createExplode(int x, int y) {
		Explode explode = new StandardExplode(x, y);
		return explode;
	}

}
