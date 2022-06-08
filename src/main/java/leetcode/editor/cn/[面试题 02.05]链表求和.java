//给定两个用链表表示的整数，每个节点包含一个数位。
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 递归 链表 数学 
// 👍 131 👎 0

package leetcode.editor.cn;

import domain.ListNode;

class SumListsLcci {
    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0), currentNode = root;
            int head = 0;
            while (l1 != null || l2 != null || head != 0) {
                int one = l1 == null ? 0 : l1.val;
                int two = l2 == null ? 0 : l2.val;
                int sum = one + two + head;
                head = sum / 10;
                sum %= 10;
                ListNode listNode = new ListNode(sum);
                currentNode.next = listNode;
                currentNode = listNode;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;

            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

