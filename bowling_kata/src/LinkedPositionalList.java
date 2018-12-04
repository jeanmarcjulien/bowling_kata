public class LinkedPositionalList {
	
	Node header;
	Node trailer;
	int size=0;
	
	Node cursor;
	Node recent = null;
	
	boolean hasNext() { 
		return (cursor != trailer.getPrevNode()); 
	}
	
	Node next(){
		if (cursor == trailer.getPrevNode()) {
			System.out.println("nothing left in the list");
		}
		recent = cursor; 
		cursor = cursor.getNextNode();
		return cursor;
	}
	
	void removeRecent( ){
		if (recent == null) {
			System.out.println("nothing left to remove"); 
		}
		LinkedPositionalList.this.remove(recent); 
		recent = null;
	}
	
	LinkedPositionalList(){
		header = new Node();
		trailer = new Node();
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
		resetIterator();
	}
	void resetIterator(){
		cursor = header;
	}
	
	int size() {
		return size;
	}
	boolean isEmpty(){
		return size==0;
	}
	Node first() {
		return header.getNextNode();
	}
	
	Node last() {
		return trailer.getPrevNode();
	}
	
	void addFirst(int data){
		addBetween(data,header,header.getNextNode());
	}
	
	void addLast(int data){
		addBetween(data,trailer.getPrevNode(),trailer);
	}
	
	void addBefore(int position, int data){
		Node node = validate(position);
		addBetween(data,node.getPrevNode(),node);
	}
	void addAfter(int position, int data){
		Node node = validate(position);
		addBetween(data,node,node.getNextNode());
	}
	void set(int position, int data){
		Node node = validate(position); 
		node.setData(data);
	}
	
	Node removeAtIndex(int position){
		return remove(validate(position));
	}
	Node removeFirst(){
		return remove(header.getNextNode());
	}
	Node removeLast(){
		return remove(trailer.getPrevNode());
	}
	
	Node validate(int position){
		Node currentNode=header.getNextNode();
		for(int i=1;i<position;i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}
	Node remove(Node node) {
		Node predecessor = node.getPrevNode();
		Node successor = node.getNextNode();
		predecessor.setNextNode(successor);
		successor.setPrevNode(predecessor);
		size--;
		return node;
	}
	void addBetween(int data, Node predecessor, Node successor) {
		Node newest = new Node(data);
		predecessor.setNextNode(newest);
		newest.setNextNode(successor);
		successor.setPrevNode(newest);
		newest.setPrevNode(predecessor);
		size++;
	}
}
