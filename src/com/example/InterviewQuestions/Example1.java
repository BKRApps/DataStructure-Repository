package com.example.InterviewQuestions;

/*
 *  Input   :   1 1 2 3 3 4 4 4 5 5 6 6 6 6 
 *  Output:   1 2 3 4 5 6
 */
public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int input[]={1,1,2,3,3,4,4,4,5,5,6,6,6,6};
			Sample1.doTask(input);
	}

}

class Sample1{
	static int output[];
	public static void doTask(int input[]){
		output=new int[input.length];
		for(int i=0, j=0;i<input.length;i++){
			if(i==0){
				output[j]=input[i];
				System.out.print(output[j]+"\t");
				j++;
			}
			else{
				if(output[j-1]!=input[i]){
					output[j]=input[i];
					System.out.print(output[j]+"\t");
					j++;
				}
			}
		}
	}
}
