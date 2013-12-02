package com.example.linkedList;

import java.util.Scanner;

public class Palindrome_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		NodeOperations op=new NodeOperations();
		while(count<6){
			Scanner scan=new Scanner(System.in);
			char character=scan.nextLine().charAt(0);
			Node node=new Node(character);
			op.add(node);
			count++;
		}
		System.out.println("Display LinkedList");
		op.display();
		/*op.reverseLinkedList();*/
		op.findPalindrome();
	}
}

class Node{
	char character;
	Node next;
	
	Node(char character){
		this.character=character;
	}
}
class NodeOperations{
	
	Node root=null;
	
	public void add(Node subNode){
		root=insert(root,subNode);
	}
	private Node insert(Node subNode1,Node subNode2){
		if(subNode1==null)
			subNode1=subNode2;
		else
			subNode1.next=insert(subNode1.next,subNode2);
		return subNode1;
	}
	public void display(){
		display(root);
	}
	private void display(Node subNode1){
		System.out.println();
		if(subNode1==null)
			return;
		else{
			System.out.print(subNode1.character+"\t");
			display(subNode1.next);
		}
	}
	public void findPalindrome(){
		Node endPoint=reverseHalfLinkedList(root);
		display(root);
		display(endPoint);
	}
	public Node reverseHalfLinkedList(Node subNode){
		Node temp1,temp2,temp3;
		int count=getCount(root);
		for(int i=0;i<(count/2)-1;i++){
			subNode=subNode.next;
		}
		
		temp1=subNode.next;subNode.next=null;
		
		temp2=temp1.next;temp3=temp2.next;
		temp1.next=null;
		while(temp2!=null){
			temp2.next=temp1;
			temp1=temp2;
			temp2=temp3;
			if(temp3!=null)
				temp3=temp3.next;
		}
		return temp1;
	}
	
	private int getCount(Node subNode){
		int count=0;
		if(subNode==null)
			return 0;
		else{
			while(subNode!=null){
				count++;
				subNode=subNode.next;
			}
			return count;
		}
	}
	public void reverseLinkedList(){
		reverseLinkedList(root);
	}
	public void reverseLinkedList(Node subNode1){
		Node temp1=subNode1,temp2=temp1.next,temp3=temp2.next;
		temp1.next=null;
		while(temp2!=null){
			temp2.next=temp1;
			temp1=temp2;
			temp2=temp3;
			if(temp3!=null)
			temp3=temp3.next;
		}
		display(temp1);
	}
}