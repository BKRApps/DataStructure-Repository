package com.example.InterviewQuestions;
/*
 * Input    : 1 1 2 2 3 5 5 6 6 9
 * Input    : 1 1 1 2 3 4 4 6 8 
 * 
 * Output : 1 2 3 4 5 6 8 9
 */
public class Example2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input1[]={1,1,2,2,3,5,5,6,6,9};
		int input2[]={1,1,1,2,3,4,4,6,8};
		Sample2.doMerge(input1,input2);
		Sample2.display();
	 }
}

class Sample2{
	static int output[];
	static int i,j,k;
	public static void doMerge(int input1[],int input2[]){
		output=new int[input1.length+input2.length];
		while(i<input1.length &&  j <input2.length){
			
			if(input1[i]==input2[j]){
				if(!checkContains(output,input1[i])){
					output[k]=input1[i];
					k++;
				}
				i++;j++;
			}
			else if(input1[i]<input2[j]){
				 if(!checkContains(output,input1[i])){
					 output[k]=input1[i];
					 k++;
				}
				i++;
			}
			else if(input1[i]>input2[j]){
				 if(!checkContains(output,input2[j])){
					 output[k]=input2[j];
					 k++;
				}
			  j++;
			}
		}
		
		if(i!=input1.length){
			for(;i<input1.length;i++){
			   if(!checkContains(output,input1[i])){
				     output[k]=input1[i];
				     k++;
			   }
			}
		}
		if(j!=input2.length){
			for(;i<input2.length;j++){
			   if(!checkContains(output,input2[j])){
				     output[k]=input2[j];
				     k++;
			   }
			}
		}
	}
	public static boolean checkContains(int input[],int key){
		for(int m:input){
			if(input[m]==key)
				return true;
		}
		return false;
	}
	public static void display(){
 	for(int n=0;n<k;n++){
			System.out.print(output[n]+"\t");
		}
		System.out.println(" ");
	}
}