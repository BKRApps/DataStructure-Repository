package com.example.BinarySearchTree;

import java.util.Stack;

public class PrintPath_ReverseTree {
	static Stack<Sample> stack=new Stack<Sample>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		
		bst.add(100); bst.add(105);
		bst.add(90);bst.add(80);bst.add(70);bst.add(85);
		bst.add(95);bst.add(92);bst.add(91);bst.add(93);bst.add(98);bst.add(97);bst.add(99);
		
		Sample root=bst.getRoot();
		Sample targetNode=root.leftChild.rightChild.rightChild.leftChild;
		printPath(root,targetNode);
		stack.push(root);
		reverseTree();
		display(targetNode.leftChild);
	}
	
	public static boolean printPath(Sample rootNode,Sample targetNode){
		boolean a,b;
		if(rootNode==null || targetNode==null)
			return false;
		else if(rootNode==targetNode){
			return true;
		}
		else{
			a=printPath(rootNode.leftChild,targetNode);
			b=printPath(rootNode.rightChild,targetNode);
			if(a==true)
				stack.push(rootNode.leftChild);
			if(b==true)
				stack.push(rootNode.rightChild);
			return (a || b);
		}
	}
	
	public static void reverseTree(){
		Sample temp1=null,temp2=null;
		while(stack.size()>1){
				if(temp1==null){
					temp1=stack.pop();
					if(temp1.leftChild==stack.peek())
						temp1.leftChild=null;
					else
						temp1.rightChild=null;
				}
				else
					temp1=temp2;
			    temp2=stack.pop();
			    if(temp2.leftChild==stack.peek())
			    	temp2.leftChild=temp1;
			    else
			    	temp2.rightChild=temp1;
		}
		temp1=stack.pop();
		temp1.leftChild=temp2;
   }

	public static void display(Sample subNode){
		if(subNode==null)
			return;
		display(subNode.leftChild);
		System.out.print(subNode.element+"\t");
		display(subNode.rightChild);
	}
}
