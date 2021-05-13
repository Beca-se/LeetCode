//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 
// 👍 657 👎 0


package leetcode.editor.cn;

class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            // Hash表 很简单  主要是统计 二进制数字里面1出现的位置的次数,其他都3次 出现的次数 除以3肯定等于0.不等于0的就是出现一次的二进制位
            int[] cnt = new int[32];
            for (int x : nums) {
                for (int i = 0; i < 32; i++) {
                    if (((x >> i) & 1) == 1) {
                        cnt[i]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (cnt[i] % 3 == 1) {
                    ans += (1 << i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  