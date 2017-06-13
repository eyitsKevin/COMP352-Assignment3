

public class huffman  {
	
	Node root;
	

	/*
	 * This method adds a new node whenever called. If root is not already added it will be created else it adds from left to right
	 */
	public void addNode(char element, int numberOfOccurence){
		Node createNode = new Node(element,numberOfOccurence);
		
		if(root == null){ //If a root is not created yet
			root = createNode;
		} else {
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
