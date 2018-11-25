package org.ican.sort;

import java.util.Arrays;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-25 6:37 PM
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int n) {
        _mergeSort(arr, 0, arr.length - 1);

    }


    //递归使用归并排序，对 arr[l....r] 的范围进行排序。
    private static void _mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        _mergeSort(arr, l, mid);
        _mergeSort(arr, mid + 1, r);
        //merge
        _merge(arr, l, mid, r);

    }

    //auxiliary
    //将  arr[l...mid]  arr[mid+1...r] 两部分进行归并
    private static void _merge(int[] arr, int l, int mid, int r) {
        //临时大小
        int[] aux = new int[r - l + 1];
        //赋值到临时数组
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            //防止数组越界...
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 5, 4, 2, 6, 7};
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));


    }


}
