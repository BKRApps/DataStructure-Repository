package com.example.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListEx {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int no,count=0;
		LinkedList list=new LinkedList();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(count<3){
		System.out.println("Enter Number ");
		no=Integer.parseInt(br.readLine());
		Node1 node=new Node1(no);
		list.insert(node);
		count++;
		}
		list.display();
	  }
	}
