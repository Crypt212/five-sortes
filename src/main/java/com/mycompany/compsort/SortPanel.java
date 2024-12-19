/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compsort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author crypt
 */
public class SortPanel extends JPanel {
	final int screenHeight = 700;
	final int screenWidth = 700;
	int [] arr;
	String sortType;
	SortPlot sp;
	private boolean waitingForSpace = false;
	
	SortPanel (int [] arr, String sortType) {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.arr = arr;
		this.sortType = sortType;
		sp = new SortPlot(arr, this);
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (waitingForSpace && e.getKeyCode() == KeyEvent.VK_SPACE) {
					waitingForSpace = false;
				}
			}
		});
		setFocusable(true);
	}
	
	public void waitForSpaceBar() {
		waitingForSpace = true;
		while (waitingForSpace) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public void run () {
		switch (sortType) {
			case "i" -> sp.insertionSort();
			case "b" -> sp.bubbleSort();
			case "s" -> sp.selectionSort();
			case "m" -> sp.mergeSort(0, arr.length - 1);
			case "q" -> sp.quickSort(0, arr.length - 1);
		}
	}
	
	@Override
	public void paint (Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.BLACK);
		g2D.fillRect(0, 0, screenWidth, screenHeight);
		ArrayBlock.setup(g2D, screenWidth, screenHeight);
		ArrayBlock.draw();
	}
}
