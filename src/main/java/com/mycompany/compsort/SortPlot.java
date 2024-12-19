/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compsort;

import static com.mycompany.compsort.Sort.swap;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author crypt
 */
public class SortPlot {
	public HashMap<String, ArrayBlock> network;
	private final SortPanel mp;
	int [] arr;

	public SortPlot(int [] arr, SortPanel mp) {
		this.mp = mp;
		this.arr = arr;
		network = new HashMap();
		network.put("MAIN", new ArrayBlock(arr, "MAIN"));
	}
	
	public void addArray(String name, int arr[]) {
		if (network.containsKey(name)) return;
		network.put(name, new ArrayBlock(arr, "name"));
	}
	
	public void removeArray(String name) {
		if (network.containsKey(name)) {
			network.get(name).delete();
			network.remove(name);
		}
	}
	
	public void setStatus(int start, int end, String name, int status) {
		for (int i = start; i <= end; i++) {
			network.get(name).status[i] = status;
		}
	}

	public void insertionSort () {
		update();
		addArray("TEMP", new int [1]);
		for (int i = 1; i < arr.length; i++) {
			
			int key = arr[i];
			network.get("TEMP").arr[0] = key;
			
			network.get("TEMP").status[0] = 4;
			setStatus(0, i, "MAIN", 1);
			network.get("MAIN").status[i] = 4;
			update();
				
			int j = i - 1;
			
			network.get("TEMP").status[0] = 1;
			setStatus(0, i, "MAIN", 1);
			update();
			
			setStatus(0, i, "MAIN", 1);
			network.get("TEMP").status[0] = 3;
			network.get("MAIN").status[j] = 2;
			update();
			
			while (j >= 0 && arr[j] > key) {
				
				arr[j + 1] = arr[j];
				network.get("TEMP").status[0] = 1;
				setStatus(0, i, "MAIN", 1);
				network.get("MAIN").status[j + 1] = 4;
				network.get("MAIN").status[j] = 4;
				update();
				j--;
				
				if (j >= 0) {
					setStatus(0, i, "MAIN", 1);
					network.get("TEMP").status[0] = 3;
					network.get("MAIN").status[j] = 2;
					update();
				}
			}
			arr[j + 1] = key;
			setStatus(0, i, "MAIN", 1);
			network.get("TEMP").status[0] = 4;
			network.get("MAIN").status[j + 1] = 4;
			update();
		}
		removeArray("TEMP");
		setStatus(0, arr.length - 1, "MAIN", 1);
		update();
	}
	
	public void bubbleSort () {
		update();
		for (int i = 0; i < arr.length - 1; i++) {
			
			setStatus(0, i, "MAIN", 1);
			update();
			
			for (int j = arr.length - 1; j > i; j--) {
				setStatus(0, i, "MAIN", 1);
				network.get("MAIN").status[j] = 2;
				network.get("MAIN").status[j -1] = 3;
				update();
				
				if (arr[j] < arr[j - 1]) {
					
					swap(j, j - 1, arr);
					setStatus(0, i, "MAIN", 1);
					network.get("MAIN").status[j] = 4;
					network.get("MAIN").status[j -1] = 4;
					update();
				}
			}
		}
		
		setStatus(0, arr.length - 1, "MAIN", 1);
		update();
	}
	
	public void selectionSort () {
		update();
		for (int i = 0; i < arr.length - 1; i++) {	
			int smallest = i;
			
			setStatus(0, i, "MAIN", 1);
			update();
			
			for (int j = i + 1; j < arr.length; j++) {
							
				setStatus(0, i, "MAIN", 1);
				network.get("MAIN").status[j] = 2;
				network.get("MAIN").status[smallest] = 3;
				update();
				
				if (arr[j] < arr[smallest]) {
					smallest = j;
					setStatus(0, i, "MAIN", 1);
					network.get("MAIN").status[smallest] = 2;
					update();
				}
			}
			swap(i, smallest, arr);
			
			setStatus(0, i, "MAIN", 1);
			network.get("MAIN").status[i] = 4;
			network.get("MAIN").status[smallest] = 4;
			update();
		}
		setStatus(0, arr.length - 1, "MAIN", 1);
		update();
	}
	
	public void mergeSort (int start, int end) {
		if (start >= end) return;
		setStatus(start, end, "MAIN", 1);
		update();
		int middle = (end + start) / 2;
		mergeSort(start, middle);
		mergeSort(middle + 1, end);
		merge(start, middle, end);
		setStatus(0, arr.length - 1, "MAIN", 1);
		update();
	}
	
	public void merge (int start, int middle, int end) {
		int size1 = middle - start + 1;
		int size2 = end - middle;
		
		int[] left = new int [size1];
		int[] right = new int [size2];
		addArray("LEFT", left);
		addArray("RIGHT", right);
		
		setStatus(start, end, "MAIN", 1);
		update();
		
		for (int i = 0; i < size1; i++) {
			left[i] = arr[start + i];
			setStatus(start, end, "MAIN", 1);
			network.get("LEFT").status[i] = 4;
			network.get("MAIN").status[start + i] = 4;
			update();
		}
		for (int i = 0; i < size2; i++) {
			right[i] = arr[middle + i + 1];
			setStatus(start, end, "MAIN", 1);
			network.get("RIGHT").status[i] = 4;
			network.get("MAIN").status[middle + i + 1] = 4;
			update();
		}
		
		int i = 0, j = 0;
		
		for (int k = start; k <= end; k++) {
			if (i == size1) {
				arr[k] = right[j++];
				setStatus(start, k, "MAIN", 1);
				network.get("RIGHT").status[j - 1] = 4;
				network.get("MAIN").status[k] = 4;
				update();
				continue;
			}
			if (i == size1) {
				arr[k] = left[i++];
				setStatus(start, k, "MAIN", 1);
				network.get("LEFT").status[i - 1] = 4;
				network.get("MAIN").status[k] = 4;
				update();
				continue;
			}
			arr[k] = left[i++];
			setStatus(start, k, "MAIN", 1);
			network.get("LEFT").status[i] = 2;
			network.get("RIGHT").status[j] = 3;
			update();
			if (left[i] < right[j]) {
				arr[k] = left[i++];
				setStatus(start, k, "MAIN", 1);
				network.get("LEFT").status[i - 1] = 4;
				network.get("MAIN").status[k] = 4;
				update();
			} else {
				arr[k] = right[j++];
				setStatus(start, k, "MAIN", 1);
				network.get("RIGHT").status[j - 1] = 4;
				network.get("MAIN").status[k] = 4;
				update();
			}
		}
		removeArray("LEFT");
		removeArray("RIGHT");
	}
	
	public void quickSort (int start, int end) {
		if (start >= end) return;
		setStatus(start, end, "MAIN", 1);
		update();
		int middle = partition(start, end);
		quickSort(start, middle - 1);
		quickSort(middle + 1, end);
		setStatus(0, arr.length - 1, "MAIN", 1);
		update();
	}
	
	public int partition (int start, int end) {
		int i = start - 1;
		
		setStatus(start, end, "MAIN", 1);
		update();
		
		for (int j = start; j < end; j++) {
			setStatus(start, i, "MAIN", 1);
			network.get("MAIN").status[j] = 3;
			network.get("MAIN").status[end] = 2;
			update();
			if (arr[j] > arr[end]) continue;
			i++;
			swap(i, j, arr);
			setStatus(start, i, "MAIN", 1);
			network.get("MAIN").status[i] = 4;
			network.get("MAIN").status[j] = 4;
			update();
		}
		swap(i + 1, end, arr);
		setStatus(start, i, "MAIN", 1);
		network.get("MAIN").status[i + 1] = 4;
		network.get("MAIN").status[end] = 4;
		update();
		return i + 1;
	}
	private void update() {
		mp.repaint();
		mp.waitForSpaceBar();
	}
}
