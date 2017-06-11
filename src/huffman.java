import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class huffman  {
	
	//Creating the Node Class, this is the first step of making a 
	class Node{
		
	}
	
	
	/*
	 *  This method tries to open and read the file
	 */
	static public void openFile(){
		
		File inputFile = new File("Jabberwock.txt");
		inputFile.setReadOnly(); //To prevent potentially destroying the file
		Scanner inStream = null;
		
		try{
			System.out.println("Attempting to open: \"" + inputFile.getName() +"\"");
			inStream = new Scanner (new FileInputStream(inputFile));		
	
		} catch (FileNotFoundException e){
			System.out.println("Error");
			e.getMessage();
			System.exit(0);
		}
		
		String lineOfString = inStream.nextLine();
		
		System.out.println("\n==========\tPrinting out the content of \"Jabberwock.txt\"\t==========\n");
	
		System.out.print(lineOfString + " ");
	
		System.out.println("\n\n==========\tEnd of \"Jabberwock.txt\"\t==========");
		

		
		System.out.println("Converting the line of string into a character array...");
		char[] notUniqueArray = lineOfString.toCharArray();
			
		System.out.println("Converting the character array into a unique character of arrays \n");
		String initial = ""; //Creating a string of unique char
		for(int i = 0 ; i< notUniqueArray.length ; i++){
			if(initial.indexOf(notUniqueArray[i]) == -1) //checking if the char is already added
				initial += notUniqueArray[i];
		}
		
		char[] uniqueCharArray = initial.toCharArray();
		
		printArray(uniqueCharArray);

		System.out.println("\n\nCounting the number of occurences in original char array... \n");
        //Creating an array of occurrences and initializing it with 0
		int[] charOccurence = new int [uniqueCharArray.length];
		for(int i = 0; i< charOccurence.length ; i++)
			charOccurence[i] = 0;  
		
	    for(int i = 0 ; i < uniqueCharArray.length ; i++){
	    	char current = uniqueCharArray[i];
	    	for(int j = 0 ; j< notUniqueArray.length ; j++){
	    		if(current == notUniqueArray[j])
	    			charOccurence[i]++; //since same size
	    		else{
	    			//do nothing
	    		}
	    	}
	    }
	    
		for(int i = 1 ; i <= charOccurence.length ;i++){
			System.out.print("[" + uniqueCharArray[i-1] + "] occurs " + charOccurence[i-1] + " time(s) \t");
			if(i % 5 == 0)
				System.out.println();
		}
	
	}
	
	
	static void printArray(char[] array){	
		for(int i = 1 ; i <= array.length ;i++){
			System.out.print("[" + (i-1) + "] = " + array[i-1] + "\t");
			if(i % 5 == 0)
				System.out.println();
		}
	}
	
	static void arraySort(int[] array){
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
openFile();
	}

}
