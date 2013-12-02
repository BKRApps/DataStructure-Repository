package com.example.InterviewQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N_Queens_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the N value for N Queen Problem");
		int nValue=Integer.parseInt(br.readLine());
		int array[][];
		array=resetArray(nValue);
		createNQueenArray(array,0);
		display(array);
		System.out.println();
		}catch(Exception e){
			
		}
	}
	
	public static int[][] resetArray(int nValue){
		int[][] array=new int[nValue][nValue];
		for(int i=0;i<nValue;i++){
			for(int j=0;j<nValue;j++){
				array[i][j]=0;
			}
		}
	  return array;
	}
	
	public static boolean createNQueenArray(int array[][],int col){
		if(col>=array.length)
			return true;
		for(int i=0;i<array.length;i++){
			if(checkValidity(array,i,col)){
					 array[i][col]=1;
					 if(createNQueenArray(array,col+1))
						 return true;
					 array[i][col]=0;
				}
			}
		return false;
	}
	
	private static boolean checkValidity(int array[][],int i,int j){
		boolean a,b,c;
		a=rowValidity(array,i);
		b=columnValidity(array,j);
		c=diagonalValidity(array,i,j);
		return a && b && c;
	}
	
	private static boolean rowValidity(int array[][],int i){
		/* we will consider row only.*/
		int k=0;
		while(k<array.length){
			if(array[i][k]==1)
				return false;
			k++;
		}
		return true;
	}
	private static boolean columnValidity(int array[][],int j){
		/* we will consider column only*/
		int k=0;
		while(k<array.length){
			if(array[k][j]==1)
				return false;
			k++;
		}
		return true;
	}
	private static boolean diagonalValidity(int array[][],int i,int j){
		int a=i,b=j;
		while(a<array.length-1 && b<array.length-1){
			if(array[a+1][b+1]==1)
				return false;
			a++;b++;
		}
	    a=i;b=j;
	    while(a>0 && b>0){
			if(array[a-1][b-1]==1)
				return false;
			a--;b--;
		}
	    a=i;b=j;
	    while(a>0 && b<array.length-1){
			if(array[a-1][b+1]==1)
				return false;
			a--;b++;
		}
	    a=i;b=j;
	    while(a<array.length-1 && b>0){
			if(array[a+1][b-1]==1)
				return false;
			a++;b--;
		}
		return true;
 	 }
	
	public static void display(int[][] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
