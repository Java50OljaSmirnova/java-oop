package telran.shapes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Canvas implements Shape, Iterable<Shape>{
	private Shape[] shapes = new Shape[0];
	private Shape[] removedShapes = new Shape[0];
	private class CanvasIterator implements Iterator<Shape>{
		int current = containsInRemoved(shapes[0]) ? getCurrent(0) : 0;
		int previous = 0;
		boolean next = false;
		@Override
		public boolean hasNext() {
			
			return current < shapes.length;
		}

		private int getCurrent(int current) {
			current++;
			while(current < shapes.length && containsInRemoved(shapes[current])) {
				current++;
			}
			return current;
		}

		@Override
		public Shape next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			int res = current;
			previous = current;
			current = getCurrent(current);
			next = true;
			return shapes[res];
		}
		@Override
		public void remove() {
		if(!next) {
			throw new IllegalArgumentException();
		}
		next = false;
		addRemoved(previous);
		
		}
	}
	@Override
	public int perimeter() {
		int res = 0;
		for(Shape num : shapes) {
			res = res + num.perimeter();
		}
		return res;
	}
	@Override
	public int square() {
		int res = 0;
		for(Shape num : shapes) {
			res = res + num.square();
		}
		return res;
	}
	public void addRemoved(int index) {
		removedShapes = Arrays.copyOf(removedShapes, removedShapes.length + 1);
		removedShapes[removedShapes.length - 1] = shapes[index];
		
	}
	public boolean containsInRemoved(Shape shape) {
		boolean res = false;
		int index = 0;
		while(index < removedShapes.length && !res) {
			if(removedShapes[index] == shape) {
				res = true;
			}
			index++;
		}
		return res;
	}
	
	@Override
	public Iterator<Shape> iterator() {
		
		return new CanvasIterator();
	}
	public void addShape(Shape shape) {
		setShapes(Arrays.copyOf(shapes, shapes.length + 1));
		shapes[shapes.length - 1] = shape;
	}
	public boolean removeIf(Predicate<Shape> predicate) {
		int oldLength = shapes.length;
		Iterator<Shape> it = iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			if(predicate.test(shape)) {
				it.remove();
			}
		}
		return oldLength < shapes.length;
	}
	public boolean removeNestedCanvases() {
		return removeIf(shape -> shape instanceof Canvas);
	}
	public Shape[] getShapes() {
		return shapes;
	}
	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
	}

}
