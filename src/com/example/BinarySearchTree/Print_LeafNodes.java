package com.example.BinarySearchTree;

public class Print_LeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		bst.add(10);bst.add(5);bst.add(6);bst.add(4);
		bst.add(3);bst.add(20);
		
		Sample root=bst.getRoot();
		printLeafNodes(root);
	}
	/*Post Order with small condition that print if both child's are NULL*/
	public static void printLeafNodes(Sample subTree){
		 if(subTree==null)
			  return;
		 printLeafNodes(subTree.leftChild);
		 printLeafNodes(subTree.rightChild);
		  if(subTree.leftChild==null && subTree.rightChild==null)
			  System.out.print(subTree.element+"\t");
	}

}
