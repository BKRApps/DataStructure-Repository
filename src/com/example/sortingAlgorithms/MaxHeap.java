package com.example.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxHeap {
	
	static int currentIndex=0;
	static int tempIndex;
	static int temp;
	static int array[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfElements=12;
		array=new int[numberOfElements];
		System.out.println("Enter\t"+(numberOfElements-1)+"\t Elements");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<numberOfElements-1;i++){
			try{
			insertion(array,Integer.parseInt(br.readLine()));
			}catch(Exception e){
				
			}
		}
		for(int i=0;i<numberOfElements-1;i++){
		//display(array);
		deletion();
		}
	}
	
	/*percolate up */
	public static void insertion(int array[],int nextElement){
		currentIndex++;
		array[currentIndex]=nextElement;
		tempIndex=currentIndex;
		while(tempIndex>1){
			if(array[tempIndex/2]>array[tempIndex])
				break;
			else{
				temp=array[tempIndex/2];
				array[tempIndex/2]=array[tempIndex];
				array[tempIndex]=temp;
			}
			tempIndex=tempIndex/2;
		}
	}
	public static void deletion(){
		System.out.print(array[1]+"\t");
		array[1]=array[currentIndex];
		currentIndex--;
		tempIndex=1;
		while(2*tempIndex+1<=currentIndex){
			if(array[tempIndex]<array[2*tempIndex] || array[tempIndex]<array[2*tempIndex+1]){
				tempIndex=array[2*tempIndex]>array[2*tempIndex+1]?(2*tempIndex):(2*tempIndex+1);
				swap(array,tempIndex/2,tempIndex);
			}
			else
				break;
			
		}
		if(2*tempIndex==currentIndex){
			if(array[tempIndex]<array[2*tempIndex]){
				swap(array,tempIndex,2*tempIndex);
			}
		}
	}
	public static void swap(int[] array,int a,int b){
		temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	public static void display(int[] array){
		for(int i=1;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	}
}
