//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1592 👎 0


package leetcode.editor.cn;


class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder("");
            int length = strs.length;
            if (length == 0) {
                return result.toString();
            }
            int minLength = 201;
            // 求最短的字符长度
            for (String str : strs) {
                minLength = Math.min(minLength, str.length());
            }
            for (int i = 0; i < minLength; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < length; j++) {
                    if (strs[j].charAt(i) != c) {
                        return result.toString();
                    }
                }
                result.append(c);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  