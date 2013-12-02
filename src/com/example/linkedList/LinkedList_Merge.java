package com.example.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList_Merge {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		LinkedList list1=new LinkedList();
		LinkedList list2=new LinkedList();
		LinkedList result;
		fillLinkedList(list1);
		fillLinkedList(list2);
		System.out.println("Sorted LinkedList");
		result=mergeLinkedList(list1,list2);
	   /* list1.display();
		list2.display();*/
		result.display();
	}
	public static void fillLinkedList(LinkedList list){
		int no,count=0;
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
	public static LinkedList mergeLinkedList(LinkedList list1,LinkedList list2){
		Node1 temp1=list1.getHead(),temp2=temp1.next;
		Node1 temp3=list2.getHead(),temp4=temp3.next;
		LinkedList result=list1;
		if(temp1.getNo()<temp3.getNo())
			result=list1;
		else 
			result=list2;
		while(temp1!=null && temp3!=null){
		if(temp1.getNo()>temp3.getNo()){
			if(temp4!=null && temp1.getNo()>temp4.getNo()){
				temp3=temp4;
				temp4=temp4.next;
			}
			else{
				temp3.next=temp1;
				temp3=temp4;
				if(temp4!=null)
				temp4=temp4.next;
			}
		}
		else{
			if(temp2!=null && temp2.getNo()<temp3.getNo()){
				temp1=temp2;
				temp2=temp2.next;
			}
			else{
				temp1.next=temp3;
				temp1=temp2;
				if(temp2!=null)
				temp2=temp2.next;
			}
		}
	}
	return result;
  }
}
