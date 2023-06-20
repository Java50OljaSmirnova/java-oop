package telran.numbers.test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BinaryOperator;

import org.junit.jupiter.api.Test;

import telran.numbers.CalcData;
import telran.numbers.Calculator;
public class CalculatorTest {
@Test
void test() {
	BinaryOperator<Double> bo = (a, b) -> a + b;
	assertEquals(30, bo.apply(10.0, 20.0));
//	BinaryOperator<Double> [] operators = new BinaryOperator[4];
//	operators[0] = (a, b) -> a + b;
//	operators[1] = (a, b) -> a - b;
//	operators[2] = (a, b) -> a * b;
//	operators[3] = (a, b) -> a / b;
//	assertEquals(-10, operators[1].apply(10.0, 20.0));
	DoubleBinaryOperator[] operators = {
			(a, b) -> a + b,
			(a, b) -> a - b,
			(a, b) -> a * b,
			(a, b) -> a / b
	};
	double[] res = {30, 10, 200, 2};
	double op1 = 20;
	double op2 = 10;
	for(int i = 0; i < operators.length; i++) {
		assertEquals(res[i],operators[i].apply(op1, op2));
	}
}
@Test
void calculateTest() {
	assertEquals(20, Calculator.calculate(new CalcData(40, 20, '-')));
	assertEquals(0.5, Calculator.calculate(new CalcData(1, 2, '/')));
	assertEquals(1, Calculator.calculate(new CalcData(0.5, 2, '*')));
	assertEquals(0.74, Calculator.calculate(new CalcData(0.5, 0.24, '+')));
}

interface DoubleBinaryOperator extends BinaryOperator<Double>{
	
}
}
