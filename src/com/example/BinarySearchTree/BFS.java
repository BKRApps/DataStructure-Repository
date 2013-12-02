package com.example.BinarySearchTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		bst.add(15);bst.add(20);bst.add(10);
		bst.add(8);bst.add(12);bst.add(5);bst.add(9);
		bst.add(11);bst.add(14);bst.add(40);
		
		Sample root=bst.getRoot();
		System.out.println("BFS Traversal");
		doBFS_Traversal(root);
		System.out.println("\nZig Zag Traversal");
		doZigZagTree(root);
	}
	
	public static void doBFS_Traversal(Sample subTree){
		Queue<Sample> queue=new LinkedList<Sample>();
		Sample temp;
		queue.add(subTree);
		while(!queue.isEmpty()){
			temp=queue.remove();
			System.out.print(temp.element+"\t");
			if(temp.leftChild!=null)
				queue.add(temp.leftChild);
			if(temp.rightChild!=null)
				queue.add(temp.rightChild);
		}
	}
	public static void doZigZagTree(Sample subTree){
		Deque<Sample> queue=new LinkedList<Sample>();
		Stack<Sample> stack=new Stack<Sample>();
		Sample temp; 
		int flag=1;
		queue.add(subTree);
		while(!queue.isEmpty() || !stack.isEmpty()){
			if(flag==1){
				while(!queue.isEmpty()){
				temp=queue.pop();
				System.out.print(temp.element+"\t");
				if(temp.leftChild!=null)
					stack.push(temp.leftChild);
				if(temp.rightChild!=null)
					stack.push(temp.rightChild);
				}
				flag=0;
			}
			else{
				while(!stack.isEmpty()){
				temp=stack.pop();
				System.out.print(temp.element+"\t");
				if(temp.rightChild!=null)
					queue.addFirst(temp.rightChild);
				if(temp.leftChild!=null)
					queue.addFirst(temp.leftChild);
				}
				flag=1;
			}
		}
	}
}
