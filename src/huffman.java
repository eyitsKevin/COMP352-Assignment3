import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class huffman {
	
	/*
	 *  This method tries to open and read the file
	 */
	public void openFile(){
		
		File inputFile = new File("Jabberwock.txt");
		inputFile.setReadOnly(); //To prevent potentially destroying the file
		Scanner inStream = null;
		
		try{
			System.out.println("Attempting to open: " + inputFile.getName());
			inStream = new Scanner (new FileInputStream(inputFile));		
	
		} catch (FileNotFoundException e){
			e.getMessage();
			System.exit(0);
		}
		
		while(inStream.hasNext()){ 
			
		}

	}
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
