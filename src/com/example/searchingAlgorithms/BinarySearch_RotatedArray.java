package com.example.searchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch_RotatedArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int key;
		/*int array[]={12,13,14,15,16,1,2,3};*/
		int array[]={1,2,3,4,5,6}; /* it returns -1 because no rotations happened*/
		int pivotPosition=findPivot(array,0,array.length-1);
		System.out.println("Pivot Position\t"+pivotPosition);
		
		System.out.println("Enter the key to search");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		key=Integer.parseInt(br.readLine());
		pivotBinarySearch(array,0,array.length-1,key);
	}
	public static int findPivot(int[] array,int low,int high){
	
		int mid;
		if(low>high) return -1;
		mid=low+(high-low)/2;
		if(array[mid]<array[mid-1] && array[mid]<array[mid+1])
			return mid-1;
		if(array[low]<=array[mid])
			return findPivot(array,mid+1,high);
		else
			return findPivot(array,low,mid-1);
	}
	
	public static void pivotBinarySearch(int array[],int low,int high,int key){
		int pivotPosition=findPivot(array,low,high);
		if(pivotPosition==-1) /* normal input i.e sorted order without any rotation */
			binarySearch(array,low,high,key);
		else if(array[low]==key)
			System.out.println("Found @ Position\t"+low);
		else if(array[low]<key)
			binarySearch(array,low,pivotPosition,key);
		else
			binarySearch(array,pivotPosition+1,high,key);
	}
	
	public static void binarySearch(int array[],int low,int high,int key){
		int mid=low+(high-low)/2;
		if(low>high)
			return ;
		else if(array[mid]==key)
			System.out.println("Found @ Position\t"+mid);
		else if(key<array[mid])
			 binarySearch(array,low,mid-1,key);
		else
			binarySearch(array,mid+1,high,key);
	}

}
