package SetProject;

import java.util.Scanner;

public class setDataType {
	
	
	 static int setDataType[][];
	 static int setsCreated = 0; //Ensures set(s) have been created 
	 static Scanner input = new Scanner(System.in);
	 
	 
	 
	 //Create Set
	 public static int[][] createSet(int number)
	 {
		 setDataType = new int[number][];
		 int capacity;
		 System.out.println("Please input the capacity of your sets:");
		 for(int i = 0; i < number; i++)
		 {
			 System.out.println("Capacity of set " + (i+1));
			 {
				 capacity = input.nextInt();
				 setDataType[i] = new int[capacity];
			 }

		 }
		 System.out.println("Sets Created.");
		 return setDataType;
	 }
	 
	 public static int[][]add(int key, int set)
	 {
		 int flag = 0;
		 if(isFull(set) == false)
		 {
			 //Duplicates Check For LOOP
			  for (int i = 0; i < setDataType[set].length; i++)
			  {
				  if(setDataType[set][i] == key)
				  {	
					  System.out.println(key + " already exisits in set");
					  flag = 1;
					  break;
					 
				  }
			  }
				 //Insert LOOP
			  for (int i = 0; i < setDataType[set].length; i++)
			  {
				  if(setDataType[set][i] == 0 && flag != 1)
				  {	
					  setDataType[set][i] = key;
					  break;
				  }
			  }
			 
		 }
		 else
		 {
			 System.out.println("Set number " + set + " Is full.");
		 }
	
		return setDataType;
		 
	 }
	 
	 public static boolean isFull(int set)
	 {
		 boolean full = false;
		 
		 for (int i = 0; i < setDataType[set].length; i++)
		 {
			 if(setDataType[set][i] == 0)
			 {
				 full = false;
			 }
			 else
			 {
				 full = true;
			 }
		 }
		 
		 return full;
	 }
	 
	 
	 //Print The Set
	 public static void print(int[][] set)
	 {
		  for (int i = 0; i < set.length; i++)
		  {
	            for (int j = 0; j < set[i].length; j++)
	                System.out.print(set[i][j] + " ");
	            System.out.println();
		  }
	 }
	 
	 
	
	
	public static void main(String[] args) 
	{
		setDataType = createSet(2);
		print(setDataType);
		setDataType = add(50,0);
		print(setDataType);
		setDataType = add(50,0);
		setDataType = add(45,0);
		setDataType = add(15,0);
		print(setDataType);	
		System.out.println(isFull(0));
		setDataType = add(50,0);
	}
			

	
}