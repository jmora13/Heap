//Jose Mora
//Project 6 
//4-26-2016

public class Heap<E extends Comparable<E>>{


  private E[] elements;            // Array that holds heap elements
  private int lastIndex;          // index of last element in heap
  private int maxIndex;           // index of last position in array
  // Constructor
  public Heap(int maxSize)
  {
    elements = (E[]) new Comparable[maxSize];
    lastIndex = -1;
    maxIndex = maxSize - 1;
  }

  public boolean isEmpty()
  // Determines whether this heap is empty.
  {
    return (lastIndex == -1);
  }

  public boolean isFull()
  // Determines whether this heap is full.
  {
    return (lastIndex == maxIndex);
  }


  public void add(E item) throws PriQOverflowException {
  // Adds item to this heap.
  // Throws PriQOverflowException if heap already full
  if (isFull()) {
	  throw new PriQOverflowException("This Heap is full");
  } else { 
	  ++lastIndex; //add slot for last index 
	  elements[lastIndex] = item; //add item to last index of array
      trickleUp(lastIndex); //trickle up
      }
  	}
  
  public void trickleUp(int lastIndex) { //go up binary tree 
	  int tempIndex = lastIndex; //index to be swapped out
	  int parentIndex = (lastIndex-1)/2;
	  while(elements[tempIndex].compareTo(elements[parentIndex]) > 0 && tempIndex > 0) { //while child is greater than parent 
	  swap(parentIndex, tempIndex); //swap parent with child
	  tempIndex = parentIndex; //swap indexes
	  parentIndex = (parentIndex-1)/2;
	  }
  }
  
  public void swap(int parentIndex, int childIndex){ //swap parent with child 
	  E temp = elements[parentIndex];
	  elements[parentIndex] = elements[childIndex];
	  elements[childIndex] = temp;
  }
  
  public E remove () throws PriQUnderflowException
  // Removes the root element from this heap
  // Throws PriQUnderflowException if heap is empty.
  {
	  if(isEmpty()) {
		  throw new PriQUnderflowException("This Heap is empty");
	  } else {
		 int childIndex = 0;
		 int currentIndex = 0;
		 E currentElem = elements[currentIndex];
		 elements[currentIndex] = elements[lastIndex];
		 --lastIndex; //decrement last index
		 trickleDown(childIndex, currentIndex); //go down binary tree
		 return currentElem;
	  } 
  }
  
  public void trickleDown(int childIndex, int currentIndex) { //go down binary tree
	  while(!isLeaf(currentIndex) && elements[greaterChild(currentIndex)].compareTo(elements[currentIndex]) > 0 ) { //while child is greater than parent
			 childIndex = greaterChild(currentIndex); //swap greater child index with current child index
			 swap(currentIndex,childIndex); //swap parent with child index
			 currentIndex = childIndex;
		 } 
  }

  public int greaterChild(int parentIndex){ //calculates with child is largest value
	  int leftChildIndex = 2 * parentIndex + 1; //left child
	  int rightChildIndex = 2 * parentIndex + 2 ; //right child
	 if(elements[leftChildIndex].compareTo(elements[rightChildIndex]) > 0 || elements[rightChildIndex] == null){
		 return leftChildIndex;
  } else {
	  return rightChildIndex;
  }
}
  public boolean isLeaf(int index) { //checks to see if value if node has no children
	 return  (2 * index + 1 > lastIndex);
  }

  
  public String toString()
  // returns a string of all the heap elements
  {
    String theHeap = new String("the heap is:\n");
    for (int index = 0; index <= lastIndex; index++)
      theHeap = theHeap + index + ". " + elements[index] + "\n";
    return theHeap;
  }

  public void print() {
	System.out.println(toString());
  }
 }





