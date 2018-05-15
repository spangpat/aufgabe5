package de.patrick;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {

	@Test
	public void istErstesHalbjahr(){
		final int month = 8;
		final boolean sollWert = false;
		assertEquals(sollWert, Util.istErstesHalbjahr(month));
		
		/*
		month = 7;
		sollWert = true;
		assertEquals(sollWert, Util.istErstesHalbjahr(month));
		*/
	}
}
