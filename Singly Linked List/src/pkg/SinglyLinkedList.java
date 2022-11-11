package pkg;

public class SinglyLinkedList {
    
    private Node head;
    private int count;
    private boolean sorted;
    
    public SinglyLinkedList() {
        this.head = (null);
        this.count = 0;
        this.sorted = false;
    }
    
    public SinglyLinkedList(int initialData) {
        this.head = new Node(initialData);
        this.count = 1;
        this.sorted = false;
    }
    
    private void reevaluateSize() {
    	if(head == null) {
    		this.count = 0;
    	} else {
	    	Node curNode = head;
	    	int counter = 1;
	    	while(curNode != null) {
	    		curNode = curNode.next;
	    		counter++;
	    	}
	    	this.count = counter;
    	}
    }
    
    public Node getAt(int pos) {
    	if(pos == 0) {
    		return this.head;
    	} else {
    		Node curNode = this.head.next;
    		int counter = 1;
    		while(curNode.next != null && pos != counter) {
    			curNode = curNode.next;
    		}
    		return curNode;
    	}
    }
    
    public void print() {
    	if(this.count == 0) {
    		System.out.println("Contains nothing!");
    	} else {
    		String out = "";
    		Node curNode = this.head;
    		while(curNode != null) {
    			out = out + curNode.data + " ";
    			curNode = curNode.next;
    		}
    		System.out.println(out);
    	}
    }
    
    public void swapNode(Node swap1, Node swap2) {
    	Node temp = swap1;
    	swap1 = swap2;
    	swap2 = temp;
    	System.out.println("Swap complete");
    }
    
    public int length() {
        return this.count;
    }
    
    public void append(int data) {
        Node last = new Node(data);
        Node curNode = null;
        if(this.head == null) {
            this.head = last;
        } else {
            curNode = this.head;
            while(curNode.next != null) {
                curNode = curNode.next;
            }
        }
        curNode.next = last;
        this.count++;
        this.sorted = false;
    }
    
    public void prepend(int data) {
        Node first = new Node(data);
        if(this.head == null) {
            this.head = first;
        } else {
            first.next = this.head;
            this.head = first;
        }
        this.count++;
        this.sorted = false;
    }
    
    public void insertAt(int data, int pos) {
    	if(pos == 0) {
            this.prepend(data);
        } else {
            Node newNode = new Node(data);
            Node preNode = this.head;
            Node curNode = this.head.next;
            int counter = 1;
            
            while(curNode != null && pos != counter) {
            	curNode = curNode.next;
            	preNode = preNode.next;
                counter++;
            }
            
            preNode.next = newNode;
            newNode.next = curNode;
        }
    	this.count++;
    	this.sorted = false;
    }
    
    public void removeAt(int pos) {
    	if(pos == 0) {
    		this.head = this.head.next;
    	} else {
    		Node curNode = this.head.next;
    		Node preNode = this.head;
    		int counter = 1;
    		while(curNode!= null && pos != counter) {
    			curNode = curNode.next;
    			preNode = preNode.next;
    			counter++;
    		}
    		preNode.next = curNode.next;
    	}
    	this.count--;
    }
    
    public void sort() {
    	//System.out.println("called sort");
    	if(!this.sorted) {
    		//System.out.println("list not sorted");
    		this.reevaluateSize();
    		//System.out.println("Size reevaluated");
    		for(int i = 0; i < this.count-1; i++) {
    			Node smallest = this.getAt(i);
    			//System.out.println("current smallest is " + smallest.data);
    			for(int j = i+1; j < this.count; j++) {
    				System.out.println("getJ: " + getAt(j).data + "\tsmallest: " + smallest.data);
    				if(this.getAt(j).data < smallest.data) {
    					smallest = this.getAt(j);
    					System.out.println("new smallest: " + smallest.data);
    				}
    			}
    			swapNode(smallest, this.getAt(i));
    		}
    	}
    	this.sorted = true;
    }
    
    public int indexOf(int key) {
    	int out = -1;
    	if(head == null) {
    		out = 0;
    	} else {
    		Node curNode = head;
    		int counter = 0;
	    	while(curNode != null) {
	    		if(key == curNode.data) {
	    			out = counter;
	    			break;
	    		}
	    		curNode = curNode.next;
	    		counter++;
	    	}
    	}
    	return out;
    }
}