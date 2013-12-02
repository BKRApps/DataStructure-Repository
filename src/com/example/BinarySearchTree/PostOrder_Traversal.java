package com.example.BinarySearchTree;

import java.util.Stack;

public class PostOrder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		//bst.add(10);bst.add(8);bst.add(5);bst.add(6);bst.add(7);bst.add(9);
		//bst.add(20);bst.add(15);bst.add(25);
		bst.add(3);bst.add(2);bst.add(1);
		Sample root=bst.getRoot();
		
		Recursive_Postorder(root);
		System.out.println();
		Iterative_Postorder1(root);
		System.out.println();
		Iterative_Postorder2(root);
	}
	
	public static void Recursive_Postorder(Sample subTree){
		if(subTree==null)
			return;
		Recursive_Postorder(subTree.leftChild);
		Recursive_Postorder(subTree.rightChild);
		System.out.print(subTree.element+"\t");
	}
	
	public static void Iterative_Postorder1(Sample subTree){
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
			else if(temp.rightChild!=null && temp.rightChild.visited==false){
				stack.push(temp.rightChild);
				temp.rightChild.visited=true;
			}
			else{
				System.out.print(stack.pop().element+"\t");
			}
		}
	}
	
	public static void Iterative_Postorder2(Sample subTree){
		Stack<Sample> stack=new Stack<Sample>();
		Sample currNode,prevNode;
		if(subTree==null)
			return;
		 stack.push(subTree);
		 prevNode=subTree;
		 while(!stack.isEmpty()){
			 currNode=stack.peek();
			 if(currNode.leftChild==prevNode ){
					if(currNode.rightChild!=null)
						stack.push(currNode.rightChild);
					else{
						System.out.print(currNode.element+"\t");
						stack.pop();
						prevNode=currNode;
					}
				}
			 else if((currNode.leftChild!=null || currNode.rightChild!=null)&& 
					(currNode.rightChild!=prevNode)){
				if(currNode.leftChild!=null)
					stack.push(currNode.leftChild);
				else if(currNode.rightChild!=null)
					stack.push(currNode.rightChild);
			}
			else{
				System.out.print(currNode.element+"\t");
				stack.pop();
				prevNode=currNode;
			}
		}
	}
}
