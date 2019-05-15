package com.zy.tank.collider;

import com.zy.tank.entity.BaseObject;
import com.zy.tank.entity.Tank;

public class TankTankCollider implements Collider {

	@Override
	public boolean collider(BaseObject o1, BaseObject o2) {
		
		if(o1 instanceof Tank && o2 instanceof Tank ) {
			checkCollide((Tank)o1, (Tank)o2);
		}
		return false;
	}
	
	private static void checkCollide(Tank tank, Tank tank2) {
		int value = tank.width*tank.width + tank.height*tank.height;
		int value2 = (tank.getX()-tank2.getX())*(tank.getX()-tank2.getX()) + (tank.getY()-tank2.getY())*(tank.getY()-tank2.getY());
		if(value > value2) {
			//System.out.println("collide");
			tank.resetPos();
			tank2.resetPos();
		}
	}
}
