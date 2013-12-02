package com.example.BinarySearchTree;

import java.util.Stack;

public class InOrder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		bst.add(10);
		//bst.add(5);bst.add(6);bst.add(4);
		//bst.add(3);bst.add(20);
		
		Sample root=bst.getRoot();
		System.out.println("Recursive Method");
		Recursive_Inorder(root);
		System.out.println("\nIterative Method Using Flag Visited");
		Iterative_Inorder1(root);
		System.out.println("\nIterative Method");
		Iterative_Inorder2(root);
	}
	
	public static void Recursive_Inorder(Sample subTree){
		if(subTree==null)
			return ;
		Recursive_Inorder(subTree.leftChild);
		System.out.print(subTree.element+"\t");
		Recursive_Inorder(subTree.rightChild);
	}
	
	public static void Iterative_Inorder1(Sample subTree){
		Sample temp;
		Stack<Sample> stack=new Stack<Sample>();
		if(subTree==null)
			return;
		stack.push(subTree);
		while(!stack.isEmpty()){
			temp=stack.peek();
			if(temp.leftChild!=null && temp.leftChild.visited==false){
				stack.push(temp.leftChild);
				temp.leftChild.visited=true;
			}
			else{
				temp=stack.pop();
				System.out.print(temp.element+"\t");
				if(temp.rightChild!=null && temp.rightChild.visited==false){
					stack.push(temp.rightChild);
					temp.visited=true;
				}
			}
		}
	}

	public static void Iterative_Inorder2(Sample subTree){
		Stack<Sample> stack=new Stack<Sample>();
		Sample node=subTree;
		while( node!=null || !stack.isEmpty() ){
			if(node!=null){
				stack.push(node);
				node=node.leftChild;
			}
			else{
				Sample temp=stack.pop();
				System.out.print(temp.element+"\t");
				node=temp.rightChild;
			}
		}
	}
}
