
package add;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProgramTest {

	@Test
	public void testAdd() {
		Program p = new Program();
		int result = p.add(2, 3);
		assertEquals(5, result);

	}

}