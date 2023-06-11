package telran.util.tests;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		Integer res = 0;
		boolean firstNum = evenOrOdd(o1);
		boolean secondNum = evenOrOdd(o2);
		if(firstNum && secondNum) {
			res = o1 - o2;
		} else if (!firstNum && !secondNum) {
			res = o2 - o1;
		} else {
			if(firstNum && !secondNum) {
				res = -1;
			} else if (!firstNum && secondNum) {
				res = 1;
			}
		}
		return  res;
	}

	private boolean evenOrOdd(Integer number) {
		
		return number % 2 == 0 ? true : false;
	}

}
