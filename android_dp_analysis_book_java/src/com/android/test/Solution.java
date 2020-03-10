package com.android.test;

/**
 * @Author: Sunzhipeng
 * @Date 2020/3/2
 * @Time 15:06
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static void main(String[] args) {

        ListNode node4 = new ListNode(-4);
        ListNode node3 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        detectCycle(node1);

    }

    private static ListNode getIntersect(ListNode head) {

        if (head == null || head.next == null) {
            System.out.println("no cycle");
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {

            if (fast == null || fast.next == null) {
                System.out.println("no cycle");
                return fast;
            }

            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        return slow;

        //         ListNode tortoise = head;
        //         ListNode hare = head;

        //         // A fast pointer will either loop around a cycle and meet the slow
        //         // pointer or reach the `null` at the end of a non-cyclic list.
        //         while (hare != null && hare.next != null) {
        //             tortoise = tortoise.next;
        //             hare = hare.next.next;
        //             if (tortoise == hare) {
        //                 return tortoise;
        //             }
        //         }

        //         return null;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null ) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode tailA = null;
        ListNode tailB = null;
        while (nodeA.next != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            if (nodeB.next != null) {
                nodeB = nodeB.next;
            } else {
                tailB = nodeB;
                nodeB = headA;
            }
            if (nodeA == nodeB) {
                return nodeA;
            }
        }

        tailA = nodeA;

        if (tailB != null && tailB != tailA) {
            return null;
        }

        nodeA=headB;
        while (nodeA.next != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            if (nodeB.next != null) {
                nodeB = nodeB.next;
            } else {
                tailB = nodeB;
                nodeB = headA;
                if (tailA != tailB) {
                    return null;
                }
            }
            if (nodeA == nodeB) {
                return nodeA;
            }
        }

        return null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast=head;
        ListNode slow=head;

        for (int i = 0; i <n ; i++) {
                fast=fast.next;
        }

        if (fast == null) {
            return slow.next;
        }

        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;


        return head;

    }

    public static ListNode detectCycle(ListNode head) {

        //         if(head==null||head.next==null) {
        //             System.out.println("no cycle");
        //             return head;
        //         }

        //         ListNode slow=head;
        //         ListNode fast=head.next;


        //         while(slow!=fast){

        //             if(fast==null||fast.next==null){
        //                 System.out.println("no cycle");
        //                 return fast;
        //             }

        //             slow=slow.next;
        //             fast=fast.next.next;
        //         }

        ListNode slow = getIntersect(head);

        ListNode frist = head;
        int index = 0;

        while (frist != slow) {
            slow = slow.next;
            frist = frist.next;
            ++index;
        }


        System.out.println("tail connects to node index " + index);

        return slow;

    }

    public static ListNode reserve(ListNode node) {

        ListNode head=node;
        ListNode cur=null;

        while (node!=null){

            cur=node.next;
            node=cur.next;

            cur.next=head;
            head=cur;
        }

        return head;

//
//        if (node == null || node.next == null) {
//            return node;
//        }else {
//            ListNode head = reserve(node.next);
//            node.next.next=node;
//            node.next=null;
//            return head;
//
//        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode nodeA=head;
        ListNode nodeB=head.next;
        ListNode nodeC=head.next;

        while (nodeA.next!=null&&nodeB.next!=null){
            nodeA.next=nodeA.next.next;
            nodeA=nodeA.next;
            nodeB.next=nodeB.next.next;
            nodeB=nodeB.next;
        }

        nodeA.next=nodeC;


        return head;
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode s=new ListNode(0);
        s.next=head;

        ListNode pre=s;
        ListNode cur=head;

        while (cur!=null){
            if (cur.val == val) {
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }

        return s.next;

    }
}