//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1858 👎 0

package leetcode.editor.cn;

import domain.ListNode;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            /**
             *前置要求:要会合并2个升序链表 {@link HeBingLiangGePaiXuDeLianBiaoLcof}
             */
            // 利用归并排序 最后的合并原理 直接合并
            if (lists.length == 0) {
                return null;
            }
            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start >= end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            return merge(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(), cur = root;
            while (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }
                cur = cur.next;
            }
            while (l2 != null) {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
            while (l1 != null) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

