package com.example.searchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int array[]={10,20,30,40,50,60,70,80,90,100};
		int key;
		System.out.println("Enter the key to search");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		key=Integer.parseInt(br.readLine());
		doBinarySearch(array,key);
	}
	
	public static void doBinarySearch(int array[],int key){
		int mid;
		int low=0,high=array.length-1;
		
		while(low<=high){
			mid=low+(high-low)/2;
			if(array[mid]==key){
				System.out.println("Found @ Position "+mid);
				break;
			}
			else if(key<array[mid])
				high=mid-1;
			else
				low=mid+1;
		}
	}

}
