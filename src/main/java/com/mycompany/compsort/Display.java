/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compsort;

import javax.swing.JFrame;

/**
 *
 * @author crypt
 */
public class Display extends JFrame {
	SortPanel panel;
	public Display (int [] arr, String sortType) {
		panel = new SortPanel(arr, sortType);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		panel.run();
		ArrayBlock.clear();
		this.dispose();
	}
}

