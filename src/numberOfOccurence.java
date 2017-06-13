import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class numberOfOccurence extends huffman {

	huffman object2 = new huffman();
	
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

		System.out.println("\n\n==========\tEnd of \"Jabberwock.txt\"\t==========\n");




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

		System.out.println("\n\nSorting the array in descending order...\n");
		TwoinputsInsertionSort(charOccurence, uniqueCharArray);
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

	/*
	 * This method sorts an array in descending order. It is important to note that the char character must also correspond and be sorted as well
	 */
	static void TwoinputsInsertionSort(int[] array, char[] array2){
		int temp;
		char temp2;
		for (int i = 0 ; i < array.length-1 ; i++){ //first ends before 1
			for(int j = i+1 ; j > 0 ; j--){ //second 
				if(array[j] > array[j-1]){
					temp = array[j];
					temp2 = array2[j];
					array[j] = array[j-1];
					array2[j] = array2[j-1];
					array[j-1] = temp; //contains the higher value
					array2[j-1] = temp2;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		openFile();

	}
}