package com.zy.tank.collider;

import java.util.LinkedList;
import java.util.List;

import com.zy.tank.entity.BaseObject;

public class ColliderChain {
	List<Collider> colliders = new LinkedList<Collider>();
	
	public ColliderChain() {
		colliders.add(new BulletTankCollider());
		colliders.add(new TankTankCollider());
	}
	
	public void collide(BaseObject o1, BaseObject o2) {
		for(Collider c:colliders) {
			if(c.collider(o1, o2)) {
				return;
			}
		}
	}

}
