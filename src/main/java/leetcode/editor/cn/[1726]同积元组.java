//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d
// 都是 nums 中的元素，且 a != b != c != d 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 104 
// nums 中的所有元素 互不相同 
// 
// Related Topics 数组 哈希表 
// 👍 19 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class TupleWithSameProduct {
    public static void main(String[] args) {
        Solution solution = new TupleWithSameProduct().new Solution();
        solution.tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            int length = nums.length;
            Map<Integer, Integer> res = new HashMap<>(length * length / 2);
            // 哈希集合
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    res.compute(nums[i] * nums[j], (k, v) -> {
                        if (v == null) {
                            return 1;
                        }
                        return v + 1;
                    });
                }
            }
            nums[0] = 0;
            res.forEach((k, v) -> {
                if (v <= 1) {
                    return;
                }
                nums[0] += v * (v - 1) / 2;
            });
            return nums[0] * 8;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

