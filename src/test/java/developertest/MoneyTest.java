package developertest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import developertest.Money;

public class MoneyTest {
	
	/**
	 * Tests that 70+10 cent and 90-10 cent lead to the same result. 
	 */
	@Test
	public void testAddSubtractOperations() {
		Money _70cent = new Money(.7, "EUR");
		Money _90cent = new Money(.9, "EUR");
		Money _10cent = new Money(.1, "EUR");
		Money r1 = _70cent.add(_10cent); // 70 cent + 10 cent = 80 cent
		Money r2 = _90cent.subtract(_10cent); // 90 cent - 10 cent = 80 cent
		assertEquals(r1, r2);
	}	

}
