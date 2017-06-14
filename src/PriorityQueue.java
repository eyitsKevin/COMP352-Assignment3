
public class PriorityQueue<T  extends Comparable<T>> {
	//a parent in position k is in position k/2
	//two children are in position : left = 2k and  right = 2k+1


	private T[] queue;
	private int sizeOfQueue;


	//Parametrized Queue
	public PriorityQueue(int sizeOfQueue){
		this.queue = (T[]) new Object[sizeOfQueue]; //Initializing the queue to a fixed sized.
	}

	public PriorityQueue(T[] array){
		this.sizeOfQueue = array.length;
		this.queue = (T[]) new Comparable[sizeOfQueue];
		for(int i = 0 ; i < sizeOfQueue ; i++)
			queue[i] = array[i];
	}


		public void insert(T itemToAdd){
			queue[++sizeOfQueue] = itemToAdd;
			//sort
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


		public  void heapSort(int position){

			
			while(position > position/2 && position > 0){ //if the child is larger than the parent class, swap them. 
				swap(position, position/2);
//				heapSort(queue,position/2); //become the parent and check again
			}
			while(position >= 2*position+1){//if the left child is greater than the right chhild, swap them
				swap(position, 2*position+1);
//			  heapSort(queue,2*position+1);
			}
			
			if(position == 1)
				break;
			
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
				Integer[] arr = {2,6,2,10,23,534,3,2};
				PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr);
				System.out.println(pq);
				pq.heapSort(arr.length-1);
				System.out.println(pq);
		}

		
		}


//		public void insert(T t){
//			if (N == arr.length - 1) 
//				resize(2*N + 1);
//			arr[++N] = t;
//			swim(N);
//		}
//
//		public T delMax(){
//			if (isEmpty()) return null;
//			T t= arr[1];
//			exch(1,N--);
//			arr[N+1] = null;
//			sink(1);
//
//			//resize this array
//			if (N == (arr.length -1)/4) resize((arr.length-1) / 2 + 1);
//			return t;
//		}
//		//helper methods
//		public String toString(){
//			StringBuffer sb = new StringBuffer();
//			sb.append("[ ");
//			for(int i = 1; i <= N; i ++)
//				sb.append(arr[i] +" ");
//			sb.append("]");
//			return sb.toString();
//		}
//
//		private boolean isEmpty(){
//			return N == 0;
//		}
//		private void resize(int capacity){
//			T[] copy = (T[]) new Comparable[capacity];
//			for(int i = 1; i <= N; i ++ )
//				copy[i] = arr[i];
//			arr = copy;
//		}
//
//		private void swim(int k){
//			while(k > 1 && less(k/2, k)){
//				exch(k/2,k);
//				k = k/2;
//			}
//		}
//
//		private void sink(int k){
//			while (2*k < N){
//				int j = 2 * k;
//				if(j < N && less(j, j +1)) j = j + 1;
//				if(less(j, k)) 
//					break;
//				exch(k,j);
//				k = j;
//			}
//		}
//
//		private boolean less(int i, int j){
//			if (arr[i].compareTo(arr[j]) < 0)
//				return true;
//			return false;
//		}





	
