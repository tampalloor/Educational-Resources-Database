
/**
 * Arraylist class which uses nodes to make the list
 * @author Thomas Ampalloor
 *
 * @param <T>
 */
public class ArrayList<T> {
	
	/**
	 * Node Class
	 * @author Thomas Ampalloor
	 * 
	 */
	public class Node{
		//Instance variables
		private Object data; 
		private Node next; 
		
		public Node(){
			this.data = null; 
			this.next = null; 
		}
		
		public Node(Object d, Node n) {
			this.data = d; 
			this.next = n;  
		}
	}
	//Instance variable
	private Node head = null; 
	
	/**
	 * Facade method
	 * Makes new node and inserts at specified psoition 
	 * @param newData
	 * @param index
	 */
	public void insert(T newData, int index) {
		insertHelper(newData, index, head); 
	}
	
	/**
	 * Method Insert helper
	 * @param newData
	 * @param index
	 * @param current
	 * @return Node
	 */
	private Node insertHelper(T newData, int index, Node current) {
		if(index ==0 ) {
			current = new Node(newData, current); 
		}
		else if(current == null) {
			System.out.println("Index out of range");
		}
		else {
			current.next = insertHelper(newData, index-1, current.next); 
		}
		
		return current; 
	}
	
	public void set(int i, T newObj) {
		Node current = this.head; 
		int index = 0; 
		while(current != null) {
			if(index + 1 == i) {
				Node nextPos = current.next; 
				current.next = new Node(newObj, nextPos.next); 
				break; 
			}
			index++;
			current = current.next; 
			
		}
	}
	
	/**
	 * Finds and deletes the node at the position specified b the index
	 * @param index
	 * @return T removed
	 */
	public T remove(int index) {
		Node removed = null; 
		if(head == null) {
			System.out.println("Head is null. Empty list ");
		}
		else if(index == 0) {
			 removed = this.head; 
			this.head = this.head.next; 
			return (T)removed; 
			
		}
		else {
			Node currentPos = this.head; 
			int currentIndex = 0;
			while(currentPos != null) {
				if(currentIndex == index-1) {
					removed = currentPos.next; 
					if(removed.next != null) {
						currentPos.next = removed.next; 
						break;
					}
					else {
						currentPos.next = null; 
						break; 
					}
				}
				else {
					currentIndex++; 
					currentPos = currentPos.next;
				}
			}
		}
		
		return (T) removed; 
	}
	
	@Override
	public String toString() {
		String all = ""; 
		Node currentPos = this.head;
		 while(currentPos != null) {
			 all += currentPos.data; 
			 currentPos = currentPos.next; 
		 }
		 
		 return all; 
	}
	
	/**
	 * 
	 * @return the size of the list
	 */
	public int size() {
		int size = 0; 
		Node currentPos = this.head; 
		if(this.head == null) {
			return 0; 
		}
		while(currentPos != null) {
			size++; 
			currentPos = currentPos.next; 
		}
		return size; 
	}
	/**
	 * 
	 * @return true if the list is empty 
	 */
	public boolean isEmpty() {
		if(this.head == null) {
			return true; 
		}
		else {
			return false; 
		}
	}
	
	@Override
	/**
	 * Facade method 
	 * @return true if the two Ts are equal
	 */
	public boolean equals(Object other) {
		if(other == null) {
			return false; 
		}
		else {
			ArrayList<T> that = (ArrayList<T>) other; 
			return equalsHelper(this.head, that.head); 
		}
	}
	
	/**
	 * Equals helper
	 * @param a Node
	 * @param b Node
	 * @return True if the two Ts are equal 
	 */
	public boolean equalsHelper(Node a, Node b) {
		if(a ==null && b == null){	
			return true;
		}
		else if(a==null || b==null) {
			return false; 
		}
		else if(!(a.data.equals(b.data))) {
			return false; 
		}
		else {
			return equalsHelper(a.next, b.next); 
		}
			
	}
	/**
	 * Adds newData to the end of the list
	 * @param newData
	 */
	public void append(T newData) {
		Node currentPos = this.head; 
		if(this.head != null) {
			while(currentPos != null) {
				if(currentPos.next == null) {
					currentPos.next = new Node(newData, currentPos.next);  
					break; 
				}
				else {
					currentPos = currentPos.next; 
				}
			}
		}
		else {
			this.head = new Node(newData, null);
			
		}

	}
	
	/**
	 * 
	 * @param index
	 * @return T at index
	 */
	public T get(int index) {
		Node currentPos = this.head; 
		int currentIndex = 0;
		
		if(this.head == null) {
			System.out.println("Head is null");
			return null; 
		}
		while(currentPos != null){
			if(currentIndex == index) {
				return (T) currentPos.data;
			}
			currentPos = currentPos.next; 
			currentIndex++; 
		}
		System.out.println("Index out of bounds");
		return null; 
	}
	
	/**
	 * Goes through list and checks if target is in the list
	 * @param target
	 * @return index of list, or -1 if not
	 */
	public int indexOf(T target) {
		Node currentPos = this.head;
		int currIndex = 0; 
		while(currentPos != null) {
			if(currentPos.equals(target)) {
				return currIndex; 
			}else {
				currentPos = currentPos.next; 
				currIndex++; 
			}
		}
		return -1; 
	}
	
	/**
	 * Deletes at intended index
	 * @param index deleted
	 */
	public void delete(int index) {
		if(head == null) {
			System.out.println("Head is null. ");
		}
		else if(head.next == null){
			System.out.println("Not a long enough list");
		}
		else if(index == 0) {
			this.head = this.head.next; 
			
		}
		else {
			Node currentPos = head; 
			int currentIndex = 0;
			while(currentPos != null) {
				if(currentIndex == index-1) {
					Node removed = currentPos.next; 
					currentPos.next = removed.next; 
				}
				else {
					currentIndex++; 
					currentPos = currentPos.next;
				}
			}
		}
		
	}
	
	/**
	 * GETTER
	 * @return head of Linked list
	 */
	public Node getHead() {
		return this.head; 
	}
	
}