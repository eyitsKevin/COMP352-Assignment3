import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ATree extends GeneralTree{

	//Implemeneting a SPLAYTREE
	
	
	
	 public static void displayFileContents(File fileIn) {
	    	Scanner reader = null;
	    	try{
	    	reader = new Scanner (new FileInputStream (fileIn.getName()));
	    	}
	    	catch (FileNotFoundException e){
	    		e.getMessage();
	    	}
	    	
	    	
	    	System.out.println("Here are the contents of the file " + fileIn.getName()  + ":");
	    	System.out.println("===============================================");
	    	int i =1 ;
	    	while(reader.hasNext()) {
	    		System.out.print(reader.next() + " ");
	    		i++;
	    		if(i%30 == 0){
	    			System.out.println();
	    		}

	    	}
	    	reader.close();

	    }
	
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Huffman wuush = new Huffman();
		File fileName = new File("Operations.txt");
		displayFileContents(fileName);
	}

}
