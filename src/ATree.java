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

	public int getSplayCount(){
		return splayCount;
	}

	// right rotate
	private Node rotateWithRC(Node n) {
		Node toRotate = n.getLeftChild();
		n.leftChild = toRotate.getRightChild();
		toRotate.rightChild = n;
		splayCount++;
		return toRotate; //returns 
	}

	// left rotate
	private Node rotateWithLC(Node n) {
		Node toRotate = n.getRightChild();
		n.rightChild = toRotate.getLeftChild();
		toRotate.leftChild = n;
		splayCount++;
		return toRotate; //returns 
	}

	///////////////////////////////////////////////////////////////////////////

	


	//FILE NEEDS TO BE CLOSED AFTER EACH USED
	public static void openFile(File fileIn) {
		Scanner reader = null;
		try{
			reader = new Scanner (new FileInputStream (fileIn.getName()));
		}
		catch (FileNotFoundException e){
			e.getMessage();
		}


		//		System.out.println("Here are the contents of the file " + fileIn.getName()  + ":");
		//		System.out.println("===============================================");
		//		int i =1 ;
		//		while(reader.hasNext()) {
		//			System.out.print(reader.next() + " ");
		//			i++;
		//			if(i%30 == 0){
		//				System.out.println();
		//			}
		//
		//		}
		//	reader.close();

	}


	public static Node transformIntoNode(int valueOfNode){

		GeneralTree.Node aNode = aTree.new Node(valueOfNode);
		return aNode;	 
	}

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

			else if(n.getNumberOfOccurence() > aTree.root.getNumberOfOccurence()) {
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
			node = null;


			//if the value to remove is smaller than the value of the current node
			if(weight < node.getNumberOfOccurence()){
				if (node.getLeftChild() != null)
					remove(node.getLeftChild(),weight); //recursive method looking at the next left child
			}

		if(weight > node.getNumberOfOccurence())
			if (node.getRightChild() != null)
				remove(node.getRightChild(),weight); //recursive method looking at the next left child

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
		case 'r' : remove(aTree.root, n.getNumberOfOccurence());
			removeCount++;
			break;
		case 'f' : find(aTree.root, n.getNumberOfOccurence());
		findCount++;
		break;
		default : System.out.print("No command were found");
		}
	}

	//Splay will bring the a node to the root by either performing a zig-zag or zig-zig - or zig
	public Node splay(Node n){
		Node rootNode = aTree.root;

		//Creating a temp node
		Node temp1 = new Node();
		temp1.leftChild = null;
		temp1.rightChild = null;


		if(root.getLeftChild() == n || root.getRightChild() == n){ //performs a zig operations 


			while (true){ 

				//TRAVERSING THE LEFT SIDE OF THE TREE
				if(n.getNumberOfOccurence() < rootNode.getNumberOfOccurence()){ 
					if(rootNode.getLeftChild() == null) 
						break; //break out of the loop - there's nothing to swap
					if(n.getNumberOfOccurence() < rootNode.getLeftChild().getNumberOfOccurence()){
						comparisonCount++;
						rootNode = rotateWithRC(n); //root Node
					}
					temp1.leftChild = rootNode;
					temp1 = rootNode;
					rootNode = rootNode.leftChild;
				}

				//TRAVERSING THE RIGHT SIDE OF THE TREE
				if(n.getNumberOfOccurence() > rootNode.getNumberOfOccurence()){ 
					if(rootNode.getRightChild() == null) 
						break; //break out of the loop - there's nothing to swap
					if(n.getNumberOfOccurence() > rootNode.getRightChild().getNumberOfOccurence()){
						comparisonCount++;
						rootNode = rotateWithLC(n); //root Node
					}
					temp1.rightChild = rootNode;
					temp1 = rootNode;
					rootNode = rootNode.rightChild;
				}
			}	
		}
		return rootNode;
	}
	public int getNumberOfCommand(File fileIn){
		Scanner reader = null;
		int count = 0;
		try{
			reader = new Scanner (new FileInputStream (fileIn.getName()));
		}
		catch (FileNotFoundException e){
			e.getMessage();
		}

		while(reader.hasNext()){
			reader.next();
			count++;
		}
		reader.close();
		return count;
	}

	public String[] getCommand(File fileIn){
		Scanner reader = null;
		try{
			reader = new Scanner (new FileInputStream (fileIn.getName()));
		}
		catch (FileNotFoundException e){
			e.getMessage();
		}

		int size = getNumberOfCommand(fileIn);
		String[] commands = new String[size];


		for(int i = 0 ; i <commands.length ;i++){
			if(reader.hasNext())
				commands[i] = reader.next(); //putting the string into the rester
		}	

		reader.close();
		return commands;
	}



	private static void find(Node root, int value) {
		if(root == null){
			return;
		}
		if(root.getNumberOfOccurence() == value){
			//System.out.println("The " + value + " was found in " + root.toString() );
			return;
		}

		if (root.leftChild != null){
			find (root.leftChild, value); //from general tree
		}
		//System.out.println(root.toString());
		if (root.rightChild != null){
			find (root.rightChild, value); //from general tree
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = args[0];
		Huffman wuush = new Huffman();
		ATree aTree = new ATree();
		File fileName = new File(file); //put file in 
		String[] commands = aTree.getCommand(fileName);

		for(int i = 0 ; i < commands.length ; i++)
			aTree.run(commands[i]);

		System.out.println("The total number of comparison operations is : " + aTree.getComparisonCount());
		System.out.println("The total number of splay operations is : " + aTree.getSplayCount());
		System.out.println("The total number of add operations is : " + aTree.getAddCount());
		System.out.println("The total number of find operations is : " + aTree.getFindCount());
		System.out.println("The total number of remove operations is : " + aTree.getRemoveCount());

	}

}
