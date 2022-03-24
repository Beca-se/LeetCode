package algorithm.sort;

import java.util.Arrays;

/**
 * @author Administrator
 * @Class Name 归并拍寻
 * @Desc TODO
 * @create: 2021-07-30 15:18
 **/
public class MergerSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 9, 15, 19};
        mergerSort(arr, true);
    }

    /**
     * 从局部有序 到整体有序
     */
    public static void mergerSort(int[] arr, boolean desc) {

        mergerSort(0, arr.length - 1, arr, desc);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergerSort(int left, int right, int[] arr, boolean desc) {
        // 如果相等就不用排序了
        if (left >= right) {
            return;
        }
        // 求中间节点
        int mid = left + (right - left) / 2;

        // 归并左边
        mergerSort(left, mid, arr, desc);
        // 归并右边
        mergerSort(mid + 1, right, arr, desc);
        // 合并
        merge(arr, left, mid, right, desc);
    }

    private static void merge(int[] arr, int left, int mid, int right, boolean asc) {
        // 开辟一个临时数组来储存合并后的数据
        int[] temp = new int[right - left + 1];

        // 合并2个有序数组,左边这个数组为[left,mid],右边那个数组为[mid+1,right]
        int lIndex = left;
        int rIndex = mid + 1;
        // 记录使用的下标位置
        int index = 0;
        // 只要2个数组没有同时到结束
        while (lIndex <= mid || rIndex <= right) {
            // 都没有到末尾
            if (lIndex <= mid && rIndex <= right) {
                // 比较大小
                boolean b = arr[lIndex] > arr[rIndex];
                if (asc == b) {
                    temp[index++] = arr[rIndex++];
                } else {
                    temp[index++] = arr[lIndex++];
                }
                continue;
            }
            // 如果左边还有数据
            if (lIndex <= mid) {
                temp[index++] = arr[lIndex++];
            } else {
                //如果右边有数据
                temp[index++] = arr[rIndex++];
            }
        }
    }
}
