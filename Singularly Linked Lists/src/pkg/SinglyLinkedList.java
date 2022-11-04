package pkg;

public class SinglyLinkedList {
    
    public Node header;
    public int count;
    public boolean sorted;
    
    public SinglyLinkedList() {
        this.header = (null);
        this.count = 0;
    }
    
    public SinglyLinkedList(int initialData) {
        this.header = new Node(initialData);
        this.count = 1;
    }
    
    /*
    functions to implement:
        --prepend
        --append
        --insertAt
        removeAt
        indexOf
        --length
    */
    
    public int length() {
        return this.count;
    }
    
    public void append(int data) {
        Node last = new Node(data);
        Node curNode = null;
        if(this.header == null) {
            this.header = last;
        } else {
            curNode = this.header;
            while(curNode.nextPointer != null) {
                curNode = last;
            }
        }
        curNode.nextPointer = last;
        this.count++;
    }
    
    public void prepend(int data) {
        Node first = new Node(data);
        if(this.header == null) {
            this.header = first;
        } else {
            first.nextPointer = this.header;
            this.header = first;
        }
        this.count++;
    }
    
    public void insertAt(int data, int pos) {
    	if(pos == 0) {
            this.prepend(data);
        } else {
            Node preNode = this.header;
            Node curNode = this.header.nextPointer;
            int counter = 1;
            
            while(curNode.nextPointer != null || pos != counter) {
                Node newNode = new Node(data);
                if(preNode.nextPointer == null) {
                    preNode.nextPointer = newNode;
                } else {
                    preNode.nextPointer = newNode;
                    newNode.nextPointer = curNode;
                }
                counter++;
            }
        }
    	this.count++;
    }
    
    public void removeAt(int pos) {
    	if(pos == 0) {
    		this.header = this.header.nextPointer;
    	} else {
    		Node curNode = this.header.nextPointer;
    		int counter = 1;
    		while(curNode.nextPointer != null || pos != counter) {
    			
    		}
    	}
    }
}