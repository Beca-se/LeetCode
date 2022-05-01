//给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "324",
//输出：324
//解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 
//输入：s = "[123,[456,[789]]]",
//输出：[123,[456,[789]]]
//解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 104 
// s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成 
// 用例保证 s 是可解析的 NestedInteger 
// 输入中的所有值的范围是 [-106, 106] 
// 
// Related Topics 栈 深度优先搜索 字符串 
// 👍 105 👎 0

package leetcode.editor.cn;

import java.util.*;

class MiniParser {
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
        NestedInteger deserialize = solution.deserialize("[123,[456,[789]]]");
        System.out.println("=");
    }

//leetcode submit region begin(Prohibit modification and deletion)

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {
        // Constructor initializes an empty nested list.
        private int value;
        private List<NestedInteger> child;

        public NestedInteger() {
            this(-1);
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
            child = new ArrayList<>();
        }

        ;

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return child.isEmpty() && value != -1;
        }

        ;

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }


        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }


        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            child.add(ni);
        }


        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return child;
        }
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// [ 1 2 3 , [ 4 5 6 ,  [  7  8  9  ]  ]  ]
    }

    class Solution {
        Stack<Character> stack = new Stack<>();

        public NestedInteger deserialize(String s) {
            // 如果不需要迭代
            if (s.charAt(0) != '[') {
                return new NestedInteger(Integer.parseInt(s));
            }

            Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
            int num = 0;
            boolean negative = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '-') {
                    negative = true;
                } else if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                } else if (c == '[') {
                    stack.push(new NestedInteger());
                } else if (c == ',' || c == ']') {
                    if (Character.isDigit(s.charAt(i - 1))) {
                        if (negative) {
                            num *= -1;
                        }
                        stack.peek().add(new NestedInteger(num));
                    }
                    num = 0;
                    negative = false;
                    if (c == ']' && stack.size() > 1) {
                        NestedInteger ni = stack.pop();
                        stack.peek().add(ni);
                    }
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

