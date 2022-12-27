//给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 
//false 。 
//
// 
// 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。 
// 
//
// 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1101"
//输出：true
//解释：
//由 1 组成的最长连续子字符串的长度是 2："1101"
//由 0 组成的最长连续子字符串的长度是 1："1101"
//由 1 组成的子字符串更长，故返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：s = "111000"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 3："111000"
//由 0 组成的最长连续子字符串的长度是 3："111000"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 示例 3： 
//
// 
//输入：s = "110100010"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 2："110100010"
//由 0 组成的最长连续子字符串的长度是 3："110100010"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 不是 '0' 就是 '1' 
// 
//
// Related Topics 字符串 👍 20 👎 0
package leetcode.editor.cn;

class LongerContiguousSegmentsOfOnesThanZeros {
    public static void main(String[] args) {
        Solution solution = new LongerContiguousSegmentsOfOnesThanZeros().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkZeroOnes(String s) {
            char[] chars = s.toCharArray();
            int len0 = 0, len1 = 0, len = chars.length;
            int startIndex = 0;
            for (int i = 1; i < len; i++) {
                // 遍历字符串 寻找不同的字符
                if (chars[i] != chars[startIndex]) {
                    int temp = i - startIndex;
                    if (chars[startIndex] == '0') {
                        len0 = Math.max(len0, temp);
                    } else {
                        len1 = Math.max(len1, temp);
                    }
                    startIndex = i;
                }
            }
            // 遍历结束需要在处理一次
            int temp = len - startIndex;
            if (chars[startIndex] == '0') {
                len0 = Math.max(len0, temp);
            } else {
                len1 = Math.max(len1, temp);
            }

            return len1 > len0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}