package com.example.BinarySearchTree;

import java.util.Stack;

public class K_DistanceNodes_InTree {
	static Stack<Sample> stack=new Stack<Sample>();
	public static void main(String args[]){
		BST_Operations bst=new BST_Operations();
		bst.add(50);bst.add(55);
		
		bst.add(40);bst.add(44);bst.add(46);bst.add(45);bst.add(48);
		
		bst.add(20);bst.add(30);bst.add(32);bst.add(34);
		bst.add(18);bst.add(16);bst.add(14);
		
		Sample root=bst.getRoot();
		Sample targetNode=root.rightChild;
		int k=2;
		 firstCase(targetNode,k);
		if(getPath(root,targetNode)){
			stack.push(root);
			Sample endNode=reverseTree();
			firstCase(endNode.leftChild,k-1);
		}
	}
	
	public static void firstCase(Sample subTree,int kLength){
		if(subTree==null)
			return;
		if(kLength==0){
			System.out.print(subTree.element+"\t");
			return;
		}
		firstCase(subTree.leftChild,kLength-1);
		firstCase(subTree.rightChild,kLength-1);
				
	}
	
	/* This will give you the path from root to targetNode*/
	public static boolean getPath(Sample rootNode,Sample targetNode){
		boolean a,b;
		if(rootNode==null || targetNode==null)
			return false;
		else if(rootNode==targetNode){
			return true;
		}
		else{
			a=getPath(rootNode.leftChild,targetNode);
			b=getPath(rootNode.rightChild,targetNode);
			if(a==true)
				stack.push(rootNode.leftChild);
			if(b==true)
				stack.push(rootNode.rightChild);
			return (a || b);
		}
	}
	/* This will reverse the tree only from targetNode to root node*/
	public static Sample reverseTree(){
		Sample temp1=null,temp2=null;
		while(stack.size()>1){
				if(temp1==null){
					temp1=stack.pop();
					if(temp1.leftChild==stack.peek())
						temp1.leftChild=null;
					else
						temp1.rightChild=null;
					if(stack.size()==1){
					   temp2=stack.pop();
					   temp2.leftChild=temp1; /* If only 2 nodes in the stack*/
					   return temp2;
					}
				}
				else
					temp1=temp2;
			    temp2=stack.pop();
			    if(temp2.leftChild==stack.peek())
			    	temp2.leftChild=temp1;
			    else
			    	temp2.rightChild=temp1;
		}
		if(temp2!=null){
		temp1=stack.pop();
		temp1.leftChild=temp2;
		}
		return temp1;
	}

}
