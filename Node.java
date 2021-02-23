package cs146F20.Ha.project1;

public class Node {
	
	private int data;
	private Node nextNode;
	//creates node Object to be used in CircularLinkedListGame class
	public Node(int data)
	{
			this.data = data;
			this.nextNode = null;
	}
	//gets data of Node
	public int getData()
	{
		return data;
	}
	//sets data of Node
	public void setData(int data) 
	{
		this.data = data;
	}
	//gets next Node
	public Node getNextNode() 
	{
		return nextNode;
	}
	//sets next Node
	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}
	//returns Node in string form
	@Override
	public String toString() 
	{
		return data + " ";
	}

}