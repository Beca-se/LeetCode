//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1700 👎 0


package leetcode.editor.cn;

import domain.ListNode;

class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode();
            ListNode current = root;
            while (l1 != null || l2 != null) {
                // 直接拼接l2
                if (l1 == null) {
                    current.next = l2;
                    l2 = l2.next;
                    current = current.next;
                    continue;
                }
                // 直接拼接l1
                if (l2 == null) {
                    current.next = l1;
                    l1 = l1.next;
                    current = current.next;
                    continue;
                }
                // 谁的值小拼接谁
                if (l1.val > l2.val) {
                    current.next = l2;
                    l2 = l2.next;
                } else {
                    current.next = l1;
                    l1 = l1.next;
                }
                current = current.next;
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  