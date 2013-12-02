package com.example.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class LargestCommonNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(21);list1.add(25);list1.add(14);list1.add(50);list1.add(55);list1.add(10);list1.add(100);
		list1.add(200);
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(10);list2.add(13);list2.add(16);list2.add(18);list2.add(20);
		solution s=new solution();
		s.findCommonLargest(list1,list2);
	}
}

class solution{
	public void findCommonLargest(List<Integer> list1, List<Integer> list2){
		int i=0,j=0;
		doMerge(list1,0,list1.size()-1);
		doMerge(list2,0,list2.size()-1);
		while(i<list1.size() && j<list2.size()){
			if(list1.get(i)==list2.get(j)){
				System.out.println("Largest Common Integer is\t"+list1.get(i));
				return;
			}
			else if(list1.get(i)>list2.get(j))
				i++;
			else
				j++;
		}
		System.out.println("Not Found");
	}
	public static void doMerge(List<Integer> list1,int start,int end){
		int mid;
		if(start==end)
			return;
		mid=(start+end)/2;
		
		doMerge(list1,start,mid);
		doMerge(list1,mid+1,end);
		
		doMergeSort(list1,start,mid,mid+1,end);
	}
	public static void doMergeSort(List<Integer> list1,int start1,int end1,int start2,int end2){
		
		   int[] temp=new int[list1.size()];
			int k=0,i=start1;
			while(start1<=end1 && start2<=end2){
			  if(list1.get(start1)==list1.get(start2)){
				  temp[k]=list1.get(start1);
				  k++;start1++;
				  temp[k]=list1.get(start2);
				  k++;start2++;
			  }
			  else if(list1.get(start1)>list1.get(start2)){
					temp[k]=list1.get(start1);
					k++;
					start1++;
				}
				else if(list1.get(start1)<list1.get(start2)){
					temp[k]=list1.get(start2);
					k++;
					start2++;
				}
			}
			if(start1<=end1){
				for(;start1<=end1;start1++,k++){
					temp[k]=list1.get(start1);
					}
			}
			if(start2<=end2){
				for(;start2<=end2;start2++)
					temp[k]=list1.get(start2);
			}
			for(int m=0;m<k;m++,i++){
				list1.remove(i);
				list1.add(i, temp[m]);
			}
		}
}
