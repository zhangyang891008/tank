package com.zy.tank.factory;

import com.zy.tank.TankFacade;
import com.zy.tank.TankFrame;
import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Explode;
import com.zy.tank.entity.Group;
import com.zy.tank.entity.Tank;

public abstract class WarFactory {
	
	public abstract Tank createTank(int x, int y, Dir dir,Group g, TankFrame tf);
	
	public abstract Bullet creatBullet(int x, int y, Dir down, Group group,TankFrame tankFrame);
	
	public abstract Explode createExplode(int x, int y, TankFrame tf);

}
