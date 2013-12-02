package com.example.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLinkedList2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int count=0,no;
		LinkedList list=new LinkedList();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(count<2){
		System.out.println("Enter Number ");
		no=Integer.parseInt(br.readLine());
		Node1 node=new Node1(no);
		list.insert(node);
		count++;
		}
		Node1 result=s.reverseBetween(list.getHead(),1,2);
		list.setHead(result);
		list.display();
	}

}
class Solution {
    public Node1 reverseBetween(Node1 head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Node1 temp1,temp2,temp3;
        Node1 start,end;
        Node1 t4;
        if(m==n)
           return head;
           
        start=traverseList(head,m-2);
        end=traverseList(head,n-1);
        t4=end.next;
        
        if(start==null){
            start=head;
            temp1=head;
            temp2=temp1.next;
            temp3=temp2.next;
            temp1.next=null;
           }
        else{
            temp1=start.next;
            temp2=temp1.next;
            temp3=temp2.next;
        }
        
        while(temp1!=end){
             temp2.next=temp1;
             temp1=temp2;
             temp2=temp3;
             if(temp3!=null)
             temp3=temp3.next;
        }
        
        if(start.next==null){
           start.next=t4;
           head=end;
        }
        else{
        start.next.next=t4;
        start.next=end;
        }
        
        return head;
    }
    
    public Node1 traverseList(Node1 head,int length){
        if(length<0)
           return null;
        while(length>0){
            head=head.next;
            length--;
        }
        return head;
    }
}