//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 
// 👍 148 👎 0

package leetcode.editor.cn;

class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        solution.oneEditAway("teacher", "taches");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int len1 = first.length(), len2 = second.length();
            if (len1 == len2) {
                int count = 0;
                for (int i = 0; i < len1; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        count++;
                    }
                    if (count > 1) {
                        return false;
                    }
                }
                return true;
            }
            if (Math.abs(len1 - len2) > 1) {
                return false;
            }
            if (len1 < len2) {
                return check(first, second);
            }
            return check(second, first);
        }

        private boolean check(String less, String more) {
            int count = 0;
            int length = less.length();
            for (int i = 0; i < length; i++) {
                while (count < 2 && less.charAt(i) != more.charAt(i + count)) {
                    count++;

                }
                if (count > 1) {
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

