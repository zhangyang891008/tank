package com.zy.tank.entity;

import java.awt.Graphics;

import com.zy.tank.ResourceMgr;
import com.zy.tank.TankFacade;
import com.zy.tank.TankFrame;

public class StandardExplode extends Explode{

	public StandardExplode(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void paint(Graphics g) {
		if(step<ResourceMgr.standardExplodes.length) {
			g.drawImage(ResourceMgr.standardExplodes[step++], x, y, null);
			
		}else {
			TankFacade.getExplodes().remove(this);
		}
	}
}
