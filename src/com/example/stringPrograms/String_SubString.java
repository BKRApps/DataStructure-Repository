package com.example.stringPrograms;

import java.util.Scanner;

public class String_SubString {

	public static void main(String[] args) {

		String s1,s2;
		int result=0,i=0,j=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the first String");
		s1=scanner.nextLine();
		System.out.println("Enter the Second String");
		s2=scanner.nextLine();
		StringEx1 ex1=new StringEx1();
		while(result!=1 && s1.length()>=i+s2.length() ){
			if(s1.charAt(i)==s2.charAt(j)){
				result=ex1.compare(s1,s2,i);
			}
			i++;
		}
		if(result==1){
			System.out.println("SubString Found @ Position "+i);
		}
		else{
			System.out.println("SubString Not Found  ");
		}
	}
}
class StringEx1{
	public int compare(String s1,String s2,int i){
		for(int j=0;j<s2.length()-1;j++,i++){
			if(s1.charAt(i)!=s2.charAt(j))
				return 0;
		}
		return 1;
	}
}
