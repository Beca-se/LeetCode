//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输入:7 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 492 👎 0

// 最长回文串	题目标题	示例:两数之和
// 409	题目编号
package leetcode.editor.cn;

class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println('a' + 1);
        System.out.println('A' + 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            int ans = 0, index = 0;
            int[] count = new int[52];
            // 'a'= 97 'A' = 65
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                index = aChar - 'a';
                if (index < 0) {
                    index = aChar - 'A' + 26;
                }
                count[index]++;
            }
            for (int num : count) {
                // 如果是偶数 直接+
                if ((num & 1) == 0) {
                    ans += num;
                } else {
                    ans += num - 1;
                }
            }
            // ans现在拼接的是偶数长度 我们判断一下是否和原字符串长度相等,
            // 如果不等说明可以用一个多余的字符来做中间字符,使得我们的回文字符串长度+1
            if (ans < chars.length) {
                ans++;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}