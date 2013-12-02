package com.example.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort {
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
		doInsertionSort(array);
		display(array);
	}
	public static void doInsertionSort(int[] array){
		int temp,i,j;
		for(i=1;i<array.length;i++){
			temp=array[i];
			for(j=i-1;j>=0;j--){
				if(array[j]<temp)
					break;
				array[j+1]=array[j];
			}
			array[j+1]=temp;
		}
	}
	public static void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	}
}
