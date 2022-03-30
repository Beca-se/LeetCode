//给定一个链表的 头节点 head ，请判断其是否为回文链表。
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 105] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 
// 👍 40 👎 0

package leetcode.editor.cn;

import domain.ListNode;

class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            // 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

            // 找到中间节点 翻转 比较
            ListNode l1 = head;
            ListNode l2 = reverse(findMid(head));
            return compare(l1, l2);

        }

        /**
         * 找链表的中间节点 如果有2个中间节点,返回第二个 <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list"/>         *
         *
         * @param head 要查询的节点
         * @return 中间节点
         */
        private ListNode findMid(ListNode head) {
            ListNode left = head, right = head;
            while (right != null && right.next != null) {
                left = left.next;
                right = right.next.next;
            }
            return left;
        }

        /**
         * 翻转链表 <a href="https://leetcode-cn.com/problems/UHnkqh/"/>
         *
         * @param head 要被翻转的链表
         * @return 翻转结果
         */
        private ListNode reverse(ListNode head) {
            ListNode root = new ListNode(), cur = null, temp;
            while (head != null) {
                temp = head.next;
                head.next = cur;
                root.next = head;
                cur = head;
                head = temp;
            }
            return root.next;
        }

        /**
         * 比较2个链表是否相等
         *
         * @param l1 l1
         * @param l2 l2
         * @return true  l1的长度>=l2的长度. 并且前面的相同位置的节点值相同
         */
        private boolean compare(ListNode l1, ListNode l2) {
            while (l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

