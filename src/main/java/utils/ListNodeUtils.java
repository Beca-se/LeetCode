package utils;

import domain.ListNode;

public class ListNodeUtils {

    private ListNodeUtils() throws IllegalAccessException {
        throw new IllegalAccessException("不允许访问构造函数.");
    }


    /**
     * 按照给定的数据顺序,创建要给链表.并返回头节点,如果从传入null或者长度为0,返回null
     *
     * @param values 要构造链表的数据
     * @return 链表的头节点
     */
    public static ListNode createListNode(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode root = new ListNode();
        ListNode current = root;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return root.next;
    }
}
