package com.zy.tank.collider;

import java.util.LinkedList;
import java.util.List;

import com.zy.tank.PropertyMgr;
import com.zy.tank.entity.BaseObject;

public class ColliderChain {
	List<Collider> colliders = new LinkedList<Collider>();
	
	public ColliderChain() {
		String collider = PropertyMgr.get("collider");
		String [] colliderArr = collider.split(",");
		for(String c: colliderArr) {
			try {
				System.out.println(c);
				colliders.add((Collider)Class.forName(c).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void collide(BaseObject o1, BaseObject o2) {
		for(Collider c:colliders) {
			if(c.collider(o1, o2)) {
				return;
			}
		}
	}

}
