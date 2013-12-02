/*
 *  amazon-interview-questions
	Print words of given string in reverse:
	"This is test" -> "test is This"
 */
package com.example.InterviewQuestions;

public class StringReverse_Exmples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer input1=new StringBuffer("This Is Test");
		StringBuffer input2=new StringBuffer("This Is Test");
		Solution1 sol2=new Solution1();
		
		sol2.problem1(input1); 
		sol2.problem2(input2); 
	}

}

class Solution1{
	/* reverse the whole string. then reverse the each word. This is O(1) space complexity
	 * input : This Is Test
	 * output: Test Is This
	 * */
	public void problem1(StringBuffer input){
		System.out.println("Input\t"+input);
		reverseString(input,0,input.length()-1);
		int i=0,j=0;
		while(j<input.length()){
			if(input.charAt(j)==32){
				reverseString(input,i,j-1);
				j++;
				i=j;
			}
			else
				j++;
		}
	 reverseString(input,i,j-1);
	 System.out.println("Output\t"+input);
	}
	
	/*reverse each word.
	 * input : This Is Test
	 * output: sihT sI tseT
	 * */
	public void problem2(StringBuffer input){
		int i=0,j=0;
		System.out.println("Input\t"+input);
		while(j<input.length()){
			if(input.charAt(j)==32){
				reverseString(input,i,j-1);
				j++;
				i=j;
			}
			else if(j==input.length()-1){
				reverseString(input,i,j);
				j++;
			}
			else
			 j++;
		}
	  System.out.println("Output\t"+input);
	  }
	public void reverseString(StringBuffer str,int i,int j){
		char temp;
		for(;i<j;i++,j--){
			temp=str.charAt(j);
			str.setCharAt(j,str.charAt(i));
			str.setCharAt(i,temp);
		}
	}
}

