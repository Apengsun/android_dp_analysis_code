package com.android.dp.book.chapter03;

//测试代码
public class Test {
	public static void main(String[] args) { // 构建器
		Builder builder = new MacbookBuilder();
		// Director
		Director pcDirector = new Director(builder);
		// 封装构建过程, 4 核, 内存 2GB, Mac 系统
		pcDirector.construct("英特尔主板","Retina 显示器");
		// 构建电脑, 输出相关信息
		System.out.println("Computer Info : " + builder.create().toString());
	}

//		public static void main(String[] args) {
//			String a = "xiaomeng2";
//			final String b = "xiaomeng";
//			String d = "xiaomeng";
//			String c = b + 2;
//			String e = d + 2;
//			System.out.println((a == c));
//			System.out.println((a == e));
//			System.out.println(("xiaomeng" == "xiaomeng"));
//		}

//	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//		Stack<Integer> stack = new Stack<Integer>();
//		while (listNode != null) {
//			stack.add(listNode.val);
//			listNode = listNode.next;
//		}
//		ArrayList<Integer> ret = new ArrayList<Integer>();
//		while (!stack.isEmpty())
//			ret.add(stack.pop());
//		return ret;
//	}
}
