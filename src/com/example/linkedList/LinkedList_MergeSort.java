package com.example.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList_MergeSort {
	static int count=0;
	static Node1 head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node1 result;
		LinkedList list=new LinkedList();
		fillLinkedList(list);
		//list.display();
		head=list.getHead();
		result=mergeSort(head);
		list.setHead(result);
		list.display();
	}
	
	public static void fillLinkedList(LinkedList list){
		int no;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter count");
		try {
			count=Integer.parseInt(br.readLine());
			while(count!=0){
				no=Integer.parseInt(br.readLine());
				Node1 node=new Node1(no);
				list.insert(node);
				count--;
			    } 
		    }catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public static Node1 mergeSort(Node1 head){
		Node1 a,b;
		if(head==null || head.next==null){
			return head;
		}
		/* split head into 2 sub lists a and b*/
		a=head;
		b=frontBackSplit(head);
		a=mergeSort(a);
		b=mergeSort(b);
		return sortedMerge(a,b);
	}
	public static Node1 sortedMerge(Node1 temp1,Node1 temp2){
		Node1 result;
		if(temp2==null)
			return temp1;
		if(temp1==null)
			return temp2;
		else if(temp1.getNo()>temp2.getNo()){
			result=temp1;
			result.next=sortedMerge(temp1.next,temp2);
		}
		else{
			result=temp2;
			result.next=temp2.next=sortedMerge(temp1,temp2.next);
		}
		return result;
	}
	public static Node1 frontBackSplit(Node1 source){
		Node1 slow=null,fast=null;
		Node1 backRef;
		slow=source;
		fast=slow.next;
		while(fast!=null){
			fast=fast.next;
			if(fast!=null){
				slow=slow.next;
				fast=fast.next;
			}
		}
		backRef=slow.next;
		slow.next=null;
		return backRef;
	}
}
