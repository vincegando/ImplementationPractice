

public class LinkedList<T> {
	
	private Node<T> head;

	public LinkedList() {
		this.head = null;
	}

	public void insertStart(T num) {
		head = new Node<T>(num, head);
	}

	public void insertEnd(T num) {
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

	public void deleteFirst() {
		if (head == null)
			return;
		else {
			head = head.getNext();
		}
	}

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

class Node<T> {

	private T data;
	private Node<T> next;
	//private Node<T> prev;

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