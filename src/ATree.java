import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.sun.crypto.provider.AESCipher.General;

import GeneralTree.Node;


public class ATree extends GeneralTree{

	private int removeCount = 0; //getting the total number of remove operations
	private int addCount = 0; //getting the total number of add operations
	private int findCount = 0; // getting the total number of find operations
	private int splayCount = 0; //getting the total number of parent change
	private int comparisonCount = 0; //getting the total number of comparison
	private static int sizeOfTree = 0; //gets updated if add/remove functions are called

	/*
	 * FINISHING UP THE NODE CLASS WITH GRANDPARENT AND PARENT POINTERS
	 */



	/////////////////////////////// GETTERS AND SETTERS /////////////////////////

	public Node getParent(){
		getParent();
	}

	public Node getGP(){
		getGP();
	}

	public void setLeftChild(Node n){
		Node leftChild = n;
		if(n != null)
			leftChild.parent = this;

	}

	///////////////////////////////////////////////////////////////////////////

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

	//	 The first double rotation is called a zigzag rotation. It takes place when either
	//	 of the following two conditions are met:
	//		 1. S is the left child of P, and P is the right child of G.
	//		 2. S is the right child of P, and P is the left child of G.

	//	 
	//	 The other double rotation is known as a zigzig rotation. A zigzig rotation takes
	//	 place when either of the following two conditions are met:
	//	 1. S is the left child of P, which is in turn the left child of G.
	//	 2. S is the right child of P, which is in turn the right child of G.
	//	 
	//A single rotation is performed only if S is a child of the root node. 
	//
	public static Node transformIntoNode(int valueOfNode){
		GeneralTree aTree = new GeneralTree();
		GeneralTree.Node aNode = aTree.new Node(valueOfNode);
		return aNode;	 
	}


	//if a is picked
	public static void insert(Node n){

		//Checking if the tree is empty
		GeneralTree aTree = new GeneralTree();
		if(aTree.root == null){ //if empty create a new node and assign it as a root
			aTree.root = new Node(n.numberOfOccurence) ; 
			return;
		}
		else{ //there's no duplicate operations
			n = new Node(n.getNumberOfOccurence());
			if( n.getNumberOfOccurence() < aTree.root.getNumberOfOccurence()){ //if value youre trying to add is smaller than the root
				n.leftChild = aTree.root.leftChild;				//swap - n becomes root while two child are the root and root's left child
				n.rightChild = aTree.root; 						
				aTree.root.leftChild = null;
			} 

			else {
				n.rightChild = aTree.root.rightChild;				//swap - n becomes root while two child are the root and root's left child
				n.leftChild = aTree.root; 						
				aTree.root.rightChild = null;
			}

			aTree.root = n; //the added node becomes the child
			sizeOfTree++; //size of queue gets incremented
		}

	}

	public void remove(int value, Node node){
		//if the value to remove is smaller than the value of the current node
		if(value < node.getNumberOfOccurence()){
			if (node.getLeftChild() != null)
				remove(value,node.getLeftChild()); //recursive method looking at the next left child

			if(node.getLeftChild() == null)
				node.g
		}

	}


	public void zig(Node n){
		GeneralTree aTree = new GeneralTree();
		Node n2, n3, n4, n5; //Nodes of tree

		if(root == n.getLeftChild()) // if node is left child of parent roo
			n = aTree.root;


	}

	public void zigzag(Node n){
		if (n == n.leftChild) {
			rotateRight(node);
			rotateLeft(node); 
		} else {
			rotateLeft(node);
			rotateRight(node); 
		}

	}


	public void zigzig(){

	}
	
	public void run(String n){
		char command =  n.charAt(0); //if a123 returns a
		String number = n.substring(1); //after the substring
		int value = Integer.parseInt(number);
		
		switch(command){
		case 'a' = insert();
				
		}
		
	}


	//Splay will bring the a node to the root by either performing a zig-zag or zig-zig - or zig
	public void splay(Node n){
		while (n.parent == null){ //while it is the root n.root != null
			Node parent = n.getParent(); //n has a parent
			if(root.getLeftChild() == n || root.getRightChild() == n){ //performs a zig

			}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Huffman wuush = new Huffman();
		File fileName = new File("Operations.txt");
		displayFileContents(fileName);
	}

}
