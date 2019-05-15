package com.test;

import com.zy.tank.entity.BeautifulTank;
import com.zy.tank.entity.Dir;
import com.zy.tank.entity.Group;
import com.zy.tank.entity.Tank;

public class TestImage {
	public static void main(String[] args) {
		Tank t = new BeautifulTank(100, 100, Dir.DOWN, Group.Bad);
		Tank t2 = new BeautifulTank(100, 60, Dir.DOWN, Group.Bad);
		int value = 10000+10000;
		int value2 = 0+40*40;
		if(value>value2) {
			System.out.println("collide");
		}
		System.out.println(value);
		System.out.println(t.height +"," +t.width);
	}

}
