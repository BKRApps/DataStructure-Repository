package com.example.InterviewQuestions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Progress_Software_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SolveIt s=new SolveIt();
		 s.readFile();
	}
}

class SolveIt{
	
	public void readFile(){
		ArrayList<String> list=new ArrayList<String>();
		try{
		BufferedReader br=new BufferedReader(new FileReader("Input.txt"));
		String line=null;
		int totTestCases=Integer.parseInt(br.readLine());
		br.readLine();
		while((line=br.readLine())!=null){
			//System.out.print(line);
			if(line.isEmpty()){
				//System.out.println("Blank Line");
				createArray(list);
				list.clear();
			}
			else{
			list.add(line);
			}
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
		createArray(list);
   }
	
	public void createArray(ArrayList<String> list){
		int count=list.size();
		int size=list.get(0).length();
		//System.out.println("Array of Size\t"+count+"*"+size);
		char grid[][]=new char[count][size];
		int visited[][]=new int[count][size];
		for(int i=0;i<count;i++){
			for(int j=0;j<size;j++){
				grid[i][j]=list.get(i).charAt(j);
				visited[i][j]=-1;
				//System.out.print(grid[i][j]+"\t");
			}
			//System.out.println();
		}
		int result=0,temp=0;
	for(int i=0;i<count;i++){
			for(int j=0;j<size;j++){
				if(grid[i][j]=='1'){
					clearVisit(visited,count,size);
					visited[i][j]=1;
					temp=findMaxGridInArray(grid,visited,i,j,count-1,size-1);
					}
				if(temp>=result){
					result=temp;
				}
			}
		}
	 //System.out.println(result);
	 writeToFile(result);
	}
	
	public int findMaxGridInArray(char[][] grid,int[][] visited,int i,int j,int maxI,int maxJ){
		
		int count=1;
		
		if(j<maxJ && grid[i][j]==grid[i][j+1] && visited[i][j+1]==-1){
			visited[i][j+1]=1;
			count=count+findMaxGridInArray(grid,visited,i,j+1,maxI,maxJ);
		}
		if(j>0 && grid[i][j]==grid[i][j-1] && visited[i][j-1]==-1){
			visited[i][j-1]=1;
			count=count+findMaxGridInArray(grid,visited,i,j-1,maxI,maxJ);
		}
		
		if(i<maxI && grid[i][j]==grid[i+1][j] && visited[i+1][j]==-1){
			visited[i+1][j]=1;
			count= count+findMaxGridInArray(grid,visited,i+1,j,maxI,maxJ);
		}
		
		if(i>0 && grid[i][j]==grid[i-1][j] && visited[i-1][j]==-1){
			visited[i-1][j]=1;
			count= count+findMaxGridInArray(grid,visited,i-1,j,maxI,maxJ);
		}
		
		if(i<maxI && j<maxJ && grid[i][j]==grid[i+1][j+1] && visited[i+1][j+1]==-1){
			visited[i+1][j+1]=1;
			count= count+findMaxGridInArray(grid,visited,i+1,j+1,maxI,maxJ);
		}
		if(i>0 && j>0 && grid[i][j]==grid[i-1][j-1] && visited[i-1][j-1]==-1){
			visited[i-1][j-1]=1;
			count= count+findMaxGridInArray(grid,visited,i-1,j-1,maxI,maxJ);
		}
		
		if(i>0 && j<maxJ && grid[i][j]==grid[i-1][j+1] && visited[i-1][j+1]==-1){
			visited[i-1][j+1]=1;
			count= count+findMaxGridInArray(grid,visited,i-1,j+1,maxI,maxJ);
		}
		if(i<maxI && j>0 && grid[i][j]==grid[i+1][j-1] && visited[i+1][j-1]==-1){
			visited[i+1][j-1]=1;
			count= count+findMaxGridInArray(grid,visited,i+1,j-1,maxI,maxJ);
		}
		return count;
	}

	public void writeToFile(Integer result){
		try{
			File file = new File("output.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			String result1=result.toString();
			bw.write(result1+"\n");
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clearVisit(int[][] visited,int count,int size){
		for(int i=0;i<count;i++){
			for(int j=0;j<size;j++){
				visited[i][j]=-1;
			}
		}
	}
}
