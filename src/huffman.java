


public class huffman  {
	
	Node root;
	

<<<<<<< HEAD
	//The leaf class, a node is a leaf when the
	 class Leaf extends Node{
		
		 public Leaf(){
			 
		 }
		 
	}
	
	
	
=======
>>>>>>> origin/Kevin
	/*
	 * This method adds a new node whenever called. If root is not already added it will be created else it adds from left to right
	 */
	public void addNode(char element, int numberOfOccurence){
		Node createNode = new Node(element,numberOfOccurence);
		
		if(root == null){ //If a root is not created yet
			root = createNode;
		} else { //root not equal to node
			//Traversing through a tree
			Node checkNode = root;
			Node parent;
			
			while(true){
				parent = checkNode;
				
				if(numberOfOccurence < checkNode.numberOfOccurence){
					checkNode = checkNode.leftChild;
					
					if(checkNode == null){
						parent.leftChild = createNode;
						return; //to get out of the while loop when the node is created as a left child 
					}
				} else { //if numberOfOccurence > checkNode.numberOfOccurence
					
					checkNode = checkNode.rightChild;
					
					if(checkNode == null){
						parent.rightChild = createNode;
						return;
					}
				}
			} //end of while loop	
		}
	} //end of add Node
	
	//Creating the Node Class, this is the first step of making a 
	class Node{
		
		private char element;
		private Node leftChild; //pointer that points left
		private Node rightChild; //pointer that point right
		private int numberOfOccurence;
		
		//Constructor
		public Node(char element, int numberOfOccurence){
			this.element = '\u0000'; //the null character 
			this.numberOfOccurence = 0;
			this.leftChild = null;
			this.rightChild = null;
		}
<<<<<<< HEAD
	}
	
	/*
	 * @return true if the node is a leaf
	 */
	public static boolean isALeaf(Node node){
		if(node.leftChild == null && node.rightChild == null)
			return true;
		else 
			return false;
	}
	
	public static void buildTree(){
		
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
	
		System.out.println("\n\n==========\tEnd of \"Jabberwock.txt\"\t==========\n");
		

=======
>>>>>>> origin/Kevin
		
		//Accessors
		//Getters
	    public int getNumberOfOccurence(){
			return numberOfOccurence;
	    }
	    
	    public char getElement(){
	    	return element;
	    }
		
	}
	
	public static void buildTree(){
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
