import java.util.ArrayList;

public class Article {
	private ArrayList<Sentence> text = new ArrayList<Sentence>();
	public Article(ArrayList<Sentence> text) {
		this.text = text;
	}
	
	public Article(String text) {
		String[] aText = text.split("\\.");
		for(int i = 0; i < aText.length;i++) {
			this.text.add(new Sentence(aText[i]+"."));
		}
	}
	
	public ArrayList<Sentence> getText() {
		return text;
	}
	public void setText(ArrayList<Sentence> text) {
		this.text = text;
	}
	
	public String toString() {
		String txt = "";
		for(int i = 0; i < this.text.size();i++) {
			txt += this.text.get(i).toString();
		}
		return txt;
		
	}
	
	public void Replace(int s, String repl) {
		for(int i = 0; i < this.text.size();i++) {
			this.text.get(i).Repl(s, repl);
		}
	}
}
