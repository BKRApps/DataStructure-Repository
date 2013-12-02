package com.example.linkedList;

public class LinkedList_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0,number=10;
		LinkedList list=new LinkedList();
		while(count<10){
		Node1 node=new Node1(number);
		list.insert(node);
		number=number+10;
		count++;
		}
	   list.display();
	   makeLoop(list.getHead(),list.getTail());
	    findLoopLinkedList(list.getHead());
	}
	public static void makeLoop(Node1 head,Node1 tail){
		tail.next=head;
	}
	public static void findLoopLinkedList(Node1 head){
		Node1 temp1,temp2;
		temp1=head;temp2=head;
		temp1=temp1.next;
		temp2=temp2.next.next;
		while(temp1!=null && temp2!=null){
			if(temp1==temp2){
				System.out.println("\n\nLoop in LinkedList");
				break;
			}
			temp1=temp1.next;
			temp2=temp2.next.next;
		}
	}
}
