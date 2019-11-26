import java.util.Iterator;

public class DbIterator implements Iterator<Music>{
	Music current;
	public DbIterator(DbLinkedList list) {
		current = list.getHead();
	}
	
	public boolean hasNext() 
    { 
        return current != null; 
    } 
	
	public Music next() {
		Music tmp = current;
		current = current.next;
		return tmp;
	}

}
