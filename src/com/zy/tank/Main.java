package com.zy.tank;

public class Main {
	public static int tankCount = 10;
	public static void main(String[] args) {
		TankFrame tf= new TankFrame();
		/**
		tf.enemyTanks.add(new Tank(300, 500, Dir.UP, Group.Bad, tf));
    	tf.enemyTanks.add(new Tank(400, 300, Dir.DOWN,Group.Bad,tf));
    	tf.enemyTanks.add(new Tank(100, 200, Dir.DOWN, Group.Bad, tf));
		 */
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
