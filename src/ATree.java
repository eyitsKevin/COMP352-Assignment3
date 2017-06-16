import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Implemeneting a SPLAYTREE

public class ATree extends GeneralTree{
	static GeneralTree aTree = new GeneralTree();
	private int removeCount = 0; //getting the total number of remove operations
	private int addCount = 0; //getting the total number of add operations
	private int findCount = 0; // getting the total number of find operations
	private int splayCount = 0; //getting the total number of parent change
	private static int comparisonCount = 0; //getting the total number of comparison
	private static int sizeOfTree = 0; //gets updated if add/remove functions are called

	/*
	 * FINISHING UP THE NODE CLASS WITH GRANDPARENT AND PARENT POINTERS
	 */



	/////////////////////////////// GETTERS AND SETTERS /////////////////////////

	public Node getParent(){
		return getParent();
	}

	public Node getGP(){
		return getGP();
	}
	
	public int getComparisonCount(){
		return comparisonCount;
	}
	
	public int getRemoveCount(){
		return removeCount;
	}
	
	public int getAddCount(){
		return addCount;
	}
	
	public int getFindCount(){
		return findCount;
	}
	
	public int getSize(){
		return sizeOfTree;
	}

	// right rotate
	private Node rotateWithRC(Node n) {
		Node toRotate = n.getLeftChild();
		n.leftChild = toRotate.getRightChild();
		toRotate.rightChild = n;

		return toRotate; //returns 
	}

	// left rotate
	private Node rotateWithLC(Node n) {
		Node toRotate = n.getRightChild();
		n.rightChild = toRotate.getLeftChild();
		toRotate.leftChild = n;

		return toRotate; //returns 
	}



	///////////////////////////////////////////////////////////////////////////




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

		GeneralTree.Node aNode = aTree.new Node(valueOfNode);
		return aNode;	 
	}


	//if a is picked
	public static void insert(Node n){

		//Checking if the tree is empty
		//GeneralTree aTree = new GeneralTree();
		if(aTree.root == null){ //if empty create a new node and assign it as a root
			aTree.root = aTree.new Node(n.getNumberOfOccurence()) ; 
			return;
		}
		else{ //there's no duplicate operations
			n = aTree.new Node(n.getNumberOfOccurence());
			if( n.getNumberOfOccurence() < aTree.root.getNumberOfOccurence()){ //if value youre trying to add is smaller than the root
				n.leftChild = aTree.root.leftChild;				//swap - n becomes root while two child are the root and root's left child
				n.rightChild = aTree.root; 						
				aTree.root.leftChild = null;
				comparisonCount++;
			} 

			else {
				n.rightChild = aTree.root.rightChild;				//swap - n becomes root while two child are the root and root's left child
				n.leftChild = aTree.root; 						
				aTree.root.rightChild = null;
				comparisonCount++;
			}

			aTree.root = n; //the added node becomes the child
			sizeOfTree++; //size of queue gets incremented
		}

	}

	//deleting a node just like in a normal BST
	public static void remove(Node node, int weight){
		//Checking if the tree is empty
		//GeneralTree aTree = new GeneralTree();
		if(aTree.root == null)
			return; //cannot remove an empty tree

		if(node == null)
			return;

		if(node.getNumberOfOccurence() == weight) 


			//if the value to remove is smaller than the value of the current node
			if(weight < node.getNumberOfOccurence()){
				if (node.getLeftChild() != null)
					remove(node.getLeftChild(),weight); //recursive method looking at the next left child

				if(node.getLeftChild() == null)
					node.g
			}

		if(weight > node.getNumberOfOccurence())
			if (node.getRightChild() != null)
				remove(node.getRightChild(),weight); //recursive method looking at the next left child

	}


	public void zig(Node n){
		GeneralTree aTree = new GeneralTree();
		Node n2, n3, n4, n5; //Nodes of tree

		if(root == n.getLeftChild()) // if node is left child of parent roo
			n = aTree.root;


	}

	public void zigzag(Node n1, Node n2){
		if()

	}


	public void zigzig(){

	}
	
	//Splay will bring the a node to the root by either performing a zig-zag or zig-zig - or zig
	public Node splay(Node n){
		
		while (n.parent == null){ //while it is the root n.root != null
			Node parent = n.getParent(); //n has a parent
			if(root.getLeftChild() == n || root.getRightChild() == n){ //performs a zig

			}
		}
	}

	public void run(String command){
		char character =  command.charAt(0); //if a123 returns a
		String number = command.substring(1); //after the substring
		int value = Integer.parseInt(number);
		Node n = transformIntoNode(value);

		switch(character){
		case 'a' : insert(n);
		addCount++;
		break;
		case 'r' : remove(n);
		removeCount++;
		break;
		case 'f' : find(n);
		removeCount++;
		break;
		default : System.out.print("No command were found");

		}

	}


	private void find(Node n) {
		// TODO Auto-generated method stub

	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Huffman wuush = new Huffman();
		File fileName = new File("Operations.txt");
		displayFileContents(fileName);
	}

}
