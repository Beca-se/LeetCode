//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 229 👎 0

package leetcode.editor.cn;

import domain.ListNode;

class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(), cur = root;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                    // 这里必须放continue,因为这里已经改变了l2的值
                    continue;
                }
                if (l2 == null) {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                    // 这里必须放continue,因为这里已经改变了l1的值
                    continue;
                }

                if (l1.val >= l2.val) {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

