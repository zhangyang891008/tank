package com.zy.tank.collider;

import com.zy.tank.TankFacade;
import com.zy.tank.entity.BaseObject;
import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Tank;

public class BulletTankCollider implements Collider{

	@Override
	public boolean collider(BaseObject o1, BaseObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet b = (Bullet) o1;
			Tank t = (Tank) o2;
			return checkCollide(b, t);
		}else if(o1 instanceof Tank && o2 instanceof Bullet) {
			collider(o2, o1);
		}else {
			return false;
		}
		return false;
	}
	
	private static Boolean checkCollide(Bullet bullet, Tank tank) {
		if(bullet.getGroup()==tank.getGroup()) {
			return false;
		}
		if(bullet.getX()>tank.getX() && bullet.getX()<tank.getX()+tank.width && bullet.getY()>tank.getY() && bullet.getY()<tank.getY()+tank.height) {
			TankFacade.remove(tank);
			TankFacade.remove(bullet);
			TankFacade.add(TankFacade.factory.createExplode(tank.getX(), tank.getY()));
			return true;
		}
		return false;
	}
}
