package com.example.BinarySearchTree;

import java.util.Stack;

public class BST_Operations {
	
	private Sample root=null;
	int leftHeight,rightHeight;
	int count=1;
	Stack<Sample> stack=new Stack<Sample>();
	public void add(int element){
		Sample node=new Sample(element,null,null);
		root=insertNode(root,node);
	}
	public Sample insertNode(Sample subTree,Sample node){
		if(subTree==null)
			subTree=node;
		else if(node.element<subTree.element){
			subTree.leftChild=insertNode(subTree.leftChild,node);
		}
		else if(node.element>subTree.element){
			 subTree.rightChild=insertNode(subTree.rightChild,node);
		}
		return subTree;
	}
	public Sample getRoot(){
		return root;
	}
}
class Sample{
	int element;
	boolean visited=false;
	Sample leftChild;
	Sample rightChild;
	
	Sample(int element,Sample left,Sample right){
		this.element=element;
		leftChild=left;
		rightChild=right;
	}
}