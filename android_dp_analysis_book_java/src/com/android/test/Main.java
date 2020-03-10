package com.android.test;
//
///**
// * @Author: Sunzhipeng
// * @Date 2020/1/17
// * @Time 13:58
// */
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * 给定一个正整数，给出消除重复数字以后最大的整数
// * 输入描述:
// * 正整数，注意考虑长整数
// * 输出描述:
// * 消除重复数字以后的最大整数
// * 示例1
// * 输入
// * 423234
// * 输出
// * 432
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String sc = scanner.next();
//        List list = new ArrayList();
//        for (int i = 0; i < sc.length(); i++) {
//            list.add(sc.charAt(i));
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (list.get(i).equals(list.get(j))) {
//                    if (Integer.valueOf(list.get(j + 1).toString()) > Integer.valueOf(list.get(j).toString())) {
//                        list.remove(j);
//                        i--;
//                        break;
//                    } else {
//                        list.remove(i);
//                        i--;
//                        break;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i));
//        }
//        System.out.println();
//    }
//
//}

public class Main {
    public static void main(String[] args) {
//        int[] A =new int[]{2,8,4,3,2};
        int[] A =new int[]{2,8,4,4,3,2};
        System.out.println( ""+solution(A,7,11,3));
    }

    public static int solution(int[] A, int X, int Y, int Z) {
        // write your code in Java SE 8
        if (A != null && A.length >= 1 && A.length <= 100000 && X >= 0 && X <= 1000000000 && Y >= 0 && Y <= 1000000000 && Z >= 0 && Z <= 1000000000) {
            int waitTime = 0;
            int xTime=0;
            int xLast=0;
            int yTime=0;
            int yLast=0;
            int zTime=0;
            int zLast=0;
            for (int i = 0; i < A.length; i++) {
                if (A[i]<1||A[i]>1000000000){
                    return -1;
                }
                if (A[i] <= X) {
                    X = X - A[i];
                    xTime=xTime+A[i];
                    xLast=A[i];
                } else if (A[i] <= Y) {
                    Y = Y - A[i];
                    yTime=yTime+A[i];
                    yLast=A[i];
                }else if (A[i] <=Z) {
                    Z = Z - A[i];
                    zTime=zTime+A[i];
                    zLast=A[i];
                }else {
                    return -1;
                }
            }
            xTime=xTime-xLast;
            yTime=yTime-yLast;
            zTime=zTime-zLast;
            if (xTime>yTime) {
                waitTime=xTime;
            }else {
                waitTime=yTime;
            }

            if (waitTime<zTime)
                waitTime=zTime;
            return waitTime;
        }
        return -1;

    }
    //    public int solution(int[] X, int[] Y) {
    //        // write your code in Java SE 8
    //        if (X != null && Y != null && X.length >= 2 && X.length <= 100000 && X.length == Y.length) {
    //            for (int i = 0; i < X.length - 1; i++) {
    //                if (X[i] >= 0 && X[i] <= 1000000000 && Y[i] >= 0 && Y[i] <= 1000000000) {
    //                    if (X[i] == X[i + 1] && Y[i] == Y[i + 1]) {
    //                        return -1;
    //                    }
    //
    //                } else {
    //                    return -1;
    //                }
    //
    //            }
    //            //快速排序
    //            quickSort(X, 0, X.length - 1);
    //            quickSort(Y, 0, Y.length - 1);
    //            int widthMax = 0;
    //            for (int i = 0; i < X.length - 1; i++) {
    //                if (X[i + 1] - X[i] > widthMax) {
    //                    widthMax = X[i + 1] - X[i];
    //                }
    //
    //            }
    //            if (widthMax == 0) {
    //                return -1;
    //            }
    //            return widthMax;
    //        }
    //        return -1;
    //    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    //    public static void main(String[] args) {
    //        Scanner in = new Scanner(System.in);
    //        List<Integer> list = new ArrayList();
    //        String s = in.nextLine();
    //        String[] strings = s.split(" ");
    //        for (int i = 0; i < strings.length; i++) {
    //            list.add(Integer.valueOf(strings[i]));
    //        }
    //        System.out.println(fun(list) + "");
    //    }
    //
    //    public static int fun(List<Integer> arr) {
    //        int sum = 0;
    //        int pre = 1;
    //        for (int i = 0; i < arr.size(); i++) {
    //            if (i + 1 == arr.size()) {
    //                sum += pre;
    //                continue;
    //            }
    //            if (arr.get(i) > arr.get(i + 1)) {
    //                sum = sum + pre + 1;
    //                pre = 1;
    //            }
    //            if (arr.get(i) == arr.get(i + 1)) {
    //                sum += pre;
    //            }
    //            if (arr.get(i) < arr.get(i + 1)) {
    //                sum += pre;
    //                pre = pre + 1;
    //            }
    //        }
    //
    //        return sum;
    //    }


}

//// you can also use imports, for example:
//// import java.util.*;
//
//// you can write to stdout for debugging purposes, e.g.
//// System.out.println("this is a debug message");
//
//class Solution {
//    public int solution(int[] A) {
//        // write your code in Java SE 8
//    }
//}
