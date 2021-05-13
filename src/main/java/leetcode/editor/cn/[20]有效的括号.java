//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2384 👎 0


package leetcode.editor.cn;

import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> cache = new Stack<>();

            /*
             * 利用栈的特性 当遇到})] 弹出上一个元素比较,如果能配对就继续,不能直接返回false
             */
            for (char c : s.toCharArray()) {
                if (c == '}' || c == ']' || c == ')') {
                    if (cache.isEmpty()) {
                        return false;
                    }
                    if (c == '}') {
                        if (!cache.pop().equals('{')) {
                            return false;
                        }
                    }
                    if (c == ']') {
                        if (!cache.pop().equals('[')) {
                            return false;
                        }
                    }
                    if (c == ')') {
                        if (!cache.pop().equals('(')) {
                            return false;
                        }
                    }

                } else {
                    cache.push(c);
                }
            }
            return cache.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  