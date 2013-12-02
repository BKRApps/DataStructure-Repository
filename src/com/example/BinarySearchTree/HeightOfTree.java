package com.example.BinarySearchTree;

public class HeightOfTree {

		public static void main(String a[]){
			BST_Operations bst=new BST_Operations();
			bst.add(10);bst.add(5);bst.add(6);bst.add(4);
			bst.add(3);bst.add(20);
			int height;
			Sample root=bst.getRoot();
			height=heightOfTree(root);
			System.out.println("Height Of a tree\t"+height);
		}
		
		public static int heightOfTree(Sample subTree){
			if(subTree==null)
		    	return 0;
		     return 1+(heightOfTree(subTree.leftChild)>heightOfTree(subTree.rightChild)
		    		 ?heightOfTree(subTree.leftChild):heightOfTree(subTree.rightChild));
		}
}
