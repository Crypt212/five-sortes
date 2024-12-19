/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compsort;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author crypt
 */
public class ArrayBlock {
	static private final Color LINE_COLOR = Color.decode("#87854f");
	static private final Color LINE2COLOR = Color.decode("#fcf51e");
	static private final Color COLOR1 = Color.decode("#282828");
	static private final Color COLOR2 = Color.decode("#006818");
	static private final Color COLOR3 = Color.decode("#680000");
	static private final Color COLOR4 = Color.decode("#004e68");
	static private final Color COLOR5 = Color.decode("#686600");
	static private final Color TEXT_COLOR = Color.decode("#ffffff");
	static private final BasicStroke normalStroke = new BasicStroke(3);
	static private final int SIDE = 40;

	private static HashMap<String, ArrayBlock> all = all = new HashMap();
	static Graphics2D g2D;
	static int screenWidth, screenHeight;
	public String name;
	public int [] arr;
	public int [] status; // 0, 1, 2
	
	public ArrayBlock (int[] a, String name) {
		arr = a;
		status = new int [a.length];
		for (int i = 0; i < status.length; i++)
			status[i] = 0;
		this.name = name;
		all.put(name, this);
	}
	
	public void delete () {
		all.remove(name);
	}
	
	static public void draw () {
		double screenFactor = (double)screenHeight / (1 + all.size());
		int i = 1;
		for (ArrayBlock a : all.values()) {
			double xPos = 50;
			double yPos = screenFactor *  i - SIDE / 2;
			
			g2D.setPaint(TEXT_COLOR);
			g2D.setFont(new Font("Ink Free", Font.BOLD, 20));
			g2D.drawString(a.name, (int)xPos, (int)(yPos - SIDE));
							
			for (int j = 0; j < a.arr.length; j++) {
				g2D.setStroke(normalStroke);
				Color c = null;
				switch(a.status[j]) {
					case 0 -> c = COLOR1;
					case 1 -> c = COLOR2;
					case 2 -> c = COLOR3;
					case 3 -> c = COLOR4;
					case 4 -> c = COLOR5;
				}
				g2D.setPaint(c);
				a.status[j] = 0;
							
				g2D.fillRect((int)xPos + j * SIDE, (int)yPos, SIDE, SIDE);
							
			}
			
			for (int j = 0; j < a.arr.length; j++) {
				g2D.setStroke(normalStroke);
				g2D.setPaint(LINE_COLOR);	
				g2D.drawRect((int)xPos + j * SIDE, (int)yPos, SIDE, SIDE);
				
				g2D.setPaint(TEXT_COLOR);
				g2D.setFont(new Font("Ink Free", Font.BOLD, 20));
				g2D.setStroke(normalStroke);
				g2D.drawString(String.valueOf(a.arr[j]), (int)(xPos + j * SIDE + SIDE / 3), (int)(yPos + 2.0 * SIDE / 3));
			}
			i++;	
		}	
	}
	
	public static void setup(Graphics2D g2D, int screenWidth, int screenHeight) {
		ArrayBlock.g2D = g2D;
		ArrayBlock.screenWidth = screenWidth;
		ArrayBlock.screenHeight = screenHeight;
	}
	
	public static void clear() {
		ArrayBlock.all.clear();
	}
}
