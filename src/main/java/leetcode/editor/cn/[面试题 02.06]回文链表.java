//编写一个函数，检查输入的链表是否是回文的。
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 112 👎 0

package leetcode.editor.cn;

import domain.ListNode;

class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            // 找中间节点
            ListNode middleNode = findMiddleNode(head);
            // 反转链表
            middleNode = turnNode(middleNode);
            // 比较是否相同
            return compare(head, middleNode);
        }

        private ListNode turnNode(ListNode middleNode) {
            ListNode currentNode = null, temp;
            while (middleNode != null) {
                temp = middleNode.next;
                middleNode.next = currentNode;
                currentNode = middleNode;
                middleNode = temp;
            }

            return currentNode;
        }

        // head的长度大于等于middleNode的长度
        private boolean compare(ListNode head, ListNode middleNode) {

            while (middleNode != null) {
                if (middleNode.val != head.val) {
                    return false;
                }
                middleNode = middleNode.next;
                head = head.next;
            }
            return true;
        }

        /**
         * 长度为奇数 返回中间节点 长度为偶数 返回中间第二个节点
         *
         * @param head
         * @return
         */

        private ListNode findMiddleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

