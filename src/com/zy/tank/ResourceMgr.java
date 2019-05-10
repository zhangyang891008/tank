package com.zy.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	public static BufferedImage badTankR,badTankL,badTankU,badTankD;
	public static BufferedImage goodTankR,goodTankL,goodTankU,goodTankD;
	public static BufferedImage standardTankR,standardTankL,standardTankU,standardTankD;
	public static BufferedImage bulletR,bulletL,bulletU,bulletD;
	public static BufferedImage beautifulBulletR,beautifulBulletL,beautifulBulletU,beautifulBulletD ;
	public static BufferedImage[] beautifulExplodes = new BufferedImage[16];
	public static BufferedImage[] standardExplodes = new BufferedImage[11];
	static{
		try {
			// tank picture
			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU, -90);
			badTankR = ImageUtil.rotateImage(badTankU, 90);
			badTankD = ImageUtil.rotateImage(badTankU, 180);
			
			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU, -90);
			goodTankR = ImageUtil.rotateImage(goodTankU, 90);
			goodTankD = ImageUtil.rotateImage(goodTankU, 180);
			
			standardTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			standardTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			standardTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			standardTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			beautifulBulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			beautifulBulletL = ImageUtil.rotateImage(beautifulBulletU, -90);
			beautifulBulletR = ImageUtil.rotateImage(beautifulBulletU, 90);
			beautifulBulletD = ImageUtil.rotateImage(beautifulBulletU, 180);
			
			for(int i=0;i<16;i++) {
				beautifulExplodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
			}
			for(int i=0;i<11;i++) {
				standardExplodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/"+(i)+".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
