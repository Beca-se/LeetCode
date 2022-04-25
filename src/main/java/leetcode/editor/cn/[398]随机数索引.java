//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 水塘抽样 哈希表 数学 随机化 
// 👍 160 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class RandomPickIndex {
    public static void main(String[] args) {
//        Solution solution = new RandomPickIndex().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Queue<Integer>> indexMap;

        public Solution(int[] nums) {
            indexMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int temp = i;
                indexMap.compute(nums[i], (k1, v1) -> {
                    if (v1 == null) {
                        v1 = new ArrayDeque<>();
                    }
                    v1.add(temp);
                    return v1;
                });
            }
        }

        public int pick(int target) {
            // 题目保证这个数一定存在就不用判断null了
            Queue<Integer> integers = indexMap.get(target);
            // 直接取第一个
            Integer poll = integers.poll();
            // 然后将这个加到队列末尾
            integers.add(poll);
            // 返回值
            return (int) poll;

        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

