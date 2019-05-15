package com.zy.tank;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.zy.tank.collider.ColliderChain;
import com.zy.tank.entity.BaseObject;
import com.zy.tank.entity.Tank;
import com.zy.tank.factory.WarFactory;

public class TankFacade {

	private static List<BaseObject> objects = new ArrayList<>();
	static ColliderChain chain = new ColliderChain();
	public static WarFactory factory;
	private static Tank tank ;
	static {
		String factoryClazz = PropertyMgr.get("factorymode");
		try {
			factory = (WarFactory) Class.forName(factoryClazz).newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void paint(Graphics g) {
		if(tank!=null) {
			tank.paint(g);
		}
		for(int i = 0;i<objects.size();i++) {
			objects.get(i).paint(g);
		}
		// check collide
		//collide();
		for(int i=0;i<objects.size();i++) {
			for(int j = i+1;j<objects.size();j++) {
				chain.collide(objects.get(i),objects.get(j));
			}
		}
	}
	
	
	public static void add(BaseObject object) {
		objects.add(object);
	}
	
	public static void remove(BaseObject object) {
		objects.remove(object);
	}
 
	public static Tank getTank() {
		return tank;
	}
	
	public static void setTank(Tank mytank) {
		tank = mytank;
	}

}
