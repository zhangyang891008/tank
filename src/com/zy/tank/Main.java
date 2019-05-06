package com.zy.tank;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		TankFrame tf= new TankFrame();
		tf.enemyTanks.add(new Tank(300, 500, Dir.UP, Group.Bad, tf));
    	tf.enemyTanks.add(new Tank(400, 300, Dir.DOWN,Group.Bad,tf));
    	tf.enemyTanks.add(new Tank(100, 200, Dir.DOWN, Group.Bad, tf));
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int i = 0; i < tf.enemyTanks.size(); i++) {
						Tank tank = tf.enemyTanks.get(i);
						int key = new Random().nextInt(4) % 4;
						Dir randomDir = Dir.LEFT;
						switch (key) {
						case 0:
							randomDir = Dir.LEFT;
							break;
						case 1:
							randomDir = Dir.RIGHT;
							break;
						case 2:
							randomDir = Dir.UP;
							break;
						case 3:
							randomDir = Dir.DOWN;
							break;
						}
						tank.setDir(randomDir);
					} 
				}
			}
		}).start();;
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
