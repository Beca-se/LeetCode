package domain;

/**
 * @author ZhouHu
 * @Class Name ListNode
 * @Desc 链表基础结构
 * @create: 2020-09-26 01:58
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
