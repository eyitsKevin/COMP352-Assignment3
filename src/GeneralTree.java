

public class GeneralTree {

	protected Node root;
	
	public GeneralTree(){
		root = null;
	}
	
	public GeneralTree(Node root){
		this.root = root;
	}

	public class Node{

		protected String element;
		protected Node leftChild; //pointer that points left
		protected Node rightChild; //pointer that point right
		protected int numberOfOccurence;

		protected Node grandParent; //zig-zag or zig-zig
		protected Node parent; //zig
		
		//Constructor
		public Node(){
			this.element = "";
			this.numberOfOccurence = 0;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		//For the ATree.java
		public Node(int numberOfOccurence){
			this.element = "";
			this.numberOfOccurence = numberOfOccurence;
			this.leftChild = null;
			this.rightChild = null;
		}

		//Creates a parentNode
		public Node(Node leftChild, Node rightChild, String element, int combinedFrequency){
			this.element = element;
			this.numberOfOccurence = combinedFrequency;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}


		public Node(String element, int numberOfOccurence){
			this.element = element; //the null character 
			this.numberOfOccurence = numberOfOccurence;
			this.leftChild = null;
			this.rightChild = null;
		}

		public Node (Node leftChild, Node rightChild, int numberOfOccurence) {
			this.numberOfOccurence = 0;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public boolean isLeaf(){
			if(this.leftChild == null && this.rightChild == null)
				return true;
			else
				return false;
		}

		public boolean isParent(){
			if(this.leftChild != null || this.rightChild != null)	
				return true; 
			else 
				return false;
		}
		
		public Node getParent(){
			return parent;
		}
		
		public Node getGP(){
			return grandParent;
		}


		public String toString(){
			if(this.element == "")
				return "the weight of this node is " + numberOfOccurence;

			return "the node {" + this.element + "} has a frequency of " + numberOfOccurence; 

		}


		///////////////////////////////// Accessors /////////////////////////////////


		//Getters
		public int getNumberOfOccurence(){
			return numberOfOccurence;
		}

		public String getElement(){
			return element;
		}

		public Node getRightChild(){
			return rightChild;
		}

		public Node getLeftChild(){
			return leftChild;
		}
		
	
	

	}

	public Node[] toNodeArray(String[] element, int[] frequency){
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

		String combinedString = leftNode.getElement() + "_" + rightNode.getElement();
		int combinedFrequency = leftNode.getNumberOfOccurence() + rightNode.getNumberOfOccurence();

		GeneralTree tree = new GeneralTree();
		Node parentNode = tree.new Node(leftNode,rightNode,combinedString, combinedFrequency);

		return parentNode;

	}

	public static void inOrderTraverse (Node root){ 
		if (root.leftChild != null){
			inOrderTraverse (root.leftChild);
		}
		//System.out.println(root.toString());
		if (root.rightChild != null){
			inOrderTraverse (root.rightChild);
		}
	}

	/////////////////////////////////  /////////////////////////////////

	public static void buildTree(Node[]  node){

		for(int i = node.length-1 ; i > 0 ; i--){

			if(i == node.length-1){
				System.out.println("Displaying root node");
				System.out.println(node[i].toString());
			}
		}
	}

	public Node getRoot(){
		return root;
	}

	public void setRoot(Node n){
		this.root = n;
	}


	/*
	 * This method adds a new node whenever called. If root is not already added it will be created else it adds from left to right
	 */
	public void addNode(String element, int numberOfOccurence){

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


//		char[] element = {'a','b','c','d'};
//		int[] freq = {1,2,3,4};
//
//		Node[] node = Huffman.createHuffmanTree(element, freq);
//
//		inOrderTraverse (node[node.length-1] );
//
//
//		for(int i = 0 ; i < node.length;i++){
//			generateBinaryCode(node[node.length-1], Character.toString(element[i]));
//			System.out.println();
//		}
//
//		System.out.println(node[2].isParent() + " " + node[0].toString());
//
//		String wuush = "ab_c";
//		System.out.println(wuush.contains("c"));
//
//		System.out.println();
//		System.out.println("\t         "+node[node.length-1]);
//		System.out.print("\t"   + node[node.length-1].getLeftChild());
//		System.out.println("\t "   + node[node.length-1].getRightChild());
//		System.out.print("\t"   + node[node.length-1].getLeftChild().getLeftChild());
//		System.out.print("\t"   + node[node.length-1].getLeftChild().getRightChild());
//		System.out.print("\t"   + node[node.length-1].getRightChild().getLeftChild());
//		System.out.print("\t"   + node[node.length-1].getRightChild().getRightChild());
//		System.out.println();
//		System.out.print("\t"   + node[node.length-1].getRightChild().getLeftChild().getLeftChild());
//		System.out.print("\t"   + node[node.length-1].getRightChild().getLeftChild().getRightChild());



	}
}

