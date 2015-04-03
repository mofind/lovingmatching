package org.aurora.lovingmatching.network;

import java.util.LinkedList;
import java.util.Queue;

public class TestSyntax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.size());
		queue.add("hello");
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		queue.add("world");
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		

	}

}
