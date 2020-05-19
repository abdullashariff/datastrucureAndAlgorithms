package com.problems;

public class Combination {

	// construct array
	// nextIndex 0, 1,
//	static int[] makeArray(int n, int[] inpArr, int nextIndex) {
//		int arr[] = new int[n];
//		for (int i = 0; i < n; i++) {
//			if (arrayAddition(arr) == n) {
//				return arr;
//			} else {
//				arr[i] = i;
//			}
//		}
//
//		return arr;
//	}
//
//	static void mainCall() {
//		int[] arr = { 1, 2 };
//		makeArray(5, arr, 1);
//	}

//	static int arrayAddition(int[] arr) {
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
//		return sum;
//	}

	// Function to print the contents of the given array
	public static void printCombination(int[] out, int n) {
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", out[i]);
		}
		System.out.println();
	}

	// Recursive function to print all combination of numbers from i to n
	// having sum n. index denotes the next free slot in output array out
	public static void recur(int i, int n, int[] out, int index) {
		// if sum becomes n, print the combination
		if (n == 0) {
			printCombination(out, index);
			//System.out.println("i:" + i + " n:" + n + " index: " + index);
			//System.out.println("--------------------");
		}

		// start from previous element in the combination till n
		for (int j = 1; j <= n; j++) {
			// place current element at current index

			if(j <= 2) {
				out[index] = j;
				// recur with reduced sum
				recur(j, n - j, out, index + 1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int[] out = new int[n];

		// print all combination of numbers from 1 to n having sum n
		recur(1, n, out, 0);
	}

}
