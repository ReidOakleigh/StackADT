package StackLab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stackLabTest {

	@Test
	void testCreateStack() {
		// ARRANGE
		Stack myStack = new Stack(1);
		// ACT
		// ASSERT
		assertTrue(myStack.isEmpty());
	}

	@Test
	void testIsEmptyTrue() {
		// ARRANGE
		Stack myStack = new Stack(1);
		// ACT
		// ASSERT
		assertTrue(myStack.isEmpty());
	}

	@Test
	void testIsEmptyFalse() throws StackFullException {
		// ARRANGE
		Stack myStack = new Stack(1);
		String item = "Java is Fun!";
		// ACT
		myStack.push(item);
		// ASSERT
		assertFalse(myStack.isEmpty());
	}

	@Test
	void testIsFullTrue() throws StackFullException {
		// ARRANGE
		Stack myStack = new Stack(1);
		String item = "Java is Fun!";
		// ACT
		myStack.push(item);
		// ASSERT
		assertTrue(myStack.isFull());
	}

	@Test
	void testIsFullFalse() throws StackFullException {
		// ARRANGE
		Stack myStack = new Stack(1);
		// ACT
		// ASSERT
		assertFalse(myStack.isFull());
	}

	@Test
	void testPushStack() throws StackFullException, StackEmptyException {
		// ARRANGE
		Stack myStack = new Stack(2);
		String item = "StackItem";
		String expected, actual;
		expected = "StackItem2";
		// ACT
		myStack.push(item + "1");
		myStack.push(item + "2");
		actual = myStack.peek(); 
		// ASSERT
		assertEquals(expected, actual);
		assertFalse(myStack.isEmpty());
	}

	@Test
	void testPushFullStack() throws StackFullException {
		// ARRANGE
		Stack myStack = new Stack(1);
		String item = "StackItem";
		myStack.push(item);
		// ACT
		// ASSERT
		assertThrows(StackFullException.class, () -> myStack.push(item));
	}

	@Test
	void testPopStack() throws StackFullException, StackEmptyException {
		// ARRANGE
		Stack myStack = new Stack(2);
		String item = "StackItem";
		String actual1, actual2, expected1, expected2;
		expected1 = "StackItem2";
		expected2 = "StackItem1"; 
		myStack.push(item + "1");
		myStack.push(item + "2");
		// ACT
		actual1 = myStack.pop();
		actual2 = myStack.pop();
		// ASSERT
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertTrue(myStack.isEmpty());
	}

	@Test
	void testStackSizeZero() {
		// ARRANGE
		Stack myStack = new Stack(2);
		int actual, expected;
		expected = 0;
		// ACT
		actual = myStack.size();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testStackSizeNonZero() throws StackFullException {
		// ARRANGE
		Stack myStack = new Stack(2);
		String item = "StackItem";
		int actual, expected;
		expected = 2;
		// ACT
		myStack.push(item + "1");
		myStack.push(item + "2");
		actual = myStack.size();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPopEmptyStack() {
		// ARRANGE
		Stack myStack = new Stack(1);
		// ACT
		// ASSERT
		assertThrows(StackEmptyException.class, () -> myStack.pop());
	}

	@Test
	void testPeekStack() throws StackLab.StackEmptyException, StackFullException {
		// ARRANGE
		Stack myStack = new Stack(1);
		String item = "StackItem";
		String actual, expected;
		// ACT
		myStack.push(item);
		expected = item;
		actual = myStack.peek();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPeekEmptyStack() {
		// ARRANGE
		Stack myStack = new Stack(1);
		// ACT
		// ASSERT
		assertThrows(StackEmptyException.class, () -> myStack.peek());
	}

	@Test
	void testPrintStackUp() throws StackEmptyException, StackFullException {
		// ARRANGE
		Stack myStack = new Stack(2);
		String item = "StackItem";
		String actual, expected;
		expected = "StackItem1\nStackItem2\n";
		// ACT
		myStack.push(item + "1");
		myStack.push(item + "2");
		actual = myStack.printStackUp();
		// ASSERT
		assertEquals(expected, actual);
		assertFalse(myStack.isEmpty());
	}

	@Test
	void testPrintStackUpEmptyStack() {
		// ARRANGE
		Stack myStack = new Stack(1);
		// ACT
		// ASSERT
		assertThrows(StackEmptyException.class, () -> myStack.printStackUp());
	}
}