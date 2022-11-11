package pkg;

public class Driver {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList(12);
		sll.prepend(4);
		sll.append(45);
		sll.append(20);
		sll.append(6);
		sll.append(87);
		sll.append(64);
		System.out.println(sll.length());
		System.out.println(sll.getAt(1).data);
		sll.print();
		sll.print();
		System.out.println(sll.indexOf(6));		
		sll.removeAt(4);
		System.out.println(sll.indexOf(6));		
		sll.insertAt(22, 3);
		sll.print();
		sll.sort();
		sll.print();


		
		/*
	    functions to implement:
	        prepend
	        append
	        insertAt
	        removeAt
	        indexOf
	        length
	    */
	}

}
