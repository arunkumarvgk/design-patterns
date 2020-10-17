package com.designpatterns.behavioural.iterator;

public class IteratorPattern {

	public static void main(String[] args) {
		final ICustomList<Integer> customList = new CustomList<Integer>(15);
		customList.add(10);
		customList.add(11);
		customList.add(12);
		customList.add(13);
		customList.add(14);
		customList.add(15);
		customList.add(16);
		
		final Iterator<Integer> iterator = customList.getIterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

interface Iterator <T> {
	boolean hasNext();
	T next();
}

interface ICustomList<T> {
	Iterator<T> getIterator();
	void add(T item);
	boolean hasSpace();
}

class CustomListIterator<T> implements Iterator<T> {
	private final T[] customList;
	private int cursor;
	private final int noOfElements;
	
	public CustomListIterator(final T[] customList, final int noOfElements) {
		this.customList = customList;
		cursor = 0;
		this.noOfElements = noOfElements;
	}

	@Override
	public boolean hasNext() {
		return customList.length > cursor && cursor < noOfElements;
	}

	@Override
	public T next() {
		return customList[cursor++];
	}	
}

class CustomList<T> implements ICustomList<T> {
	private transient Object[] customList;
	private int index = 0;
	private static final int DEFAULT_CAPACITY = 10;

	public CustomList() {
		this(DEFAULT_CAPACITY);
	}
	
	public CustomList(final int capacity) {
		this.customList = new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> getIterator() {
		return new CustomListIterator<T>((T[])customList, index);
	}
	
	@Override
	public void add(final T item) {
		if (hasSpace()) {
			this.customList[index++] = item;
		}
	}
	
	@Override
	public boolean hasSpace() {
		return index < this.customList.length;
	}
}