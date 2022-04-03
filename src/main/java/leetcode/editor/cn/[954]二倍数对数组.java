//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 104 
// arr.length 是偶数 
// -105 <= arr[i] <= 105 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 93 👎 0

package leetcode.editor.cn;

import java.util.*;

class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        solution.canReorderDoubled(new int[]{2, -1, -2, 1, 1, 1, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {

            // 分成2组  0 和其他数
            List<Integer> vals = new ArrayList<>();
            int zeroCount = 0;
            for (int num : arr) {
                if (num == 0) {
                    zeroCount++;
                } else {
                    vals.add(num);
                }
            }
            if ((zeroCount & 1) == 1) {
                return false;
            }
            // 注意这里使用的绝对值排序
            Collections.sort(vals, ((o1, o2) -> {
                return Math.abs(o1) - Math.abs(o2);
            }));
            int temp;
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = vals.size() - 1; i >= 0; i--) {
                temp = vals.get(i);
                Integer integer = count.get(temp * 2);
                if (integer != null) {
                    integer -= 1;
                    if (integer == 0) {
                        count.remove(temp * 2);
                    } else {
                        count.put(temp * 2, integer);
                    }
                } else {
                    count.compute(temp, (k, v) -> {
                        if (v == null) {
                            v = 0;
                        }
                        return v + 1;
                    });
                }
            }
            return count.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

