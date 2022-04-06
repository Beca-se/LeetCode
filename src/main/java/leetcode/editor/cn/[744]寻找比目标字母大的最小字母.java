//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
// 
//
// 示例 2: 
//
// 
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
// 
//
// 示例 3: 
//
// 
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 104 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 
// 👍 193 👎 0
package leetcode.editor.cn;

class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int len = letters.length;
            // 如果不在范围内 直接返回第一个字符
            if (target < letters[0] || target >= letters[len - 1]) {
                return letters[0];
            }
            // 利用二分法查找第一个比target大的字符下标
            int left = 0, right = len, mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (letters[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 返回结果
            return letters[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}