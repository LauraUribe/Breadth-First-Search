// this class creates a queue (through a linked list) with two objects: landing (odd) and take off (even)
// what this class must have:
// manual clock
// check if queue is empty (boolean)
// 0 - 3 planes can be in either queue. Only 0-1 can land/take off at same time.
// while 0 - 3 planes - add to queue
/* public class Queue
{
	Queue<Integer> landingQ = new LinkedList<Integer>();
}
*/
public class cuecue<T>
{
	private int total;  // how many elements are in queue
	private Node first, last;
	private int cuecueSize;
	
	private class Node
	{
		private T ele;  // queue object
		private Node next;  // goes to next node
		
	}
	// public cuecue(){}
	
	public cuecue<T> enqueue(T ele) 
	{
		Node current = last;
		last = new Node();
		last.ele = ele;
		
		if (total++ == 0) first = last;
		else current.next = last;
		
		cuecueSize++;  // enqueue;
		return this;
	}
	
	public T dequeue() 
	{
		if (total == 0) throw new java.util.NoSuchElementException();
		T ele = first.ele;
		first = first.next;
		if (--total == 0) last = null;
		cuecueSize--; // dequeue;
		return ele;
	}
	
	public int size()
	{
		return cuecueSize;
	}
	
	  @Override
	    public String toString()
	    {
	        StringBuilder sb = new StringBuilder();
	        Node tmp = first;
	        while (tmp != null) {
	            sb.append(tmp.ele).append(", ");
	            tmp = tmp.next;
	        }
	        return sb.toString();
	    }

	
}
