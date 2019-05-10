package com.zy.tank.firestrategy;

import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Tank;

public class DefaultFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bx = t.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int by = t.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		new Bullet(bx, by, t.getDir() ,t.getGroup(), t.getTf());
	}

}
