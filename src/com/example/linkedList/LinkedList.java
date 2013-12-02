package com.example.linkedList;

public class LinkedList {
	Node1 head=null,tail=null;
	public void insert(Node1 subNode){
		if(head==null){
			head=subNode;
			tail=head;
		}
		else{
			tail.next=subNode;
			tail=tail.next;
		}
	}
	public void display(){
		Node1 temp=head;
		 while(temp!=null){
			  System.out.print(temp.getNo()+"\t");
			  temp=temp.next;
		  }
	}
	public Node1 getHead(){
		return head;
	}
	public void setHead(Node1 head){
		this.head=head;
	}
	public Node1 getTail(){
		return tail;
	}
}

class Node1{
	private int no;
	Node1 next=null;
	Node1(){
		
	}
	Node1(int no){
		this.no=no;
	 }
	public int getNo(){
		return this.no;
	}
}