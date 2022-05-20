//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。 
//
// 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 2 * 104 
// intervals[i].length == 2 
// -106 <= starti <= endi <= 106 
// 每个间隔的起点都 不相同 
// 
// Related Topics 数组 二分查找 排序 
// 👍 128 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

class FindRightInterval {
    public static void main(String[] args) {
        Solution solution = new FindRightInterval().new Solution();
        int[][] arr = new int[][]{
                {3, 4},
                {2, 3},
                {1, 2}
//                {0, 1},
//                {5, 7}
        };
        int[] rightInterval = solution.findRightInterval(arr);
        System.out.println("===");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int[][] index = new int[intervals.length][];
            for (int i = 0; i < intervals.length; i++) {
                index[i] = new int[]{intervals[i][0], i};
            }
            Arrays.sort(index, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            int[] ans = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                ans[i] = findRight(index, intervals[i][1]);
            }
            return ans;
        }

        private int findRight(int[][] index, int target) {
            int left = 0, right = index.length - 1, mid;
            if (target > index[right][0]) {
                return -1;
            }
            while (left < right) {
                mid = left + (right - left) / 2;

                if (index[mid][0] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return index[left][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

