package pkg;

public class LinkedList {
	
	public Node head;
	public Node tail;
	public int size;
	private boolean sorted;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.sorted = true;
	}
	
	public LinkedList(int data) {
		Node start = new Node(data);
		this.head = start;
		this.tail = start;
		this.size = 1;
		this.sorted = true;
	}
	
	//////
	
	public void traverse() {
		Node curNode = this.head;
		System.out.print("head >");
		while(curNode != null) {
			System.out.print(" > " + curNode.data);
			curNode = curNode.next;
		}
		System.out.println(" > tail");
	}
	
	public void backTraverse() {
		Node curNode = this.tail;
		System.out.print("tail >");
		while(curNode != null) {
			System.out.print(" > " + curNode.data);
			curNode = curNode.prev;
		}
		System.out.println(" > head");
	}
	
	private void updateSize() {
		this.size = 0;
		if(head == null) {
			//do nothing
		} else if(this.head.next == null) {
			this.size = 1;
		} else {
			Node curNode = this.head;
			while(curNode != null) {
				this.size++;
				curNode = curNode.next;
			}
		}
	}
	
	public void swap(int pos1, int pos2) {
		int mark1;
		int mark2;
		if(pos1 < pos2) {
			mark1 = pos1;
			mark2 = pos2;
		} else if(pos2 < pos1) {
			mark2 = pos1;
			mark1 = pos2;
		} else {
			return;
		}
		
		Node curNode = this.head;
		int counter = 0;
		while(curNode != null && counter != mark1 ) {
			curNode = curNode.next;
		}
		Node fu = curNode;
		while(curNode != null && counter != mark2) {
			curNode = curNode.next;
		}
		Node bar = curNode;
		
		swap(fu, bar);
	}
	
	private void swap(Node fu, Node bar) {
		System.out.println("swapping " + fu.data + ", " + bar.data);
		Node tempPrev = fu.prev;
		Node tempNext = fu.next;
		fu.next = bar.next;
		fu.prev = bar.prev;
		bar.next = tempNext;
		bar.prev = tempPrev;
		
		fu.next.prev = fu;
		bar.next.prev = bar;
		fu.prev.next = fu;
		bar.prev.next = bar;
	}
	
	
	public void sort() {
		/*
		 * MAKE SURE TO UPDATE PREV & NEXT AFTER EACH CHANGE
		 * AND UPDATE THE HEADER AND TAIL AS WELL
		 * first element is "sorted," start with 2nd element
		 * if the data of the element is less than that of its previous, then swap.
		 * outer loop repeats until the end of the structure (marker node == null)
		 * repeat until you get to the header (current node == null)
		 */
		Node marker = this.head.next;
		while(marker != null) {
			Node curNode = marker.prev;
			while(curNode != null) {
				if(marker.data < curNode.data) {
					swap(marker, curNode);
					if(curNode == this.head) {
						this.head = marker;
					} else if (marker == this.tail) {
						this.tail = curNode;
					}
				}
				curNode = curNode.prev;
			}
			marker = marker.next;
		}
	}
	
	public void Append(int data) {
		Node newNode = new Node(data);
		newNode.prev = this.tail;
		this.tail.next = newNode;
		this.tail = newNode;
		System.out.println("added " + data);
	}
}
