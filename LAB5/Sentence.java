import java.util.ArrayList;

public class Sentence {
	private ArrayList<Word> sentence  = new ArrayList<Word>();
	private ArrayList<Symbol> punct  = new ArrayList<Symbol>();
	private ArrayList<String> sen_pu  = new ArrayList<String>();
	public Sentence(ArrayList<Word> sentence, ArrayList<Symbol> punct) {
		this.sentence = sentence;
		this.punct = punct;
	}
	
	public Sentence(String sentence) {
		String[] aSentence = sentence.split("");
		String tmp = "";
		for(int i = 0; i < aSentence.length;i++) {
			if(Sentence.isLetter(aSentence[i],0)) {
				tmp += aSentence[i];
			}else if(!Sentence.isLetter(aSentence[i],0)){
				this.sentence.add(new Word(tmp));
				sen_pu.add("s");
				tmp = "";
				this.punct.add(new Symbol(aSentence[i],i));
				sen_pu.add("p");
			}
			else {
				this.sentence.add(new Word(tmp));
				sen_pu.add("s");
				tmp = "";
			}
			
		}
	}

	public ArrayList<Word> getSentence() {
		return sentence;
	}

	public void setSentence(ArrayList<Word> sentence) {
		this.sentence = sentence;
	}

	public ArrayList<Symbol> getPunct() {
		return punct;
	}

	public void setPunct(ArrayList<Symbol> punct) {
		this.punct = punct;
	}
	
	public static boolean isLetter(String s, int i) {
		if (Character.isLetter(s.charAt(i) ) ) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		/*int curri = 0;
		int indxs[] = new int [this.punct.size()];
		for(int i = 0; i < this.punct.size();i++) {
			indxs[i] =this.punct.get(i).getPlace();
		}
		String snt = "";
		for(int i = 0; i < this.sentence.size();i++) {
			for(int j = curri ; j<indxs.length;j++) {
				if(indxs[j]==snt.length()) {
					snt +=this.punct.get(j).getSymbol();
					curri++;
				}
				
			}
			snt +=this.sentence.get(i).toString();
		}
		return snt+".";*/
		String snt ="";
		int sen = 0;
		int pu = 0;
		for(int i = 0; i<sen_pu.size();i++) {
			if(sen_pu.get(i)=="s") {
				snt +=this.sentence.get(sen).toString();
				sen++;
			}else {
				snt +=this.punct.get(pu).getSymbol();
				pu++;
			}
		}
		return snt;
	}
	
	public void Repl(int s, String repl) {
		for(int i = 0; i < this.sentence.size();i++) {
			if(this.sentence.get(i).getword().size() == s) {
				this.sentence.get(i).setword(new Word(repl).getword());
			}
		}
	}
	
}
