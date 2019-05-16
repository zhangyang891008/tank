package com.zy.tank;

import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Group;
import com.zy.tank.factory.WarFactory;

public class Main {
	public static int tankCount = 8;
	public static void main(String[] args) {
		TankFrame tf= new TankFrame();
		//change factory
		String factoryClazz = PropertyMgr.get("factorymode");
		try {
			WarFactory factory = (WarFactory) Class.forName(factoryClazz).newInstance();
			for(int i= 0;i<tankCount;i++) {
				TankFacade.add(factory.createTank(100, 10+80*i, Dir.DOWN, Group.Bad));
			}
			
			while(true) {
				try {
					Thread.sleep(50);
					tf.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}

}
