package telran.exceptions.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class ExceptionsTest {
	
	@Test
	void testException() {
		int res = 0;
			try {
				res = itThrowsCheckedException(10);
				System.out.println("everything ok");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				res = 100;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				res = 200;
			}
			assertEquals(20, res);
	}
	private int itThrowsCheckedException(int number) throws Exception {
		if(number < 0) {
			throw new Exception("just test checked exception");
		}
		if(number > 1000) {
			throw new RuntimeException("number cannot be greater than 1000");
		}
		return number * 2;
	}
	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(200);
		assertEquals(bbf.getFloor(), getMinFloor(bbf));
		BallBrokenFloor bbf1 = new BallBrokenFloor(10);
		assertEquals(bbf1.getFloor(), getMinFloor(bbf1));
		
	}
	private int getMinFloor(BallBrokenFloor bbf) {
		int left = 0;
		int right = bbf.getnFloors();
		int medium = right / 2;
		while( left <= right) {
			try {
				bbf.broken(medium);
				left = medium + 1;
			}catch (Exception e) {
				right = medium - 1;
			}		
			medium = (left + right) / 2;
		}
		return left;
	}

}
