package com.zy.tank;

import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Group;
import com.zy.tank.entity.Tank;

public class Main {
	public static int tankCount = 10;
	public static void main(String[] args) {
		TankFrame tf= new TankFrame();
		
    	for(int i= 0;i<tankCount;i++) {
    		tf.enemyTanks.add(new Tank(200, 100+50*i, Dir.DOWN, Group.Bad, tf));
    	}
    	
		while(true) {
			try {
				Thread.sleep(50);
				tf.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
