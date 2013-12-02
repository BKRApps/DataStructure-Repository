package com.example.InterviewQuestions;

public class DuplicteElement_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={100,2,3,4,1,7,6,4};
		for(int i=0;i<a.length;i++){
			if(a[Math.abs(a[i])]>=0)
				a[Math.abs(a[i])]=-a[Math.abs(a[i])];
			else
				System.out.println(Math.abs(a[i]));
		}
	}

}

