package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;

public class StandardExplode extends Explode{

	public StandardExplode(int x, int y, TankFrame tf) {
		super(x, y, tf);
	}
	
	@Override
	public void paint(Graphics g) {
		if(step<ResourceMgr.standardExplodes.length) {
			g.drawImage(ResourceMgr.standardExplodes[step++], x, y, null);
			
		}else {
			tf.explodes.remove(this);
		}
	}
}
