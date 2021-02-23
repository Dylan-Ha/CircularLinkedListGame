package cs146F20.Ha.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void initialTests() {
		//initial test case
		//testing the different methods of the class
		CircularLinkedListGame prisoners=new CircularLinkedListGame();
		assertTrue(prisoners.isEmpty());
		assertEquals(0, prisoners.getSize());
		prisoners.insert(5);
		assertFalse(prisoners.isEmpty());
		assertEquals(1,prisoners.getSize());
	}

	@Test
	//test case 1 For n=6, k = 2, Output: 1
	public void test1() {
		CircularLinkedListGame prisoners=new CircularLinkedListGame();
		prisoners.insert(1);
		prisoners.insert(2);
		prisoners.insert(3);
		prisoners.insert(4);
		prisoners.insert(5);
		prisoners.insert(6);
		assertEquals(1, prisoners.winner(2));
	}

	@Test
	// test case 2 For n= 1, k = 9, Output =1
	public void test2() {
		CircularLinkedListGame prisoners=new CircularLinkedListGame();
		prisoners.insert(1);
		assertEquals(1, prisoners.winner(9));
	}

	@Test
	//test case 3 For n=7, k = 7, Output = 4
	public void test3() {
		CircularLinkedListGame prisoners=new CircularLinkedListGame();
		prisoners.insert(1);
		prisoners.insert(2);
		prisoners.insert(3);
		prisoners.insert(4);
		prisoners.insert(5);
		prisoners.insert(6);
		prisoners.insert(7);
		assertEquals(4, prisoners.winner(7));
	}

	@Test
	//test case 4 For n =12, k = 8, Output= 2
	public void test4() {
		CircularLinkedListGame prisoners=new CircularLinkedListGame();
		prisoners.insert(1);
		prisoners.insert(2);
		prisoners.insert(3);
		prisoners.insert(4);
		prisoners.insert(5);
		prisoners.insert(6);
		prisoners.insert(7);
		prisoners.insert(8);
		prisoners.insert(9);
		prisoners.insert(10);
		prisoners.insert(11);
		prisoners.insert(12);
		assertEquals(2, prisoners.winner(8));
	}

	@Test
	//test case 5 For n = 5, k = 1, Output = 3
	public void test5() {
		CircularLinkedListGame prisoners=new CircularLinkedListGame();
		prisoners.insert(1);
		prisoners.insert(2);
		prisoners.insert(3);
		prisoners.insert(4);
		prisoners.insert(5);
		assertEquals(3, prisoners.winner(1));
	}

}
