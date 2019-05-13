package com.zy.tank.firestrategy;

import com.zy.tank.TankFacade;
import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Tank;

public class DefaultFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bx = t.getX() + Tank.width/2 - Bullet.width/2;
		int by = t.getY() + Tank.height/2 - Bullet.height/2;
		TankFacade.factory.creatBullet(bx, by, t.getDir() ,t.getGroup(), t.getTf());
	}

}
