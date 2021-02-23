package cs146F20.Ha.project1;

public class CircularLinkedListGame {

	private Node head;
	private Node tail;
	private int size = 0;
	//inserts node 
	public void insert(int data)
	{
		//adds size to linkedlist (originally set to 0)
		++size;
		//if the linked list is empty
		if(head==null)
		{
			//creates a new Node taking data as variable
			Node newNode = new Node(data);
			//sets head to the new Node
			this.head=newNode;
			//makes it point to itself
			newNode.setNextNode(head);
			//makes it circular 
			this.tail=head;
		}
		else
		{
			//inserts after head
			insert(data,head);
		}
	}
	//given pointer node, inserts node after 
	private void insert(int data, Node node)
	{
		//if the pointer is not the tail, keep iterating until tail is found then add after
		if(node !=tail)
		{
			insert(data, node.getNextNode());
		}
		else
		{
			//creates a new node object taking data as parameter
			Node newNode = new Node(data);
			//sets the node after the pointer node as the new Node
			node.setNextNode(newNode);
			//makes it point to itself
			newNode.setNextNode(head);
			//makes it circular 
			this.tail = newNode;
		}
	}
	
	//returns true if the size of linkedlist is 0
	public boolean isEmpty()
	{
		if(size==0)
		{
			return true;
		}
		return false;
	}
	
	//returns size of linkedlist
	public int getSize()
	{
		return size;
	}
	
	public void remove(int data)
	{
		//don't do anything if there's nothing to delete
		if(this.head==null)
		{
			return;
		}
		//will remove the node as long as the node after the head is not null and the one being removed is the head
		if(this.head.getNextNode()!=null && this.head.getData()== data)
		{
			//sets the node after the tail to the node after the head
			this.tail.setNextNode(this.head.getNextNode());
			//then sets the head as the one after itself essentially deleting the head
			this.head = this.head.getNextNode();
			size--;
			return;
		}
		
		Node newHead = this.head;
		//will run if newHead is not the tail
		while(newHead!= tail)
		{
			//if the node after the newHead is not the same as the node being removed, then the newHead will be removed
			if(newHead.getNextNode().getData()!=data)
			{
				newHead = newHead.getNextNode();
			}
			else
			{
				//nextNode is the node after newHead
				Node nextNode = newHead.getNextNode();
				//the node after newHead is set as the node after nextNode
				newHead.setNextNode(nextNode.getNextNode());
				//resets nextNode to null
				nextNode = null;
				size--;
				return;
			}
		}
		//only will run if node being deleted is the last node(tail node)
		newHead = this.head;
		while(newHead!= tail)
		{
			//iterates until node after newHead is the tail
			if(newHead.getNextNode()!= tail)
			{			
				//will then point newHead as itself, deleting the tail
				newHead =  newHead.getNextNode();
			}
			else
			{
				//otherwise, it will just make the one after the head null
				newHead.setNextNode(null);
				size--;
				this.tail = newHead;
				tail.setNextNode(head);
				return;
			}
		}
	}
	public int winner(int k)
	{
		Node nodeRemove = this.head;
		//runs loop as long as there isn't a winner (1 left=winner)
		while (size != 1)
		{
			for(int i=1; i<=k;i++)
			{
				//node to get removed keeps changing until i=k
				nodeRemove = nodeRemove.getNextNode();
			}
			//removes the node and sets the removed node to the one after that
			remove(nodeRemove.getData());
			nodeRemove= nodeRemove.getNextNode();
		}
		
		return this.head.getData();
	}
}
