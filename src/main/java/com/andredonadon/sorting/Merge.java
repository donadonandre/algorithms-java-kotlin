package com.andredonadon.sorting;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] array = {12, 15, 7, 9, 2, 5, 1, 10, 4, 8};

        System.out.println("Original array:" + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("Ordered array:" + Arrays.toString(array));
    }

    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 2];
        int[] R = new int[n2 + 2];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

}
