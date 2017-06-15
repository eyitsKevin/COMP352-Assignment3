
public class PriorityQueue<T  extends Comparable<T>> { //since generic item are comparable
	//a parent in position k is in position k/2
	//two children are in position : left = 2k and  right = 2k+1
	// queue should follow a tree like this :
	//				( 10 )
	//				/	 \
	//			 (6)   	  (4)    
	//			/   \    /   \
	//		  (3)   (3)  (2)  (2) 
	// T[] queue = [ 10, 6 , 4, 3, 3, 2, 2]

	private T[] queue; //while the index 0 is unused so index 1 contains the root
	private int sizeOfQueue;
	private int sizeOfHeap;

	


	public static void buildNode(String element, int frequency){
		GeneralTree tree = new GeneralTree();
		GeneralTree.Node createNode = tree.new Node(element, frequency);
	}
	
//	class PQNode extends GeneralTree{
//		
//		PQNode next;
//		GeneralTree.Node node;
//		
//		
//		public PQNode(){
//		
//		}
//		
//		public PQNode(GeneralTree.Node node){
//			this.node=node;
//			next = null;
//		}
//		
//		public GeneralTree.Node getTree(){
//			return node;
//		}
//		
//		public void setNext(PQNode next){
//			this.next = next;
//		}
//		
//
//		public PQNode getNext(){
//			return next;
//		}
//		
//		
//	}
//
//
//	public void insert(PQNode node){
//		
//		PQNode t;
//		PQNode n = head;
//		
//		if(head == null){
//			head = new PQNode()
//		}
//		else {
//			while(t.next != null){ //add to last
//				if(node.getTree().getNumberOfOccurence() < n.getTree().getNumberOfOccurence())
//					
//			}
//		}
//		//boolean posFound=false;
//		if(n==null){
//			
//			//posFound=true;
//		}
//		
//		else{
//			
//			while(n.right!=null){
//		
//		if(x.getTree().frequency<n.getTree().frequency){
//				temp=n;
//				x.right=temp;
//				//n=x;
//				if(temp==head){
//					head=x;
//				}
//				break;
//			}
//		if(x.getTree().frequency<n.right.getTree().frequency){
//			x.right=n.right;
//			n.right=x;
//			break;
//			}
//		}
//		}
//		if( node.next !)
//		
//	}






	public void buildHeap(){

	}



	//	public boolean isLeaf(int position){
	//	
	//		if (position != 2*position )
	//	}



	//Parametrized Queue
	public PriorityQueue(int sizeOfQueue){
		this.sizeOfQueue = sizeOfQueue+1; //Initializing the queue to a fixed sized.
		queue = (T[])new Object ([this.sizeOfQueue]);
		sizeOfHeap = 0;
	}

	public PriorityQueue(T[] array){
		this.sizeOfQueue = array.length;
		this.queue = (T[]) new Comparable[sizeOfQueue];
		for(int i = 0 ; i < sizeOfQueue ; i++)
			queue[i] = array[i];
	}


	public void insert(T itemToAdd){
		queue[++sizeOfQueue] = itemToAdd;
		heapSort(queue, sizeOfQueue);
	}





	private  void swap(int i, int j){
		T temp = queue[i];
		queue[i] = queue[j];
		queue[j] = temp;
	}


	//Accessor
	public int getSizeOfQueue() {
		return sizeOfQueue;
	}

	public T[] getQueue() {
		return queue;
	}

	//Mutator
	public void setQueue(T[] queue) {
		this.queue = queue;
	}

	public void setSizeOfQueue(int sizeOfQueue) {
		this.sizeOfQueue = sizeOfQueue;
	}

	public void buildHeap(T[] queue){
		for(int i = sizeOfQueue/2 ; i >= 1 ; i--)
			heapSort(queue, i);
	}

	public  void heapSort(T[] queue, int position){
		int left = 2*position;
		int right = 2*position + 1;
		int greatest;

		if(left <= sizeOfQueue && queue[left].compareTo(queue[position]) > 0) // //if the child is larger than the parent class, swap them.
			greatest = left;
		else
			greatest = position;

		if(right <= sizeOfQueue && queue[right].compareTo(queue[left]) > 0)
			greatest = right;
		else
			greatest = left;

		if(greatest != position){
			swap(position, greatest);
			heapSort(queue, greatest);
		}

	}

	public String toString(){
		String queuePrint = "";
		for(int i = 0 ; i < queue.length ; i ++){
			queuePrint += queue[i] + " " ;
		}
		return queuePrint;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {null,2,6,2,10,23,534};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr);
		pq.buildNode("a", 5);
		pq.toString();
	
	}


}






