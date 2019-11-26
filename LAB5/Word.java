import java.util.ArrayList;

public class Word {
	private ArrayList<Letter> word  = new ArrayList<Letter>();
	
	public Word(ArrayList<Letter> word) {
		this.word = word;
	}
	
	public Word(String word) {
		String[] aWord = word.split("");
		for(int i = 0; i < aWord.length;i++) {
			this.word.add(new Letter(aWord[i]));
		}
	}
	public ArrayList<Letter> getword() {
		return word;
	}

	public void setword(ArrayList<Letter> word) {
		this.word = word;
	}
	
	public String toString() {
		String wrd = "";
		for(int i = 0; i < this.word.size();i++) {
			wrd += this.word.get(i).getLetter();
		}
		return wrd;
		
	}
	
}
