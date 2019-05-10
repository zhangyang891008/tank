package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFrame;

public class BeautifulExplode extends Explode {

	public BeautifulExplode(int x, int y, TankFrame tf) {
		super(x, y, tf);
	}

	@Override
	public void paint(Graphics g) {
		if(step<ResourceMgr.beautifulExplodes.length) {
			g.drawImage(ResourceMgr.beautifulExplodes[step++], x, y, null);
			
		}else {
			tf.explodes.remove(this);
		}
	}
}
