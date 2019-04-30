package com.zy.tank;

import java.awt.Graphics;
import java.util.List;


public class Bullet {

	private int x,y;
	private Dir dir;
	TankFrame tf;
	private static int SPEED=15;
	private boolean alive = true;
	public Bullet(int x, int y, Dir down, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.dir = down;
		this.tf = tankFrame;
	}
	
	public void paint(Graphics g) {
		//�ж�̹�˻�����Ļ�е�ʱ���ٽ��л���
		if(isAlive()) {
			g.fillOval(x, y, 20, 20);
			move();
		}
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	private void move() {	
		switch(dir) {
		case LEFT:
			x-= SPEED;
			break;
		case RIGHT:
			x+=SPEED;
			break;
		case UP:
			y-=SPEED;
			break;
		case DOWN:
			y+=SPEED;
			break;
		}
		
		//�ж��ƶ���λ���Ƿ��Ѿ�������Ļ��
		if(x<0 || y<0 || x>tf.frameSizeX || y>tf.frameSizeY) {
			System.out.println("position:("+x+","+y+")");
			setAlive(false);
 
		}
		
		List<Tank> tanks = tf.getTanks();
		for(Tank tank:tanks) {
			int tank_X = tank.getX();
			int tank_Y = tank.getY();
			if(tank_X-x<10 && tank_Y-y<10) {
				tank.setAlive(false);
				//�ӵ�������̹�ˣ��ӵ�Ҳ������
				setAlive(false);
				//TODO ��ըЧ�������
			}
		}
	}

}
