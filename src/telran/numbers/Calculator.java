package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	static DoubleBinaryOperator[] operators = {
			(a, b) -> a + b,
			(a, b) -> a - b,
			(a, b) -> a * b,
			(a, b) -> a / b
	};
	static char[] operations = {
		'+','-','*','/'
	};
	
	static public double calculate(CalcData cd) {
		int index = findIndex(cd.operation);
		
		return operators[index].apply(cd.op1, cd.op2);
	}

	private static int findIndex(char operation) {
		int res = -1;
		int index = 0;
		while(index < operations.length && res == -1) {
			if(operations[index] == operation) {
				res = index;
			}
			index++;
		}

		return res;
	}
}
interface DoubleBinaryOperator extends BinaryOperator<Double> {
	
}
