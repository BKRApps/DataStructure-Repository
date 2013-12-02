package com.example.BinarySearchTree;

public class MaxLength_InTree {

	static int temp=-1;
	static Sample resultTree=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		
		bst.add(100);bst.add(200);
		
		bst.add(60); bst.add(5);bst.add(4);bst.add(3);bst.add(2);
		bst.add(61);bst.add(62);bst.add(63);bst.add(64);bst.add(65);bst.add(66);bst.add(67);bst.add(68);
		
		Sample root=bst.getRoot();
		MaxLength(root);
		temp++; /*count the node itself*/
		System.out.println("Maximum Length You can Traverse in a tree \t"+temp);
		System.out.println("ResultNode\t"+resultTree.element);
		display(resultTree);
	}
	
	public static int MaxLength(Sample subTree){
		int a,b,total;
		if(subTree==null)
			return 0;
		else{
			a=MaxLength(subTree.leftChild);
			b=MaxLength(subTree.rightChild);
			total=a+b;
			if(temp==-1)
				temp=a+b;
			else{
				if(total>temp){
					temp=total;
				   resultTree=subTree;
				}
			}
			return (1+(a>b?a:b));	
		}
	}
	public static void display(Sample subTree){
		if(subTree==null)
			return;
		display(subTree.leftChild);
		System.out.print(subTree.element+"\t");
		display(subTree.rightChild);
	}
}
