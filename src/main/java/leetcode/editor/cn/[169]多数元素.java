//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
//
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 976 👎 0


package leetcode.editor.cn;

class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {

            // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
            // 利用投票法
            int count = 0;
            int value = 0;
            for (int num : nums) {
                if (count == 0) {
                    value = num;
                    count++;
                } else {
                    if (num == value) {
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  