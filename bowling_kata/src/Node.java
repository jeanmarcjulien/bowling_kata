class Node{
	
	int data;
	Node nextNode;
	Node prevNode;
	
	Node(int data) {
		this.data = data;
	}
	Node() {
	}
	int getData() {
		return data;
	}
	Node getNextNode() {
		return this.nextNode;
	}
	Node getPrevNode() {
		return this.prevNode;
	}
	void setData(int data) {
		this.data = data;
	}
	void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
}
