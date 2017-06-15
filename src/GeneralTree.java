

public class GeneralTree {

	Node root;

	public class Node{

		private char element;
		private String combinedElement;
		private Node leftChild; //pointer that points left
		private Node rightChild; //pointer that point right
		private int numberOfOccurence;

		//Constructor
		public Node(){
			this.element = '\u0000'; //the null character 
			this.numberOfOccurence = 0;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		//Creates a parentNode
		public Node(Node leftChild, Node rightChild, String combinedElement, int combinedFrequency){
			this.combinedElement = combinedElement;
			this.numberOfOccurence = combinedFrequency;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		
		public Node(char element, int numberOfOccurence){
			this.element = element; //the null character 
			this.numberOfOccurence = numberOfOccurence;
			this.leftChild = null;
			this.rightChild = null;
		}
			
		 public Node (Node leftChild, Node rightChild, int numberOfOccurence) {
					this.numberOfOccurence = 0;
					this.leftChild = null;
					this.rightChild = null;
		        }
		 
		 public boolean isLeaf(Node node){
			 if(node.leftChild == null && node.rightChild == null)
				 return true;
			 else
				 return false;
		 }

		 public boolean isParent(Node node){
			 if(node.combinedElement != null)	//since building a parent node will necessary have a combined element 
				 return true; 
			 else 
				 return false;
		 }
			public String toString(){
				
				return "the node " + this.combinedElement + "  occurs " + numberOfOccurence + " time(s)"; 
			}
		 

		///////////////////////////////// Accessors /////////////////////////////////
		
		
		//Getters
		public int getNumberOfOccurence(){
			return numberOfOccurence;
		}

		public char getElement(){
			return element;
		}
		
		
	}
	
	public Node[] toNodeArray(char[] element, int[] frequency){
		Node[] nodeArray = new Node[element.length];
		for(int i = 0 ; i < element.length ; i++){
			nodeArray[i] = new Node(element[i],frequency[i]);
		}
		return nodeArray;
	}
	
	/*
	 * This method sorts an array in descending order. It is important to note that the char character must also correspond and be sorted as well
	 */
	static void insertionSort(Node[] array){
		Node temp;

		for (int i = 0 ; i < array.length-1 ; i++){ //first ends before 1
			for(int j = i+1 ; j > 0 ; j--){ //second 
				if(array[j].getNumberOfOccurence() < array[j-1].getNumberOfOccurence()){
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp; //contains the higher value
				}
			}
		}
	}
	
	static Node addNode(Node leftNode, Node rightNode){
		StringBuilder sb = new StringBuilder();
		StringBuilder combinedChar = sb.append(leftNode.getElement()).append(rightNode.getElement());
		String string = combinedChar.toString();
		int combinedFrequency = leftNode.getNumberOfOccurence() + rightNode.getNumberOfOccurence();
		
		GeneralTree tree = new GeneralTree();
		Node parentNode = tree.new Node(leftNode,rightNode,string, combinedFrequency);
		
		return parentNode;
		
	}
	
	

	
	
	
		/////////////////////////////////  /////////////////////////////////
	
	public void buildTree(){
		
	}
	

	



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
	}//end of add Node


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

