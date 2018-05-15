package de.patrick;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {
	@Test
	public void testQueue() {
		Queue que = new Queue(3);
		final int sollWert1 = 29;
		final int sollWert2 = 5;
		final int sollWert3 = 95;
		final int sollWert4 = 7;
		que.enqueue(sollWert1);
		assertEquals(sollWert1, que.queue[0]);
		que.enqueue(sollWert2);
		assertEquals(sollWert2, que.queue[1]);
		que.enqueue(sollWert3);
		assertEquals(sollWert3, que.queue[2]);
		que.enqueue(sollWert4);
		assertEquals(sollWert4, que.queue[2]);
		
		assertEquals(sollWert1, que.dequeue());
		assertEquals(sollWert2, que.dequeue());
		assertEquals(sollWert4, que.dequeue());
		
		
		try{
			assertEquals("Liste ist Leer",que.dequeue());
		} catch(IllegalStateException e){
			
		}
		
		
		
	}
}
