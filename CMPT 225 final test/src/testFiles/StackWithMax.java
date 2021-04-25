package testFiles;

import java.util.*;

public class StackWithMax<T extends Comparable<T>> {

	Stack<T> main=new Stack<>();
	Stack<T> maxStack=new Stack<>();
	T max=null;
	
	public StackWithMax() {

	}
	public void push(T item) {
		main.push(item);
		if(max==null) {
			max=item;
		}
		else if(max.compareTo(item)==-1) {
			max=item;
		}
		maxStack.push(max);
	}
	public T pop() {
		maxStack.pop();
		return main.pop();
	}
	public T getMax() {
		return maxStack.peek();
	}
	public int size() {
		return main.size();
	}
	public boolean isEmpty() {
		return main.isEmpty();
	}
}
