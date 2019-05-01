package com.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestFrame extends Frame{
	public TestFrame(){
		this.setVisible(true);
		this.setTitle("testFrame");
		this.setSize(600, 800);
	}
	
	@Override
	public void paint(Graphics g) {
		Image img;
		try {
			img = ImageIO.read(TestFrame.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			g.drawImage(img, 50, 50, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
