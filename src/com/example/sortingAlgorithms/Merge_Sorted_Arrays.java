package com.example.sortingAlgorithms;
/*
 * If a sorted matrix given and asked to sort the arrays.
 * [12,18,25,40,54
 * 1,20,24,30,40
 * 1,50,80,90,100
 * 34,68,89,95,150]
 */
public class Merge_Sorted_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* input */
		int a[][]=new int[4][5];
		a[0][0]=12;a[0][1]=18;a[0][2]=25;a[0][3]=40;a[0][4]=54;
		a[1][0]=1;a[1][1]=20;a[1][2]=24;a[1][3]=30;a[1][4]=40;
		a[2][0]=1;a[2][1]=50;a[2][2]=80;a[2][3]=90;a[2][4]=100;
		a[3][0]=34;a[3][1]=68;a[3][2]=89;a[3][3]=95;a[3][4]=150;
		/*output array*/
		int b[]=new int[20];
		for(int i=0,k=0;i<4;i++){
			for(int j=0;j<5;j++){
				b[k]=a[i][j];
				k++;
			}
		}
		display(b);
		int i=0,j=0,mi=0,nj=0;
		for(;nj<20;){
			mi=mi+5;	
			j=j+5;
			nj=j+5;
			System.out.println("Value"+nj);
			doMerge(b,i,mi,j,nj);
		}
		display(b);
	}
	
	public static void doMerge(int[] array,int i,int m,int j,int n){
		int temp[]=new int[20];
		int k=0;
		while(i<m && j<n){
			
			if(array[i]==array[j]){
				temp[k]=array[i];k++;i++;
				temp[k]=array[j];k++;j++;
			}
			
			else if(array[i]<array[j]){
				temp[k]=array[i];
				i++;
				k++;
			}
			
			else if(array[i]>array[j]){
				temp[k]=array[j];
				j++;
				k++;
			}
		}
		if(i!=m){
			for(;i<m;i++,k++)
				temp[k]=array[i];
		}
		if(j!=n){
			for(;j<n;k++,j++)
				temp[k]=array[j];
		}
		for(i=0;i<n;i++){
			array[i]=temp[i];
		}
	}
	public static void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	}
}

