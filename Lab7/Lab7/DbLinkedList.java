
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class DbLinkedList implements  Set<Music>{
	private Music head;
	public Music getHead() {
		return head;
	}

	public void setHead(Music head) {
		this.head = head;
	}

	private Music lastE;
	static int size = 0;
	
	@Override
	public boolean add(Music arg0) {
		if(size == 0) {
			head = arg0;
			head.next=null;
			head.prev=null;
			lastE = head;
			size++;
		}else if(this.containsF(arg0)){
			System.out.println("Already in the list");
			return false;
		}else{
		Music current = arg0;
		lastE.next = current;
		current.prev = lastE;
		current.next = null;
		lastE = current;
		size++;
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean addAll(Collection arg0) {
		for(Music m : (Collection<Music>)arg0) {
			if(size == 0) {
				head = m;
				head.next=null;
				head.prev=null;
				lastE = head;
			size++;
			}else {
				Music current = m;
				lastE.next = current;
				current.prev = lastE;
				current.next = null;
				lastE = current;
				size++;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
	}

	@Override
	public boolean contains(Object arg0) {
		Music tmp = head;
		while(tmp.next != null)
		{
			if(tmp == (Music)arg0) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public boolean containsF(Music arg0) {
		Music tmp = head;
		while(tmp.next != null)
		{
			if(tmp.getComposer() == arg0.getComposer()&&tmp.getLength()==arg0.getLength()&&tmp.getName()==arg0.getName()) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean containsAll(Collection arg0) {
		Music tmp = head;
		for(Music m: (Collection<Music>)arg0) {
			while(tmp.next != null)
			{
				if(tmp == m) {
					return true;
				}
				tmp = tmp.next;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public Iterator<Music> iterator() {
		
		return new DbIterator(this);
	}

	@Override
	public boolean remove(Object arg0) {
		Music tmp = head;
		if(head == null) {
		}else if(size == 1) {
		 head=null;
		 size = 0;
		}else{
			while(tmp.next != null)
				{
				if(tmp == (Music)arg0) {
					Music pre = tmp.prev;
					Music post = tmp.next;
					pre.next = post;
					post.prev = pre;
					size--;
					return true;
				}else {
					tmp = tmp.next;
				}
				
			}
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean removeAll(Collection arg0) {
		Music tmp = head;
		if(head == null) {}else {
			while(tmp.next != null) {
				for(Music m:(Collection<Music>) arg0) {
					if(tmp == m){
						Music delete = tmp;
						tmp = tmp.next;
						this.remove(delete);
					}
				}
					
			}
				
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean retainAll(Collection arg0) {
		Music tmp = head;
		boolean ToDelete = false;
		if(head == null) {}else {
			while(tmp.next != null) {
				for(Music m:(Collection<Music>) arg0) {
					if(tmp != m){
						ToDelete = true;
					}else {
						ToDelete = false;
					}
				}
				if(ToDelete) {
					Music delete = tmp;
					tmp = tmp.next;
					this.remove(delete);
					
				}
				
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Music[] toArray() {
		Music tmp = head;
		int n=0;
		Music[] mus = new Music[size];
		if(head == null) {
			System.out.println("It is empty");
		}else {
			while(tmp != null) {
				mus[n] = tmp;
				n++;
				tmp = tmp.next; 
			}
			return mus;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Music[] toArray(Object[] arg0) {
		
		return null;
	}

	

}
