package com.zh.leetcode.august.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@see href=https://leetcode-cn.com/problems/minimum-absolute-difference/}
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * @author ZhouHu
 * @since 2020-08-02 16:41
 **/
public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(arr);

        // 找到最小的绝对差
        int minimumAbsDifference = Integer.MAX_VALUE;
        int abs;
        for (int i = 0; i < arr.length - 1; i++) {
            abs = Math.abs(arr[i] - arr[i + 1]);
            if (abs < minimumAbsDifference) {
                minimumAbsDifference = abs;
            }
        }
        List<Integer> child;
        for (int i = 0; i < arr.length - 1; i++) {
            abs = Math.abs(arr[i] - arr[i + 1]);
            if (abs == minimumAbsDifference) {
                child = new ArrayList<>();
                child.add(arr[i]);
                child.add(arr[i + 1]);
                result.add(child);
            }
        }
        return result;
    }
}
