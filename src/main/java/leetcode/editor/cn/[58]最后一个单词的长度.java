//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 249 👎 0


package leetcode.editor.cn;

class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("b a  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int result = 0;
            boolean wordFlag = false;
            for (int i = chars.length - 1; i >= 0; i--) {
                // 遇到非空字符后的第一个空格,推=退出
                if (chars[i] == ' ' && wordFlag) {
                    break;
                }
                // 遇到第一个非空格字符 将标记改为true,并开始计数
                if (chars[i] != ' ') {
                    result++;
                    wordFlag = true;
                }

            }
            // 返回长度
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}