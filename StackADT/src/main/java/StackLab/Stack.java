
/**************************************************************
* Name        : StackADT
* Author      : Rumbi Chinhamhora
* Created     : 02/07/2021
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : Created Stack Class with a constructors one, 
* 				set to whatever you prefer with the other setting the maxSize I set mine to  
* 				maxSize to 5 for testing. Notice top start with -1 because it has nothing in it.
*               NB: I am fascinated with the Maven Tool. I created my StackADT project and converted it to
*               Maven Project to see the pom.xml
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/


package StackLab;

public class Stack {
	// Members
	private int top;  					// Last item pushed to the stack
	private final int maxSize; 			// Maximum entries allowed in the stack
	private final String[] stackItems; 	// This is the stack
	
	public Stack() {
		this.maxSize = 5; 
		this.top = -1; 
		this.stackItems = new String[maxSize];
	}
	
	/**
	 * @param maxSize - sets maximum size of the stack 
	 */
	public Stack( int maxSize) {
		this.maxSize = maxSize;
		this.top = -1; 
		this.stackItems = new String[maxSize];
	}
	
	/**
	 * This method determines if additional items can be added to the stack
	 * @return isFull : boolean
	 */
	public boolean isFull() {
		return top == maxSize -1; 	// If the last item fills the stack
	}
	
	/**
	 * This method determines if the stack contains no items
	 * @return isEmpty : boolean
	 */
	public boolean isEmpty() {
		return top == -1;
	}
   
   /**
	* This method will return current number of items in stack
	 * @return size : int
	 */
	public int size() {
		return top + 1;
	}
	
	/**
	 * This method returns the next entry at the top of the stack
	 * @return item : String
	 * @throws StackEmptyException 
	 */
	public String peek() throws StackEmptyException{
		if (! this.isEmpty()) 
			return stackItems[top];
		throw new StackEmptyException(); 
	}
	
	/**
	 * This method removed the item at the top of the stack, removing it from the stack
	 * @return item : String
	 */
	public String pop() throws StackEmptyException {
		if ( isEmpty() ) throw new StackEmptyException();
		String item = peek();
		top--;
		return item;
	}	
	
	/**
	 * This method adds an item to the stack
	 * @param item : String
	 */
	public void push(String item) throws StackFullException {
		if (! this.isFull()) {
			top++;
			stackItems[top] = item;
		} else
		throw new StackFullException();
	}

	/**
	 * This method returns a string concatenating the stack items followed by a new line
	 * @return item : String
	 * @throws StackEmptyException
	 */
	public String printStackUp() throws StackEmptyException {
		if ( isEmpty() ) throw new StackEmptyException();
		StringBuilder stackString = new StringBuilder();
		for ( int i = 0; i <= top; i++ ) {
			stackString.append(stackItems[i]).append('\n');
		}
		return stackString.toString();
	}
}
