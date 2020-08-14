import java.util.Scanner;

class Solution {
	private static Scanner in = new Scanner(System.in);

	// Creating own SingleLinkedList 
	static class SingleLinkedListNode {
		int data;
		SingleLinkedListNode next;

		public SingleLinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class SingleLinkedList {
		SingleLinkedListNode head;
		SingleLinkedListNode tail;

		public void insertNode(int data) {
			SingleLinkedListNode newNode = SingleLinkedListNode(data);

			if (head == null) {
				this.head = newNode;
			}else {
				this.tail.next = newNode;
			}
			this.tail = newNode;
		}

		 static void print() {
        	SinglyLinkedListNode temp = this.head;
			while(temp != null){
				System.out.print(temp.data + "--> ");
				temp = temp.next; 
			}
		}
	}

	static void findCycle(SingleLinkedList list) {
		SingleLinkedListNode slowPointer = list.head;
		SingleLinkedListNode fastPointer = list.head;

		while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) return true;
		}
	}

	public static void main(String[] args) {
		int size = in.next();
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 0; i<size ; i++) {
			list.insertNode(in.next());
		}
		list.print();

		System.out.println(findCycle(list));
	}
}