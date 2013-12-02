package com.example.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BubbleSort {
	static int array[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfElements=5;
		array=new int[numberOfElements];
		System.out.println("Enter\t"+numberOfElements+"\t Elements");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<numberOfElements;i++){
			try{
			array[i]=Integer.parseInt(br.readLine());
			}catch(Exception e){
				
			}
		}
		display(array);
		doBubbleSort(array);
		display(array);
	}
	
	public static void doBubbleSort(int[] array){
		/*
		 *  Compare each pair of elements and swap them if required.
		 */
		int temp,numberOfSwap=1;
		for(int i=0;i<array.length && numberOfSwap>=1 ;i++){
			numberOfSwap=0;
			for(int j=0;j<array.length-(i+1);j++){
				if(array[j]<array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					numberOfSwap=1;
				}
			}
		}
	 }
	public static void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	}
}


