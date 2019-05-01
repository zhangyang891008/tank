package com.zy.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	public static BufferedImage tankR,tankL,tankU,tankD;
	
	public static BufferedImage bulletR,bulletL,bulletU,bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	static{
		try {
			// tank picture
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			for(int i=0;i<16;i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
