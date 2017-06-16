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
			aTree.root = n;
			return;
		}
		else{
			aTree.root = splay(valueOfNode, aTree.root);
			if( value < aTree.root.getNumberOfOccurence()){ //if value youre trying to add is smaller than the root

			}
		}

	}
	

	
	public void zig(Node n){
		GeneralTree aTree = new GeneralTree();
		Node n2, n3, n4, n5; //Nodes of tree
		
		if(root == n.getLeftChild()) // if node is left child of parent roo
			n = aTree.root;
			
			
	}

	public void zigzag(Node n){
		if (n == n.parent.leftChild) {
			rotateRight(node);
			rotateLeft(node); 
		} else {
			rotateLeft(node);
			rotateRight(node); 
		}

	}

	public void zigzig(){

	}


	//Splay will bring the a node to the root by either performing a zig-zag or zig-zig - or zig
	public void splay(Node n){
		while (n != root){
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
