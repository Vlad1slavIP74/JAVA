public class Main7 {
	
	public static void main (String[]args) {
		DbLinkedList list= new DbLinkedList();
		System.out.println("List is currently empty: "+list.isEmpty());
		System.out.println();
		list.add(new Music(4.06f, "No One Lives Forever", "Oingo Boingo" ));
		list.add(new Music(3.06f, "Johnny B. Goode", "Chuck Berry" ));
		list.add(new Music(2, "Father's Shout", "Pink Floyd" ));
		list.add(new Music(3.06f, "Johnny B. Goode", "Chuck Berry" ));
		
		for(Music c:list) {
			System.out.println("Now playing: "+c);
		}
		Music tmp = list.getHead();
		System.out.println();
		list.remove(tmp.next);
		for(Music c:list) {
			System.out.println("Now playing: "+c);
		}

		list.add(new Music(3.06f, "Johnny B. Goode", "Chuck Berry" ));
		
		Music disc[] = (Music[])list.toArray();
		System.out.println("disc capasity is: "+disc.length);
		for(Music c:disc) {
			System.out.println("Now playing: "+c);
		}
		System.out.println();
		System.out.println("List is currently empty: "+list.isEmpty());
		System.out.println();
		System.out.println("List contains "+tmp.next+" ? :"+ list.contains(tmp.next));
		System.out.println("List contains "+new Music(2.23f, "Jailhouse Rock", "Elvis Presley" )
				+" ? :"+ list.contains(new Music(2.23f, "Jailhouse Rock", "Elvis Presley" )));
		
		
	}
	
}
