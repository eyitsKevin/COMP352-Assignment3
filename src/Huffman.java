import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Huffman {



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

		System.out.println("TEST");
		GeneralTree.Node[] nodeArray = createHuffmanTree(uniqueCharArray, charOccurence);
//		String[] binaryArray = binaryCodeArray(nodeArray, uniqueCharArray);
		System.out.println("SYMBOLS\t   FREQUENCY\tBINARY CODE");
		for(int i = 0 ; i < nodeArray.length ; i++){

			System.out.print("  "+uniqueCharArray[i] + "\t      " + charOccurence[i]  + "\t " );
			generateBinaryCode(nodeArray[nodeArray.length-1], Character.toString(uniqueCharArray[i]));
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
				if(array[j] < array[j-1]){
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

	public static GeneralTree.Node[] createHuffmanTree(char[] element, int[] frequencyArray){
		int i = 0;
		int j = i+1;

		int size = element.length;
		String[] elementArray = charToString(element);

		GeneralTree tree = new GeneralTree();
		GeneralTree.Node[] nodeArray = new GeneralTree.Node[elementArray.length]; //creating a Node[] array
		GeneralTree.Node[] queue = new GeneralTree.Node[elementArray.length + (elementArray.length-1)]; //since an array of [1 2 3]{3} will have a PQ of [6 3 3 2 1]{5}
		//Transforming into a Node[] array
		nodeArray = tree.toNodeArray(elementArray, frequencyArray);


		System.out.println();
		System.out.println();
		//adding the two smallest values to create a root array of Node
		//adding the one at position i will be 1, while adding at position i+1 will be the right
		int iterator = 0; // will iterate through the array

		while(iterator < nodeArray.length-1){
			//adding both iterator
			GeneralTree.Node node = GeneralTree.addNode(nodeArray[iterator], nodeArray[iterator+1]); //returns a node a puts it at position iterator+1
			nodeArray[iterator+1] = node;
			GeneralTree.insertionSort(nodeArray);
			iterator++;
		}

		//		GeneralTree.Node root = nodeArray[nodeArray.length-1];
		//		System.out.println(root);
		//		System.out.println(root.getLeftChild());
		//		System.out.println(root.getRightChild());
		//		System.out.println(root.getLeftChild().getLeftChild()); //193
		//		System.out.println(root.getLeftChild().getRightChild());
		//		System.out.println(root.getRightChild().getLeftChild());
		//		System.out.println(root.getRightChild().getRightChild());
		//		System.out.println();
		//		System.out.println(root.getLeftChild().getRightChild().getLeftChild());
		//		System.out.println(root.getLeftChild().getRightChild().getRightChild());
		//		System.out.println(root.getLeftChild().getRightChild().getLeftChild().getLeftChild());
		//		System.out.println(root.getLeftChild().getRightChild().getLeftChild().getRightChild());
		//		System.out.println(root.getLeftChild().getRightChild().getLeftChild().getLeftChild().getLeftChild());
		//		System.out.println(root.getLeftChild().getRightChild().getLeftChild().getLeftChild().getRightChild());
		//		System.out.println(root.getLeftChild().getRightChild().getLeftChild().getRightChild());
		//		System.out.println(root.getLeftChild().getRightChild().getRightChild());

		return nodeArray;


	}




	 
	public  static void generateBinaryCode(GeneralTree.Node root, String find){
	

		if(root.getLeftChild().isLeaf())
			System.out.print(0);

		if(root.getRightChild().isLeaf())
			System.out.print(1);

		if(root.getLeftChild().getElement().contains(find) && !root.getLeftChild().isLeaf()){
			root = root.getLeftChild();
			System.out.print(0);
			generateBinaryCode(root, find);
		}

		if(root.getRightChild().getElement().contains(find) && !root.getRightChild().isLeaf()){
			root = root.getRightChild();
			System.out.print(1);
			generateBinaryCode(root, find);
		}


	}







	static public  String[] charToString(char[] character){
		String[] toString = new String[character.length];
		for(int i = 0 ; i < character.length ; i++){
			toString[i] =  Character.toString(character[i]);
		}
		return toString;
	}

	public static String charToString(char character){
		String toString = "";
		toString =  Character.toString(character);
		return toString;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openFile();



	}

}
