package telran.util.tests;

import org.junit.jupiter.api.Test;
import static telran.util.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
public class ArraysTest {
	Integer[] numbers = {10, 5, -5, 100, 200};
	String[] strings = {"lmn", "a", "ab", "abc", "b", "ba"};
@Test
void addObjectTest() {
	Integer[] expectedNumbers = {10, 5, -5, 100, 200, 50};
	assertArrayEquals(expectedNumbers, addObject(numbers, 50));
	String[] expectedStrings = {"lmn", "a", "ab", "abc", "b", "ba", "bb"};
	assertArrayEquals(expectedStrings, addObject(strings, "bb"));
}
@Test
void insertObjectTest() {
	Integer[] expectedLast = {10, 5, -5, 100, 200, 50};
	Integer[] expectedFirst = {50, 10, 5, -5, 100, 200};
	Integer[] expectedMiddle = { 10, 5, 50, -5, 100, 200};
	assertArrayEquals(expectedLast, insertObject(numbers, 5, 50));
	assertArrayEquals(expectedFirst, insertObject(numbers, 0, 50));
	assertArrayEquals(expectedMiddle, insertObject(numbers, 2, 50));
}
@Test
void digitsSumComparatorTest() {
	Comparator<Integer> comp = new DigitsSumComparator();
	assertTrue(comp.compare(9, 66) < 0);
	assertTrue(comp.compare(9, 111) > 0);
	assertTrue(comp.compare(3, 111) == 0);
	assertTrue(comp.compare(3, -111) == 0);
}
@Test
void standardSortComparatorTest() {
	Integer [] array = {10, 5, 110, 9, 22, 33};
	Integer [] expected = {10, 110, 22, 5, 33, 9};
	Arrays.sort(array, new DigitsSumComparator());
	assertArrayEquals(expected, array);
}
@Test
void bubbleSortComparatorTest() {
Integer [] array = {10, 5, -5, 100, 200};
Integer [] expected = {10, 100, 200, 5, -5};
bubbleSort(array, new EvenOddComparator());
assertArrayEquals(expected, array);
Integer [] array1 = {10, 5, 110, 9, 22, 33};
Integer [] expected1 = {10, 22, 110, 33, 9, 5};
bubbleSort(array1, new EvenOddComparator());
assertArrayEquals(expected1, array1);
}
}
