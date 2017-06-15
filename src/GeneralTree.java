

public class GeneralTree {

	Node root;

	public class Node{

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
			
		 public Node (Node leftChild, Node rightChild, int numberOfOccurence) {
					this.numberOfOccurence = 0;
					this.leftChild = null;
					this.rightChild = null;
		        }
		 
		

		///////////////////////////////// Accessors /////////////////////////////////
		
		
		//Getters
		public int getNumberOfOccurence(){
			return numberOfOccurence;
		}

		public char getElement(){
			return element;
		}
		
		public String toString(){
			return "the node " + this.element + " is occurs " + numberOfOccurence; 
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
				if(array[j].getNumberOfOccurence() > array[j-1].getNumberOfOccurence()){
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp; //contains the higher value
				}
			}
		}
	}
	
	
	
	public Node addTwoSmallest(Node[] nodeArray){
		
		
		
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

