package com.zy.tank;


public class Main {
	
	public static void main(String[] args) {
		TankFrame tf= new TankFrame();
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
