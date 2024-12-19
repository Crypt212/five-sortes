/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.compsort;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author crypt
 */
public class Main {

	static Scanner sc = new Scanner(System.in);
	static ArrayList answers;
		
	private static String requestAnswer (String message, ArrayList<String> answers) {
			sc.reset();
			while (true) {
				System.out.print(message);
				String choice = sc.nextLine();
				for (String answer : answers) {
					if (choice.compareTo(answer) != 0) continue;
					return answer;
				}
				System.out.println("Invalid choice");
			}
	}
	
	public static void main(String[] args) {
		ArrayList<String> answers;
			for (boolean showAgain = true; showAgain;) {
				answers = new ArrayList<>(Arrays.asList("i", "b", "s", "m", "q"));
				String sortType = requestAnswer("What type('i'sertion/'b'ubble/'s'election/'m'erge/'q'uick): ", answers);
				answers = new ArrayList<>(Arrays.asList("y", "n"));
				String random = requestAnswer("Generate random example?(y/n) ", answers);

				int[] arr = null;
				switch (random) {
					case "n" -> {
						answers = new ArrayList<>(Arrays.asList("y", "n"));
						int size = 0;
						for (boolean done = true; done;) {
							System.out.print("Enter array size?(1 - 8) ");
							size = sc.nextInt();
							if (size < 1 || size > 8) continue;
							done = true;
						}
						arr = new int [size];
						for (int i = 0; i < size; i++) {
							arr[i] = size = sc.nextInt();
						}
					}
					case "y" -> arr = new int [] {2, 4, 5, 7, 1, 2, 3, 6};
					
				}
				
				answers = new ArrayList<>(Arrays.asList("g", "c"));
				String display = requestAnswer("Display?('g'raphical/'c'onsole) ", answers);
				
				switch (display) {
					case "g" -> {
						Display d = new Display(arr, sortType);
						while (d.isVisible()) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					case "c" -> {
						System.out.print("Array:          [");
						for (int i = 0; i < arr.length; i++) {
							System.out.print(arr[i]);
							if (i != arr.length - 1) System.out.print(", ");
						}
						System.out.print("]\n");
						switch (sortType) {
							case "i" -> Sort.insertionSort(arr);
							case "b" -> Sort.bubbleSort(arr);
							case "s" -> Sort.selectionSort(arr);
							case "m" -> Sort.mergeSort(arr, 0, arr.length - 1);
							case "q" -> Sort.quickSort(arr, 0, arr.length - 1);
						}
						System.out.print("Sorted Array:   [");
						for (int i = 0; i < arr.length; i++) {
							System.out.print(arr[i]);
							if (i != arr.length - 1) System.out.print(", ");
						}
						System.out.print("]\n");
					}


				}
				
				answers = new ArrayList<>(Arrays.asList("y", "n"));
				String choice = requestAnswer("Run again? (y/n): ", answers);
 				switch (choice) {
					case "y" -> showAgain = true;
					case "n" -> showAgain = false;
				}
			}
	}
}
