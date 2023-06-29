package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.shapes.Canvas;
import telran.shapes.Rectangle;
import telran.shapes.Shape;
import telran.shapes.Square;

class ShapeTests {
	Rectangle rectangle;
	Square square;
	Canvas canvas;
	Canvas canvasInterior;
	
	@BeforeEach
	void setUp(){
		rectangle = new Rectangle(3, 5);
		square = new Square (4);
		canvasInterior = new Canvas ();
		canvas = new Canvas();
		canvas.addShape(rectangle);
		canvas.addShape(square);
		canvasInterior.addShape(new Rectangle (5, 7));
		canvasInterior.addShape(new Square(2));
	}
	@Test
	void shapePerimeterTest() {
		assertEquals(16, rectangle.perimeter());
		assertEquals(16, square.perimeter());
		
	}
	@Test
	void shapeSquareTest() {
		assertEquals(15, rectangle.square());
		assertEquals(16, square.square());
		
	}

	@Test
	void addShapeTest() {
		Shape[] expected = {rectangle, square, canvasInterior};
		int perimeter = canvas.perimeter() + canvasInterior.perimeter();
		int square = canvas.square() + canvasInterior.square();
		canvas.addShape(canvasInterior);
		assertEquals(perimeter, canvas.perimeter());
		assertEquals(square, canvas.square());
		assertArrayEquals(expected, canvas.getShapes());	
	}
//	@Test
//	void iteratorTest() {
//		int index = 0;
//		Shape [] expected = ;
//		Iterator<Shape> it = canvas.iterator();
//		
//		while (it.hasNext()) {
//			assertEquals(expected[index], it.next());
//			index++;
//		}
//		
//		assertEquals(5, current);
//		assertThrowsExactly(NoSuchElementException.class, () -> it.next());
//	}
	

}
