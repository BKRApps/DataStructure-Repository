package com.example.BinarySearchTree;

public class Morris_Inorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_Operations bst=new BST_Operations();
		bst.add(15);bst.add(20);bst.add(10);
		bst.add(8);bst.add(12);bst.add(5);bst.add(9);
		bst.add(11);bst.add(14);bst.add(40);
		
		Sample root=bst.getRoot();
		
		morrisInorder(root);
	}
	
	public static void morrisInorder(Sample rootNode){
		Sample currentNode,preNode;
		currentNode=rootNode;
		while(currentNode!=null){
			if(currentNode.leftChild==null){
				System.out.print(currentNode.element+"\t");
				currentNode=currentNode.rightChild;
			}
			else{
				preNode=currentNode.leftChild;
				while(preNode.rightChild!=null && preNode.rightChild!=currentNode)
					preNode=preNode.rightChild;
				if(preNode.rightChild==null){
					preNode.rightChild=currentNode;
					currentNode=currentNode.leftChild;
				}
				else{
					preNode.rightChild=null;
					System.out.print(currentNode.element+"\t");
					currentNode=currentNode.rightChild;
				}
			}
		}
	}

}
