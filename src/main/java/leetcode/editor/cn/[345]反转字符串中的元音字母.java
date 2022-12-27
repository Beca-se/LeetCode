//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 275 👎 0

// 反转字符串中的元音字母	题目标题	示例:两数之和
// 345	题目编号
package leetcode.editor.cn;

class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = s.length() - 1;
            while (left < right) {
                // 如果不是元音字符 继续寻找
                while (left < right && !isVowel(chars[left])) {
                    left++;
                }
                while (left < right && !isVowel(chars[right])) {
                    right--;
                }
                if (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    right--;
                    left++;
                }
            }
            return new String(chars);
        }

        private boolean isVowel(char c) {
            switch (c) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    return true;
                default:
                    return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}