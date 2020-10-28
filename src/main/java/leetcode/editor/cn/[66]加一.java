//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 568 👎 0


package leetcode.editor.cn;

class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {

            for (int i = digits.length - 1; i >= 0; i--) {
                // 从最后向前扫面 如果是9 就设置为0
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    // 如果不是9 就加上1 然后返回
                    digits[i] = digits[i] + 1;
                    return digits;
                }
            }
            // 如果到了这里 说明数字全是9 需要进1位,构建一个新数组 长度比元数组多1个,然后设置第一个值为1即可
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  