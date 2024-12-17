/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.compsort;

import Compare.ComparisonPanel;
import Compare.SortComparisons;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author crypt
 */
public class CompSort {

	public static void main(String[] args) {
		SortComparisons sc = new SortComparisons();
		int arr [] = {11, 2, 3 , 6, 23, 1, 4};
		
		sc.bubbleSort();
		JFrame jf = new JFrame();
		ComparisonPanel p = new ComparisonPanel();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(p);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		System.out.println("Hello World!");
		System.out.println("Hello World!");
	}
}
