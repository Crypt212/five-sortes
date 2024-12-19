/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compsort;

/**
 *
 * @author crypt
 */
public class Sort {
	
	public static void swap (int i, int j, int [] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void insertionSort (int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	public static void bubbleSort (int [] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = arr.length - 1; j > i; j--)
				if (arr[j] < arr[j - 1])
					swap(j, j - 1, arr);
	}
	
	public static void selectionSort (int [] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallest]) {
					smallest = j;
				}
			}
			swap(i, smallest, arr);
		}
	}
	
	public static void mergeSort (int [] arr, int start, int end) {
		if (start >= end) return;
		int middle = (end + start) / 2;
		mergeSort(arr, start, middle);
		mergeSort(arr, middle + 1, end);
		merge(arr, start, middle, end);
	}
	
	public static void merge (int [] arr, int start, int middle, int end) {
		int size1 = middle - start + 1;
		int size2 = end - middle;
		
		int[] left = new int [size1];
		int[] right = new int [size2];
		
		for (int i = 0; i < size1; i++)
			left[i] = arr[start + i];
		for (int i = 0; i < size2; i++)
			right[i] = arr[middle + i + 1];
		
		int i = 0, j = 0;
		
		for (int k = start; k <= end; k++) {
			if (i != size1 && (j == size2 || left[i] < right[j])) {
				arr[k] = left[i++];
			} else {
				arr[k] = right[j++];
			}
		}
	}
	
	public static void quickSort (int [] arr, int start, int end) {
		if (start >= end) return;
		int middle = partition(arr, start, end);
		quickSort(arr, start, middle - 1);
		quickSort(arr, middle + 1, end);
	}
	
	public static int partition (int [] arr, int start, int end) {
		int i = start - 1;
		
		for (int j = start; j < end; j++) {
			if (arr[j] <= arr[end]) {
				i++;
				swap(i, j, arr);
			}
		}
		swap(i + 1, end, arr);
		return i + 1;
	}
}
