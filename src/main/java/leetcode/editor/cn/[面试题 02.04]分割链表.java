//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你不需要 保留 每个分区中各节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 103 👎 0

package leetcode.editor.cn;

import domain.ListNode;

class PartitionListLcci {
    public static void main(String[] args) {
        Solution solution = new PartitionListLcci().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            ListNode minNode = new ListNode(0), minTail = minNode, maxNode = new ListNode(0), maxTail = maxNode;
            while (head != null) {
                if (head.val < x) {
                    minTail.next = head;
                    minTail = head;
                } else {
                    maxTail.next = head;
                    maxTail = head;
                }
                head = head.next;
            }
            minTail.next = maxNode.next;
            maxTail.next = null;
            return minNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

