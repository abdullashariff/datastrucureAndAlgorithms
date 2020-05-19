package com.problems;

public class RandomSumEqN {

	public static void main(String[] args) {
		int n = 3;
		int[] arr = new int[n];
		generateCombination(1, n, arr, 0);
	}

	static void generateCombination(int i, int n, int[] arr, int index) {

		if (n == 0) {
			for (int k = 0; k < index; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}

		for (int j = 1; j <= n; j++) {
			if (j <= 2) {
				arr[index] = j;
				//System.out.println("j:" + j + " index:" + index + " n:" + n);
				generateCombination(i, n - j, arr, index + 1);
			}
		}
	}

}

// out put
// n=5
//1 1 1 1 1 
//1 1 1 2 
//1 1 2 1 
//1 2 1 1 
//1 2 2 
//2 1 1 1 
//2 1 2 
//2 2 1 

//n=3
//1 1 1 
//1 2 
//2 1 

