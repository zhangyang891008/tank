package com.zy.tank;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.zy.tank.entity.Bullet;
import com.zy.tank.entity.Explode;
import com.zy.tank.entity.Tank;
import com.zy.tank.factory.WarFactory;

public class TankFacade {
	private static List<Tank> enemyTanks = new ArrayList<Tank>();
	private static List<Bullet> bullets = new ArrayList<Bullet>();
	private static List<Explode> explodes = new ArrayList<Explode>();
	public static WarFactory factory;
	private static Tank tank ;
	public static TankFrame tf;
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
		
		for(int i = 0;i<enemyTanks.size();i++){
			enemyTanks.get(i).paint(g);
		}
		
		for(int i = 0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		
		for(int i = 0;i<explodes.size();i++) {
			explodes.get(i).paint(g);
		}
			
		// check collide
		collide();
	}
	

	private static void collide() {
		for(int i = 0;i<bullets.size();i++) {
			for(int j = 0;j<enemyTanks.size();j++) {
				checkCollide(bullets.get(i),enemyTanks.get(j));
			}
		}
	}
	
	private static void checkCollide(Bullet bullet, Tank tank) {
		if(bullet.getGroup()==tank.getGroup()) {
			return;
		}
		if(bullet.getX()>tank.getX() && bullet.getX()<tank.getX()+tank.width && bullet.getY()>tank.getY() && bullet.getY()<tank.getY()+tank.height) {
			TankFacade.getEnemyTanks().remove(tank);
			TankFacade.getBullets().remove(bullet);
			TankFacade.getExplodes().add(TankFacade.factory.createExplode(tank.getX(), tank.getY(), tf));
		}
	}
	
	public static List<Tank> getEnemyTanks(){
		return enemyTanks;
	}
 
	public static List<Bullet> getBullets(){
		return bullets;
	}
	
	public static List<Explode> getExplodes(){
		return explodes;
	}
	
	public static Tank getTank() {
		return tank;
	}
	
	public static void setTank(Tank mytank) {
		tank = mytank;
	}


	public static void setTf(TankFrame tankFrame) {
		tf = tankFrame;
	}
	
}
