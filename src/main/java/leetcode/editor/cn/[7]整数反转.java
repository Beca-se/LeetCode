//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2792 👎 0


package leetcode.editor.cn;

class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
//        solution.reverse(8463847412);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            // 处理溢出边界 2147483647 -2147483648

            int resilt = 0;
            int digital = 0;
            while (x != 0) {
                digital = x % 10;
                /*if (resilt < -214748364 || (resilt == -214748364 && digital < -8) || resilt > 214748364 || (resilt == 214748364 && digital > 7)) {
                    return 0;
                }*/
                // 为什么不用判断  resilt == -214748364 和 resilt == 214748364 的情况,因为传入的是一个数字而不是字符串,到这个时候了,传入的数字前面最大值只能是2
                if (resilt < -214748364 || resilt > 214748364) {
                    return 0;
                }
                resilt = resilt * 10 + digital;
                x /= 10;
            }
            return resilt;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  