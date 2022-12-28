//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1105 👎 0

// 重排链表	题目标题	示例:两数之和
// 143	题目编号
package leetcode.editor.cn;

import domain.ListNode;

import java.util.Stack;

class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            // 利用栈存储链表
            ListNode root = head, currentNode = head;
            // 将全部的push进stack
            Stack<ListNode> listNodeStack = new Stack<>();
            while (head != null) {
                listNodeStack.push(head);
                head = head.next;
            }
            // 构建新的ListNode
            while (listNodeStack.peek() != currentNode && listNodeStack.peek() != currentNode.next) {
                ListNode temp = currentNode.next;
                currentNode.next = listNodeStack.pop();
                currentNode.next.next = temp;
                currentNode = temp;
                listNodeStack.peek().next = null;
            }
            head = root;
            // 寻找链表中间节点 876. 链表的中间结点
            // 翻转后半部分链表 206. 反转链表
            // 合并链表

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}