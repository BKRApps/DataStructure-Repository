package com.example.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectionSort {
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
		doSelectionSort(array);
		display(array);
	}
	public static void doSelectionSort(int[] array){
		int i,j,minIndex,minValue;
		for(i=0;i<array.length;i++){
			minIndex=i;
			minValue=array[i];
			for(j=i+1;j<array.length;j++){
				if(array[j]<minValue){
					minIndex=j;
					minValue=array[j];
				}
			}
			if(minIndex!=i){
			array[minIndex]=array[i];
			array[i]=minValue;
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
