
//Linked List class
public class LinkedList<T> {
	
	//start of linked list
	private Node<T> head;

	public LinkedList() {
		this.head = null;
	}

	//sets head to a new node with the previous head as the next node
	public void insertStart(T num) {
		head = new Node<T>(num, head);
	}

	//iterates to end of linked list and puts the new node at the end
	public void insertEnd(T num) {
		//if the list is empty, insert at the front
		if (head == null) {
			insertStart(num);
		}
		else {
			Node<T> temp = head;
			while (temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(new Node<T>(num, null));
		}
	}

	//deletes first node by setting head to the next node in the linked list
	public void deleteFirst() {
		if (head == null)
			return;
		else {
			head = head.getNext();
		}
	}

	//deletes last node by iterating to the second to last node, then sets the next of this node to null
	public void deleteLast() {
		if (head == null) 
			return;
		else {
			Node<T> temp = head;
			while(temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(null);
		}
	}	

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = null;
	}

	//iterates through linked list and prints the data in each node
	public void printList() {
		if (head == null) {
			return;
		}
		else {
			Node<T> temp = head;
			while(temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
	}

	//main function for testing
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertStart(2);
		list.insertStart(1);
		list.insertStart(0);
		list.insertEnd(3);
		list.printList();
		System.out.print("\n");

		list.deleteFirst();
		list.deleteLast();
		list.printList();
		System.out.print("\n");
		
		System.out.print(list.isEmpty());
		System.out.print("\n");
		
		list.clear();
	}

}

//Node class
class Node<T> {

	private T data;
	private Node<T> next;
	

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}