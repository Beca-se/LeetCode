//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
//
// Related Topics 字符串 👍 193 👎 0

// 字符串中的单词数	题目标题	示例:两数之和
// 434	题目编号
package leetcode.editor.cn;

class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {

            int ans = 0, len = s.length();
            // 遍历
            for (int i = 0; i < len; i++) {
                // 如果本字符不是空格
                if (s.charAt(i) != ' ') {
                    // 直接将结果+1
                    ans++;
                    // 向后寻找第一个空格
                    while (i < len && s.charAt(i) != ' ') {
                        i++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}