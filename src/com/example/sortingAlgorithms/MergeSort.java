package com.example.sortingAlgorithms;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={10,1,5,34,50,67,51,14,18};
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
		System.out.println();
		doMerge(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
	}
	
	public static void doMerge(int a[],int start,int end){
		int mid;
		if(start==end)
			return;
		mid=(start+end)/2;
		
		doMerge(a,start,mid);
		doMerge(a,mid+1,end);
		
		doMergeSort(a,start,mid,mid+1,end);
	}
	public static void doMergeSort(int a[],int start1,int end1,int start2,int end2){
		
	   int[] temp=new int[a.length];
		int k=0,i=start1;
		while(start1<=end1 && start2<=end2){
		  if(a[start1]==a[start2]){
			  temp[k]=a[start1];
			  k++;start1++;
			  temp[k]=a[start2];
			  k++;start2++;
		  }
		  else if(a[start1]<a[start2]){
				temp[k]=a[start1];
				k++;
				start1++;
			}
			else if(a[start1]>a[start2]){
				temp[k]=a[start2];
				k++;
				start2++;
			}
		}
		if(start1<=end1){
			for(;start1<=end1;start1++,k++){
				temp[k]=a[start1];
				}
		}
		if(start2<=end2){
			for(;start2<=end2;start2++)
				temp[k]=a[start2];
		}
		for(int m=0;m<k;m++,i++)
			a[i]=temp[m];
	}
}
