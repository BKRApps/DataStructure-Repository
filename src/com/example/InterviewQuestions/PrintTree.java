package com.example.InterviewQuestions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class PrintTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Node> list1=new Vector<Node>();
		List<Node> list2=new Vector<Node>();
		List<Node> list3=new Vector<Node>();
		List<Node> list4=new Vector<Node>();
		
		Node one=new Node(1,list1);
		
		Node two=new Node(2,list2);
		Node three=new Node(3,list3);
		Node four=new Node(4,list4);
		
		list1.add(two);list1.add(three);list1.add(four);
		
		Node five=new Node(5,null);
		Node six=new Node(6,null);
		Node seven=new Node(7,null);
		
		list2.add(five);
		list4.add(six);list4.add(seven);
		
		List<Node> result=traverseTreeAndReturnListContainingAllNodes(one);
		System.out.println();
	}
	public static List<Node> traverseTreeAndReturnListContainingAllNodes(Node n){
				List<Node> arrayList = new ArrayList<Node>();
				LinkedList<Node> queue = new LinkedList<Node>();
				if( n == null ) 
					return arrayList;
				queue.add(n);
				while(queue.size() != 0 ){
				     Node temp = queue.remove();
				     System.out.println(temp.label);
				     arrayList.add(temp);
					 if( temp.children != null && temp.children.size() != 0)
						 queue.addAll(temp.children);
				}
				return arrayList;
	}
}

class Node {
    int label;
    List<Node> children;
    public Node(int label,List<Node> children){
  	  this.children=children;
  	  this.label=label;
    }
}
