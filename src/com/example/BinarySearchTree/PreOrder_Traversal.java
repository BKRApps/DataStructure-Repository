package com.example.BinarySearchTree;

import java.util.Stack;

public class PreOrder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		bst.add(10);bst.add(5);bst.add(6);bst.add(4);
		bst.add(3);bst.add(20);
		
		Sample root=bst.getRoot();
		
		Recursive_Preorder(root);
		Iterative_Preorder1(root);
	}
	
	public static void Recursive_Preorder(Sample subTree){
		if(subTree==null)
			return;
		System.out.print(subTree.element+"\t");
		Recursive_Preorder(subTree.leftChild);
		Recursive_Preorder(subTree.rightChild);
	}
	
	public static void Iterative_Preorder1(Sample subTree){
		Stack<Sample> stack=new Stack<Sample>();
		stack.push(subTree);
		while(!stack.isEmpty()){
			subTree=stack.pop();
			System.out.print(subTree.element+"\t");
			if(subTree.rightChild!=null)
				stack.push(subTree.rightChild);
			if(subTree.leftChild!=null){
				stack.push(subTree.leftChild);
			 }
		}
	}

}
