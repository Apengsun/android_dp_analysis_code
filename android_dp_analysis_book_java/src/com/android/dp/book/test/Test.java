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

package com.android.dp.book.test;

import java.util.ArrayList;

public class Test {
//    public static void main(String[] args) {
//        ResFinder.put(new ResItem(ResType.COLOR, "color1"), 123);
//        ResFinder.put(new ResItem(ResType.COLOR, "color1"), 123);
//        ResFinder.put(new ResItem(ResType.COLOR, "color2"), 222);
//        ResFinder.put(new ResItem(ResType.COLOR, "color3"), 333);
//        System.out.println("size : " + ResFinder.mResourcesCache.size());
//
//        int resId = ResFinder.getResourceId(ResType.COLOR, "color1");
//        System.out.println(" color = " + resId);
//    }
//public static void main(String[] args) {
//    // TODO Auto-generated method stub
//    int temvalue = 0;
//    AtomicInteger i = new AtomicInteger(0);
//    temvalue = i.getAndSet(3);
//    System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:0;  i:3
//    temvalue = i.getAndIncrement();
//    System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:3;  i:4
//    temvalue = i.getAndAdd(5);
//    System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:4;  i:9
//}
//}
    public static void main(String[] args) {
        //        ResFinder.put(new ResItem(ResType.COLOR, "color1"), 123);
        //        ResFinder.put(new ResItem(ResType.COLOR, "color1"), 123);
        //        ResFinder.put(new ResItem(ResType.COLOR, "color2"), 222);
        //        ResFinder.put(new ResItem(ResType.COLOR, "color3"), 333);
        //        System.out.println("size : " + ResFinder.mResourcesCache.size());
        //
        //        int resId = ResFinder.getResourceId(ResType.COLOR, "color1");
        //        System.out.println(" color = " + resId);
        //
        //        Node node4=new Node();
        //        node1.value=4;
        //        Node node3=new Node();
        //        node3.value=3;
        //        node3.next=node4;
        //        Node node2=new Node();
        //        node2.value=2;
        //        node2.next=node3;
        //        Node node1=new Node();
        //        node1.value=1;
        //        node1.next=node2;
        //
        //       Node node= reserve(node1);
        //        while (node.next!=null){
        //            System.out.println(" node = " + node.value);
        //        }
        ArrayList test=selfDividing(1, 22);
        for (int i = 0; i <test.size() ; i++) {
            System.out.print(test.get(i)+" ");
        }
    }

    public static Node reserve(Node node) {
        if (node == null) {
            return node;
        }

        Node head=null;
        Node cur=null;
        boolean isEnd = false;
        op(node, isEnd, head, cur);
        return head;

    }

    public static void op(Node node, boolean isEnd, Node head, Node cur) {
        if (node.next == null) {
            if (isEnd) {
                cur.next = node;
                cur = node;
            } else {
                isEnd = true;
                head = node;
                cur = node;
            }
        } else {
            op(node.next, isEnd, head, cur);
        }
    }

    public static ArrayList<Integer> selfDividing(int left, int right) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = left; i <= right; i++) {
            int b = 0;
            for (b = i; b > 0; b = b / 10) {
                if (b % 10 == 0 || i % (b % 10) != 0)
                    break;
            }
            if (b == 0)
                result.add(i);

        }

        return result;

    }

}


class Node {
    public int value;
    public Node next;

}


