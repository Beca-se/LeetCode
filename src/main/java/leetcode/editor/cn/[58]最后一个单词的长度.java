//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 311 👎 0


package leetcode.editor.cn;

class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int result = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                // 遇到非空字符后的第一个空格
                if (chars[i] == ' ') {
                    // 如果还没有一个英文字符,继续
                    if (result == 0) {
                        continue;
                    } else {
                        // 如果有英文字符了,说明找到了长度,退出
                        break;
                    }
                }
                // 如果不是空格 ,长度+1
                result++;
            }
            // 返回长度
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  