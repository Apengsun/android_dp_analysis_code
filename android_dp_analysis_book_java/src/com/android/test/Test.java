/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.android.test;

public class Test {
    public static void main(String[] args) {
        //        ResFinder.put(new ResItem(ResType.COLOR, "color1"), 123);
        //        ResFinder.put(new ResItem(ResType.COLOR, "color1"), 123);
        //        ResFinder.put(new ResItem(ResType.COLOR, "color2"), 222);
        //        ResFinder.put(new ResItem(ResType.COLOR, "color3"), 333);
        //        System.out.println("size : " + ResFinder.mResourcesCache.size());
        //
        //        int resId = ResFinder.getResourceId(ResType.COLOR, "color1");
        //        System.out.println(" color = " + resId);

        //        Node node4 = new Node();
        //        node4.value = 4;
        //        Node node3 = new Node();
        //        node3.value = 3;
        //        node3.next = node4;
        //        Node node2 = new Node();
        //        node2.value = 2;
        //        node2.next = node3;
        //        Node node1 = new Node();
        //        node1.value = 1;
        //        node1.next = node2;
        //
        //        Node node = reserve(node1);
        //        while (node != null) {
        //            System.out.println(" node = " + node.value);
        //            node = node.next;
        //        }

        int[] a = {1, 99, 3, 27, 5, 8, 12, 6, 9, 15};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");

        int[] b = switchNum(a);

        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            }
        }


    }

    public static Node reserve(Node node) {

        if (node == null || node.next == null) {
            return node;
        } else {
            Node head = reserve(node.next);
            node.next.next = node;
            node.next = null;
            return head;

        }
    }

    public static int[] switchNum(int[] arr) {
        if (arr == null || arr.length <= 1)
            return arr;
        int pre = 0;
        int end = arr.length - 1;

        while (pre < end) {
            int temp = arr[pre];
            arr[pre] = arr[end];
            arr[end] = temp;
            pre++;
            end--;
        }
        return arr;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int overNum = 0;

        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + overNum;
            pre.next = new ListNode(0);
            pre.next.val = sum % 10;
            overNum = sum / 10;

            pre = pre.next;

            l1 = l1.next;
            l2 = l2.next;


        }

        if (overNum == 0) {
            pre.next = l1 == null ? l2 : l1;
        } else if (overNum == 1) {
            if (l1 == null && l2 != null) {
                while (l2 != null && overNum == 1) {
                    int sum = l2.val + overNum;
                    pre.next = new ListNode(0);
                    pre.next.val = sum % 10;
                    overNum = sum / 10;
                    pre = pre.next;
                    l2 = l2.next;
                    if (overNum == 0) {
                        pre.next = l2;
                    }
                }
            }
            if (l1 != null && l2 == null) {
                while (l1 != null && overNum == 1) {
                    int sum = l1.val + overNum;
                    pre.next = new ListNode(0);
                    pre.next.val = sum % 10;
                    overNum = sum / 10;
                    pre = pre.next;
                    l1 = l1.next;
                    if (overNum == 0) {
                        pre.next = l1;
                    }
                }
            }
            if (l1 == null && l2 == null) {
                pre.next = new ListNode(overNum);
            }
        }

        return head.next;


    }

    public Node flatten(Node head) {
        flattentail(head);
        return head;
    }

    public Node flattentail(Node head) {

        if (head == null) {
            return head;
        }

        if (head.child == null) {
            if (head.next == null) {
                return head;
            }
            return flattentail(head.next);
        } else {

            Node child = head.child;
            Node next = head.next;
            head.next = child;
            child.prev = head;
            head.child = null;

            Node chlidtail = flattentail(child);
            if (next != null) {
                chlidtail.next = next;
                next.prev = chlidtail;
                return flattentail(next);
            }

            return chlidtail;
        }

    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode end = null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
        }

        if (fast == slow)
            return head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;

        return result;


    }

    public ListNode rotateRight2(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }

        int slowNum=length-k%length;
        if (slowNum == length) {
            return head;
        }

        for (int i = 1; i <slowNum ; i++) {
            slow=slow.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;

        return result;


    }


}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

}


