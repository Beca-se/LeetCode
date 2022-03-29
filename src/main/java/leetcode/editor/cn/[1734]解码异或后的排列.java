//给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
//
// 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
//，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
//
// 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
//
// 
//
// 示例 1： 
//
// 输入：encoded = [3,1]
//输出：[1,2,3]
//解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// 示例 2： 
//
// 输入：encoded = [6,5,4,6]
//输出：[2,4,1,5,3]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n < 105 
// n 是奇数。 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 82 👎 0


package leetcode.editor.cn;

class DecodeXoredPermutation {
    public static void main(String[] args) {
        Solution solution = new DecodeXoredPermutation().new Solution();
        solution.decode(new int[]{3, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decode(int[] encoded) {
            // n是奇数  答案是 1 ~ n, 长度是encoded的长度+1
            int length = encoded.length + 1;
            int[] ans = new int[length];
            // 它是前 n 个正整数的排列 , 然后求出 1 ^ 2 ^ 3 ^ 4 ^ ... ^ n的值
            int count = 0;
            for (int i = 0; i <= length; i++) {
                if ((i & 1) == 0 && i < length - 1) {
                    count ^= encoded[i];
                }
                count ^= i;
            }
            ans[length - 1] = count;
            // 因为n是奇数 所以encoded的长度是偶数,并且
            // encoded[0] = ans[0] ^ ans[1]
            // encoded[1] = ans[1] ^ ans[2]
            // encoded[2] = ans[2] ^ ans[3]
            // encoded[3] = ans[3] ^ ans[4]
            // ....
            // encoded[n-2] = ans[n-3] ^ ans[n-2]
            // encoded[n-1] = ans[n-2] ^ ans[n-1]
            //我们只看 encoded[0], encoded[2], encoded[4],...,encoded[n-1];
            // encoded[0] ^  encoded[2] ^  encoded[4] ^ ... ^ encoded[n-2] = ans[0] ^ ans[1] ^ ans[2] ^ ... ^ ans[n-3] ^ ans[n-1];

            // 它是前 n 个正整数的排列
            // 然后求出 1 ^ 2 ^ 3 ^ 4 ^ ... ^ n的值
            //  然后将2个值异或就可以得到ans[n-1]的值
            ans[length - 1] = count;
            // 得到ans[i] 我们就可以根据encode规则进行解密
            for (int i = length - 2; i >= 0; i--) {
                ans[i] = encoded[i] ^ ans[i + 1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  