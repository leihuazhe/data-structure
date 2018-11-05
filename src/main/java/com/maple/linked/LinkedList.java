package com.maple.linked;

/**
 * 链表
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-05 10:57 PM
 */
public class LinkedList<E> {
    //    private Node head;
    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    //关键，找到要添加节点的前一个节点,然后将 prev 的 next 节点赋值给 node 的 next节点
    // prev.next 新的next 节点为 node
    // node.next = prev.next
    // prev.next = node

    // prev.next =node
    // node.next = prev.next => 错误
    //在 index(0-based)位置添加新的元素e
    /*public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            //待插入节点的前一个节点.
            //第一轮循环时，prev 已经为1 ，因为 0 处为 head 节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);
            size++;
        }
    }*/

    public void add(int index, E e) {
        // >
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }

        Node prev = dummyHead;
        // 0 之前的节点，1之前的节点.
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //链表投添加元素 e
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //get 第 index 个元素
    public E get(int index) {
        ensure(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //修改第 index 个位置的元素 e
    public void set(int index, E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 遍历有区别
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        //不是 cur.next != null
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除元素,找到待删除元素之前的元素.
     *
     * @param index 索引位置
     * @return E
     */
    public E remove(int index) {
        //ensure
        ensure(index);

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        //删除元素的前一个元素的next发生变化
        //将删除的node 的next置为 null
        prev.next = delNode.next;
        //指向空,从链表中删除
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder resp = new StringBuilder();
       /* Node cur = dummyHead.next;
        while (cur != null) {
            resp.append(cur + "->");
            cur = cur.next;
        }*/
        resp.append("Head: ");
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            resp.append(cur + "->");
        }
        resp.append(" NULL");
        return resp.toString();
    }

    private void ensure(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


}
