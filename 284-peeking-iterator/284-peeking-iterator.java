// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
    Integer curr = null;
    
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if(iterator.hasNext()) curr = iterator.next();
        
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return curr;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer toReturn = curr;
        curr = iterator.hasNext() ? iterator.next() : null;
        return toReturn;
	}
	
	@Override
	public boolean hasNext() {
	    return curr != null;
	}
}