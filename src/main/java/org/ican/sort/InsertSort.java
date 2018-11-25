package org.ican.sort;

/**
 * O(n2)
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-25 4:48 PM
 */
public class InsertSort {

    //插入排序，从 下标 1 开始

    /**
     * 插入排序可以提前结束.
     */
    public static void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            //为1的时候，与0的位置比较。
            //往前推
            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[i]) {
                //和前面的比
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void insertSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                //前一个位置元素向后挪一下
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }

    }

    public static void swap(int[] arr, int target, int des) {
        int tmp = arr[target];
        arr[target] = arr[des];
        arr[des] = tmp;
    }


}
