package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ZhouHu
 * @Class Name BaseSort
 * @Desc 快排
 * @create: 2021-07-30 17:51
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        quickSort(arr, false);

    }

    public static void quickSort(int[] arr, boolean asc) {
        quickSort(arr, 0, arr.length - 1, asc);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快排的核心实现
     *
     * @param arr   要排序的数组
     * @param left  要排序数组中的左指针
     * @param right 要排序数组的右指针
     * @param asc   true 升序 false 降序
     */
    public static void quickSort(int[] arr, int left, int right, boolean asc) {

        // 如果左指针大于或者等于右指针 不需要排序
        if (left >= right) {
            return;
        }

        // 选取基数
        int base = arr[left], leftIndex = left, rightIndex = right;

        while (left < right) {
            // 这里必须从右边开始扫描
            if (asc) {
                while (left < right && arr[right] <= base) {
                    right--;
                }
                while (left < right && arr[left] >= base) {
                    left++;
                }

            } else {
                while (left < right && arr[right] >= base) {
                    right--;
                }
                while (left < right && arr[left] <= base) {
                    left++;
                }
            }

            // 交换位置
            if (left < right) {
                arr[left] ^= arr[right];
                arr[right] ^= arr[left];
                arr[left] ^= arr[right];
            }
        }
        // 最总left == right
        arr[leftIndex] = arr[left];
        arr[left] = base;
        quickSort(arr, leftIndex, left - 1, asc);
        quickSort(arr, left + 1, rightIndex, asc);

    }
}
