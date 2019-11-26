public class Music implements Comparable<Music>{
	private float length;
	private String name;
	private String composer;
	protected Music next;
	protected Music prev;
	
	public Music(float length, String name, String composer) {
		this.composer=composer;
		this.length=length;
		this.name=name;
	}
	
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	
	public void playMusic() {
		System.out.println("Now playing : "+ name + " by " + composer);
	}

	@Override
	public int compareTo(Music another) {
		if(this.getLength() > another.getLength())
            return 1;
        else if (this.getLength() == another.getLength())
            return 0 ;
        return -1 ;
	}
	
	public String toString() {
		return name+" by "+composer+" length "+length;
		
	}
	
}
