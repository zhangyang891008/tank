package com.zy.tank.firestrategy;

import com.zy.tank.TankFacade;
import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Tank;

public class FourDirFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bx = t.getX() + Tank.width/2 - Bullet.width/2;
		int by = t.getY() + Tank.height/2 - Bullet.height/2;
		TankFacade.factory.creatBullet(bx, by, Dir.DOWN ,t.getGroup(), t.getTf());
		TankFacade.factory.creatBullet(bx, by, Dir.LEFT, t.getGroup(), t.getTf());
		TankFacade.factory.creatBullet(bx ,by, Dir.RIGHT, t.getGroup(), t.getTf());
		TankFacade.factory.creatBullet(bx ,by, Dir.UP, t.getGroup(), t.getTf());
	}

}
