package org.ican.sort;

import java.util.Arrays;

/**
 * O(n2)
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-25 4:31 PM
 */
public class SelectionSort {

    public static void sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //传入的是下标...
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int target, int des) {
        int tmp = arr[target];
        arr[target] = arr[des];
        arr[des] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 5, 4, 2, 6, 7};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));


    }
}
